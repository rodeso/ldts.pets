package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.menu.GameOver;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.model.menu.Settings;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.states.GameOverState;
import com.l13gr03.pets.states.MenuState;
import com.l13gr03.pets.states.SettingsState;
import com.l13gr03.pets.states.TeamSelectState;

import java.io.IOException;

public class    BattleController extends Controller<Battlefield> {
    public BattleController(Battlefield battlefield) {
        super(battlefield);
    }

    @Override
    public void step(Game game, GUI.ACTION action, double time) throws IOException {
        switch (action){
            case UP:
                if (getModel().getCurrentColumn()==0) {
                    getModel().previousEntry();
                }
                else{
                    getModel().previousEntry2();
                }
                break;
            case DOWN:
                if (getModel().getCurrentColumn()==0) {
                    getModel().nextEntry();
                }
                else {
                    getModel().nextEntry2();
                }
                break;
            case SELECT:
                if (getModel().getCurrentEntry()==0){
                    if (getModel().getCurrentEntry2()>=0) {
                        getModel().attack(1, getModel().getCurrentEntry2());
                        getModel().attack(2, 0);
                    }
                }else{
                    if (getModel().getCurrentEntry2()>=0) {
                        getModel().change(1, getModel().getCurrentEntry2() + 1);
                        //getModel().change(2, 1);
                        getModel().attack(2, 0);

                    }
                }
                if (getModel().getCurrentEntry2()>=0) {
                    Battlefield.Round round = getModel().newRound();
                    try {
                        round.playRound();
                    }catch (InterruptedException e){
                        System.out.println("Error");
                    }
                }
                if (getModel().isGameOver()){
                    game.setState(new GameOverState(new GameOver(getModel().getWinner())));
                }

                break;
            case QUIT:
                game.setState(null);
                break;
            case ESCAPE:
                game.setState(new MenuState(new Menu()));
                break;
            case RIGHT:
                if (getModel().getCurrentColumn()==0)
                    getModel().nextColumn();
                break;
            case LEFT:
                if (getModel().getCurrentColumn()==1)
                    getModel().previousColumn();
                break;
        }
    }
}
