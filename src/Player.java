import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Dice> dices;
    private int playerScore;


    public Player() {

    }
    public void getDices(int numberOfDicesLeft){
        dices = new ArrayList<>();
        for (int i = 0; i < numberOfDicesLeft; i++) {
            dices.add(new Dice());
        }
    }
    public List<Integer> rollDices() {
        List<Integer> results = new ArrayList<>();
        for (Dice dice : dices) {
            results.add(dice.roll());
        }
        return results;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}