package com.l13gr03.pets.utils.random;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ThreeRandomizerTest {
    @Test
    void generate3Test(){
        Randomizer r = new ThreeRandomizer();
        assertNotNull(r.generate3());
    }
    @Test
    void oneInTenTest(){
        int n = -1;
        int a = 3;
        Randomizer r = new ThreeRandomizer();

        assertFalse(r.oneInTen(n));
        assertFalse(r.oneInTen(a));
    }
    @Test
    void oneInFiftyTest(){
        int n = -1;
        int a = 3;
        Randomizer r = new ThreeRandomizer();

        assertFalse(r.oneInFifty(n));
        assertFalse(r.oneInFifty(a));
    }
    @Test
    void decideTest(){
        Randomizer r = new ThreeRandomizer();
        assertFalse(r.decide());
    }
}
