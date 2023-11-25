package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model){
        this.model=model;
    }
    public T getModel(){return model;}
    public abstract void step (Game game, GUI.ACTION action, double time) throws IOException;
}
