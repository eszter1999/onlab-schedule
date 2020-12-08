package bme.schoolschedule.data;

public class Timeslot {
    private final int ID;
    private final String timeslot;

    public Timeslot(int timeslotId, String timeslot){
        this.ID = timeslotId;
        this.timeslot = timeslot;
    }

    /////*getters*/////

    public int getID(){
        return this.ID;
    }

    public String getTimeslot(){
        return this.timeslot;
    }
}
