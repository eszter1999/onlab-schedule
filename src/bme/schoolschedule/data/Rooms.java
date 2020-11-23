package bme.schoolschedule.data;

import bme.schoolschedule.room;

public class Rooms {
    int id;
    room type;
    String name;    //id
    int capacity;       //capacity

    public Rooms(int id, room t, String n, int s) {
        this.id = id;
        type = t;
        name = n;
        capacity = s;
    }
     public String getName(){
        return name;
     }

     public String getType(){
        return type.toString();
     }

}

