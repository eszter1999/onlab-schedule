package bme.schoolschedule;

import bme.schoolschedule.data.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Timetable {

    private final HashMap<Integer, Rooms> rooms;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, Teachers> teachers;
    private final HashMap<Integer, Lessons> lessons;
    private final HashMap<Integer, Timeslot> timeslots;

    private int numClasses = 0;

    public Timetable() {
        this.rooms = new HashMap<>();
        this.groups = new HashMap<>();
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
    public void addGroup(int classID, String className, int classCapacity, int[] lessonsIds){
        this.groups.put(classID, new Group(classID, className, classCapacity, lessonsIds));
        this.numClasses = 0;
    }

    //add lessons to timetable
    public void addLessons(int lessonId, String group, String lessonName, int LessonNPW, int teacher, room type){
        this.lessons.put(lessonId, new Lessons(lessonId, group, lessonName, LessonNPW, teacher, type));
    }

    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
    }

    //get a class for add to a lesson
    public int[] getLessons(String name){
        ArrayList<Integer> lesson = new ArrayList<>();
        for (Map.Entry<Integer, Lessons> entry : lessons.entrySet()) {
            Lessons value = entry.getValue();
            if (value.getGroup().equals(name)) {
                lesson.add(value.getId());
            }
        }
        int[] l = new int[lesson.size()];
        for(int i = 0; i < lesson.size(); i++)
            l[i] = lesson.get(i);
        return l;
    }

    //get a group
    public Group getGroup(String name){
        for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
            Group value = entry.getValue();
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public Group[] getGroupsAsArray() {
        return this.groups.values().toArray(new Group[this.groups.size()]);
    }

    public Timeslot getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    public int getLessonRoomType(int lessonid){
        for (Map.Entry<Integer, Lessons> entry : lessons.entrySet()) {
            Lessons value = entry.getValue();
            if(value.getId() == lessonid)
                return 1 ; //value.getType()
        }
        return 1;
    }

    public Rooms getRandomRoom() {
        Object[] roomsArray = this.rooms.values().toArray();
        Rooms room = (Rooms) roomsArray[(int) (roomsArray.length * Math.random())];
        return room;
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

    public int getNumClasses() {
        if (this.numClasses > 0) {
            return this.numClasses;
        }

        int numClasses = 0;
        Group groups[] = this.groups.values().toArray(new Group[this.groups.size()]);
        for (Group group : groups) {
            numClasses += group.getLessonsIds().length;
        }
        this.numClasses = numClasses;

        return this.numClasses;
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
        for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
            Group value = entry.getValue();
            System.out.print(value.getName() + "\t" + " ");
            for(int i = 0; i < value.getLessonsIds().length; i++)
                System.out.print(value.getLessonsIds()[i] + " ");
            System.out.println();
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
