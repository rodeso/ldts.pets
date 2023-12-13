package com.l13gr03.pets.utils.calculator;

import com.l13gr03.pets.model.game.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class AdvantageCalculator implements Calculator {

    public static final Map<Integer, Integer> CHEAT_SHEET = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 5);
        put(5, 2);
        put(2, 7);
        put(7, 6);
        put(6, 3);
        put(3, 4);
        put(4, 1);
        put(8, 0);
        put(9, 0);
        put(10, 0);
        put(11, 0);
        put(12, 0);
    }};

    public double execute(Entity.Attack attackerAttack,Entity attacker, Entity defender) {
        if (CHEAT_SHEET.get(attackerAttack.getElementId())== defender.getId()) {
            return 2.0;
        } else if (CHEAT_SHEET.get(defender.getId()) == attackerAttack.getElementId()) {
            return 0.5;
        } else {
            return 1.0;
        }
    }

}




