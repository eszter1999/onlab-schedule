package bme.schoolschedule;

import bme.schoolschedule.data.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Timetable {

    private Random randomGenerator;

    private final HashMap<Integer, Rooms> rooms;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, Teachers> teachers;
    private final HashMap<Integer, Lessons> lessons;
    private final HashMap<Integer, Timeslot> timeslots;
    private Class classes[];

    private ArrayList<Integer> pe;
    private ArrayList<Integer> it;
    private ArrayList<Integer> normal;
    private ArrayList<Integer> bio;
    private ArrayList<Integer> phy;
    private ArrayList<Integer> chem;

    private int numClasses = 0;

    public Timetable() {
        randomGenerator = new Random();
        this.rooms = new HashMap<>();
        this.groups = new HashMap<>();
        this.teachers = new HashMap<>();
        this.lessons = new HashMap<>();
        this.timeslots = new HashMap<>();
        this.pe = new ArrayList<>();
        this.it = new ArrayList<>();
        this.normal = new ArrayList<>();
        this.bio = new ArrayList<>();
        this.phy = new ArrayList<>();
        this.chem = new ArrayList<>();
    }

    public Timetable(Timetable cloneable) {
        randomGenerator = new Random();
        this.rooms = cloneable.getRooms();
        this.teachers = cloneable.getTeachers();
        this.lessons = cloneable.getLessons();
        this.groups = cloneable.getGroups();
        this.timeslots = cloneable.getTimeslots();
        this.pe = cloneable.getRooms(room.PE);
        this.it = cloneable.getRooms(room.IT);
        this.normal = cloneable.getRooms(room.NORMAL);
        this.bio = cloneable.getRooms(room.BIO);
        this.phy = cloneable.getRooms(room.PHY);
        this.chem = cloneable.getRooms(room.CHEM);
    }

    private HashMap<Integer, Group> getGroups() {
        return this.groups;
    }

    private HashMap<Integer, Rooms> getRooms() {
        return this.rooms;
    }

    private HashMap<Integer, Timeslot> getTimeslots() {
        return this.timeslots;
    }

    private HashMap<Integer, Lessons> getLessons() {
        return this.lessons;
    }

    private HashMap<Integer, Teachers> getTeachers() {
        return this.teachers;
    }

    public void assortRooms(){
        this.pe = getRooms(room.PE);
        this.it = getRooms(room.IT);
        this.normal = getRooms(room.NORMAL);
        this.bio = getRooms(room.BIO);
        this.phy = getRooms(room.PHY);
        this.chem = getRooms(room.CHEM);
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

    //get lessons for a group
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

    public Teachers getTeacher(int teacherId) {
        return this.teachers.get(teacherId);
    }

    public Timeslot getTimeslot(int timeslotId) {
        return this.timeslots.get(timeslotId);
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

    public Class[] getClasses() {
        return this.classes;
    }

    public Group getGroup(int groupId) {
        return this.groups.get(groupId);
    }


    public Lessons getLesson(int lessonid){
        for (Map.Entry<Integer, Lessons> entry : lessons.entrySet()) {
            Lessons value = entry.getValue();
            if(value.getId() == lessonid)
                return value ; //value.getType()
        }
        return null;
    }

    //get a room
    public Rooms getRoom(int id){
        for (Map.Entry<Integer, Rooms> entry : rooms.entrySet()) {
            Rooms value = entry.getValue();
            if (value.getId() == id){
                return value;
            }
        }
        return null;
    }

    //get rooms of a specified type
    public ArrayList<Integer> getRooms(room room) {
        ArrayList<Integer> r = new ArrayList<>();
        for (Map.Entry<Integer, Rooms> entry : rooms.entrySet()) {
            Rooms value = entry.getValue();
            if (value.getType().equals(room.toString())) {
                r.add(value.getId());
            }
        }
        return r;
    }

    public Timeslot getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    public Group[] getGroupsAsArray() {
        return this.groups.values().toArray(new Group[0]);
    }

    public Rooms getRandomRoom(String type) {
        switch (type) {
            case "IT":
                Rooms room = getRoom(this.it.get((int) (this.it.size() * Math.random())));
                return room;
            case "NORMAL":
                return getRoom(this.normal.get((int) (this.it.size() * Math.random())));
            case "PHY":
                room = getRoom(this.phy.get((int) (this.it.size() * Math.random())));
                return room;
            case "BIO":
                room = getRoom(this.bio.get((int) (this.it.size() * Math.random())));
                return room;
            case "PE":
                room = getRoom(this.pe.get((int) (this.it.size() * Math.random())));
                return room;
            case "CHEM":
                room = getRoom(this.chem.get((int) (this.it.size() * Math.random())));
                return room;
            default:
                return null;
        }
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

    public void createClasses(Individual individual) {
        // Init classes
        Class classes[] = new Class[this.getNumClasses()];

        // Get individual's chromosome
        int chromosome[] = individual.getChromosome();
        int chromosomePos = 0;
        int classIndex = 0;

        for (Group group : this.getGroupsAsArray()) {
            int lessonsIds[] = group.getLessonsIds();
            for (int lessonId : lessonsIds) {
                classes[classIndex] = new Class(classIndex, group.getId(), lessonId);

                // Add timeslot
                classes[classIndex].addTimeslot(chromosome[chromosomePos]);
                chromosomePos++;

                // Add room
                classes[classIndex].setRoomId(chromosome[chromosomePos]);
                chromosomePos++;

                // Add professor
                classes[classIndex].addTeacher(chromosome[chromosomePos]);
                chromosomePos++;

                classIndex++;
            }
        }

        this.classes = classes;
    }

    public int calcClashes() {
        int clashes = 0;

        for (Class classA : this.classes) {
            // Check room capacity
            int roomCapacity = this.getRoom(classA.getRoomId()).getCapacity();
            int groupSize = this.getGroup(classA.getGroupId()).getSize();

            if (roomCapacity < groupSize) {
                clashes++;
            }

            // Check if room is taken
            for (Class classB : this.classes) {
                if (classA.getRoomId() == classB.getRoomId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }

            // Check if professor is available
            for (Class classB : this.classes) {
                if (classA.getTeacherId() == classB.getTeacherId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }
        }

        return clashes;
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
