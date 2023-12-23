package com.l13gr03.pets.view;

import com.l13gr03.pets.gui.GUI;
import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.menu.TeamSelectMul;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class TeamSelectMulViewerTest {
    @Test
    void testDrawElements() {
        // Create a mock GUI
        GUI gui = Mockito.mock(GUI.class);

        // Create a TeamSelectMul instance for testing
        // You need to replace TeamSelectMul with the actual class if it's not provided in the question
        TeamSelectMul teamSelectMul = new TeamSelectMul(/* initialize with necessary parameters */);

        // Create a TeamSelectMulViewer instance with the mock model
        TeamSelectMulViewer teamSelectMulViewer = new TeamSelectMulViewer(teamSelectMul);

        // Call the drawElements method
        teamSelectMulViewer.drawElements(gui);

        // Verify that the gui.drawText method is called with the expected arguments

        // Example: Verify for the first entry when isSelected is true
        String expectedText = "> " + teamSelectMul.getEntry(0);
        Position expectedPosition = new Position(4 - 1, 2 + 2 * 0);
        String expectedColor = "#FF0000";
        Mockito.verify(gui, Mockito.times(1)).drawText(
                ArgumentMatchers.eq(expectedPosition),
                ArgumentMatchers.eq(expectedText),
                ArgumentMatchers.eq(expectedColor)
        );

        // Example: Verify for the second entry when isSelected is false
        expectedText = teamSelectMul.getEntry(1);
        expectedPosition = new Position(4, 2 + 2 * 1);
        expectedColor = "#FFFFFF";
        Mockito.verify(gui, Mockito.times(1)).drawText(
                ArgumentMatchers.eq(expectedPosition),
                ArgumentMatchers.eq(expectedText),
                ArgumentMatchers.eq(expectedColor)
        );

        // Add more verification for other parts of the drawElements method
        // ...

        // Example: Verify for the back button when isBackSelect is true
        expectedText = "> " + teamSelectMul.getBack();
        expectedPosition = new Position(gui.getWidth() / 2 + 7 - 1, gui.getHeight() - 3);
        expectedColor = "#FF0000";
        Mockito.verify(gui, Mockito.times(1)).drawText(
                ArgumentMatchers.eq(expectedPosition),
                ArgumentMatchers.eq(expectedText),
                ArgumentMatchers.eq(expectedColor)
        );

        // Example: Verify for the next button when TeamFull is true and isNextSelect is true
        if (teamSelectMul.TeamFull()) {
            expectedText = "> " + teamSelectMul.getNext();
            expectedPosition = new Position(gui.getWidth() / 2 + 17 - 1, gui.getHeight() - 3);
            expectedColor = "#FF0000";
            Mockito.verify(gui, Mockito.times(1)).drawText(
                    ArgumentMatchers.eq(expectedPosition),
                    ArgumentMatchers.eq(expectedText),
                    ArgumentMatchers.eq(expectedColor)
            );
        }

        // You can continue adding more verifications based on the logic in your drawElements method
    }
}
