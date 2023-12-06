package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.game.entities.Entity;

public class AquaticAlly extends Entity {
    private static final int id = 1;
    private static final String ability = "Bubble Shield"; //It defends the first attack


    public AquaticAlly(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }

    public void useAbility(){
        if(Battlefield.getRoundCounter() == 0){ //depois de criar o battlefield ver se este problema continua

    }
}
