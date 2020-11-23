package bme.schoolschedule.data;

public class Lessons {
    int id;
    Classes classes;    //the students attending the class
    String name;        //the subject of the class
    int number;         //frequency per week
    Teachers teacher;   //who teaches the class
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
}
