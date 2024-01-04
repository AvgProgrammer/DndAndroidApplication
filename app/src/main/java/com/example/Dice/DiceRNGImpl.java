package Dice;

public class DiceRNGImpl implements IDiceRNG {
    private final int MIN_ROLL = 1;
    private final int MAX_ROLL = 20;

    @Override
    public int rng() {
        return (int) Math.floor(Math.random() * (MAX_ROLL - MIN_ROLL + 1) + MIN_ROLL);
    }
}
