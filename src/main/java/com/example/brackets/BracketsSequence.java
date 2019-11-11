package com.example.brackets;

public class BracketsSequence {
    private String sequence;

    public BracketsSequence(String sequence) {
        this.sequence = takeOnlyBrackets(sequence);
    }

    public boolean isCorrect() {
        return isCorrect(sequence);
    }

    private static boolean isCorrect(String sequence) {
        if (sequence.isEmpty()) {
            return true;
        }
        char openBracket = sequence.charAt(0);
        int pairPosition = findPair(sequence, openBracket);
        if (pairPosition == -1) {
            return false;
        }
        return isCorrect(sequence.substring(1, pairPosition - 1))
                && isCorrect(sequence.substring(pairPosition));
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

    private String takeOnlyBrackets(String sequence) {
        StringBuilder brackets = new StringBuilder();
        for (int i = 0; i < sequence.length(); i++) {
            if (isBracket(sequence.charAt(i))) {
                brackets.append(sequence.charAt(i));
            }
        }
        return brackets.toString();
    }

    private static boolean isBracket(char symbol) {
        switch (symbol) {
            case '(': case ')':
            case '[': case ']':
            case '{': case '}':
                return true;
        }
        return false;
    }

    private static boolean matches(char openingBracket, char closingBracket) {
        return openingBracket == '(' && closingBracket == ')'
                || openingBracket == '[' && closingBracket == ']'
                || openingBracket == '{' && closingBracket == '}';
    }
}
