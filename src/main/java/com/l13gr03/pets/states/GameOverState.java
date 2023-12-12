package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.controller.GameOverController;
import com.l13gr03.pets.controller.MenuController;
import com.l13gr03.pets.model.menu.GameOver;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.view.GameOverViewer;
import com.l13gr03.pets.view.MenuViewer;
import com.l13gr03.pets.view.Viewer;

public class GameOverState extends State<GameOver>{
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
