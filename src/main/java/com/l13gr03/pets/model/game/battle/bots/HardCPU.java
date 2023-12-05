package com.l13gr03.pets.model.game.battle.bots;
import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.Entity;

import static com.l13gr03.pets.utils.calculator.AdvantageCalculator.CHEAT_SHEET;

public class HardCPU extends CPU{
    public HardCPU(){
        super("Hard Bot");
        super.createParty();
    }


    public boolean isDisavantaged(Entity e1, Entity e2){
        if (CHEAT_SHEET.get(e2.getId()) == e1.getId()){
            return true;
        }

        return false;
    }
    public int isAttackSuperEffective(Entity.Attack[] attacks, Entity e){
        for(int i = 0; i < 4; i++)
            if (CHEAT_SHEET.get(attacks[i].getElementId()) == e.getId()){
            return i;
        }
        return 4;
    }
    public Entity.Attack choseAttack(Entity.Attack[] attacks,Entity e){
        if (isAttackSuperEffective(attacks,e) < 4){
            return attacks[isAttackSuperEffective(attacks,e)];
        }
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




