package bme.schoolschedule.data;

import bme.schoolschedule.room;

public class Lessons {
    int id;
    String group;    //the students attending the class
    String name;        //the subject of the class
    int number;         //frequency per week
    int teacherId;   //who teaches the class
    room type;

    /*to set*/
    int time; //to change from int
    Rooms room; //where

    public Lessons(int i, String c, String name, int number, int teacher, room r){
        id = i;
        this.group = c;
        this.name = name;
        this.number = number;
        this.teacherId = teacher;
        this.type = r;
    }
    public String getName(){ return name;}
    public String getGroup() {return group;}
    public int getId() {return id;}
    public int getNumber() {return number;}
    public int getTeacher() { return teacherId; }
    public Rooms getRoom() { return room; }
    public room getType(){return type;}

    public void setTime(int time) {this.time = time;}
    public int getTime() {return time;}
    public void setRoom(Rooms room) {this.room=room;}


    /*public String toString(){
        String s = "time" + " - " + "room" +
        return "";
    }*/
}
