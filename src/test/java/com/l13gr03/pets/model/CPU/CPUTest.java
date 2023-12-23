package com.l13gr03.pets.model.CPU;
import static org.junit.jupiter.api.Assertions.*;


import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.battle.bots.CPU;
import com.l13gr03.pets.model.game.battle.bots.EasyCPU;
import com.l13gr03.pets.model.game.battle.bots.HardCPU;
import com.l13gr03.pets.model.game.battle.bots.MediumCPU;
import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.model.game.entities.species.*;
import org.junit.jupiter.api.Test;

public class CPUTest {

    @Test
    void testCPU(){
        CPU c = new MediumCPU();
        assertEquals(c.getName(), "Medium Bot");

    }
    @Test
    public void testEasyCPU() {
        CPU ec = new EasyCPU();
        assertNotNull(ec.chooseAttack(new Entity.Attack[]{
                new Entity.Attack("Special", "Bullet Seed", "Bio", 6, 2),
                new Entity.Attack("Physical", "Vine Whip", "Bio", 18, 2),
                new Entity.Attack("Status", "Poison", "Bio", 5, 7),
                new Entity.Attack("Special", "Magical Shot", "Celestial", 16, 3)}, new AquaticAlly("a"), new LavaLurker("l")));
    }
    @Test
    void testMediumCPU(){
        MediumCPU mc = new MediumCPU();
        AquaticAlly a = new AquaticAlly("A");
        CelestialGuardian c = new CelestialGuardian("C");
        CyberneticCompanion cy = new CyberneticCompanion("CY");
        assertNotNull(mc.chooseAttack(new Entity.Attack[]{
                new Entity.Attack("Special", "Bullet Seed", "Bio", 6, 2),
                new Entity.Attack("Physical", "Vine Whip", "Bio", 18, 2),
                new Entity.Attack("Status", "Poison", "Bio", 5, 7),
                new Entity.Attack("Special", "Magical Shot", "Celestial", 16, 3)}, a, cy));

        assertTrue(mc.isDisadvantaged(a,cy));
        assertFalse(mc.isDisadvantaged(c,a));

        assertNotNull(mc.isAttackSuperEffective(new Entity.Attack[]{
                new Entity.Attack("Special", "Bullet Seed", "Bio", 6, 2),
                new Entity.Attack("Physical", "Vine Whip", "Bio", 18, 2),
                new Entity.Attack("Status", "Poison", "Bio", 5, 7),
                new Entity.Attack("Special", "Magical Shot", "Celestial", 16, 3)},a));

    }
    @Test
    void testHardCPU(){
        HardCPU hc = new HardCPU();
        AquaticAlly a = new AquaticAlly("A");
        CelestialGuardian c = new CelestialGuardian("C");
        CyberneticCompanion cy = new CyberneticCompanion("CY");
        Party p1 = new Party(a,c,cy);
        assertNotNull(hc.chooseAttack(new Entity.Attack[]{
                new Entity.Attack("Special", "Bullet Seed", "Bio", 6, 2),
                new Entity.Attack("Physical", "Vine Whip", "Bio", 18, 2),
                new Entity.Attack("Status", "Poison", "Bio", 5, 7),
                new Entity.Attack("Special", "Magical Shot", "Celestial", 16, 3)}, a, cy));

        assertTrue(hc.isDisadvantaged(a,cy));
        assertFalse(hc.isDisadvantaged(c,a));

        assertNotNull(hc.whatIsBestAttack(new Entity.Attack[]{
                new Entity.Attack("Special", "Bullet Seed", "Bio", 6, 2),
                new Entity.Attack("Physical", "Vine Whip", "Bio", 18, 2),
                new Entity.Attack("Status", "Poison", "Bio", 5, 7),
                new Entity.Attack("Special", "Magical Shot", "Celestial", 16, 3)},a,cy));

        assertNotNull(hc.change(p1,a,c));
    }

}
