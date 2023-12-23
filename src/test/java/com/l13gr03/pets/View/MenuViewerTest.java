package com.l13gr03.pets.View;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.Menu;
import com.l13gr03.pets.view.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    private GUI gui;
    private Menu menu;
    private MenuViewer viewer;

    @BeforeEach
    void setMenu() {
        menu = new Menu();
        viewer = new MenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawMenu() throws IOException, InterruptedException {
        viewer.draw(gui);
        int centerX = gui.getWidth()/2;
        int centerY = gui.getHeight()/2;
        for (int i = 0; i < menu.getNumberEntries(); i++) {
            if(menu.isSelected(i)){
            String expectedText = "> " + menu.getEntry(i);
            Position expectedPosition = new Position(centerX - expectedText.length() / 2 - 2, centerY + i);
            String expectedColor = "#FF0000";

            Mockito.verify(gui, Mockito.times(1)).drawText(
                    ArgumentMatchers.any(Position.class),
                    ArgumentMatchers.eq(expectedText),
                    ArgumentMatchers.eq(expectedColor)
            );
            }
        }
    }
}
