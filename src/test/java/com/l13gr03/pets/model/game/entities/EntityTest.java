package com.l13gr03.pets.model.game.entities;

import static org.junit.jupiter.api.Assertions.*;

import com.l13gr03.pets.model.game.entities.Entity.Attack;
import com.l13gr03.pets.model.game.entities.species.*;
import org.junit.jupiter.api.Test;

public class EntityTest {


    @Test
    public void testEntityAttack() {
        Attack attack = new Attack("Special", "Seed Bullet","Bio",6,2);
        AquaticAlly aq = new AquaticAlly("Aqua");

        aq.setHP(10);
        aq.setAtk(20);
        aq.setDef(25);
        aq.setSAtk(30);
        aq.setSDef(35);
        aq.setSpd(40);

        assertEquals(10,aq.getHP());
        assertEquals(20,aq.getAtk());
        assertEquals(25,aq.getDef());
        assertEquals(30,aq.getSAtk());
        assertEquals(35,aq.getSDef());
        assertEquals(40,aq.getSpd());

        assertEquals("Special", attack.getType());

        assertEquals("Seed Bullet", attack.getDescription());
        assertEquals("Bio", attack.getAttack_element());
        assertEquals(6, attack.getDamage());
        assertEquals(2, attack.getElementId());


    }

    @Test
    public void testNone() {
        None p = new None("");
        // Test entity creation
        assertEquals("", p.getName());
        //assertNotNull(b.getPosition()); // Assuming position is set elsewhere
        assertEquals(0, p.getId());


        // Test stats getters 0,0,0,0,0,0
        assertEquals(0, p.getHP());
        assertEquals(0, p.getAtk());
        assertEquals(0, p.getDef());
        assertEquals(0, p.getSAtk());
        assertEquals(0, p.getSDef());
        assertEquals(0, p.getSpd());

        assertEquals("", p.getAbility());

    }

