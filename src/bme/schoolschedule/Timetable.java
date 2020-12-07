package bme.schoolschedule;

import bme.schoolschedule.data.*;

import java.util.HashMap;
import java.util.Map;

public class Timetable {

    private final HashMap<Integer, Rooms> rooms;
    private final HashMap<Integer, Classes> classes;
    private final HashMap<Integer, Teachers> teachers;
    private final HashMap<Integer, Lessons> lessons;
    private final HashMap<Integer, Timeslot> timeslots;

    public Timetable() {
        this.rooms = new HashMap<>();
        this.classes = new HashMap<>();
        this.teachers = new HashMap<>();
        this.lessons = new HashMap<>();
        this.timeslots = new HashMap<>();
    }

    //add room to timetable
    public void addRoom(int roomId, room type, String roomName, int capacity) {
        this.rooms.put(roomId, new Rooms(roomId, type, roomName, capacity));
    }

    //add teacher to timetable
    public void addTeacher(int teacherId, String teacherName, int working_hour) {
        this.teachers.put(teacherId, new Teachers(teacherId, teacherName, working_hour));
    }

    //add class to timetable
    public void addClass(int classID, String className, int classCapacity){
        this.classes.put(classID, new Classes(classID, className, classCapacity));
    }

    //add lessons to timetable
    public void addLessons(int lessonId, Classes classes, String lessonName, int LessonNPW, int teacher){
        this.lessons.put(lessonId, new Lessons(lessonId, classes, lessonName, LessonNPW, teacher));
    }

    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
    }

    //get a class for add to a lesson
    public Classes getClasses(String name){
        for (Map.Entry<Integer, Classes> entry : classes.entrySet()) {
            Classes value = entry.getValue();
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    //get a teacher for add a lesson
    public int getTeacher(String name){
        for (Map.Entry<Integer, Teachers> entry : teachers.entrySet()) {
            Teachers value = entry.getValue();
            if (value.getName().equals(name)) {
                return entry.getKey();
            }
        }
        return 0;
    }


    //ezek csak a beolvasás teszteléséhez kellettek
    public void kiirasT(){
        for (Map.Entry<Integer, Teachers> entry : teachers.entrySet()) {
            Teachers value = entry.getValue();
            System.out.println(value.getName() + "\t" + entry.getKey());
        }
    }

    public void kiirasTS(){
        for (Map.Entry<Integer, Timeslot> entry : timeslots.entrySet()) {
            Timeslot value = entry.getValue();
            System.out.println(value.getTimeslot() + "\t" + entry.getKey());
        }
    }

    public void kiirasC(){
        for (Map.Entry<Integer, Classes> entry : classes.entrySet()) {
            Classes value = entry.getValue();
            System.out.println(value.getName() + "\t" + entry.getKey());
        }
    }

    public void kiirasL(){
        for (Map.Entry<Integer, Lessons> entry : lessons.entrySet()) {
            Lessons value = entry.getValue();
            System.out.println(value.getName() + "\t" + entry.getKey());
        }
    }

    public void kiirasR(){
        for (Map.Entry<Integer, Rooms> entry : rooms.entrySet()) {
            Rooms value = entry.getValue();
            System.out.println(value.getType() + "\t" + entry.getKey());
        }
    }
}
