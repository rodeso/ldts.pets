package com.l13gr03.pets.model.game.battle.bots;

import com.l13gr03.pets.model.game.entities.Entity;


public class EasyCPU extends CPU {
    public EasyCPU(){
        super("Easy Bot");
    }

    public int chooseAttack( Entity.Attack[] attacks,Entity e1,Entity e2) {
        return random.nextInt(4);
    }
}
