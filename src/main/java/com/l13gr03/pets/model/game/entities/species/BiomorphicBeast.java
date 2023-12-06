package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.battle.Battlefield;
import com.l13gr03.pets.model.game.entities.Entity;

public class BiomorphicBeast extends Entity {
    private static final int id = 2;
    private static final String ability = "Nature's Gift"; //Regenerates a certain amount of health each round


    public BiomorphicBeast(String n) {
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
        if(this.getHP() > 0 && this.getHP() < 91){
            if(this.getHP() < 81){
                setHP(getHP() + 10);
            }
            int res = 90 - getHP();
            setHP(getHP() + res);
        }
    }
}
