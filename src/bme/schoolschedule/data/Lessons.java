package bme.schoolschedule.data;

public class Lessons {
    Classes classes;
    String name;
    int number;
    Teachers teacher;

    public Lessons(Classes c, String name, int number, Teachers t){
        this.classes = c;
        this.name = name;
        this.number = number;
        this.teacher = t;
    }

    public String getName(){
        return name;
    }
}
