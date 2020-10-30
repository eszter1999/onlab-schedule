package bme.schoolschedule;

import bme.schoolschedule.data.*;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Classes> classes = new ArrayList<>();
        ArrayList<Lessons> lessons = new ArrayList<>();
        ArrayList<Rooms> rooms = new ArrayList<>();
        ArrayList<Teachers> teachers = new ArrayList<>();

        room r = room.valueOf("PE");
        System.out.println(r);

        inputReader(classes, teachers, teachers, "teachers");
        inputReader(classes, teachers, classes, "classes");
        inputReader(classes, teachers, lessons, "lessons");
        inputReader(classes, teachers, rooms, "rooms");

        //kiirasC(classes);
        //kiirasL(lessons);
        kiirasR(rooms);
        //kiirasT(teachers);


    }


    public static void inputReader(ArrayList<Classes> classes, ArrayList<Teachers> teachers, ArrayList arrayList, String type) {
        try {
            InputStream in = Main.class.getResourceAsStream("/" + type + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] line = currentLine.split("/t");
                if (type.equals("classes"))
                    arrayList.add(new Classes(line[0], Integer.parseInt(line[1])));
                else if (type.equals("teachers"))
                    arrayList.add(new Teachers(line[0], Integer.parseInt(line[1])));
                else if (type.equals("lessons"))
                    arrayList.add(new Lessons(findClass(line[0], classes), line[1], Integer.parseInt(line[2]), findTeacher(line[3], teachers)));
                else {
                    String str = line[0];
                    arrayList.add((new Rooms(room.valueOf(str), line[1], Integer.parseInt(line[2]))));
                }
                currentLine = reader.readLine();
            }
            reader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static Classes findClass(String s, ArrayList<Classes> arrayList) {
        for (Classes cl : arrayList) {
            if (cl.getName().equals(s))
                return cl;
        }
        return null;
    }


    public static Teachers findTeacher(String s, ArrayList<Teachers> arrayList){
        for (Teachers t : arrayList) {
            if(t.getName().equals(s))
                return t;
        }
        return null;
    }

    public static void kiirasC(ArrayList<Classes> arrayList){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).getName());
        }
    }

    public static void kiirasT(ArrayList<Teachers> arrayList){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).getName());
        }
    }

    public static void kiirasL(ArrayList<Lessons> arrayList){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).getName());
        }
    }
    public static void kiirasR(ArrayList<Rooms> arrayList){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).getName());
            System.out.println(arrayList.get(i).getType());
        }
    }

}

