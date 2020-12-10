package bme.schoolschedule;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Timetable timetable = initializeTimetable();

        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);

        // Initialize population
        Population population = ga.initPopulation(timetable);

        // Evaluate population
        ga.evalPopulation(population, timetable);

        // Keep track of current generation
        int generation = 1;

        // Start evolution loop
        while (!ga.isTerminationConditionMet(generation, 200)
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
        System.out.println("Clashes: " + timetable.calcClashes());

        // Print classes
        System.out.println();
        Class classes[] = timetable.getClasses();
        int classIndex = 1;
        for (Class bestClass : classes) {
            System.out.println("Class " + classIndex + ":");
            System.out.println("Lesson: " +
                    timetable.getLesson(bestClass.getLessonId()).getName());
            System.out.println("Group: " +
                    timetable.getGroup(bestClass.getGroupId()).getName());
            System.out.println("Room: " +
                    timetable.getRoom(bestClass.getRoomId()).getName());
            System.out.println("Teacher: " +
                    timetable.getTeacher(bestClass.getTeacherId()).getName());
            System.out.println("Time: " +
                    timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot());
            System.out.println("-----");
            classIndex++;
        }
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

    /*private void initTimetable() {
        inputReader("teachers");
        inputReader("lessons");
        inputReader("groups");
        inputReader("rooms");
        inputReader("timeslot");
    }*/

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
                    default:
                        timetable.addRoom(num, room.valueOf(line[0]), line[1], Integer.parseInt(line[2]));
                        num++;
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
}


