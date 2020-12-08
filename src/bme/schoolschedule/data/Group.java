package bme.schoolschedule.data;

public class Group {
    final int id;
    private String name;    //unique
    private int number;     //number of students in class
    private final int lessonsIds[];

    public Group(int i, String name, int number, int[] lessonsIds) {
        id = i;
        this.name = name;
        this.number = number;
        this.lessonsIds = lessonsIds;
    }

    public String getName(){
        return name;
    }
    public int getNumber() {return number;}
    public int getId() {return id;}
    public int[] getLessonsIds() {return lessonsIds;}
}
