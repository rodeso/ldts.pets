package com.l13gr03.pets;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.l13gr03.pets.model.menu.Menu;

import java.io.IOException;
import com.l13gr03.pets.model.menu.Menu;

public class Game {
    Menu menu=new Menu();
    TerminalSize terminalSize;
    private int x=155;
    private int y=50;
    Screen screen;

    boolean inMenu=true;
    boolean inSettings=false;
    boolean inGame=false;
    boolean inMulti=false;
    public Game(){
        try {
            terminalSize = new TerminalSize(x, y);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            screen = new TerminalScreen(terminalFactory.createTerminal());
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void run() throws IOException{
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter()=='q'){
                screen.close();
            } else if (key.getKeyType()==KeyType.EOF) {break;}
            if (menu.getFinalOption()>-1){
                switch (menu.getFinalOption()){
                    case 0:{
                        inMenu=false;
                        inGame=true;
                        break;
                    }
                    case 1:{
                        inMulti=true;
                        inMenu=false;
                        break;
                    }
                    case 2:{
                        inSettings=true;
                        inMenu=false;
                        break;
                    }
                    case 3:{
                        screen.close();
                    }
                }
            }


        }

    }
    public void draw() throws IOException{
        screen.clear();
        if (inMenu){
            menu.draw(screen);
        }
        if (inGame){

        }
        if (inMulti){

        }
        if (inSettings){

        }
        screen.refresh();
    }
    private void processKey(KeyStroke key) {
        if (inMenu){
            menu.processKey(key);
        }
        if (inGame){

        }
        if (inMulti){

        }
        if (inSettings){

        }
    }

}
