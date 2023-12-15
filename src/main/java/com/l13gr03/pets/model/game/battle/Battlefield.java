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
    private String round;
    private List<String> PokeHP;
    private List<String> Option;
    private List<String> option2;
    private int currentEntry=0;
    private int currentEntry2=-1;
    private int currentColumn=0;

    private List<Round> history;
    private Position position1, position2;
    private Party player1, player2;
    private Entity active1, active2;
    private boolean change1 = false, change2 = false;
    private Entity.Attack attack1, attack2;

    private boolean isGameOver = false;
    private int winner;
    private List<String> poke1Arte;
    private List<String> poke2Arte;
    private String poke1Color;
    private String poke2Color;

    public Battlefield(Party p1, Party p2) {
        history = new Stack<>();
        player1 = p1;
        player2 = p2;
        active1= player1.getP(1);
        active2 = player2.getP(1);
        PokeHP= Arrays.asList(p1.getP(1).getName(),Integer.toString(p1.getP(1).getHP()),p2.getP(1).getName(),Integer.toString(p2.getP(1).getHP()));
        round="ROUND 0";
        Option= Arrays.asList("Attack","Switch");
        option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
        poke1Arte=active1.getArte();poke1Color=active1.getColor();
        poke2Arte=active2.getArte();poke2Color=active2.getColor();
    }
    public int getRoundCounter() {
        return history.size();
    }
    //during battle, both choose the entity they want to choose and the attack, if they want to change they wait a round
    public Round newRound() {
        currentRound = new Round(active1, active2, attack1, attack2, history.size() + 1);
        PokeHP= Arrays.asList(active1.getName(),Integer.toString(active1.getHP()),active2.getName(),Integer.toString(active2.getHP()));
        history.add(currentRound);
        round="ROUND "+ Integer.toString(getRoundCounter());
        return currentRound;
    }
    public void change(int player, int entity) {
        Entity.Attack c = new Entity.Attack("Physical", "Change", "Null", 0, 0);
        if (player == 1) {
            if (!player1.getP(entity).isKO()) {
                active1 = player1.getP(entity);
                attack1 = c;
                change1 = true;
            }
        }
        if (player == 2) {
            if (!player1.getP(entity).isKO()) {
                active2 = player2.getP(entity);
                attack2 = c;
                change2 = true;
            }
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
            break;
        }
    }
    public Entity getActive(int n) {
        return switch (n) {
            case 1 -> active1;
            case 2 -> active2;
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }
    public Party getPlayer(int n) {
        return switch (n) {
            case 1 -> player1;
            case 2 -> player2;
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }
    public List<String> getPokeHP(){return PokeHP;}
    public void setPokeHP(List<String> list){
        PokeHP=list;
    }
    public void setPoke(List<String> poke1,List<String> poke2,String color1,String color2){
        poke1Arte=poke1;
        poke2Arte=poke2;
        poke1Color=color1;
        poke2Color=color2;
    }
    public List<String> getOption(){return Option;}
    public List<String> getOption2(){return option2;}
    public String getRound(){return round;}
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.Option.size() - 1) {
            currentEntry = 0;
            option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
        }else{
            option2= Arrays.asList(player1.getP(1).getName(),player1.getP(2).getName(),player1.getP(3).getName());
        }
    }
    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0) {
            currentEntry = this.Option.size() - 1;
            option2= Arrays.asList(player1.getP(1).getName(),player1.getP(2).getName(),player1.getP(3).getName());
        }
        else{
            option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
        }
    }
    public void nextEntry2() {
        currentEntry2++;
        if (currentEntry2 > this.option2.size() - 1)
            currentEntry2 = 0;
    }

    public void previousEntry2() {
        currentEntry2--;
        if (currentEntry2 < 0)
            currentEntry2 = this.option2.size() - 1;
    }
    public void nextColumn(){
        currentColumn++;
        currentEntry2=0;
    }
    public void previousColumn(){
        currentColumn--;
        currentEntry2=-1;
    }
    public String OptionSelected(){
        return Option.get(currentEntry);
    }
    public String Option2Selected(){
        return option2.get(currentEntry2);
    }
    public int getCurrentColumn(){return currentColumn;}
    public int getCurrentEntry2(){return currentEntry2;}
    public boolean isSelected(int i) {
        return currentEntry2 == i;
    }
    public int getCurrentEntry(){return currentEntry;}
    public List<String> getPoke1Arte(){return poke1Arte;}
    public List<String> getPoke2Arte(){return poke2Arte;}
    public String getPoke1Color(){return poke1Color;}
    public String getPoke2Color(){return poke2Color;}

    public boolean isGameOver() {
        return isGameOver;
    }
    public void makeGameOver() {
        isGameOver = true;
    }
    public void GAMEOVER(int i) {
        winner = i;
        makeGameOver();
    }
    public int getWinner(){
        return winner;
    }

    public class Round {
        private Entity e1, e2;
        private Entity.Attack c1, c2;
        private int d1, d2;
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
                attackerAttack = c1.copy();
                defenderAttack = c2.copy();
            } else {
                attacker = e2;
                defender = e1;
                attackerAttack = c2.copy();
                defenderAttack = c1.copy();
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
            if (Objects.equals(attackerAttack.getDescription(), "Change"))
                attackerAttack.miss();
            if (Objects.equals(defenderAttack.getDescription(), "Change"))
                defenderAttack.miss();

            // Calculate and apply damage to the opposing entity
            Calculator adv = new AdvantageCalculator();
            Calculator phy = new PhysicalDamageCalculator();
            Calculator spe = new SpecialDamageCalculator();
            if (!attackerAttack.missed()) {
                if (Objects.equals(attackerAttack.getType(), "Physical")) {
                    //if physical
                    double d = phy.execute(attackerAttack, attacker, defender);
                    d1 = (int) (d * adv.execute(attackerAttack, attacker, defender));
                    int newDefenderHP = defender.getHP() - d1;
                    //set new hp to the defending entity
                    defender.setHP(Math.max(newDefenderHP, 0));

                } else if (Objects.equals(attackerAttack.getType(), "Special")) {
                    //if special
                    double d = spe.execute(attackerAttack, attacker, defender);
                    d1 = (int) (d * adv.execute(attackerAttack, attacker, defender));
                    int newDefenderHP = defender.getHP() - d1;
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
            if (defender.getHP()==0) defender.makeKO();
            setPokeHP(Arrays.asList(e1.getName(),Integer.toString(e1.getHP()),e2.getName(),Integer.toString(e2.getHP())));
            setPoke(e1.getArte(),e2.getArte(),e1.getColor(),e2.getColor());
            // Check if the defender is still alive and let it attack
            if (!defenderAttack.missed()) {
                if (!defender.isKO()) {
                    if (Objects.equals(defenderAttack.getType(), "Physical")) {
                        //if physical
                        double d = phy.execute(defenderAttack, defender, attacker);
                        d2 = (int) (d * adv.execute(defenderAttack, defender, attacker));
                        int newDefenderHP = attacker.getHP() - d2;
                        //set new hp to the attacking entity
                        attacker.setHP(Math.max(newDefenderHP, 0));

                    } else if (Objects.equals(defenderAttack.getType(), "Special")) {
                        //if special
                        double d = spe.execute(defenderAttack, defender, attacker);
                        d2 = (int) (d * adv.execute(defenderAttack, defender, attacker));
                        int newDefenderHP = attacker.getHP() - d2;
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
            if (attacker.getHP()==0) attacker.makeKO();
            setPokeHP(Arrays.asList(e1.getName(),Integer.toString(e1.getHP()),e2.getName(),Integer.toString(e2.getHP())));
            setPoke(e1.getArte(),e2.getArte(),e1.getColor(),e2.getColor());
            //Force Changes
            if (attacker.isKO()) {
                //force change attacker
                if (attacker == e1) {
                    if (!player1.getP(2).isKO()) {
                        e1 = player1.getP(2);
                        active1 = player1.getP(2);
                        option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
                        currentEntry=0;
                    }
                    else if (!player1.getP(3).isKO()) {
                        e1 = player1.getP(3);
                        active1 = player1.getP(3);
                        option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
                        currentEntry=0;
                    }
                    else if (!player1.getP(1).isKO()) {
                        e1 = player1.getP(1);
                        active1 = player1.getP(1);
                        option2 = Arrays.asList(active1.getMove(0).getDescription(), active1.getMove(1).getDescription(), active1.getMove(2).getDescription(), active1.getMove(3).getDescription());
                        currentEntry=0;
                    }
                        else GAMEOVER(2);
                } else {
                    if (!player2.getP(2).isKO()) {
                        e2 = player2.getP(2);
                        active2 = player2.getP(2);
                    }
                    else if (!player2.getP(3).isKO()) {
                        e2 = player2.getP(3);
                        active2 = player2.getP(3);
                    }
                    else if (!player2.getP(1).isKO()) {
                        e2 = player2.getP(1);
                        active2 = player2.getP(1);
                        option2 = Arrays.asList(active2.getMove(0).getDescription(), active2.getMove(1).getDescription(), active2.getMove(2).getDescription(), active2.getMove(3).getDescription());
                    }
                    else GAMEOVER(1);
                }
            } else if (defender.isKO()) {
                //force change defender
                if (defender == e1) {
                    if (!player1.getP(2).isKO()) {
                        e1 = player1.getP(2);
                        active1 = player1.getP(2);
                        option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
                        currentEntry=0;
                    }
                    else if (!player1.getP(3).isKO()) {
                        e1 = player1.getP(3);
                        active1 = player1.getP(3);
                        option2= Arrays.asList(active1.getMove(0).getDescription(),active1.getMove(1).getDescription(),active1.getMove(2).getDescription(),active1.getMove(3).getDescription());
                        currentEntry=0;
                    }
                    else if (!player1.getP(1).isKO()) {
                        e1 = player1.getP(1);
                        active1 = player1.getP(1);
                        option2 = Arrays.asList(active1.getMove(0).getDescription(), active1.getMove(1).getDescription(), active1.getMove(2).getDescription(), active1.getMove(3).getDescription());
                        currentEntry=0;
                    }
                    else GAMEOVER(2);
                } else {
                    if (!player2.getP(2).isKO()) {
                        e2 = player2.getP(2);
                        active2 = player2.getP(2);
                    }
                    else if (!player2.getP(3).isKO()) {
                        e2 = player2.getP(3);
                        active2 = player2.getP(3);
                    }
                    else if (!player2.getP(1).isKO()) {
                        e2 = player2.getP(1);
                        active2 = player2.getP(1);
                        option2 = Arrays.asList(active2.getMove(0).getDescription(), active2.getMove(1).getDescription(), active2.getMove(2).getDescription(), active2.getMove(3).getDescription());
                    }
                    else GAMEOVER(1);
                }
            }
            setPokeHP(Arrays.asList(e1.getName(),Integer.toString(e1.getHP()),e2.getName(),Integer.toString(e2.getHP())));
            setPoke(e1.getArte(),e2.getArte(),e1.getColor(),e2.getColor());
            //status conditions
            if (attacker.hasCondition()) attacker.setHP(attacker.getHP() - 5);
            if (defender.hasCondition()) defender.setHP(defender.getHP() - 5);
            //end round
            if (defender.getHP()==0) defender.makeKO();
            if (attacker.getHP()==0) attacker.makeKO();
            setPokeHP(Arrays.asList(e1.getName(),Integer.toString(e1.getHP()),e2.getName(),Integer.toString(e2.getHP())));
            setPoke(e1.getArte(),e2.getArte(),e1.getColor(),e2.getColor());
            //Print
            if (Objects.equals(attackerAttack.getDescription(), "Change")) {
                System.out.print(attacker.getName());
                System.out.println(" switched in!");
            } else {
                System.out.print(attacker.getName());
                System.out.print(" used ");
                System.out.print(attackerAttack.getDescription());
                Thread.sleep(1000);
                if (!attackerAttack.missed()) {
                    if (Objects.equals(attackerAttack.getType(), "Status"))
                        System.out.println(" and improved itself!");
                    else {
                        System.out.print(" and dealt ");
                        System.out.print(d1);
                        System.out.print(" of damage!\n");
                    }
                    if (defender.isKO()) {
                        System.out.print(defender.getName());
                        System.out.println(" is knocked out!");
                    }
                } else System.out.println(" but missed!");
            }
            Thread.sleep(2000);
            if (Objects.equals(defenderAttack.getDescription(), "Change")) {
                System.out.print(defender.getName());
                System.out.println(" switched in!");
            } else {
                System.out.print(defender.getName());
                System.out.print(" used ");
                System.out.print(defenderAttack.getDescription());
                Thread.sleep(1000);
                if (!defender.isKO()) {
                    if (!defenderAttack.missed()) {
                        if (Objects.equals(defenderAttack.getType(), "Status"))
                            System.out.println(" and improved itself!");
                        else {
                            System.out.print(" and dealt ");
                            System.out.print(d2);
                            System.out.println(" of damage!");
                        }
                        if (attacker.isKO()) {
                            System.out.print(attacker.getName());
                            System.out.println(" is knocked out!");
                        }
                    } else System.out.println(" but missed!");
                } else System.out.println(" but is knocked out!");
            }

            setPokeHP(Arrays.asList(e1.getName(),Integer.toString(e1.getHP()),e2.getName(),Integer.toString(e2.getHP())));
            setPoke(e1.getArte(),e2.getArte(),e1.getColor(),e2.getColor());
        }
    }
}
