package com.l13gr03.pets.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l13gr03.pets.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LanternaGUI implements GUI {
    Screen screen;
    private int x;
    private int y;

    public LanternaGUI(int width, int height) throws IOException/*,FontFormatException, URISyntaxException*/ {
        x=width;y=height;
        TerminalSize terminalSize = new TerminalSize(x, y);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary
    }
    public int getWidth(){return x;}
    public int getHeight(){return y;}

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    public ACTION processKey() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter() == 'q'){
            return ACTION.QUIT;
        }

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }


    @Override
    public void refresh()throws IOException{screen.refresh();}
    @Override
    public void clear()throws IOException{screen.clear();}
    @Override
    public void close()throws IOException{screen.close();}
}
