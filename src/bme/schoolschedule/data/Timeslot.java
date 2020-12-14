package bme.schoolschedule.data;

public class Timeslot {
    private final int id;
    private final String time;

    public Timeslot(int timeslotId, String time) {
        this.id = timeslotId;
        this.time = time;
    }

    public int getId(){
        return this.id;
    }

    public String getTime(){
        return this.time;
    }
}
