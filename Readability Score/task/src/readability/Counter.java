package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {

    private static int sentenceCount = 0;
    private static int charCount = 0;
    private static int wordCount = 0;
    private static int sylables = 0;
    private static int polysyllables = 0;
    private static final Pattern pattern = Pattern.compile("(?i)[aeiouy][aeiouy]*");
    private static Matcher matcher;


    public static int getSentenceCount() {
        return sentenceCount;
    }

    public static int getWordCount() {
        return wordCount;
    }

    public static int getSylables() {
        return sylables;
    }

    public static int getPolysyllables() {
        return polysyllables;
    }

    public static int getCharCount() {
        return charCount;
    }

    public static void scanInputMessage (String message) {
        String[] messageArray = message.split(" ");
        wordCount = messageArray.length;
        int countPolySylab = 0;
        boolean found;
        for (int i = 0; i < messageArray.length; i++) {
            countPolySylab = 0;
            charCount += messageArray[i].length();
            if (messageArray[i].matches("\\w+[!\\?\\.]")) {
                sentenceCount++;
            } else if (i == messageArray.length - 1 && !messageArray[i].matches("\\w+[!\\?\\.]")) {
                sentenceCount++;
            }
            found = false;
            matcher = pattern.matcher(messageArray[i]);

            while (matcher.find()) {
                sylables++;
                countPolySylab++;
                found = true;
            }
            if (messageArray[i].charAt(messageArray[i].length() - 1) == 'e') {
                sylables--;
            } else if (!found) {
                sylables++;
            }
            if (countPolySylab > 2) {
                polysyllables++;
            }
        }


    }
}

