package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.controller.TeamSelectController;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.view.TeamSelectViewer;
import com.l13gr03.pets.view.Viewer;

public class TeamSelectState extends State<TeamSelect> {

    public TeamSelectState(TeamSelect model) {
        super(model);

    }

    @Override
    protected Viewer<TeamSelect> getViewer() {
        return new TeamSelectViewer(getModel());
    }

    @Override
    protected Controller<TeamSelect> getController() {
        return new TeamSelectController(getModel());
    }

}
