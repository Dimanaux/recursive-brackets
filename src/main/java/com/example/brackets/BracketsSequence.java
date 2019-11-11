package com.example.brackets;

public class BracketsSequence {
    private static boolean isCorrectBracketsSequence(String sequence) {
        if (sequence.isEmpty()) {
            return true;
        }
        char openBracket = sequence.charAt(0);
        int pairPosition = findPair(sequence, openBracket);
        if (pairPosition == -1) {
            return false;
        }
        return isCorrectBracketsSequence(sequence.substring(1, pairPosition - 1))
                && isCorrectBracketsSequence(sequence.substring(pairPosition));
    }

    private static int findPair(String sequence, char openBracket) {
        int depth = 1;
        int i = 1;
        while (i < sequence.length() && depth > 0) {
            if (sequence.charAt(i) == openBracket) {
                depth += 1;
            } else if (matches(openBracket, sequence.charAt(i))) {
                depth -= 1;
            }
            i++;
        }
        return depth != 0 ? -1 : i;
    }

    private static boolean matches(char openingBracket, char closingBracket) {
        return openingBracket == '(' && closingBracket == ')'
                || openingBracket == '[' && closingBracket == ']'
                || openingBracket == '{' && closingBracket == '}';
    }
}
