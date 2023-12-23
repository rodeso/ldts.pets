package com.l13gr03.pets.controller;

import com.l13gr03.pets.Game;
import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.model.game.entities.species.AquaticAlly;
import com.l13gr03.pets.model.game.entities.species.BiomorphicBeast;
import com.l13gr03.pets.model.game.entities.species.CelestialGuardian;
import com.l13gr03.pets.states.GameOverState;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class BattleControllerTest {
    @Test
    void testStep() throws IOException {
        // Create mock objects
        AquaticAlly a = new AquaticAlly("A");
        BiomorphicBeast b = new BiomorphicBeast("B");
        CelestialGuardian c = new CelestialGuardian("C");
        Entity.Attack a1 = new Entity.Attack("Physical", "Aqua Jet", "Aquatic", 8, 1);
        Entity.Attack a2 = new Entity.Attack("Special", "Bullet Seed","Bio",6,2);
        Battlefield battlefieldMock = mock(Battlefield.class);
        Game gameMock = mock(Game.class);
        GUI.ACTION actionMock = GUI.ACTION.SELECT;
        double time = 1.0;

        // Create BattleController instance with mock dependencies
        BattleController battleController = new BattleController(battlefieldMock);

        // Stubbing: define the behavior of the mocks
        when(battlefieldMock.getDiff()).thenReturn(1); // Assuming EasyCPU for simplicity
        when(battlefieldMock.getCurrentColumn()).thenReturn(0);
        when(battlefieldMock.getCurrentEntry()).thenReturn(0);
        when(battlefieldMock.getCurrentEntry2()).thenReturn(0);
        when(battlefieldMock.getPlayer(2)).thenReturn(new Party(a,b,c));
        when(battlefieldMock.getActive(2)).thenReturn(a); // Assuming Pokemon class
        when(battlefieldMock.getActive(1)).thenReturn(b);
        when(battlefieldMock.newRound()).thenReturn(battlefieldMock.newRound()); // Assuming Round as an inner class of Battlefield

        // Test the behavior
        battleController.step(gameMock, actionMock, time);

        // Verify that the methods were called as expected
        verify(battlefieldMock, times(1)).previousEntry();
        verify(battlefieldMock, times(1)).attack(1, 0);
        verify(battlefieldMock, times(1)).attack(2, 0);
        verify(battlefieldMock, times(1)).newRound();
        verify(gameMock, times(1)).setState(any(GameOverState.class));
    }
}
