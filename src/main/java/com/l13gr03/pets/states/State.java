package com.l13gr03.pets.states;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, double time) throws IOException {
        GUI.ACTION action = gui.processKey();
        controller.step(game, action,time);
        viewer.draw(gui);
    }
}
