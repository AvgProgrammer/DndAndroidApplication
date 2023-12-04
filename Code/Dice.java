import java.util.Random;
public class Dice {
    public int throwDice(int limit){
        Random rand = new Random();
        int x=0;
        for (int i=0;i<=3;i++){
            x+=rand.nextInt(limit);
        }
        return x/4;
    }
}
