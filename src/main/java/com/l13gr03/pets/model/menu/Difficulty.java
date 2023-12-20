package com.l13gr03.pets.model.menu;

import java.util.Arrays;
import java.util.List;



public class Difficulty {


    public String header="Choose the difficulty level";
    private final List<String> entries;
    private int currentEntry = 0;

    public Difficulty() {
        this.entries = Arrays.asList("Easy","Medium","Hard", "Back");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public int getCurrentEntry(){return currentEntry;}
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }


}
