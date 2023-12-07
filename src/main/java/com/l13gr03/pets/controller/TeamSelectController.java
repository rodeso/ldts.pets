package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.states.SettingsState;

import java.io.IOException;

public class TeamSelectController extends Controller<TeamSelect> {
    public TeamSelectController(TeamSelect teamSelect) {
        super(teamSelect);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        switch (action){
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedPlay()){int i=0;}
                if (getModel().isSelectedMulti()){int i=0;}
                if (getModel().isSelectedSett()) {game.setState(new SettingsState(new Settings()));}
                if (getModel().isSelectedExit()) {game.setState(null);}
                break;
            case QUIT:
                game.setState(null);
                break;

        }
    }
}
