package com.l13gr03.pets.model.game.battle;

import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.utils.calculator.AdvantageCalculator;
import com.l13gr03.pets.utils.calculator.Calculator;
import com.l13gr03.pets.utils.calculator.PhysicalDamageCalculator;
import com.l13gr03.pets.utils.calculator.SpecialDamageCalculator;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.StatusRandomizer;
import com.l13gr03.pets.utils.random.TurnRandomizer;

import java.util.*;

public class Battlefield {
    private Round currentRound;
    private String Round;
    private List<String> PokeHP;
    private List<String> Option;
    private String[] option2;

    private List<Round> history;
    private Position position1, position2;
    private Party player1, player2;
    private Entity active1, active2;
    private boolean change1, change2;
    private Entity.Attack attack1, attack2;

    public Battlefield(Party p1, Party p2) {
        history = new Stack<>();
        player1 = p1;
        player2 = p2;
        PokeHP= Arrays.asList(p1.getP(1).getName(),Integer.toString(p1.getP(1).getHP()),p2.getP(2).getName(),Integer.toString(p2.getP(2).getHP()));
        Round="ROUND 0";
        Option= Arrays.asList("Attack","Switch");
    }
    public int getRoundCounter() {
        return history.size();
    }
    //during battle, both choose the entity they want to choose and the attack, if they want to change they wait a round
    public void newRound() {
        if (change1) {attack1.miss();}
        if (change2) {attack2.miss();}
        currentRound = new Round(active1, active2, attack1, attack2, history.size() + 1);
        PokeHP= Arrays.asList(active1.getName(),Integer.toString(active1.getHP()),active2.getName(),Integer.toString(active2.getHP()));
        history.add(currentRound);
        Round="ROUND "+ Integer.toString(getRoundCounter());
    }
    public void change(int player, int entity) {
        if (player == 1) {
            active1 = player1.getP(entity);
            change1 = true;
        }
        if (player == 2) {
            active2 = player2.getP(entity);
            change2 = true;
        }
    }
    public void attack(int player, int attack) {
        if (player == 1) {
            attack1 = active1.getMove(attack);
            change1 = false;
        }
        if (player == 2) {
            attack2 = active2.getMove(attack);
            change2 = false;
        }
    }
    public void showHistory() throws InterruptedException {
        System.out.println("Showing History:");
        for (Round round : history) {
            System.out.println(round.print());
        }
    }


    public class Round {
        private Entity e1, e2;
        private Entity.Attack c1, c2;
        private double d1, d2;
        private int roundNumber;
        private Round(Entity p1, Entity p2, Entity.Attack a1, Entity.Attack a2, int rn) {
            e1 = p1;
            e2 = p2;
            c1 = a1;
            c2 = a2;
            roundNumber = rn;
        }

