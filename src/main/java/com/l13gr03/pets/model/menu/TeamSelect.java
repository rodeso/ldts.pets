package com.l13gr03.pets.model.menu;

import java.util.Arrays;
import java.util.List;

public class TeamSelect {
    private final List<String> entries;
    private int currentEntry = 0;

    public TeamSelect() {
        this.entries = Arrays.asList("Pikachu","Penis","Choura");
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

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public boolean isSelectedPlay() {
        return isSelected(0);
    }
    public boolean isSelectedMulti() {
        return isSelected(1);
    }
    public boolean isSelectedSett() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
