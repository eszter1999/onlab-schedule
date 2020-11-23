package bme.schoolschedule.data;

public class Lessons {
    final int id;
    final Classes classes;    //the students attending the class
    final String name;        //the subject of the class
    final int number;         //frequency per week
    final Teachers teacher;   //who teaches the class
    /*to set*/
    int time; //to change from int
    Rooms room; //where

    public Lessons(int i, Classes c, String name, int number, Teachers t){
        id = i;
        this.classes = c;
        this.name = name;
        this.number = number;
        this.teacher = t;
    }
    public String getName(){ return name;}
    public Classes getClasses() {return classes;}
    public int getId() {return id;}
    public int getNumber() {return number;}
    public Teachers getTeacher() { return teacher; }

    public void setTime(int time) {this.time = time;}
    public int getTime() {return time;}
    public void setRoom(Rooms room) {this.room=room;}
    public Rooms getRoom() { return room; }

    /*public String toString(){
        String s = "time" + " - " + "room" +
        return "";
    }*/
}
