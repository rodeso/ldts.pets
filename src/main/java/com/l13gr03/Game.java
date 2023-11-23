package com.l13gr03;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class Game {
    TerminalSize terminalSize;
    Screen screen;
    public Game(int x, int y){
        try {
            TerminalSize terminalSize = new TerminalSize(x, y);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Screen screen = new TerminalScreen(terminalFactory.createTerminal());
            screen.startScreen();
        } catch (IOException e){e.getStackTrace();}

    }
    public void run() throws IOException{
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter()=='q'){
                screen.close();
            } else if (key.getKeyType()==KeyType.EOF) {break;}



        }

    }
    public void draw() throws IOException{

    }
    private void processKey(KeyStroke key) {

    }

}