    @Test
    public void testAquaticAlly() {
        AquaticAlly b = new AquaticAlly("Blastem");
        // Test entity creation
        assertNotNull(b);
        assertEquals("Blastem", b.getName());
        //assertNotNull(b.getPosition()); // Assuming position is set elsewhere
        assertEquals(1, b.getId());

        
        // Test stats getters 79, 93, 120, 110, 110, 88
        assertEquals(130, b.getHP());
        assertEquals(93, b.getAtk());
        assertEquals(120, b.getDef());
        assertEquals(90, b.getSAtk());
        assertEquals(110, b.getSDef());
        assertEquals(88, b.getSpd());

        // Test attacks getters
        assertEquals("Bubble Shield", b.getAbility());
        assertNotNull(b.getMove(0));
        assertNotNull(b.getMove(1));
        assertNotNull(b.getMove(2));
        assertNotNull(b.getMove(3));

        assertEquals("#87CEFA", b.getColor());
    }
    @Test
    public void testBiomorphicBeast() {
        BiomorphicBeast a = new BiomorphicBeast("Angree");
        // Test entity creation
        assertNotNull(a);
        assertEquals("Angree", a.getName());
        //assertNotNull(venosaurio.getPosition()); // Assuming position is set elsewhere
        assertEquals(2, a.getId());
        
        // Test stats getters 100, 80, 110, 110, 120, 80
        assertEquals(100, a.getHP());
        assertEquals(70, a.getAtk());
        assertEquals(110, a.getDef());
        assertEquals(100, a.getSAtk());
        assertEquals(120, a.getSDef());
        assertEquals(80, a.getSpd());

        // Test attacks getters
        assertEquals("Nature's Gift", a.getAbility());
        assertNotNull(a.getMove(0));
        assertNotNull(a.getMove(1));
        assertNotNull(a.getMove(2));
        assertNotNull(a.getMove(3));

        assertEquals("#A0522D", a.getColor());
    }
    @Test
    public void testCelestialGuardian() {
        CelestialGuardian d = new CelestialGuardian("Doxxis");
        // Test entity creation
        assertNotNull(d);
        assertEquals("Doxxis", d.getName());
        //assertNotNull(d.getPosition()); // Assuming position is set elsewhere
        assertEquals(3, d.getId());
        
        // Test stats getters 50, 150, 50, 150, 50, 150
        assertEquals(50, d.getHP());
        assertEquals(80, d.getAtk());
        assertEquals(50, d.getDef());
        assertEquals(150, d.getSAtk());
        assertEquals(50, d.getSDef());
        assertEquals(100, d.getSpd());

        assertEquals("#A0522D", d.getColor());

        // Test attacks getters
        assertEquals("Cosmic Mind", d.getAbility());
        assertNotNull(d.getMove(0));
        assertNotNull(d.getMove(1));
        assertNotNull(d.getMove(2));
        assertNotNull(d.getMove(3));

        assertEquals("#A0522D", d.getColor());
    }
    @Test
    public void testCyberneticCompanion() {
        CyberneticCompanion m = new CyberneticCompanion("Metagrosso");
        // Test entity creation
        assertNotNull(m);
        assertEquals("Metagrosso", m.getName());
        //assertNotNull(d.getPosition()); // Assuming position is set elsewhere
        assertEquals(4, m.getId());

        // Test stats getters 80, 135, 130, 95, 90, 70
        assertEquals(130, m.getHP());
        assertEquals(110, m.getAtk());
        assertEquals(130, m.getDef());
        assertEquals(70, m.getSAtk());
        assertEquals(90, m.getSDef());
        assertEquals(70, m.getSpd());

        // Test attacks getters
        assertEquals("Metal Power", m.getAbility());
        assertNotNull(m.getMove(0));
        assertNotNull(m.getMove(1));
        assertNotNull(m.getMove(2));
        assertNotNull(m.getMove(3));

        assertEquals("#FFFF00", m.getColor());
    }
    @Test
    public void testLavaLurker() {
        LavaLurker k = new LavaLurker("Nekizal");
        // Test entity creation
        assertNotNull(k);
        assertEquals("Nekizal", k.getName());
        //assertNotNull(d.getPosition()); // Assuming position is set elsewhere
        assertEquals(5, k.getId());

        // Test stats getters 80, 145, 80, 125, 70, 100
        assertEquals(70, k.getHP());
        assertEquals(145, k.getAtk());
        assertEquals(80, k.getDef());
        assertEquals(100, k.getSAtk());
        assertEquals(70, k.getSDef());
        assertEquals(100, k.getSpd());

        // Test attacks getters
        assertEquals("Flame Fists", k.getAbility());
        assertNotNull(k.getMove(0));
        assertNotNull(k.getMove(1));
        assertNotNull(k.getMove(2));
        assertNotNull(k.getMove(3));

        assertEquals("#D0312D", k.getColor());


    }
    @Test
    public void testShadowSpecter() {
        ShadowSpecter n = new ShadowSpecter("Nocturnyx");
        // Test entity creation
        assertNotNull(n);
        assertEquals("Nocturnyx", n.getName());
        //assertNotNull(d.getPosition()); // Assuming position is set elsewhere
        assertEquals(6, n.getId());

        // Test stats getters 69, 150, 70, 121, 70, 120
        assertEquals(69, n.getHP());
        assertEquals(150, n.getAtk());
        assertEquals(70, n.getDef());
        assertEquals(90, n.getSAtk());
        assertEquals(70, n.getSDef());
        assertEquals(70, n.getSpd());

        // Test attacks getters
        assertEquals("Shadow Sneak", n.getAbility());
        assertNotNull(n.getMove(0));
        assertNotNull(n.getMove(1));
        assertNotNull(n.getMove(2));
        assertNotNull(n.getMove(3));

        assertEquals("#800080", n.getColor());

    }
    @Test
    public void testStoneGolem() {
        StoneGolem g = new StoneGolem("Big7");
        // Test entity creation
        assertNotNull(g);
        assertEquals("Big7", g.getName());
        //assertNotNull(d.getPosition()); // Assuming position is set elsewhere
        assertEquals(7, g.getId());

        // Test stats getters 100, 100, 200, 50, 100, 50
        assertEquals(100, g.getHP());
        assertEquals(100, g.getAtk());
        assertEquals(200, g.getDef());
        assertEquals(50, g.getSAtk());
        assertEquals(100, g.getSDef());
        assertEquals(50, g.getSpd());

        // Test attacks getters
        assertEquals("Rough Skin", g.getAbility());
        assertNotNull(g.getMove(0));
        assertNotNull(g.getMove(1));
        assertNotNull(g.getMove(2));
        assertNotNull(g.getMove(3));

        //Test Art
        assertEquals("#FFA500", g.getColor());

    }
}