        public void playRound() throws InterruptedException {
            Randomizer random = new TurnRandomizer();
            Randomizer hit = new StatusRandomizer();

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

            //determine if attack hits
            if (hit.oneInFifty()) {attackerAttack.miss();}
            if (hit.oneInFifty()) {defenderAttack.miss();}


            //start ability
            attacker.useAbility(roundNumber);
            defender.useAbility(roundNumber);
            //use ability
            if (attacker.isAbilityOn()) {
                int c = attacker.getId();
                switch (c) {
                    case 0:
                        break;
                    case 1:
                        defenderAttack.miss();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        defender.setCondition();
                        break;
                    case 6:
                        break;
                    case 7:
                        int newDefenderHP = defender.getHP() - 5;
                        defender.setHP(Math.max(newDefenderHP, 0));
                        break;
                }
            }
            if (defender.isAbilityOn()) {
                int c = defender.getId();
                switch (c) {
                    case 0:
                        break;
                    case 1:
                        attackerAttack.miss();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        attacker.setCondition();
                        break;
                    case 6:
                        break;
                    case 7:
                        int newDefenderHP = attacker.getHP() - 5;
                        attacker.setHP(Math.max(newDefenderHP, 0));
                        break;
                }
            }


            // Calculate and apply damage to the opposing entity
            Calculator adv = new AdvantageCalculator();
            Calculator phy = new PhysicalDamageCalculator();
            Calculator spe = new SpecialDamageCalculator();
            if (!attackerAttack.missed()) {
                if (Objects.equals(attackerAttack.getType(), "Physical")) {
                    //if physical
                    double d = phy.execute(attackerAttack, attacker, defender);
                    d1 = d * adv.execute(attackerAttack, attacker, defender);
                    int newDefenderHP = defender.getHP() - (int) d1;
                    //set new hp to the defending entity
                    defender.setHP(Math.max(newDefenderHP, 0));

                } else if (Objects.equals(attackerAttack.getType(), "Special")) {
                    //if special
                    double d = spe.execute(attackerAttack, attacker, defender);
                    d1 = d * adv.execute(attackerAttack, attacker, defender);
                    int newDefenderHP = defender.getHP() - (int) d1;
                    //set new hp to the defending entity
                    defender.setHP(Math.max(newDefenderHP, 0));
                } else if (Objects.equals(attackerAttack.getType(), "Status")) {
                    //if status
                    int a = attackerAttack.getElementId();
                    switch (a) {
                        case 0: //boost hp
                            attacker.setHP(attacker.getHP() + attackerAttack.getDamage());
                            break;
                        case 1: //boost atk
                            attacker.setAtk(attacker.getAtk() + attackerAttack.getDamage());
                            break;
                        case 2: //boost def
                            attacker.setDef(attacker.getDef() + attackerAttack.getDamage());
                            break;
                        case 3: //boost sp. atk
                            attacker.setSAtk(attacker.getSAtk() + attackerAttack.getDamage());
                            break;
                        case 4: //boost sp. def
                            attacker.setSDef(attacker.getSDef() + attackerAttack.getDamage());
                            break;
                        case 5: //boost speed
                            attacker.setSpd(attacker.getSpd() + attackerAttack.getDamage());
                            break;
                        case 6: //poison or burn
                            defender.setCondition();
                            break;
                        case 7: //nerf atk
                            defender.setAtk(defender.getAtk() - attackerAttack.getDamage());
                            break;
                        case 8: //nerf def
                            defender.setDef(defender.getDef() - attackerAttack.getDamage());
                            break;
                        case 9: //nerf sp. atk
                            defender.setSAtk(defender.getSAtk() - attackerAttack.getDamage());
                            break;
                        case 10: //nerf sp. def
                            defender.setSDef(defender.getSDef() - attackerAttack.getDamage());
                            break;
                        case 11: //nerf speed
                            defender.setSpd(defender.getHP() - attackerAttack.getDamage());
                            break;
                    }

                }
            }

            // Check if the defender is still alive and let it attack
            if (!defenderAttack.missed()) {
                if (defender.getHP() > 0) {
                    if (Objects.equals(defenderAttack.getType(), "Physical")) {
                        //if physical
                        double d = phy.execute(defenderAttack, defender, attacker);
                        d2 = d * adv.execute(defenderAttack, defender, attacker);
                        int newDefenderHP = attacker.getHP() - (int) d2;
                        //set new hp to the attacking entity
                        attacker.setHP(Math.max(newDefenderHP, 0));

                    } else if (Objects.equals(defenderAttack.getType(), "Special")) {
                        //if special
                        double d = spe.execute(defenderAttack, defender, attacker);
                        d2 = d * adv.execute(defenderAttack, defender, attacker);
                        int newDefenderHP = attacker.getHP() - (int) d2;
                        //set new hp to the attacking entity
                        attacker.setHP(Math.max(newDefenderHP, 0));
                    } else if (Objects.equals(attackerAttack.getType(), "Status")) {
                        //if status
                        int a = defenderAttack.getElementId();
                        switch (a) {
                            case 0: //boost hp
                                defender.setHP(defender.getHP() + defenderAttack.getDamage());
                                break;
                            case 1: //boost atk
                                defender.setAtk(defender.getAtk() + defenderAttack.getDamage());
                                break;
                            case 2: //boost def
                                defender.setDef(defender.getDef() + defenderAttack.getDamage());
                                break;
                            case 3: //boost sp. atk
                                defender.setSAtk(defender.getSAtk() + defenderAttack.getDamage());
                                break;
                            case 4: //boost sp. def
                                defender.setSDef(defender.getSDef() + defenderAttack.getDamage());
                                break;
                            case 5: //boost speed
                                defender.setSpd(defender.getSpd() + defenderAttack.getDamage());
                                break;
                            case 6: //poison or burn
                                attacker.setCondition();
                                break;
                            case 7: //nerf atk
                                attacker.setAtk(defender.getAtk() - defenderAttack.getDamage());
                                break;
                            case 8: //nerf def
                                attacker.setDef(defender.getDef() - defenderAttack.getDamage());
                                break;
                            case 9: //nerf sp. atk
                                attacker.setSAtk(defender.getSAtk() - defenderAttack.getDamage());
                                break;
                            case 10: //nerf sp. def
                                attacker.setSDef(defender.getSDef() - defenderAttack.getDamage());
                                break;
                            case 11: //nerf speed
                                attacker.setSpd(defender.getHP() - defenderAttack.getDamage());
                                break;

                        }
                    }

                }
            }
            //status conditions
            if (attacker.hasCondition()) attacker.setHP(attacker.getHP() - 5);
            if (defender.hasCondition()) defender.setHP(defender.getHP() - 5);
            //end round
            print();
        }
        public boolean print() throws InterruptedException {
            System.out.print(e1.getName());
            System.out.print(" used ");
            System.out.print(c1.getDescription());
            Thread.sleep(1000);
            if (!c1.missed()) {
                System.out.print(" and dealt ");
                System.out.print(d1);
                System.out.print(" of damage!\n");
            } else System.out.println(" but missed!");
            Thread.sleep(2000);
            System.out.print(e2.getName());
            System.out.print(" used ");
            System.out.print(c2.getDescription());
            Thread.sleep(1000);
            if (!c2.missed()) {
            System.out.print(" and dealt ");
            System.out.print(d2);
            System.out.print(" of damage!\n");
            } else System.out.println(" but missed!");

            return false;
        }
    }
}
