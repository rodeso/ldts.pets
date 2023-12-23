package com.l13gr03.pets.states;
import com.l13gr03.pets.controller.BattleMulController;
import com.l13gr03.pets.model.game.battle.BattlefiedlMul;
import com.l13gr03.pets.view.BattleMulViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class BattleMulStateTest {
    @Test
    void testGetViewerAndController() {


        BattlefiedlMul BMMock = mock(BattlefiedlMul.class);
        BattleMulViewer BMVMock = mock(BattleMulViewer.class);
        BattleMulController BMCMock = mock(BattleMulController.class);
        BattleMulState BMSMock = mock(BattleMulState.class);

        // Create the BattleMulState instance with mocks
        BattleMulState BMS = new BattleMulState(BMMock);

        // Stubbing: define the behavior of the mocks
        when(BMSMock.getViewer()).thenReturn(BMVMock);
        when(BMSMock.getController()).thenReturn(BMCMock);

        // Test the behavior
        // Verify that the methods were called as expected
        verify(BMSMock, times(1)).getViewer();
        verify(BMSMock, times(1)).getController();
    }
}
