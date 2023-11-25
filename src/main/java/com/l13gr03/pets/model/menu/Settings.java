package com.l13gr03.pets.model.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Settings {
    private final List<String> entries;
    private int currentEntry = 0;

    public Settings() {
        this.entries = Arrays.asList("Default: 150x50","Small: 90x30","Square: 50x50", "Return");
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

    public boolean isSelectedReturn() {
        return isSelected(3);
    }

    public boolean isSelectedDefault() {
        return isSelected(0);
    }
    public boolean isSelectedSmall() {
        return isSelected(1);
    }
    public boolean isSelectedSquare() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
