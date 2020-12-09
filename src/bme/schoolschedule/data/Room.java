package bme.schoolschedule.data;

import bme.schoolschedule.roomType;

public class Room {
    private final int ID;
    private final String roomNumber;
    private final int capacity;
    private final roomType type;

    public Room(int roomId, roomType rt, String roomNumber, int capacity) {
        this.ID = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = rt;
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

