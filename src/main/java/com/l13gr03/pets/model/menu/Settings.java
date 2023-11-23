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

public class Settings {
    private int selectedOption = 0;

    private int finalOption=-1;

    boolean confirm=false;

    public Settings() {

    }
    public void draw(Screen screen) throws IOException {

        TextGraphics textGraphics = screen.newTextGraphics();
        int screenWidth = screen.getTerminalSize().getColumns();
        int screenHeight = screen.getTerminalSize().getRows();
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;
        textGraphics.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(centerX - 8 / 2, centerY -1, "Resolution");
        drawOption(screen, textGraphics, "Default: 150x50", 0);
        drawOption(screen, textGraphics, "Small: 90x30", 1);
        drawOption(screen, textGraphics, "Square 50x50", 2);
        drawOption(screen, textGraphics, "Confirm", 3);


    }

    private void drawOption(Screen screen, TextGraphics textGraphics, String text, int optionNumber) {
        TextCharacter arrow = new TextCharacter('>', TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT);
        TextCharacter space = new TextCharacter(' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT);
        TextColor selectedColor = TextColor.ANSI.YELLOW;  // Cor para a opção selecionada

        int screenWidth = screen.getTerminalSize().getColumns();
        int screenHeight = screen.getTerminalSize().getRows();
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

        TerminalPosition position = new TerminalPosition(centerX - text.length() / 2, centerY + optionNumber * 2);

        if (selectedOption == optionNumber) {
            textGraphics.setCharacter(position, new TextCharacter('>', TextColor.ANSI.WHITE, selectedColor));
        } else {
            textGraphics.setCharacter(position, space);
        }

        for (int i = 0; i < text.length(); i++) {
            position = position.withRelativeColumn(1);
            TextCharacter character = new TextCharacter(text.charAt(i));
            if (selectedOption == optionNumber) {
                character = character.withForegroundColor(selectedColor);
            }
            textGraphics.setCharacter(position, character);
        }
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowDown) {
            selectedOption = (selectedOption + 1) % 4; // 4 é o número total de opções no menu
        } else if (key.getKeyType() == KeyType.ArrowUp) {
            selectedOption = (selectedOption - 1 + 4) % 4; // 4 é o número total de opções no menu
        } else if (key.getKeyType() == KeyType.Enter) {
            if (selectedOption!=3) {
                finalOption = selectedOption;
            } else{
                confirm=true;
            }
        }
    }
    public int getFinalOption(){return finalOption;}
    public boolean isConfirm(){return confirm;}
    public void setConfirm(){confirm=false;}
}