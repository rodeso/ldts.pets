package com.l13gr03.pets.model.game.entities;

public class StoneGolem extends Entity{
    private static final int id = 6;
    private static final String ability = "Rough Skin"; //Every time it recives a physical attack deals physical damage to the enemy
    private static final String name = "";


    public StoneGolem(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
}