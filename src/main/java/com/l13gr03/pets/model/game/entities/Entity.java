package com.l13gr03.pets.model.game.entities;

import com.l13gr03.pets.model.Position;
import com.l13gr03.pets.model.game.entities.moves.AttackFactory;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.StatusRandomizer;

import java.util.List;

public abstract class Entity {
    private Position position;
    //Attributes
    private final String name;
    private static boolean shiny = false;
    private boolean abilityState = false;
    private boolean condition = false; //false is no condition, true is either burn or poison
    private boolean KO = false;
    private final int[] stats = new int[6];
    private final Attack[] attacks = new Attack[4];
    private List<String> arte;
    private String color;
    private String shcolor;

    //Methods
    public Entity(String n) {
        AttackFactory a = new AttackFactory();
        Randomizer r = new StatusRandomizer();
        if (r.oneInFifty(0)) setShiny();
        name = n;
        setAttacks(a.createAttack(this));
    }
    public abstract int getId();


    public void setPosition(Position p) {
        position = p;
    }
    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    //Stats Setter
    public void setStats(int[] newStats) {
        if (newStats.length == stats.length) {
            System.arraycopy(newStats, 0, stats, 0, stats.length);
        } /*else {
            throw error;
        }*/
    }
    //Attacks Setter
    public void setAttacks(Attack[] newAttacks){
        if (newAttacks.length == attacks.length) {
            System.arraycopy(newAttacks, 0, attacks, 0, attacks.length);
        }
    }
    //Stats Getters
    public int[]getStats(){
        return stats;
    }
    public int getHP() {
        return stats[0];
    }
    public int getAtk() {
        return stats[1];
    }
    public int getDef() {
        return stats[2];
    }
    public int getSAtk() {
        return stats[3];
    }
    public int getSDef() {
        return stats[4];
    }
    public int getSpd() {
        return stats[5];
    }
    //Attacks Getters
    public Attack getMove(int n) {
        if (n<4 && n>=0)
            return attacks[n];
        else return null;
    }
    public Entity.Attack[] getAttacks() {
        return attacks;
    }
    //Shiny Setter
    public void setShiny() {
        shiny = true;
    }
    public boolean isShiny() {
        return shiny;
    }

    public void setHP(int max) {
        stats[0] = max;
    }
    public void setAtk(int max) {
        stats[1] = max;
    }
    public void setDef(int max) {
        stats[2] = max;
    }
    public void setSAtk(int max) {
        stats[3] = max;
    }
    public void setSDef(int max) {
        stats[4] = max;
    }
    public void setSpd(int max) {
        stats[5] = max;
    }

    public void turnAbilityOn(){
        abilityState = true;
    }
    public void turnAbilityOff(){
        abilityState = false;
    }
    public boolean isAbilityOn(){
        return abilityState;
    }

    public void setCondition() {condition = true;}
    public boolean hasCondition() {return condition;}
    public boolean isKO() {return KO;}
    public void makeKO() {KO = true;}

    public abstract void useAbility(int n);

    //Attack Class
    public static class Attack {
        private final String type;
        private final String attack_element;
        private final String description;
        private final int damage;
        private int elementId;
        private boolean miss = false;
        public Attack(String t, String desc,String ae, int d, int eId) {
            type = t;
            description = desc;
            attack_element = ae;
            damage = d;
            elementId = eId;

        }
        public Attack copy() {
            return new Attack(this.type, this.description, this.attack_element, this.damage, this.elementId);
        }
        public int getDamage() {
            return damage;
        }
        public int getElementId() {
            return elementId;
        }

        public String getType() {
            return type;
        }

        public String getDescription() {
            return description;
        }

        public String getAttack_element() { return attack_element; }

        public void setElementId(int eId) { this.elementId = eId; }
        public void miss() {
            miss = true;
        }
        public boolean missed() {
            return miss;
        }
    }
    public List<String> getArte(){return arte;}
    public String getColor(){return color;}
    public String getShColor(){return shcolor;}

}