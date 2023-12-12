package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.GameOver;
import com.l13gr03.pets.model.menu.Menu;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    protected void drawElements(GUI gui) {
        int centerX = gui.getWidth()/2;
        int centerY = gui.getHeight()/2;
        for (int i = 0; i < getModel().getText().size(); i++) {
            gui.drawText(
                    new Position(centerX - getModel().getText().get(i).length() / 2, centerY + 2*i),
                    getModel().getText().get(i),
                    "#00FFFF");
        }
    }
}
