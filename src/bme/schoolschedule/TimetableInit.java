package bme.schoolschedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TimetableInit {

    private Timetable timetable;

    public TimetableInit(Timetable tt) {
        timetable = tt;
        initTimetable();

        /*timetable.kiirasC();
        timetable.kiirasL();
        timetable.kiirasR();
        timetable.kiirasT();*/
    }

    //add teachers, classes, rooms and lessons to the timetable
    public void initTimetable(){
        inputReader("teachers");
        inputReader("classes");
        inputReader("lessons");
        inputReader("rooms");
    }

    public void inputReader(String type) {
        try {
            //fontos hogy a res-ben kell tárolni a fileokat
            int num = 0;
            InputStream in = Main.class.getResourceAsStream("/" + type + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                num++;
                String[] line = currentLine.split("\t");
                //megnézi hogy miket olvasunk be
                if (type.equals("classes"))
                    timetable.addClass(num, line[0],Integer.parseInt(line[1]));
                else if (type.equals("teachers"))
                    timetable.addTeacher(num, line[0], Integer.parseInt(line[1]));
                else if (type.equals("lessons"))
                    timetable.addLessons(num, timetable.getClasses(line[0]),line[1], Integer.parseInt(line[2]), timetable.getTeacher(line[3]));
                else
                    timetable.addRoom(num, room.valueOf(line[0]), line[1], Integer.parseInt(line[2]));

                currentLine = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
