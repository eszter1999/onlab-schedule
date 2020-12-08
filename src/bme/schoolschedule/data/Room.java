package bme.schoolschedule.data;

import bme.schoolschedule.roomType;

public class Room {
    private final int ID;
    private final String roomNumber;
    private final int capacity;

    public Room(int roomId, String roomNumber, int capacity) {
        this.ID = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    /////*getters*////
    public int getID() {
        return this.ID;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }
}

