package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.menu.Menu;

public class BattleViewer extends Viewer<Battlefield> {
    public BattleViewer(Battlefield battlefield) {
        super(battlefield);
    }

    @Override
    protected void drawElements(GUI gui) {
        int RX= 2;
        int RY= 2;
        gui.drawText(
                new Position(RX,RY), getModel().getRound(),
                "#FFFFFF");
        int Poke1X= 2;
        int Poke1Y= gui.getHeight()*2/3-1;
        for (int i=0; i<2;i++){
            gui.drawText(
                    new Position(Poke1X,Poke1Y+i), getModel().getPokeHP().get(i),
                    "#FFFFFF");
            if (i==1){
                gui.drawText(
                        new Position(Poke1X,Poke1Y+i), getModel().getPokeHP().get(i),
                        "#FF0000");
            }
        }
        int Poke2x=gui.getWidth()-getModel().getPokeHP().get(2).length()-2;
        int Poke2y= 2;
        for (int i=0; i<2;i++){
            gui.drawText(
                    new Position(Poke2x,Poke2y+i), getModel().getPokeHP().get(2+i),
                    "#FFFFFF");
            if (i==1){
                gui.drawText(
                        new Position(Poke2x,Poke2y+i), getModel().getPokeHP().get(2+i),
                        "#FF0000");
            }
        }
        for (int i=0;i<gui.getWidth();i++ ){
            gui.drawText(
                    new Position(i,Poke1Y+3), "_",
                    "#FFFFFF");
        }
        int OPX= 2;
        int OPY= gui.getHeight()*2/3+5;
        for (int i=0;i<getModel().getOption().size();i++){
            if (getModel().getOption().get(i).equals(getModel().OptionSelected())){
                String text =">"+getModel().getOption().get(i);
                gui.drawText(
                        new Position(OPX-1, OPY + 2 * i), text,
                        "#FF0000");
            }else {
                gui.drawText(
                        new Position(OPX, OPY + 2 * i), getModel().getOption().get(i),
                        "#FFFFFF");
            }
        }
        int OP2X= gui.getWidth()/3;
        int OP2Y= gui.getHeight()*2/3+5;
        for (int i=0;i<getModel().getOption2().size();i++){
            gui.drawText(
                    new Position(OP2X, OP2Y + i), getModel().getOption2().get(i),
                    "#FFFFFF");
        }
    }
}
