package com.l13gr03.pets.model.game.entities;

import com.l13gr03.pets.model.Position;

public abstract class Entity {
    private Position position;
    //Attributes
    private String name;
    private final int id = 0;
    private static boolean shiny = false;
    private int[] stats = new int[6];
    private Attack[] attacks = new Attack[4];

    //Methods
    public Entity(String n) {name = n;}
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
            // idk what to do here yet :shrug:
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
    public Attack getFirst() {
        return attacks[0];
    }
    public Attack getSecond() {
        return attacks[1];
    }
    public Attack getThird() {
        return attacks[2];
    }
    public Attack getFourth() {
        return attacks[3];
    }
    //Shiny Setter
    public void setShiny() {
        shiny = true;
    }

    public void setHP(int max) {
        stats[0] = max;
    }

    //Attack Class
    public static class Attack {
        private String type;
        private String attack_element;
        private String description;
        private int damage;
        private int elementId;
        public Attack(String t, String desc,String ae, int d, int eId) {
            type = t;
            description = desc;
            attack_element = ae;
            damage = d;
            elementId = eId;

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
    }

}
