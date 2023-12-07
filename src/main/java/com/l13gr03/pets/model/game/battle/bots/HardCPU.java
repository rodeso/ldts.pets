package com.l13gr03.pets.model.game.battle.bots;
import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.utils.calculator.AdvantageCalculator;
import com.l13gr03.pets.utils.calculator.SpecialDamageCalculator;
import com.l13gr03.pets.utils.calculator.Calculator;
import com.l13gr03.pets.utils.calculator.PhysicalDamageCalculator;

import java.lang.reflect.Array;
import java.util.Vector;

import static com.l13gr03.pets.utils.calculator.AdvantageCalculator.CHEAT_SHEET;

public class HardCPU extends CPU{
    public HardCPU(){
        super("Hard Bot");
        super.createParty();
    }

    public void change(Entity p1, Entity p2, Entity p3, Entity e) {
        if (CHEAT_SHEET.get(p1.getId()) == e.getId()) {
            Entity active1 = p1;
            boolean change1 = true;
        }
        else if (CHEAT_SHEET.get(p2.getId()) == e.getId()) {
            Entity active2 = p2;
            boolean change2 = true;
        }
        else if (CHEAT_SHEET.get(p3.getId()) == e.getId()) {
            Entity active3 = p3;
            boolean change3 = true;
        }
    }
    public boolean isDisavantaged(Entity e1, Entity e2){
        if (CHEAT_SHEET.get(e2.getId()) == e1.getId()){
            return true;
        }

        return false;
    }
    public int whatIsBestAttack(Entity.Attack[] attacks, Entity e1,Entity e2){
        Vector <Double> aux = new Vector<>();
        for(int d = 0; d < 4; d++){
            Calculator dmg = new SpecialDamageCalculator();
            double a = dmg.execute(attacks[d],e1, e2);
            Calculator adv = new AdvantageCalculator();
            double b = adv.execute(attacks[d],e1,e2);
            aux.add(a*b);
        }
        int position = 0;
        double max = 0.0;
        for(int i = 0; i < 4; i++){
            if(aux.elementAt(i) > max){
                position = i;
                max = aux.elementAt(i);
            }
        }
        return position;
    }
    public Entity.Attack choseAttack(Entity.Attack[] attacks,Entity e1,Entity e2){
        if (whatIsBestAttack(attacks,e1,e2) < 4){
            return attacks[whatIsBestAttack(attacks,e1,e2)];
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




