package bme.schoolschedule;

import bme.schoolschedule.data.Group;
import bme.schoolschedule.data.Lessons;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    public Individual(Timetable timetable) {
        int numClasses = timetable.getNumClasses();

        int chromosomeLength = numClasses * 3;
        int[] newChromosome = new int[chromosomeLength];
        int chromosomeIndex = 0;
        for (Group group : timetable.getGroupsAsArray()) {
            // Loop through module
            for (int LessonId : group.getLessonsIds()) {

                // Add random time
                int timeslotId = timetable.getRandomTimeslot().getId();
                newChromosome[chromosomeIndex] = timeslotId;
                chromosomeIndex++;

                // Add random room
                int roomId = timetable.getRandomRoom(timetable.getLesson(LessonId).getType().toString()).getId();
                newChromosome[chromosomeIndex] = roomId;
                chromosomeIndex++;

                // Add teacher
                Lessons lesson = timetable.getLesson(LessonId);
                newChromosome[chromosomeIndex] = lesson.getTeacher();
                chromosomeIndex++;
            }
        }
        this.chromosome = newChromosome;
    }

    public Individual(int chromosomeLength) {
        // Create random individual
        int[] individual;
        individual = new int[chromosomeLength];

        for (int gene = 0; gene < chromosomeLength; gene++) {
            individual[gene] = gene;
        }

        this.chromosome = individual;
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }

    public int getGene(int offset) {
        return this.chromosome[offset];
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene] + ",";
        }
        return output;
    }

}
