package com.l13gr03.pets.gui;

import com.l13gr03.pets.model.Position;

import javax.swing.*;
import java.io.IOException;

public interface GUI {
    ACTION processKey() throws IOException;
    public void drawText(Position position, String text, String color);
    public void refresh() throws IOException;
    public void clear()throws IOException;
    public void close() throws IOException;
    public int getWidth();
    public int getHeight();
    enum ACTION{UP,DOWN,LEFT,RIGHT,SELECT,QUIT,NONE}
}
