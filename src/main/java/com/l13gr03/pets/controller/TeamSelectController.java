package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.battle.bots.HardCPU;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.states.BattleState;
import com.l13gr03.pets.states.MenuState;

import java.io.IOException;

public class TeamSelectController extends Controller<TeamSelect> {
    public TeamSelectController(TeamSelect teamSelect) {
        super(teamSelect);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        switch (action){
            case UP:
                if (getModel().getCurrentColumn()==0){getModel().previousEntry();}
                if (getModel().getCurrentColumn()==1){getModel().previousTeam();}
                break;
            case DOWN:
                if (getModel().getCurrentColumn()==0){getModel().nextEntry();}
                if (getModel().getCurrentColumn()==1){getModel().nextTeam();}
                break;
            case SELECT:
                if (getModel().getCurrentColumn()==0){

                    if (!getModel().TeamFull()){
                        getModel().teamADD();
                    }
                }
                if (getModel().getCurrentColumn()==1){
                    if (!getModel().TeamEmpty()){
                        getModel().teamRM();
                    }
                }
                if (getModel().getCurrentColumn()==2){
                    game.setState(new MenuState(new Menu()));
                }
                if (getModel().getCurrentColumn()==3){
                    Party party=new Party(getModel().getParty(0), getModel().getParty(1), getModel().getParty(2));
                    Party party1=new HardCPU().createParty();
                    game.setState(new BattleState(new Battlefield(party,party1,getModel().getDiff())));


                }
                break;
            case QUIT:
                game.setState(null);
                break;
            case LEFT:
                getModel().previousColumn();
                break;
            case RIGHT:
                getModel().nextColumn();
        }
    }
}
