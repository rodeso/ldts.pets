package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.controller.MenuController;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.view.MenuViewer;
import com.l13gr03.pets.view.Viewer;


public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
