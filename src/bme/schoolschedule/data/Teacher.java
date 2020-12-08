package bme.schoolschedule.data;

public class Teacher {
    private final int ID;
    private final String name;

    public Teacher(int Id, String Name){
        this.ID = Id;
        this.name = Name;
    }

    /////*getters*/////

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

}

