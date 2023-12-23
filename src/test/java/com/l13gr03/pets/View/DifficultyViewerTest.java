package com.l13gr03.pets.View;
import com.l13gr03.pets.gui.LanternaGUI;
import com.l13gr03.pets.model.Position;

import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.model.menu.Difficulty;
import com.l13gr03.pets.view.DifficultyViewer;
import org.junit.jupiter.api.Test;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.Difficulty;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class DifficultyViewerTest {
    @Test
    void testDrawElements() throws IOException {
        Difficulty difficulty = new Difficulty();
        DifficultyViewer DV = new DifficultyViewer(difficulty);
        GUI gui = new LanternaGUI(70, 30, 20);
        int centerX = gui.getWidth() / 2;
        int centerY = gui.getHeight() / 2;

        // Criar mocks das classes GUI e Model
        GUI guiMock = mock(GUI.class);
        DifficultyViewer DVMock = mock(DifficultyViewer.class);
        Difficulty modelMock = mock(Difficulty.class);

        // Configurar o estado do seu modelo conforme necessário antes de chamar drawElements
        when(guiMock.getWidth()).thenReturn(100); // Substituir pelos valores reais esperados
        when(guiMock.getHeight()).thenReturn(50); // Substituir pelos valores reais esperados
        when(modelMock.getHeader()).thenReturn("Choose the difficulty level");// Substituir pelos valores reais esperados
        when(modelMock.getNumberEntries()).thenReturn(3);// Substituir pelos valores reais esperados
        when(modelMock.isSelected(anyInt())).thenReturn(false);// Substituir pelos valores reais esperados
        when(modelMock.getEntry(anyInt())).thenReturn("Entry"); // Substituir pelos valores reais esperados

        // Configurar a chamada do método getModel() no seu objeto yourClass
        Mockito.when(DVMock.getModel()).thenReturn(modelMock);

        // Chamar o método drawElements com o mock da GUI
        DV.drawElements(guiMock);


        for (int i = 0; i < DV.getModel().getNumberEntries(); i++) {
            if (DV.getModel().isSelected(i)) {
                String text = "> " + DV.getModel().getEntry(i);
                gui.drawText(new Position(centerX - DV.getModel().getEntry(i).length() / 2 - 2, centerY + i),
                        text, "#FF0000");
            } else {
                gui.drawText(
                        new Position(centerX - DV.getModel().getEntry(i).length() / 2, centerY + i),
                        DV.getModel().getEntry(i),
                        "#FFFFFF");
            }
        }


    }
}
