package com.l13gr03.pets.model.game.battle;

import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.utils.calculator.AdvantageCalculator;
import com.l13gr03.pets.utils.calculator.Calculator;
import com.l13gr03.pets.utils.calculator.PhysicalDamageCalculator;
import com.l13gr03.pets.utils.calculator.SpecialDamageCalculator;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.TurnRandomizer;

import java.util.Objects;
import java.util.Stack;

public class Battlefield {
    private Round currentRound;
    private int height, width;
    private Stack<Round> history;
    private Position position1, position2;
    private Party player1, player2;

    public Battlefield(int h, int w, Party p1, Party p2) {
        height = h;
        width = w;
        history = new Stack<>();
        player1 = p1;
        player2 = p2;
    }
    public int getRoundCounter() {
        return history.size();
    }

    public void newRound(Entity p1, Entity p2, Entity.Attack a1, Entity.Attack a2, boolean change1, boolean change2) {
        if (change1) {a1 = null;}
        if (change2) {a2 = null;}
        currentRound = new Round(p1, p2, a1, a2, history.size() + 1);
        history.push(currentRound);
    }

    public class Round {
        private Entity e1, e2;
        private Entity.Attack c1, c2;
        private int roundNumber;
        private Round(Entity p1, Entity p2, Entity.Attack a1, Entity.Attack a2, int rn) {
            e1 = p1;
            e2 = p2;
            c1 = a1;
            c2 = a2;
            roundNumber = rn;
        }

        public void playRound() { //TODO: Add isAbilityOn() to inflict burn or thorns on the opponent
            Randomizer random = new TurnRandomizer();

            // Determine which entity attacks first based on speed
            Entity attacker, defender;
            Entity.Attack attackerAttack, defenderAttack;

            if (e1.getSpd() > e2.getSpd() || (e1.getSpd() == e2.getSpd() && random.decide())) {
                attacker = e1;
                defender = e2;
                attackerAttack = c1;
                defenderAttack = c2;
            } else {
                attacker = e2;
                defender = e1;
                attackerAttack = c2;
                defenderAttack = c1;
            }
            // Calculate and apply damage to the opposing entity
            Calculator adv = new AdvantageCalculator();
            Calculator phy = new PhysicalDamageCalculator();
            Calculator spe = new SpecialDamageCalculator();

            if (Objects.equals(attackerAttack.getType(), "Physical")) {
                //if physical
                double d = phy.execute(attackerAttack, attacker, defender);
                double damage = d * adv.execute(attackerAttack, attacker, defender);
                int newDefenderHP = defender.getHP() - (int) damage;
                //set new hp to the defending entity
                defender.setHP(Math.max(newDefenderHP, 0));

            } else if (Objects.equals(attackerAttack.getType(), "Special")) {
                //if special
                double d = spe.execute(attackerAttack, attacker, defender);
                double damage = d * adv.execute(attackerAttack, attacker, defender);
                int newDefenderHP = defender.getHP() - (int) damage;
                //set new hp to the defending entity
                defender.setHP(Math.max(newDefenderHP, 0));
            } else if (Objects.equals(attackerAttack.getType(), "Status")) {
                int a = attackerAttack.getElementId();
                switch (a) {
                    case 0:
                        attacker.setHP(attacker.getHP()+attackerAttack.getDamage());
                        break;
                    case 1:
                        attacker.setAtk(attacker.getAtk());
                }

            }

            // Check if the defender is still alive and let it attack
            if (defender.getHP() > 0) {
                if (Objects.equals(defenderAttack.getType(), "Physical")) {
                    //if physical
                    double d = phy.execute(defenderAttack, defender, attacker);
                    double damage = d * adv.execute(defenderAttack, defender, attacker);
                    int newDefenderHP = attacker.getHP() - (int) damage;
                    //set new hp to the attacking entity
                    attacker.setHP(Math.max(newDefenderHP, 0));

                } else if (Objects.equals(defenderAttack.getType(), "Special")) {
                    //if special
                    double d = spe.execute(defenderAttack, defender, attacker);
                    double damage = d * adv.execute(defenderAttack, defender, attacker);
                    int newDefenderHP = attacker.getHP() - (int) damage;
                    //set new hp to the attacking entity
                    attacker.setHP(Math.max(newDefenderHP, 0));
                }
            }
        }
    }
}
