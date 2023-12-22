package com.l13gr03.pets.model.game.battle.bots;
import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.utils.calculator.AdvantageCalculator;
import com.l13gr03.pets.utils.calculator.SpecialDamageCalculator;
import com.l13gr03.pets.utils.calculator.Calculator;
import com.l13gr03.pets.utils.calculator.PhysicalDamageCalculator;

import java.util.Objects;
import java.util.Vector;

import static com.l13gr03.pets.utils.calculator.AdvantageCalculator.CHEAT_SHEET;

public class HardCPU extends CPU{
    public HardCPU(){
        super("Hard Bot");
        super.createParty();
    }

    public int change(Party party, Entity current, Entity e) {
        if (CHEAT_SHEET.get(party.getP(1).getId()) == e.getId() && party.getP(1) != current && (!party.getP(1).isKO())) {
            return 1;
        }
        else if (CHEAT_SHEET.get(party.getP(2).getId()) == e.getId() && party.getP(2) != current && (!party.getP(2).isKO())) {
            return 2;
        }
        else if (CHEAT_SHEET.get(party.getP(3).getId()) == e.getId() && party.getP(3) != current && (!party.getP(3).isKO())) {
            return 3;
        }
        else if (party.getP(1) != current && (!party.getP(1).isKO())) {
            return 1;
        }
        else if (party.getP(2) != current && (!party.getP(2).isKO())) {
            return 2;
        }
        else if (party.getP(3) != current && (!party.getP(3).isKO())) {
            return 3;
        }
        else return 0;
    }
    public boolean isDisadvantaged(Entity e1, Entity e2){
        return CHEAT_SHEET.get(e2.getId()) == e1.getId();
    }
    public int whatIsBestAttack(Entity.Attack[] attacks, Entity e1,Entity e2){
        Vector <Double> aux = new Vector<>();
        for(int d = 0; d < 4; d++){
            Calculator spe = new SpecialDamageCalculator();
            Calculator phy = new PhysicalDamageCalculator();
            Calculator adv = new AdvantageCalculator();
            double a=0, b=0;
            if (Objects.equals(attacks[d].getType(), "Physical")) {
                a = phy.execute(attacks[d],e1, e2);
                b = adv.execute(attacks[d],e1,e2);

            }
            else if (Objects.equals(attacks[d].getType(), "Special")) {
                a = spe.execute(attacks[d], e1, e2);
                b = adv.execute(attacks[d], e1, e2);
            }
            aux.add(a*b);
        }

        int position = 0;
        double max = 0.0;
        for(int i = 0; i < 4; i++){
            if(aux.elementAt(i) >= max){
                position = i;
                max = aux.elementAt(i);
            }
        }
        return position;
    }
    public int chooseAttack(Entity.Attack[] attacks,Entity e1,Entity e2){
        if (whatIsBestAttack(attacks,e1,e2) < 4){
            return whatIsBestAttack(attacks,e1,e2);
        }
        return random.nextInt(4);
    }
}




