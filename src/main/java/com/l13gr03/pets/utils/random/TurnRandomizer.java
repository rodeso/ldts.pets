package com.l13gr03.pets.utils.random;

import java.util.Random;

public class TurnRandomizer implements Randomizer{
    private final Random random;
    public TurnRandomizer() {
        this.random = new Random();
    }
    public boolean decide() {
        return (random.nextInt(2) == 0);
    }
    @Override
    public boolean oneInTen(int n) {
        return false;
    }
    @Override
    public int[] generate3() {
        return null;
    }
    @Override
    public boolean oneInFifty(int n) {
        return false;
    }

}
