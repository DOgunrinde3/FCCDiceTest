import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> allGameScores = new ArrayList<>();
        int numberOfSimulations = 10000;
        int numberOfDices = 5;

        for(int i = 0; i < numberOfSimulations; i++) {
            Player player = new Player();
            DiceGameService diceGame = new DiceGameService(numberOfDices);
            while (diceGame.getNumberOfDiceLeft() != 0) {
                diceGame.play(player);
            }
            allGameScores.add(player.getPlayerScore());
        }
        System.out.println(String.format("Number of simulations was %s using %s dice ", numberOfSimulations , numberOfDices));
        printOccurences(allGameScores);

    }

    private static void printOccurences(List<Integer> totalScore){
        List<Integer> distinctNumbers = totalScore.stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctNumbers);
        for (int i = 0; i < distinctNumbers.size(); i++){
            int index = i;
            int numberOfOccurrences = (int) totalScore.stream().filter(integer -> integer == distinctNumbers.get(index)).count();
            System.out.println("Total " + distinctNumbers.get(i) + " occurs " + String.format("%.2f", (double) numberOfOccurrences / totalScore.size()) + " occurred " + numberOfOccurrences + " times");

        }
    }
}