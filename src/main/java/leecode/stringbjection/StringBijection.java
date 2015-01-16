package leecode.stringbjection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringBijection {
    public static void main(String[] args) {
        String chars = "abaac";
        String string = "johnjohnnyjohnjohncodes";
        List<String> stringBijection = getStringBijection(chars, string);

        System.out.println(Arrays.toString(stringBijection.toArray()));
    }

    public static List<String> getStringBijection(String chars, String string) {
        if (chars == null || string == null) {
            return null;
        }

        Map<Character, String> bijection = new HashMap<Character, String>();
        Deque<String> assignments = new ArrayDeque<String>();
        List<String> results = new ArrayList<String>();
        boolean hasBijection = getStringBijection(chars, string, 0, 0, bijection, assignments);

        if (!hasBijection) {
            return null;
        }

        for (String result : assignments) {
            results.add(result);
        }

        return results;
    }

    private static boolean getStringBijection(String chars, String string, int charIndex, int stringIndex, Map<Character, String> bijection, Deque<String> assignments) {
        int charsLen = chars.length();
        int stringLen = string.length();

        if (charIndex == charsLen && stringIndex == stringLen) {
            return true;
        } else if (charIndex == charsLen || stringIndex == stringLen) {
            return false;
        }

        char currentChar = chars.charAt(charIndex);
        List<String> possibleWords = new ArrayList<String>();
        boolean charAlreadyAssigned = bijection.containsKey(currentChar);

        if (charAlreadyAssigned) {
            String word = bijection.get(currentChar);
            possibleWords.add(word);
        } else {
            StringBuilder word = new StringBuilder();

            for (int i = stringIndex; i < stringLen; ++i) {
                word.append(string.charAt(i));
                possibleWords.add(word.toString());
            }
        }

        for (String word : possibleWords) {
            int wordLen = word.length();
            int endIndex = stringIndex + wordLen;

            if (endIndex <= stringLen && string.substring(stringIndex, endIndex).equals(word)) {
                if (!charAlreadyAssigned) {
                    bijection.put(currentChar, word);
                }

                assignments.addLast(word);

                boolean done = getStringBijection(chars, string, charIndex + 1, stringIndex + wordLen, bijection, assignments);

                if (done) {
                    return true;
                }

                assignments.removeLast();

                if (!charAlreadyAssigned) {
                    bijection.remove(currentChar);
                }
            }
        }

        return false;
    }
}