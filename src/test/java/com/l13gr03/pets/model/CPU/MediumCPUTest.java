package com.l13gr03.pets.model.CPU;

import com.l13gr03.pets.model.game.battle.bots.MediumCPU;
import com.l13gr03.pets.model.game.entities.Entity;
import org.junit.jupiter.api.Test;
import com.l13gr03.pets.model.game.entities.species.*;
import com.l13gr03.pets.model.game.entities.Entity.Attack;
import static com.l13gr03.pets.utils.calculator.AdvantageCalculator.CHEAT_SHEET;
import static org.junit.jupiter.api.Assertions.*;

public class MediumCPUTest {

    @Test
    public void testIsDisadvantaged(){
        LavaLurker l = new LavaLurker("Pau");
        AquaticAlly a = new AquaticAlly("Pau2");


        assertEquals(CHEAT_SHEET.put(a.getId(), l.getId()),(CHEAT_SHEET.put(1,5)));
    }

}





