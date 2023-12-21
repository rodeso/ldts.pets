package com.l13gr03.pets.gui;
import com.l13gr03.pets.model.Position;

import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.model.menu.Difficulty;
import com.l13gr03.pets.view.DifficultyViewer;
import org.junit.jupiter.api.Test;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.Difficulty;

import static org.mockito.Mockito.*;

public class DifficultyViewerTest {
    /*@Test
    void testDrawElements() {
        // Criar uma instância da classe que contém o método drawElements
        Difficulty difficulty = new Difficulty();
        DifficultyViewer yourClass = new DifficultyViewer(difficulty);

        // Criar mocks das classes GUI e Model
        GUI guiMock = mock(GUI.class);


        // Configurar o estado do seu modelo conforme necessário antes de chamar drawElements
        when(guiMock.getWidth()).thenReturn(100); // Substituir pelos valores reais esperados
        when(guiMock.getHeight()).thenReturn(50); // Substituir pelos valores reais esperados
        when(getModel().header()).thenReturn("Example Header"); // Substituir pelos valores reais esperados
        when(guiMock.getNumberEntries()).thenReturn(3); // Substituir pelos valores reais esperados
        when(guiMock.isSelected(anyInt())).thenReturn(false); // Substituir pelos valores reais esperados
        when(guiMock.getEntry(anyInt())).thenReturn("Entry"); // Substituir pelos valores reais esperados

        // Configurar a chamada do método getModel() no seu objeto yourClass
        when(yourClass.getModel()).thenReturn(modelMock);

        // Chamar o método drawElements com o mock da GUI
        yourClass.drawElements(guiMock);

        // Verificar se o método drawText foi chamado com os parâmetros esperados
        verify(guiMock, times(1)).drawText(
                new Position(47, 24), // Substituir pelos valores reais esperados para centerX e centerY
                "Example Header",
                "#FFFFFF"
        );

        // Verificar outras chamadas do método drawText conforme necessário para as outras partes do método drawElements
        verify(guiMock, times(3)).drawText(any(Position.class), anyString(), anyString());

        // Verificar outros aspectos relevantes do estado ou comportamento, se necessário
    }*/
}
