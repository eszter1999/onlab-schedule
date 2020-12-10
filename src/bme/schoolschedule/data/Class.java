package bme.schoolschedule.data;

public class Class {
    private final int classID;
    private final int groupID;
    private final int moduleID;
    private int teacherID;
    private int timeslotID;
    private int roomID;

    public Class(int classId, String name,  int groupId, int moduleId){
        this.classID = classId;
        this.moduleID = moduleId;
        this.groupID = groupId;
    }

    /////*adders*/////

    public void addTeacher(int professorId){
        this.teacherID = professorId;
    }

    public void addTimeslot(int timeslotId){
        this.timeslotID = timeslotId;
    }

    /////*setter*/////

    public void setRoomId(int roomId){
        this.roomID = roomId;
    }

    /////*getters*/////

    public int getClassID(){
        return this.classID;
    }

    public int getGroupID(){
        return this.groupID;
    }

    public int getModuleID(){
        return this.moduleID;
    }

    public int getTeacherID(){
        return this.teacherID;
    }

    public int getTimeslotID(){
        return this.timeslotID;
    }

    public int getRoomID(){
        return this.roomID;
    }
}
