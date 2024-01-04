package Dice;

public class DiceRoll {
    private int result;
    private int modifier;
    private String description;
    private Dice.IDiceRNG diceRNG;

    public DiceRoll() {
        this.modifier = 0;
        this.description = "D20";
        this.diceRNG=new Dice.DiceRNGImpl();
        roll();
    }

    public DiceRoll(int modifier) {
        this.modifier = modifier;
        this.description = "D20 + " + modifier;
        this.diceRNG=new Dice.DiceRNGImpl();
        roll();
    }

    public DiceRoll(int modifier, String description) {
        this.modifier = modifier;
        this.description = description;
        this.diceRNG=new Dice.DiceRNGImpl();
        roll();
    }

    public void roll(){
        this.result = this.diceRNG.rng() + this.modifier;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getModifier() {
        return this.modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiceRNG(IDiceRNG diceRNG) {
        this.diceRNG = diceRNG;
    }
}
