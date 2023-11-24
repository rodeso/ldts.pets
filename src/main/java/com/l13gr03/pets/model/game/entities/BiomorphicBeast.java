package com.l13gr03.pets.model.game.entities;

public class BiomorphicBeast extends Entity{
    private static final String ability = "Nature's gift"; //Regenerates a certain amount of health each round


    public BiomorphicBeast(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
