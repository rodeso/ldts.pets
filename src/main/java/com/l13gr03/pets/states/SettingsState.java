package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.controller.SettingsController;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.view.SettingsViewer;
import com.l13gr03.pets.view.Viewer;

public class SettingsState  extends State<Settings>{
    public SettingsState(Settings model){super(model);};
    @Override
    protected Viewer<Settings> getViewer() {
        return new SettingsViewer(getModel());
    }

    @Override
    protected Controller<Settings> getController() {
        return new SettingsController(getModel());
    }
}
