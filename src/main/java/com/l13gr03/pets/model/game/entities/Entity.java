package com.l13gr03.pets.model.game.entities;

import com.l13gr03.pets.model.Position;

public abstract class Entity {
    private Position position;
    //Attributes
    private String name;
    private int id;
    private static int nextId = 1;
    private static boolean shiny = false;
    private int[] stats = new int[6];

    //Methods
    public Entity(String n) {
        name = n;
        id = nextId;
        nextId++;
    }
    public void setPosition(Position p) {
        position = p;
    }
    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setStats(int[] newStats) {
        if (newStats.length == stats.length) {
            System.arraycopy(newStats, 0, stats, 0, stats.length);
        } /*else {
            // idk what to do here yet :shrug:
            throw error;
        }*/
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

    public void setShiny() {
        shiny = true;
    }
}
