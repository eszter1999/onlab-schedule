package bme.schoolschedule;

import bme.schoolschedule.data.Group;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    public Individual(Timetable timetable) {
        int numClasses = timetable.getNumClasses();

        int chromosomeLength = numClasses * 3;
        int newChromosome[] = new int[chromosomeLength];
        int chromosomeIndex = 0;
        for (Group group : timetable.getGroupsAsArray()) {
            // Loop through modules
            for (int LessonId : group.getLessonsIds()) {
                // Add random time
                int timeslotId = timetable.getRandomTimeslot().getTimeslotId();
                newChromosome[chromosomeIndex] = timeslotId;
                chromosomeIndex++;

                // Add random room

                /*int roomId = timetable.getRandomRoom().getRoomId();
                newChromosome[chromosomeIndex] = roomId;
                chromosomeIndex++;

                // Add random professor
                Module module = timetable.getModule(moduleId);
                newChromosome[chromosomeIndex] = module.getRandomProfessorId();
                chromosomeIndex++;*/
            }
        }

    }
}
