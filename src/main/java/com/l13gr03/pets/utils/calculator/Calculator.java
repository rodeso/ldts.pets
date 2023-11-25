package com.l13gr03.pets.utils.calculator;

import com.l13gr03.pets.model.game.entities.Entity;

public interface Calculator {
    double execute(Entity.Attack attackerAttack, Entity attacker, Entity defender);
}