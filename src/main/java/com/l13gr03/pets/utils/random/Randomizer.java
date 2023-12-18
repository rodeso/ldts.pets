package com.l13gr03.pets.utils.random;

public interface Randomizer {
    boolean decide();
    int[] generate3();
    boolean oneInTen(int n);
    boolean oneInFifty(int n);
}

