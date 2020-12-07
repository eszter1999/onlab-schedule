package bme.schoolschedule.data;

public class Teachers {
    final int id;
    String name;        //unique
    int working_hour;   //the maximum

    public Teachers(int i, String n, int w){
        id = i;
        name = n;
        working_hour = w;
    }

    public String getName(){
        return name;
    }

    public int getId(){return id;}
    public int getWorking_hour(){return working_hour;}

}

