package bme.schoolschedule.data;

public class Module {
    private final int ID;
    //private final String code;
    private final String name;
    private final int teacherIDs[];

    public Module(int moduleId, String moduleCode, String module, int professorIds[]){
        this.ID = moduleId;
        this.code = moduleCode;
        this.name = module;
        this.teacherIDs = professorIds;
    }

    /////*getters*/////

    public int getID(){
        return this.ID;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public int getRandomTeacherID(){
        int tid = teacherIDs[(int) (teacherIDs.length * Math.random())];
        return tid;
    }
}
