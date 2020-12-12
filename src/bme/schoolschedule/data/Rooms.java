package bme.schoolschedule.data;

import bme.schoolschedule.room;

public class Rooms {
    int id;
    room type;          //some lessons only can be held in a specific type of room
    String name;        //unique, refers to location in the school
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
     public int getCapacity() { return capacity; }
     public int getId() { return id; }
}

