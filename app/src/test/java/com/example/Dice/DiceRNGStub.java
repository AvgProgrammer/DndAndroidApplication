package Dice;

import Dice.IDiceRNG;

public class DiceRNGStub implements IDiceRNG {
    @Override
    public int rng() {
        return 15;
    }

}
