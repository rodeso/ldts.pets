package com.l13gr03.pets.utils.calculator;

import com.l13gr03.pets.model.game.entities.*;
import com.l13gr03.pets.model.game.entities.species.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testPhysicalDamageCalculator() {
        Calculator physicalDamageCalculator = new PhysicalDamageCalculator();
        Entity.Attack attack = new Entity.Attack("Physical", "Water Slap", "Aquatic",50, 1);
        AquaticAlly attacker = new AquaticAlly("Attacker");
        StoneGolem defender = new StoneGolem("Defender");

        double result = physicalDamageCalculator.execute(attack, attacker, defender);

        // Asserting that the result is within a small tolerance due to double precision
        assertEquals(23.25, result, 0.001); //93/200 * 50
    }

    @Test
    public void testSpecialDamageCalculator() {
        Calculator specialDamageCalculator = new SpecialDamageCalculator();
        Entity.Attack attack = new Entity.Attack("Special", "Seed Bomb", "Bio",60,2);
        BiomorphicBeast attacker = new BiomorphicBeast("Attacker");
        LavaLurker defender = new LavaLurker("Defender");

        double result = specialDamageCalculator.execute(attack, attacker, defender);

        // Asserting that the result is within a small tolerance due to double precision
        assertEquals(94.2857, result, 0.001); //110/70 * 60
    }

    @Test
    public void testSpecialDamageCalculatorIfAttackTypeIsDifferent() {
        Calculator specialDamageCalculator = new SpecialDamageCalculator();
        Entity.Attack attack = new Entity.Attack("Special", "Seed Bomb", "Bio",60,2);
        CelestialGuardian attacker = new CelestialGuardian("Attacker");
        LavaLurker defender = new LavaLurker("Defender");

        double result = specialDamageCalculator.execute(attack, attacker, defender);

        // Asserting that the result is within a small tolerance due to double precision
        assertEquals(96.42857142857142, result, 0.001); // (150/70 * 60) * 0.75
    }

    @Test
    public void testAdvantageCalculator() {
        Calculator advantageCalculator = new AdvantageCalculator();
        Entity.Attack attack = new Entity.Attack("Special", "Cosmic Power","Celestial",70,3);
        CelestialGuardian attacker = new CelestialGuardian("Attacker");
        CyberneticCompanion defender = new CyberneticCompanion("Defender");

        double result = advantageCalculator.execute(attack, attacker, defender);

        assertEquals(2.0, result, 0.001); //SuperEffective
    }
}
