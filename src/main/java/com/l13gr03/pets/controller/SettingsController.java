package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class SettingsController extends Controller<Settings> {
    public SettingsController(Settings settings) {
        super(settings);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        try {
            switch (action) {
                case UP:
                    getModel().previousEntry();
                    break;
                case DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if (getModel().isSelectedDefault()) {
                        game.getGui().close();
                        new Game(150,50).start();
                    }
                    if (getModel().isSelectedSmall()) {
                        game.getGui().close();
                        new Game(90,30).start();
                    }
                    if (getModel().isSelectedSquare()) {
                        game.getGui().close();
                        new Game(100,50).start();
                    }
                    if (getModel().isSelectedReturn()) {
                        game.setState(new MenuState(new Menu()));
                    }
                    break;
                case QUIT:
                    game.setState(null);
                    break;

            }
        } catch (IOException | FontFormatException | URISyntaxException e) {
            throw new IOException(e);
        }
    }
}
