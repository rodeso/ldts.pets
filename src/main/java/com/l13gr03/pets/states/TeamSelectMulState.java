package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.Controller;


import com.l13gr03.pets.controller.TeamSelectMulController;
import com.l13gr03.pets.model.menu.TeamSelectMul;

import com.l13gr03.pets.view.TeamSelectMulViewer;
import com.l13gr03.pets.view.Viewer;

public class TeamSelectMulState extends State<TeamSelectMul>{
    public TeamSelectMulState(TeamSelectMul model) {
        super(model);

    }

    @Override
    protected Viewer<TeamSelectMul> getViewer() {
        return new TeamSelectMulViewer(getModel());
    }

    @Override
    protected Controller<TeamSelectMul> getController() {
        return new TeamSelectMulController(getModel());
    }
}
