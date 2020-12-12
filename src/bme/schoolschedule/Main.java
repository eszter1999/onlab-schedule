package bme.schoolschedule;


import bme.schoolschedule.data.Group;
import bme.schoolschedule.data.Teachers;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Timetable timetable = initializeTimetable();

        GeneticAlgorithm ga = new GeneticAlgorithm(101, 0.001, 0.9, 2, 5);

        // Initialize population
        Population population = ga.initPopulation(timetable);

        // Evaluate population
        ga.evalPopulation(population, timetable);

        // Keep track of current generation
        int generation = 1;

        // Start evolution loop
        while (!ga.isTerminationConditionMet(generation, 1000)
                && !ga.isTerminationConditionMet(population)) {
            // Print fitness
            System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evalPopulation(population, timetable);

            // Increment the current generation
            generation++;
        }

        // Print fitness
        timetable.createClasses(population.getFittest(0));
        System.out.println();
        System.out.println("Solution found in " + generation + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Clashes: " + timetable.calcClashes()[0]);
        System.out.println("RoomClashes: " + timetable.calcClashes()[1]);
        System.out.println("TeacherClashes: " + timetable.calcClashes()[2]);
        System.out.println("GroupClashes: " + timetable.calcClashes()[3]);

        //int[] teachers = timetable.printTeachers();
        //for(int i = 0; i < teachers.length; i++)
        //    System.out.println("teacher id: " + i + " working hour: " + teachers[i]);

        // Print classes
        System.out.println();
        //export to excel
        new ExcelExport(timetable);
    }

    private static Timetable initializeTimetable() {
        Timetable timetable = new Timetable();
        inputReader("teachers", timetable);
        inputReader("lessons", timetable);
        inputReader("groups", timetable);
        inputReader("rooms", timetable);
        inputReader("timeslot", timetable);
        timetable.assortRooms();

        return timetable;
    }


    private static void inputReader(String type, Timetable timetable) {
        try {
            //fontos hogy a res-ben kell tárolni a fileokat
            int num = 0;
            InputStream in = Main.class.getResourceAsStream("/" + type + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] line = currentLine.split("\t");
                //megnézi hogy miket olvasunk be
                switch (type) {
                    case "groups":
                        timetable.addGroup(num, line[0], Integer.parseInt(line[1]), timetable.getLessons(line[0]));
                        num++;
                        break;
                    case "teachers":
                        timetable.addTeacher(num, line[0], Integer.parseInt(line[1]));
                        num++;
                        break;
                    case "lessons":
                        for (int i = 0; i < Integer.parseInt(line[2]); i++) {
                            timetable.addLessons(num, line[0], line[1], Integer.parseInt(line[2]), timetable.getTeacher(line[3]), room.valueOf(line[4]));
                            num++;
                        }
                        break;
                    case "timeslot":
                        timetable.addTimeslot(num, line[0]);
                        num++;
                        break;
                    case "rooms":
                        timetable.addRoom(num, room.valueOf(line[0]), line[1], Integer.parseInt(line[2]));
                        num++;
                        break;
                    default:
                        break;
                }

                currentLine = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList getClasses(Timetable timetable, String group){
        ArrayList<Class> classes =  new ArrayList<>();
        for (Class cl : classes) {
            if(timetable.getGroup(cl.getGroupId()).getName().equals(group))
                classes.add(cl);
        }
        return classes;
    }
}


