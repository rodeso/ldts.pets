package com.l13gr03.pets.view;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.Settings;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SettingsViewerTest {
        private GUI gui;
        private Settings settings;
        private SettingsViewer viewer;

        @BeforeEach
        void setMenu () {
            settings = new Settings();
            viewer = new SettingsViewer(settings);
            gui = Mockito.mock(GUI.class);
        }

        @Test
        void testDrawElements () throws IOException, InterruptedException {
            viewer.draw(gui);
            int centerX = gui.getWidth() / 2;
            int centerY = gui.getHeight() / 2;
            for (int i = 0; i < settings.getNumberEntries(); i++) {
                if (settings.isSelected(i)) {
                    String expectedText = "> " + settings.getEntry(i);
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
