package bme.schoolschedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TimetableInit {

    private final Timetable timetable;

    public TimetableInit(Timetable tt) {
        timetable = tt;
        initTimetable();

        timetable.kiirasC();
        timetable.kiirasL();
        /*timetable.kiirasR();
        timetable.kiirasT();
        timetable.kiirasTS();
    }

    //add teachers, classes, rooms and lessons to the timetable
    private void initTimetable(){
        inputReader("teachers");
        inputReader("lessons");
        inputReader("groups");
        inputReader("rooms");
        inputReader("timeslot");
    }

    private void inputReader(String type) {
        try {
            //fontos hogy a res-ben kell tárolni a fileokat
            int num = 0;
            InputStream in = Main.class.getResourceAsStream("/" + type + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] line = currentLine.split("\t");
                //megnézi hogy miket olvasunk be
                switch (type) {
                    case "groups":
                        timetable.addGroup(num, line[0], Integer.parseInt(line[1]), timetable.getLessons(line[0]));
                        num++;
                        break;
                    case "teachers":
                        timetable.addTeacher(num, line[0], Integer.parseInt(line[1]));
                        num++;
                        break;
                    case "lessons":
                        for(int i = 0; i < Integer.parseInt(line[2]); i++) {
                            timetable.addLessons(num, line[0], line[1], Integer.parseInt(line[2]), timetable.getTeacher(line[3]), room.valueOf(line[4]));
                            num++;
                        }
                        break;
                    case "timeslot":
                        timetable.addTimeslot(num, line[0]);
                        num++;
                        break;
                    default:
                        timetable.addRoom(num, room.valueOf(line[0]), line[1], Integer.parseInt(line[2]));
                        num++;
                        break;
                }

                currentLine = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
