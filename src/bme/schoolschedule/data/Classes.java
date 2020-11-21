package bme.schoolschedule.data;

public class Classes {
   private String name;
   private int number; //number of students in class

    public Classes(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }
}
