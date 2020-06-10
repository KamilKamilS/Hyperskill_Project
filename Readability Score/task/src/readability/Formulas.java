package readability;

import org.hamcrest.Matcher;

public class Formulas {


    public double firstFormula() {
        double words = Counter.getWordCount();
        double charCount = Counter.getCharCount();
        double sentence = Counter.getSentenceCount();

        double score = 4.71 * ((double) charCount / words) + 0.5 *((double) words / sentence) - 21.43;
        return score;
    }

    public double secondFormula() {
        double words = Counter.getWordCount();
        double sentences = Counter.getSentenceCount();
        double syllables = Counter.getSylables();

        return (0.39 * words / sentences + 11.8 * syllables / words -15.59);
    }

    public double thirdFormula() {
        double polysyllables = Counter.getPolysyllables();
        double sentence = Counter.getSentenceCount();

        double score = 1.043 * Math.sqrt(polysyllables * 30 / sentence) + 3.1291;
        return score;
    }

    public double fourthFormula() {
        double l =  Counter.getCharCount() * 100 / (double) Counter.getWordCount();
        double s =  Counter.getSentenceCount() * 100 / (double) Counter.getWordCount();



        double score = 0.0588 * l - 0.296 * s - 15.8;
        return score;
    }
}
