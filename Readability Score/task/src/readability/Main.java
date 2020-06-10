package readability;


import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inputMessage = MyReadFile.readFile(args[0]);
        Counter.scanInputMessage(inputMessage);

        Formulas formulas = new Formulas();
        double firstScore = formulas.firstFormula();
        double secondScore = formulas.secondFormula();
        double thirdScore = formulas.thirdFormula();
        double fourthScore = formulas.fourthFormula();

        System.out.printf("Words: %d%n", Counter.getWordCount());
        System.out.printf("Sentences: %d%n", Counter.getSentenceCount());
        System.out.printf("Characters: %d%n", Counter.getCharCount());
        System.out.printf("Syllables: %d%n", Counter.getSylables());
        System.out.printf("Polysyllables: %d%n", Counter.getPolysyllables());
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): \n");

        String userPick = scanner.nextLine();
        double averageAge = (double) (ageFromScore(firstScore) + ageFromScore(secondScore)
                + ageFromScore(thirdScore) + ageFromScore(fourthScore)) / 4;

        switch (userPick) {
            case "ARI":
                System.out.printf("Automated Readability Index: %.2f (about %d year olds).%n", firstScore, ageFromScore(firstScore));
                break;
            case "FK":
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).%n", secondScore, ageFromScore(secondScore) );
                break;
            case "SMOG":
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).", thirdScore, ageFromScore(thirdScore) );
                break;
            case "CL":
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds).", fourthScore, ageFromScore(fourthScore));
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f (about %d year olds).%n", firstScore, ageFromScore(firstScore) );
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).%n", secondScore, ageFromScore(secondScore) );
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).%n", thirdScore, ageFromScore(thirdScore) );
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds).%n%n", fourthScore, ageFromScore(fourthScore));

                System.out.printf("This text should be understood in average by %.2f year olds.", averageAge);
        }
    }

    private static int ageFromScore(double score) {
        int scoreRound = (int) Math.ceil(score);
        switch (scoreRound) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
                return 24;
            case 14:
                return 25;
            default:
                return 25;
        }
    }
}
