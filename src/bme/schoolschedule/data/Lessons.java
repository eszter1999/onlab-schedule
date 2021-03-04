package bme.schoolschedule.data;

public class Lessons {
    private final int id;
    private final String group;    //the students attending the class
    private final String name;        //the subject of the class
    private final int number;         //frequency per week
    private final int teacherId;   //who teaches the class
    private final room type;

    public Lessons(int i, String c, String name, int number, int teacher, room r){
        id = i;
        this.group = c;
        this.name = name;
        this.number = number;
        this.teacherId = teacher;
        this.type = r;
    }
    public String getName(){ return name;}
    public String getGroup() {return group;}
    public int getId() {return id;}
    public int getTeacher() { return teacherId; }
    public room getType(){return type;}
}
