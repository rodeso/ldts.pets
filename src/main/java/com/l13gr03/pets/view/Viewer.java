package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    public T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}
