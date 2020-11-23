package bme.schoolschedule.data;

public class Teachers {
    int id;
    String name;        //id
    int working_hour;   //the maximum

    public Teachers(int i, String n, int w){
        id = i;
        name = n;
        working_hour = w;
    }

    public String getName(){
        return name;
    }
}

