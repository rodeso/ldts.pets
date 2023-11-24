package com.l13gr03.pets.model.game.entities;

public class AquaticAlly extends Entity{
    private static final String ability = "Wet Skin"; //+S.Def


    public AquaticAlly(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
