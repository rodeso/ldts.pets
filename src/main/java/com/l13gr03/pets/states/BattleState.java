package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.BattleController;
import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.controller.MenuController;
import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.view.BattleViewer;
import com.l13gr03.pets.view.MenuViewer;
import com.l13gr03.pets.view.Viewer;


public class BattleState extends State<Battlefield>{
    public BattleState(Battlefield model) {
        super(model);
    }

    @Override
    protected Viewer<Battlefield> getViewer() {
        return new BattleViewer(getModel());
    }

    @Override
    protected Controller<Battlefield> getController() {
        return new BattleController(getModel());
    }
}
