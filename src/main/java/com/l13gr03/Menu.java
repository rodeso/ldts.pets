package com.l13gr03;

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
    private int x = 1280;
    private int y = 720;
    private TerminalSize terminalSize;
    private Screen screen;
    private int selectedOption = 0;

    public Menu() {
        try {
            terminalSize = new TerminalSize(155, 50);
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
            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
        }
    }

    public void draw() throws IOException {
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();

        drawOption(textGraphics, "Play", 0);
        drawOption(textGraphics, "Settings", 1);
        drawOption(textGraphics, "Close", 2);

        screen.refresh();
    }

    private void drawOption(TextGraphics textGraphics, String text, int optionNumber) {
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

    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowDown) {
            selectedOption = (selectedOption + 1) % 3; // 3 é o número total de opções no menu
        } else if (key.getKeyType() == KeyType.ArrowUp) {
            selectedOption = (selectedOption - 1 + 3) % 3; // 3 é o número total de opções no menu
        } else if (key.getKeyType() == KeyType.Enter) {
            // Lógica para executar a opção selecionada
            switch (selectedOption) {
                case 0:
                    System.out.println("Opção 'Jogar' selecionada");
                    break;
                case 1:
                    System.out.println("Opção 'Configurações' selecionada");
                    break;
                case 2:
                    System.out.println("Opção 'Fechar' selecionada");
                    try {
                        screen.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
            }
        }
    }
}
