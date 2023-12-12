package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.game.entities.Entity;

public class BiomorphicBeast extends Entity {
    private static final int id = 2;
    private static final String ability = "Nature's Gift"; //Regenerates a certain amount of health each round


    public BiomorphicBeast(String n) {
        super(n);
        super.setStats(new int[]{100, 80, 110, 110, 120, 80}); //Mega Venusaur -25
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }

    public void useAbility(int n){
        if(this.getHP() > 0 && this.getHP() < 101){
            if(this.getHP() < 91){
                setHP(getHP() + 10);
            } else {
                int res = 100 - getHP();
                setHP(getHP() + res);
            }
        }
    }
}
