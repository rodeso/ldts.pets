package com.l13gr03.pets.utils.calculator;

import com.l13gr03.pets.model.game.entities.Entity;

public class PhysicalDamageCalculator implements Calculator{
    public double execute(Entity.Attack attackerAttack, Entity attacker, Entity defender) {
        int moveDamage = attackerAttack.getDamage();
        int power = attacker.getAtk();
        int def = defender.getDef();
        if(attackerAttack.getElementId() == attacker.getId() || attackerAttack.getElementId() == 7){
            return (double) power /def * moveDamage;
        }
        else{
            return (double) power /def * moveDamage * 0.75;
        }
    }

}
