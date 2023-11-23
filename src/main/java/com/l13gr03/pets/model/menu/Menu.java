package com.l13gr03.pets.model.menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;


import java.io.IOException;

public class Menu {


    private int selectedOption = 0;

    private int finalOption=-1;

    public Menu() {

    }
    public void draw(Screen screen) throws IOException {

        TextGraphics textGraphics = screen.newTextGraphics();

        drawOption(screen, textGraphics, "Play", 0);
        drawOption(screen, textGraphics, "Multiplayer", 1);
        drawOption(screen, textGraphics, "Settings", 2);
        drawOption(screen, textGraphics, "Close", 3);


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
            // Lógica para executar a opção selecionada
            finalOption=selectedOption;
        }
    }
    public int getFinalOption(){return finalOption;}
}
