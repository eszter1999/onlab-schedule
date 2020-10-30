package bme.schoolschedule.data;

public class Teachers {
    String name;
    int working_hour;

    public Teachers(String n, int w){
        name = n;
        working_hour = w;
    }

    public String getName(){
        return name;
    }
}

