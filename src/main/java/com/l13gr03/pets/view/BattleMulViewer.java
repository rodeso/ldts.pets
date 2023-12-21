package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.game.battle.BattlefiedlMul;
import com.l13gr03.pets.model.game.battle.Battlefield;

public class BattleMulViewer extends Viewer<BattlefiedlMul> {
    public BattleMulViewer(BattlefiedlMul battlefield) {
        super(battlefield);
    }

    @Override
    public void drawElements(GUI gui) {
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
                        "#00FFFF");
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
                        "#00FFFF");
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
            if (getModel().getCurrentEntry2()>=0) {
                if (getModel().isSelected(i)) {
                    String text = ">" + getModel().getOption2().get(i);
                    gui.drawText(
                            new Position(OP2X - 1, OP2Y + i), text,
                            "#FFD700");
                } else {
                    gui.drawText(
                            new Position(OP2X, OP2Y + i), getModel().getOption2().get(i),
                            "#FFFFFF");
                }
            }
            else{
                gui.drawText(
                        new Position(OP2X, OP2Y + i), getModel().getOption2().get(i),
                        "#FFFFFF");
            }
        }
        int poke1X= 12;
        int poke1Y=gui.getHeight()*2/3-getModel().getPoke1Arte().size()-2;
        for (int i=0;i<getModel().getPoke1Arte().size();i++){
            gui.drawText(
                    new Position(poke1X, poke1Y + i), getModel().getPoke1Arte().get(i),
                    getModel().getPoke1Color());
        }
        int poke2X= gui.getWidth()- getModel().getPokeHP().get(2).length()-2-getModel().getPoke2Arte().get(1).length()-1;
        int poke2Y=5;
        for (int i=0;i<getModel().getPoke2Arte().size();i++){
            gui.drawText(
                    new Position(poke2X, poke2Y + i), getModel().getPoke2Arte().get(i),
                    getModel().getPoke2Color());
        }
    }
}
