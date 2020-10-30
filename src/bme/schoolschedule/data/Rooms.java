package bme.schoolschedule.data;

import bme.schoolschedule.room;

public class Rooms {
    room type;
    String name;
    int size;

    public Rooms(room t, String n, int s) {
        type = t;
        name = n;
        size = s;
    }
     public String getName(){
        return name;
     }

     public String getType(){
        return type.toString();
     }

}

