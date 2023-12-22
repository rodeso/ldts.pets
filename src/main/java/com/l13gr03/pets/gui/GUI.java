package com.l13gr03.pets.gui;

import com.l13gr03.pets.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION processKey() throws IOException;
    void drawText(Position position, String text, String color);
    void refresh() throws IOException;
    void clear()throws IOException;
    void close() throws IOException;
    int getWidth();
    int getHeight();
    enum ACTION{UP,DOWN,LEFT,RIGHT,SELECT,QUIT,NONE,ESCAPE}
}
