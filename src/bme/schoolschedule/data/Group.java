package bme.schoolschedule.data;

public class Group {
    final int id;
    private String name;    //unique
    private int size;     //number of students in class
    private final int lessonsIds[];

    public Group(int i, String name, int number, int[] lessonsIds) {
        id = i;
        this.name = name;
        this.size = number;
        this.lessonsIds = lessonsIds;
    }

    public String getName(){
        return name;
    }
    public int getSize() {return size;}
    public int getId() {return id;}
    public int[] getLessonsIds() {return lessonsIds;}
}
