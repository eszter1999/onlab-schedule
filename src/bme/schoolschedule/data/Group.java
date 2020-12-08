package bme.schoolschedule.data;

public class Group {
    private final int ID;
    private final int size;
    private final int moduleIDs[];

    public Group(int groupId, int groupSize, int moduleIds[]){
        this.ID = groupId;
        this.size = groupSize;
        this.moduleIDs = moduleIds;
    }

    /////*getters*/////

    public int getID(){
        return this.ID;
    }

    public int getSize(){
        return this.size;
    }

    public int[] getModuleIDs(){
        return this.moduleIDs;
    }
}
