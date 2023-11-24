package com.l13gr03.pets.model.game.entities;

public class ShadowSpecter extends Entity{
    private static final String ability = "Shadow Body"; //Gains the opponents ability


    public ShadowSpecter(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
