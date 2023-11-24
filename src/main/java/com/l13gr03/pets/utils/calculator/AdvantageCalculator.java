package com.l13gr03.pets.utils.calculator;

import com.l13gr03.pets.model.game.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class AdvantageCalculator implements Calculator {

    private static final Map<Integer, Integer> CHEAT_SHEET = new HashMap<Integer, Integer>() {{
        put(0, 4);
        put(4, 1);
        put(1, 6);
        put(6, 5);
        put(5, 2);
        put(2, 3);
        put(3, 0);
    }};

    public double execute(Entity.Attack attackerAttack, Entity attacker, Entity defender) {
        if (CHEAT_SHEET.get(attacker.getId()) == defender.getId()) {
            return 2.0;
        } else if (CHEAT_SHEET.get(defender.getId()) == attacker.getId()) {
            return 0.5;
        } else {
            return 1.0;
        }
    }
}


