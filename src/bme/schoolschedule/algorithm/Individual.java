package bme.schoolschedule.algorithm;

import bme.schoolschedule.Timetable;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    public Individual(Timetable tt){
        int numClasses = tt.getNumClasses();

        //a gene for room, time and teacher
        int chromoLenght = numClasses*3;
        //random individual
        int newChromo[] = new int[chromoLenght];
        int chromoIndex = 0;
        //trough all classes

    }
}
