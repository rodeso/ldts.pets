package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.Settings;

public class SettingsViewer extends Viewer<Settings> {
    public SettingsViewer(Settings settings) {
        super(settings);
    }

    @Override
    public void drawElements(GUI gui) {
        int centerX= gui.getWidth()/2;
        int centerY=gui.getHeight()/2;
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)){
                String text="> "+ getModel().getEntry(i);
                gui.drawText(new Position(centerX-getModel().getEntry(i).length()/2-2, centerY + i),
                        text,"#FF0000");
            }
            else {
                gui.drawText(
                        new Position(centerX - getModel().getEntry(i).length() / 2, centerY + i),
                        getModel().getEntry(i),
                        "#FFFFFF");
            }
        }
    }
}
