package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.controller.DifficultyController;
import com.l13gr03.pets.model.menu.Difficulty;
import com.l13gr03.pets.view.DifficultyViewer;
import com.l13gr03.pets.view.Viewer;

public class DifficultyState extends State<Difficulty>{

    public DifficultyState(Difficulty difficulty) {
        super(difficulty);
    }

    @Override
    protected Viewer<Difficulty> getViewer() {
        return new DifficultyViewer(getModel());
    }

    @Override
    protected Controller<Difficulty> getController() {
        return new DifficultyController(getModel());
    }
}
