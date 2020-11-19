package me.koply.sahbaturgulbatur.records;

import java.util.LinkedList;

public class Game {

    private String title, description, runwaylength;
    private LinkedList<Horse> horses;

    public void printInformation() {
        System.out.println("-- " + title + " --");
        System.out.println(description);
        System.out.println("Pist uzunluğu: " + runwaylength);
        System.out.println("Atlar: ");
        for (Horse h : horses) {
            h.printInformation();
        }
        System.out.println("-");
    }


    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Game setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRunwaylength() {
        return runwaylength;
    }

    public Game setRunwaylength(String runwaylength) {
        this.runwaylength = runwaylength;
        return this;
    }

    public LinkedList<Horse> getHorses() {
        return horses;
    }

    public Game setHorses(LinkedList<Horse> horses) {
        this.horses = horses;
        return this;
    }
}