package com.l13gr03.pets.model.game.entities;

public class LavaLurker extends Entity{
    private static final int id = 4;
    private static final String ability = "Flame Fists"; // Every time it lands a physical attack 10% chance it burns


    public LavaLurker(String n) {
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
