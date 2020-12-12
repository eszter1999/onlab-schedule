package bme.schoolschedule;

import bme.schoolschedule.data.Group;
import bme.schoolschedule.data.Lessons;

import java.util.ArrayList;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    public Individual(Timetable timetable) {
        int numClasses = timetable.getNumClasses();

        int chromosomeLength = numClasses * 3;
        int[] newChromosome = new int[chromosomeLength];
        int chromosomeIndex = 0;
        for (Group group : timetable.getGroupsAsArray()) {
            // Loop through modules
            ArrayList<Integer> timeslots = new ArrayList<>();
            for (int LessonId : group.getLessonsIds()) {
                // Add random time
                /*Boolean check = true;
                int random = 0;
                int id = 0;

                while (check) {
                    check = false;
                    random = timetable.getTimeslot(id).getTimeslotId();
                    for (int str : timeslots) {
                        if (random == str) {
                            check = true;
                            break;
                        }
                    }
                    id++;
                }*/

                int timeslotId = timetable.getRandomTimeslot().getTimeslotId();
                timeslots.add(timeslotId);
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


    public Individual(int[] chromosome) {
        // Create individual chromosome
        this.chromosome = chromosome;
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

    public boolean containsGene(int gene) {
        for (int i = 0; i < this.chromosome.length; i++) {
            if (this.chromosome[i] == gene) {
                return true;
            }
        }
        return false;
    }

}
