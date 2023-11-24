package com.l13gr03.pets.model.game.entities;

public class AquaticAlly extends Entity{
    private static final int id = 0;
    private static final String ability = "Bubble Shield"; //It defends the first attack


    public AquaticAlly(String n) {
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
