package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.menu.Difficulty;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.states.MenuState;
import com.l13gr03.pets.states.SettingsState;
import com.l13gr03.pets.states.TeamSelectState;

import java.io.IOException;

public class DifficultyController extends Controller<Difficulty> {

    public DifficultyController(Difficulty difficulty) {
        super(difficulty);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                switch (getModel().getCurrentEntry()){
                    case 0:{game.setState(new TeamSelectState(new TeamSelect(1)));
                            break;
                    }
                    case 1:{game.setState(new TeamSelectState(new TeamSelect(2)));
                            break;
                    }
                    case 2:{game.setState(new TeamSelectState(new TeamSelect(3)));
                            break;
                    }
                    case 3:{game.setState(new MenuState(new Menu()));
                        break;
                    }
                }
                break;
            case QUIT:
                game.setState(null);

                break;

        }
    }
}
