package com.l13gr03.pets.model.game.battle.bots;

import com.l13gr03.pets.model.game.entities.Entity;


public class EasyCPU extends CPU {
    public EasyCPU(){
        super("Easy Bot");
    }

    public Entity.Attack choseAttack( Entity.Attack[] attacks,Entity e1,Entity e2) {
        int n1 = random.nextInt(4);
        if (n1 == 0) {
            return attacks[0];
        }
        else if (n1 == 1) {
            return attacks[1];
        }
        else if (n1 == 2) {
            return attacks[2];
        }
        else if (n1 == 3) {
            return attacks[3];
        }
        return null;
    }
}
