package bme.schoolschedule;

public class Class {
    private final int classId;
    private final int groupId;
    private final int lessonId;
    private int teacherId;
    private int timeslotId;
    private int roomId;

    public Class(int classId, int groupId, int lessonId){
        this.classId = classId;
        this.lessonId = lessonId;
        this.groupId = groupId;
    }


    public void addTeacher(int teacherId){
        this.teacherId = teacherId;
    }

    public void addTimeslot(int timeslotId){
        this.timeslotId = timeslotId;
    }

    public void setRoomId(int roomId){
        this.roomId = roomId;
    }

    public int getClassId(){
        return this.classId;
    }

    public int getGroupId(){
        return this.groupId;
    }

    public int getLessonId(){
        return this.lessonId;
    }

    public int getTeacherId(){
        return this.teacherId;
    }

    public int getTimeslotId(){
        return this.timeslotId;
    }

    public int getRoomId(){
        return this.roomId;
    }
}