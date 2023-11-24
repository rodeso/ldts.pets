package com.l13gr03.pets.model.game.entities;

public class CyberneticCompanion extends Entity{
    private static final String ability = "Metal Body"; //+Def


    public CyberneticCompanion(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
