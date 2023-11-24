package com.l13gr03.pets.model.game.entities;

public class ShadowSpecter extends Entity{
    private static final int id = 5;
    private static final String ability = "Shadow Sneak"; //Always attacks first


    public ShadowSpecter(String n) {
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
