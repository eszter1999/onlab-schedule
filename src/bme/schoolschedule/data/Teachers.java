package bme.schoolschedule.data;

public class Teachers {
    final int id;
    private final String name;        //unique
    //private final int working_hour;   //the maximum

    public Teachers(int i, String n, int w){
        id = i;
        name = n;
        //working_hour = w;
    }

    public String getName(){
        return name;
    }

    public int getId(){return id;}
    //public int getWorking_hour(){return working_hour;}

}

