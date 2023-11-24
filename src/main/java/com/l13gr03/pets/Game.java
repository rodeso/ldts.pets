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
import com.l13gr03.pets.model.menu.Settings;

public class Game {
    Menu menu=new Menu();
    Settings settings=new Settings();
    TerminalSize terminalSize;
    private int x=150;
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
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
            } else if (key.getKeyType() == KeyType.EOF) {
                break;
            }
            if (inMenu) {
                if (menu.getFinalOption() > -1) {
                    handleMenu(menu.getFinalOption());
                }
            }
            if (inSettings) {
                if (settings.isConfirm()) {
                    handleSettings(settings.getFinalOption());
                }
            }

        }
    }
    private void handleMenu(int option)throws IOException{

        switch (option){
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
        menu.setFinalOption();

    }

    private void handleSettings(int option)throws IOException{
            switch (option){
                case 0:{
                    x=150;y=50;
                    break;
                }
                case 1:{
                    x=90;y=30;
                    break;
                }
                case 2:{
                    x=110;y=50;
                    break;
                }
            }
            inSettings=false;
            inMenu=true;
            settings.setConfirm();
            terminalSize = new TerminalSize(x, y);
            screen.close(); // Fecha o terminal atual
            screen = new TerminalScreen(new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).createTerminal());
            screen.startScreen();
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
            settings.draw(screen);
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
            settings.processKey(key);
        }
    }

}
