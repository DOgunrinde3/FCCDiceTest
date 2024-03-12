import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceGameService {

   private int threes;
   private int numberOfDiceLeft;
   private List<Integer> currentDiceHand = new ArrayList<>();


    public DiceGameService(int numberOfDiceLeft) {
    this.numberOfDiceLeft = numberOfDiceLeft;
    }

    public void play(Player player){
        player.getDices(numberOfDiceLeft);
        currentDiceHand = player.rollDices();
        threes = 0;
        player.setPlayerScore((player.getPlayerScore() + calculateScore()));
        numberOfDiceLeft =  calculateRemainingDice();
    }

    private int calculateScore(){
        Collections.sort(currentDiceHand);
        return getThrees() ? 0 : currentDiceHand.get(0);
    }

    public boolean getThrees(){
        threes = (int) currentDiceHand.stream().filter(integer -> integer == 3).count();
        return threes != 0;
    }

    private int calculateRemainingDice(){
        return getThrees() ? (numberOfDiceLeft - threes) : (numberOfDiceLeft - 1);
    }
    public int getNumberOfDiceLeft() {
        return numberOfDiceLeft;
    }

}
