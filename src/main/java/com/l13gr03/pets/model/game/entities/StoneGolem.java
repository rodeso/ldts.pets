package com.l13gr03.pets.model.game.entities;

public class StoneGolem extends Entity{
    private static final String ability = "Rock Hard"; //+HP


    public StoneGolem(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
