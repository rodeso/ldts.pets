package com.l13gr03.pets.model.game.battle.bots;
import com.l13gr03.pets.model.game.entities.Entity;


import static com.l13gr03.pets.utils.calculator.AdvantageCalculator.CHEAT_SHEET;

public class MediumCPU extends CPU {
        public MediumCPU(){
            super("Medium Bot");
            super.createParty();
        }


        public boolean isDisadvantaged(Entity e1, Entity e2){
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
        public int chooseAttack(Entity.Attack[] attacks,Entity e1,Entity e2){
            if (isAttackSuperEffective(attacks,e2) < 4){
                return isAttackSuperEffective(attacks,e2);
            } else {
                return random.nextInt(4);
            }
        }
}

