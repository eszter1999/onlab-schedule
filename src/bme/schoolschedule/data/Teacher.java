package bme.schoolschedule.data;

public class Teacher {
    private final int ID;
    private final String name;
    private int working_hours = 0;

    public Teacher(int Id, String Name){
        this.ID = Id;
        this.name = Name;
    }

    public Teacher( int Id, String name, int workinghours) {
        this.working_hours = workinghours;
        this.ID = Id;
        this.name = name;
    }

    /////*getters*/////

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

}

