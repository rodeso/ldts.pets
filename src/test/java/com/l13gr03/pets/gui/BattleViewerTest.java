package com.l13gr03.pets.gui;

import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.game.battle.BattlefiedlMul;
import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.species.AquaticAlly;
import com.l13gr03.pets.model.game.entities.species.BiomorphicBeast;
import com.l13gr03.pets.model.game.entities.species.CelestialGuardian;
import com.l13gr03.pets.view.BattleMulViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BattleViewerTest {
    @Test
    void testDrawElements() throws InterruptedException {
        GUI gui;
        AquaticAlly a = new AquaticAlly("A");
        BiomorphicBeast b = new BiomorphicBeast("B");
        CelestialGuardian c = new CelestialGuardian("C");
        Party p1 = new Party(a,b,c);
        Party p2 = new Party(c,b,a);
        BattlefiedlMul battlefield = new BattlefiedlMul(p1,p2);
        // Criar uma instância da classe que contém o método drawElements
        BattleMulViewer BMV = new BattleMulViewer(battlefield);
        // Criar um mock da classe GUI
        GUI guiMock = mock(GUI.class);
        // Configurar o estado do seu modelo conforme necessário antes de chamar drawElements

        // Chamar o método drawElements com o mock da GUI
        BMV.drawElements(guiMock);

        // Verificar se o método drawText foi chamado com os parâmetros esperados
        verify(guiMock, times(1)).drawText(
                new Position(2, 2), // Substituir pelos valores reais esperados para RX e RY
                BMV.getModel().getRound(), // Substituir pelo valor real esperado para getRound()
                "#FFFFFF" // Substituir pelo valor real esperado para a cor
        );

        // Verificar outros aspectos relevantes do estado ou comportamento, se necessário
    }
}
