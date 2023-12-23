package com.l13gr03.pets.View;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.GameOver;
import com.l13gr03.pets.view.GameOverViewer;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameOverViewTest {
    @Test
    void testDrawElements() {
    int i = 1;
    GameOver go = new GameOver(i);
    GameOverViewer GOV = new GameOverViewer(go);
    String str = new String("Player " + Integer.toString(i)+ " won the game");

    // Criar mocks das classes GUI e Model
    GUI guiMock = mock(GUI.class);
    GameOver modelMock = mock(GameOver.class);
    GameOverViewer GOVMock = mock(GameOverViewer.class);

    // Configurar o estado do seu modelo conforme necessário antes de chamar drawElements
    when(guiMock.getWidth()).thenReturn(100); // Substituir pelos valores reais esperados
    when(guiMock.getHeight()).thenReturn(50); // Substituir pelos valores reais esperados
    when(modelMock.getText()).thenReturn(Arrays.asList("GAME OVER", str, "<Press ENTER to go back to the menu>")); // Substituir pelos valores reais esperados

    // Configurar a chamada do método getModel() no seu objeto yourClass
    when(GOVMock.getModel()).thenReturn(modelMock);

    // Chamar o método drawElements com o mock da GUI
        GOV.drawElements(guiMock);

    // Verificar se o método drawText foi chamado com os parâmetros esperados
    verify(guiMock, times(1)).drawText(
            ArgumentMatchers.any(Position.class), // Usar ArgumentMatchers.any() para o objeto Position
            eq("GAME OVER"),
            eq("#00FFFF")
                        );
    verify(guiMock, times(1)).drawText(
            ArgumentMatchers.any(Position.class), // Usar ArgumentMatchers.any() para o objeto Position
            eq(str),
            eq("#00FFFF")
                        );
    verify(guiMock, times(1)).drawText(
            ArgumentMatchers.any(Position.class), // Usar ArgumentMatchers.any() para o objeto Position
            eq("<Press ENTER to go back to the menu>"),
            eq("#00FFFF")
                        );

    // Verificar outros aspectos relevantes do estado ou comportamento, se necessário
}
}
