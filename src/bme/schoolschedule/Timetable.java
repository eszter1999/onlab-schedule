package bme.schoolschedule;

import bme.schoolschedule.data.*;
import bme.schoolschedule.data.Class;

import java.util.HashMap;
import java.util.Map;

public class Timetable {

    private final HashMap<Integer, Room> rooms;
    private final HashMap<Integer, Class> classes;
    private final HashMap<Integer, Teacher> teachers;
    private final HashMap<Integer, Lessons> lessons;
    private final HashMap<Integer, Timeslot> timeslots;

    public Timetable() {
        this.rooms = new HashMap<>();
        this.classes = new HashMap<>();
        this.teachers = new HashMap<>();
        this.lessons = new HashMap<>();
        this.timeslots = new HashMap<>();
    }

    public int getNumClasses(){return  classes.size();}


    /////*adders*/////
    //add room to timetable
    public void addRoom(int roomId, roomType type, String roomName, int capacity) {
        this.rooms.put(roomId, new Room(roomId, type, roomName, capacity));
    }

    //add teacher to timetable
    public void addTeacher(int teacherId, String teacherName, int working_hour) {
        this.teachers.put(teacherId, new Teacher(teacherId, teacherName, working_hour));
    }

    //add class to timetable
    public void addClass(int classID, String className, int classCapacity){
        this.classes.put(classID, new Class(classID, className, classCapacity));
    }

    //add lessons to timetable
    public void addLessons(int lessonId, Class classes, String lessonName, int LessonNPW, int teacher){
        this.lessons.put(lessonId, new Lessons(lessonId, classes, lessonName, LessonNPW, teacher));
    }

    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
    }


    /////*getters*/////
    //get a class for add to a lesson
    public Class getClasses(String name){
        for (Map.Entry<Integer, Class> entry : classes.entrySet()) {
            Class value = entry.getValue();
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    //get a teacher for add a lesson
    public int getTeacher(String name){
        for (Map.Entry<Integer, Teacher> entry : teachers.entrySet()) {
            Teacher value = entry.getValue();
            if (value.getName().equals(name)) {
                return value.getId();
            }
        }
        return 0;
    }


    /////*print*/////
    //ezek csak a beolvasás teszteléséhez kellettek
    public void kiirasT(){
        for (Map.Entry<Integer, Teacher> entry : teachers.entrySet()) {
            Teacher value = entry.getValue();
            System.out.println(value.getName() + "\t" + entry.getKey());
        }
    }

    public void kiirasC() {
        for (Map.Entry<Integer, Class> entry : classes.entrySet()) {
            Class value = entry.getValue();
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
        for (Map.Entry<Integer, Room> entry : rooms.entrySet()) {
            Room value = entry.getValue();
            System.out.println(value.getType() + "\t" + entry.getKey());
        }
    }
}
