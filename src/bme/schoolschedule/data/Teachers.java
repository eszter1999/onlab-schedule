package bme.schoolschedule.data;

public class Teachers {
    String name;        //id
    int working_hour;   //the maximum

    public Teachers(String n, int w){
        name = n;
        working_hour = w;
    }

    public String getName(){
        return name;
    }
}

