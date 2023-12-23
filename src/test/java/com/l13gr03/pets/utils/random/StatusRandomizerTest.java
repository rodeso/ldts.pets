package com.l13gr03.pets.utils.random;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatusRandomizerTest {
    @Test
    void oneInTenTest(){
        int n = -1;
        int a = 3;
        Randomizer r = new StatusRandomizer();

        assertTrue(r.oneInTen(n));
        assertFalse(r.oneInTen(a));
    }
    @Test
    void oneInFiftyTest(){
        int n = -1;
        int a = 3;
        Randomizer r = new StatusRandomizer();

        assertTrue(r.oneInFifty(n));
        assertFalse(r.oneInFifty(a));
    }
    @Test
    void generate3Test(){
        Randomizer r = new StatusRandomizer();
        assertNull(r.generate3());
    }
    @Test
    void decideTest(){
        Randomizer r = new StatusRandomizer();
        assertFalse(r.decide());
    }
}
