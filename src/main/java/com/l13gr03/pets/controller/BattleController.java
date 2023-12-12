package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.states.SettingsState;
import com.l13gr03.pets.states.TeamSelectState;

import java.io.IOException;

public class BattleController extends Controller<Battlefield> {
    public BattleController(Battlefield battlefield) {
        super(battlefield);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        switch (action){
            case UP:

                break;
            case DOWN:

                break;
            case SELECT:

                break;
            case QUIT:
                game.setState(null);
                break;

        }
    }
}
