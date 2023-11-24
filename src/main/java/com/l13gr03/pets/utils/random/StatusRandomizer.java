package com.l13gr03.pets.utils.random;

import java.util.Random;

public class StatusRandomizer implements Randomizer{
    private final Random random;
    public StatusRandomizer() {
        this.random = new Random();
    }
    public boolean oneInTen() {
        return (random.nextInt(10) == 0);
    }
    public boolean oneInFifty() {
        return (random.nextInt(50) == 0);
    }
}
