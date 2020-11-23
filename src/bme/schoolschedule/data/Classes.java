package bme.schoolschedule.data;

public class Classes {
    final int id;
    private String name;    //unique
    private int number;     //number of students in class

    public Classes(int i, String name, int number) {
        id = i;
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }
    public int getNumber() {return number;}
    public int getId() {return id;}
}
