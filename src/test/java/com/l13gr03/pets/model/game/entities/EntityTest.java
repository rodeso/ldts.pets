package com.l13gr03.pets.model.game.entities;

import static org.junit.jupiter.api.Assertions.*;

import com.l13gr03.pets.model.game.entities.Entity.Attack;
import org.junit.jupiter.api.Test;

public class EntityTest {

    @Test
    public void testAquaticAlly() {
        AquaticAlly reumatoide = new AquaticAlly("Reumatoide");
        // Test entity creation
        assertNotNull(reumatoide);
        assertEquals("Reumatoide", reumatoide.getName());
        //assertNotNull(reumatoide.getPosition()); // Assuming position is set elsewhere
        assertEquals(1, reumatoide.getId());

        reumatoide.setStats(new int[]{79, 83, 100, 85, 105, 78});
        reumatoide.setAttacks(new Attack[]{
                new Attack("Special", "Aqua Jet", 30),
                new Attack("Physical", "Hydro Pump", 90),
                new Attack("Status", "Blizzard", 80),
                new Attack("Physical", "Tackle", 40)});
        // Test stats getters
        assertEquals(79, reumatoide.getHP());
        assertEquals(83, reumatoide.getAtk());
        assertEquals(100, reumatoide.getDef());
        assertEquals(85, reumatoide.getSAtk());
        assertEquals(105, reumatoide.getSDef());
        assertEquals(78, reumatoide.getSpd());

        // Test attacks getters
        assertEquals("Bubble Shield", reumatoide.getAbility());
        assertNotNull(reumatoide.getFirst());
        assertNotNull(reumatoide.getSecond());
        assertNotNull(reumatoide.getThird());
        assertNotNull(reumatoide.getFourth());
    }
    @Test
    public void testBiomorphicBeast() {
        BiomorphicBeast venusaurio = new BiomorphicBeast("Venusaurio");
        // Test entity creation
        assertNotNull(venusaurio);
        assertEquals("Venusaurio", venusaurio.getName());
        //assertNotNull(venosaurio.getPosition()); // Assuming position is set elsewhere
        assertEquals(1, venusaurio.getId());

        venusaurio.setStats(new int[]{90, 83, 60, 85, 105, 30});
        venusaurio.setAttacks(new Attack[]{
                new Attack("Physical", "Bullet Seed", 30),
                new Attack("Special", "Vine Whip", 90),
                new Attack("Status", "Poison", 80),
                new Attack("Physical", "Tackle", 40)});
        // Test stats getters
        assertEquals(90, venusaurio.getHP());
        assertEquals(83, venusaurio.getAtk());
        assertEquals(60, venusaurio.getDef());
        assertEquals(85, venusaurio.getSAtk());
        assertEquals(105, venusaurio.getSDef());
        assertEquals(30, venusaurio.getSpd());

        // Test attacks getters
        assertEquals("Nature's Gift", venusaurio.getAbility());
        assertNotNull(venusaurio.getFirst());
        assertNotNull(venusaurio.getSecond());
        assertNotNull(venusaurio.getThird());
        assertNotNull(venusaurio.getFourth());
    }
    @Test
    public void testCelestialGuardian() {
        CelestialGuardian doxxis = new CelestialGuardian("Doxxis");
        // Test entity creation
        assertNotNull(doxxis);
        assertEquals("Doxxis", doxxis.getName());
        //assertNotNull(doxxis.getPosition()); // Assuming position is set elsewhere
        assertEquals(1, doxxis.getId());

        doxxis.setStats(new int[]{50, 150, 50, 150, 50, 150});
        doxxis.setAttacks(new Attack[]{
                new Attack("Status", "Calm Mind", 30),
                new Attack("Special", "Psychic Shock", 90),
                new Attack("Special", "Blizzard", 80),
                new Attack("Physical", "Tackle", 40)});
        // Test stats getters
        assertEquals(50, doxxis.getHP());
        assertEquals(150, doxxis.getAtk());
        assertEquals(50, doxxis.getDef());
        assertEquals(150, doxxis.getSAtk());
        assertEquals(50, doxxis.getSDef());
        assertEquals(150, doxxis.getSpd());

        // Test attacks getters
        assertEquals("Cosmic Mind", doxxis.getAbility());
        assertNotNull(doxxis.getFirst());
        assertNotNull(doxxis.getSecond());
        assertNotNull(doxxis.getThird());
        assertNotNull(doxxis.getFourth());
    }
}
