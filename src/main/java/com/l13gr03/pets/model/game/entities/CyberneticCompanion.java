package com.l13gr03.pets.model.game.entities;

public class CyberneticCompanion extends Entity{
    private static final int id = 3;
    private static final String ability = "Metal Power"; //Boosts the physical attacks


    public CyberneticCompanion(String n) {
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
