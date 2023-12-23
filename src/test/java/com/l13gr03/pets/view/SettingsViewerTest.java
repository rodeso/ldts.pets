package com.l13gr03.pets.view;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.gui.LanternaGUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.Settings;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SettingsViewerTest {
    @Test
    void testDrawElements() throws IOException {
        GUI gui = new LanternaGUI(70, 30, 20);
        int centerX = gui.getWidth() / 2;
        int centerY = gui.getHeight() / 2;
        // Criar mocks
        GUI guiMock = mock(GUI.class);
        Settings modelMock = mock(Settings.class);
        SettingsViewer SVMock = mock(SettingsViewer.class);

        // Configurar o mock para retornar valores esperados
        when(modelMock.getNumberEntries()).thenReturn(3);  // Substitua pelo número desejado de entradas
        when(modelMock.isSelected(0)).thenReturn(true);
        when(modelMock.isSelected(1)).thenReturn(false);
        when(modelMock.isSelected(2)).thenReturn(true);
        when(modelMock.getEntry(0)).thenReturn("Opcao1");
        when(modelMock.getEntry(1)).thenReturn("Opcao2");
        when(modelMock.getEntry(2)).thenReturn("Opcao3");

        // Criar uma instância da sua classe
        SettingsViewer SV = new SettingsViewer(modelMock);

        // Chamar o método a ser testado
        SVMock.drawElements(guiMock);


        // Verificar se o método drawText foi chamado com os parâmetros esperados para cada entrada
        for (int i = 0; i < SV.getModel().getNumberEntries(); i++) {
            if (SV.getModel().isSelected(i)) {
                String text = "> " + SV.getModel().getEntry(i);
                gui.drawText(new Position(centerX - SV.getModel().getEntry(i).length() / 2 - 2, centerY + i),
                        text, "#FF0000");
            } else {
                gui.drawText(
                        new Position(centerX - SV.getModel().getEntry(i).length() / 2, centerY + i),
                        SV.getModel().getEntry(i),
                        "#FFFFFF");
            }


            // Certificar-se de que não há mais interações não verificadas com o mock
            verifyNoMoreInteractions(guiMock);
        }
    }
}
