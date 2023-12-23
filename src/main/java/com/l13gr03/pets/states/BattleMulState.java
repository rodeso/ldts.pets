package com.l13gr03.pets.states;

import com.l13gr03.pets.controller.BattleMulController;
import com.l13gr03.pets.controller.Controller;
import com.l13gr03.pets.model.game.battle.BattlefiedlMul;
import com.l13gr03.pets.view.BattleMulViewer;
import com.l13gr03.pets.view.Viewer;

public class BattleMulState extends State<BattlefiedlMul> {
    public BattleMulState(BattlefiedlMul model) {
        super(model);
    }

    @Override
    public Viewer<BattlefiedlMul> getViewer() {
        return new BattleMulViewer(getModel());
    }

    @Override
    public Controller<BattlefiedlMul> getController() {
        return new BattleMulController(getModel());
    }
}
