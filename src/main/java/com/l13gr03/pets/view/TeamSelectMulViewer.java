package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.TeamSelect;
import com.l13gr03.pets.model.menu.TeamSelectMul;

public class TeamSelectMulViewer extends Viewer<TeamSelectMul> {
    public TeamSelectMulViewer(TeamSelectMul teamSelectMul) {
        super(teamSelectMul);
    }

    @Override
    protected void drawElements(GUI gui) {
        int Xentities = 4;
        int Yentities = 2;
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)){
                String text=">"+ getModel().getEntry(i);
                gui.drawText(new Position(Xentities-1, Yentities+2*i),
                        text,"#FF0000");
            }
            else {
                gui.drawText(
                        new Position(Xentities, Yentities + 2*i),
                        getModel().getEntry(i),
                        "#FFFFFF");
            }
        }
        int statsX= gui.getWidth()/2+17;
        int statsY= 2;
        for (int i=0;i < getModel().getNumberStats();i++){

            gui.drawText(
                    new Position(statsX, statsY+ 2*i),
                    Integer.toString(getModel().getStat(i)),
                    "#FFFFFF");

        }
        int teamX= gui.getWidth()/2;
        int teamY= gui.getHeight()/2;
        for (int i=0;i < getModel().getNumberTeam();i++){
            if (getModel().isTeamSelected(i)){
                String text=">"+ getModel().getTeam(i);
                gui.drawText(new Position(teamX-1, teamY+2*i),
                        text,"#FF0000");
            }else {
                gui.drawText(
                        new Position(teamX, teamY + 2 * i),
                        getModel().getTeam(i),
                        "#FFFFFF");
            }
        }
        int statsTX= gui.getWidth()/2;
        int statsTY= 2;
        for (int i=0;i < getModel().getNumberStatType();i++){
            gui.drawText(
                    new Position(statsTX, statsTY + 2*i),
                    getModel().getStatType(i),
                    "#FFFFFF");
        }
        int backX=gui.getWidth()/2+7;
        int backY= gui.getHeight()-3;
        if (getModel().isBackSelect()){
            String text=">"+ getModel().getBack();
            gui.drawText(new Position(backX-1, backY),
                    text,"#FF0000");
        }else {
            gui.drawText(
                    new Position(backX, backY),
                    getModel().getBack(),
                    "#FFFFFF");
        }
        int nextX=gui.getWidth()/2+17;
        int nextY= gui.getHeight()-3;
        if (getModel().TeamFull()){
            if (getModel().isNextSelect()){
                String text=">"+ getModel().getNext();
                gui.drawText(new Position(nextX-1, nextY),
                        text,"#FF0000");
            }else {
                gui.drawText(
                        new Position(nextX, nextY),
                        getModel().getNext(),
                        "#FFFFFF");
            }
        }
    }
}
