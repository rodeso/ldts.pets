package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.menu.GameOver;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.states.MenuState;
import com.l13gr03.pets.states.SettingsState;
import com.l13gr03.pets.states.TeamSelectState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        switch (action){

            case SELECT:
                game.setState(new MenuState(new Menu()));
                break;
            case QUIT:
                game.setState(null);

                break;

        }
    }
}
