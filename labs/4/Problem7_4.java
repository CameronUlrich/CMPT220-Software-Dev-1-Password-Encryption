import java.util.Scanner;


public class Problem7_4 {

    static final int MAX = 100;
    public static void main(String[] args) {

        int[] scores = new int[MAX];
        int numberOfScores = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter grades: ");
        for (int i = 0; i < MAX; i++) {

            int num = input.nextInt();

            if (num < 0)  break;// break out of loop if input is negative

            scores[i] = num;
            numberOfScores++;
        }
        scores[numberOfScores] = -1; // marking last end of array
        int average = getAverage(scores, numberOfScores);
        int aboveAETA = scoresAboveAndEqualToAverage(scores, average);

        System.out.println("Number of scores: " + numberOfScores);
        System.out.println("Average score is: " + average);
        System.out.println("Scores above average = " + aboveAETA);
        System.out.println("Scores below average = " + (numberOfScores - aboveAETA));

    }

    public static int getAverage(int[] scores, int numberOfScores) {
        int total = 0;
        for (int i = 0; scores[i] >= 0; i++) {
            total += scores[i];
        }

        return total / numberOfScores;
    }

    public static int scoresAboveAndEqualToAverage(int[] scores, int average) {
        int count = 0;
        for (int i = 0; scores[i] >= 0; i++) {

            if (scores[i] >= average) count++;
        }

        return count;
    }
}