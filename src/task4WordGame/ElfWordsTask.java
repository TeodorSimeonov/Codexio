package task4WordGame;

import java.util.*;

public class ElfWordsTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        while (!isContainingSameLetters(firstWord, secondWord)) {
            firstWord = secondWord;
            secondWord = scanner.nextLine();
        }
    }

    private static boolean isContainingSameLetters(String firstWord, String secondWord) {
        return compareWordsLetters(firstWord, secondWord);
    }

    //abca
    //abcd
    private static boolean compareWordsLetters(String firstWord, String secondWord) {
        //Always start with longer word
        if (secondWord.length() > firstWord.length()) {
            String temp = firstWord;
            firstWord = secondWord;
            secondWord = temp;
        }
        StringBuilder firstSb = new StringBuilder(firstWord);
        StringBuilder secondSb = new StringBuilder(secondWord);

        for (int i = 0; i < firstWord.length(); i++) {
            char letter1 = firstSb.charAt(i);
            if (letter1 == ' ') {
                continue;
            }
            for (int j = 0; j < secondWord.length(); j++) {
                char letter2 = secondSb.charAt(j);
                if (letter2 == ' ') {
                    continue;
                }
                if (letter1 == letter2) {
                    //removing the same letters
                    firstSb.replace(i, i + 1, " ");
                    secondSb.replace(j, j + 1, " ");
                    break;
                }
            }
        }
        //Replace all spaces with "" and leave only different letters
        String differentLetters1 = firstSb.toString();
        differentLetters1 = differentLetters1.replaceAll("\\s+", "");
        String differentLetters2 = secondSb.toString();
        differentLetters2 = differentLetters2.replaceAll("\\s+", "");

        if (differentLetters1.length() + differentLetters2.length() == 0) {
            System.out.println("Words contain same letters!");
            return true;
        }
        System.out.println(differentLetters1.length() + differentLetters2.length() + " removed letters!");
        return false;
    }
}
