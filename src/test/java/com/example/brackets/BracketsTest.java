package com.example.brackets;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketsTest {
    @Test
    public void emptyLineShouldBeCorrect() {
        assertTrue(new BracketsSequence("").isCorrect());
    }

    @Test
    public void textWithNoBracketsShouldBeCorrect() {
        assertTrue(new BracketsSequence("I ate my pants!").isCorrect());
    }

    @Test
    public void lineStartingWithClosingBracketShouldBeIncorrect() {
        assertFalse(new BracketsSequence(")[]{}").isCorrect());
        assertFalse(new BracketsSequence("]]").isCorrect());
        assertFalse(new BracketsSequence("}{").isCorrect());
    }

    @Test
    public void mixedBracketsSequencesShouldBeIncorrect() {
        assertFalse(new BracketsSequence("{[}]").isCorrect());
        assertFalse(new BracketsSequence("([)]").isCorrect());
    }

    @Test
    public void correctArithmeticExpressionsShouldBeCorrect() {
        assertTrue(new BracketsSequence("1 * (2 + 3)").isCorrect());
        assertTrue(new BracketsSequence("1 - [2 / (3 + 4) - 5]").isCorrect());
        assertTrue(new BracketsSequence("1 / ([2 / {3 - 4}] * 5 - 6)").isCorrect());
    }

    @Test
    public void simpleTextWithBracesShouldBeCorrect() {
        assertTrue(new BracketsSequence("Term (explanation in single braces) ...").isCorrect());
    }

    @Test
    public void textWithNestedBracesShouldBeIncorrect() {
        assertFalse(
                new BracketsSequence(
                        "I like pies (especially sweet (with beautiful " +
                                " decorations) but this one was too sweet."
                ).isCorrect()
        );
    }
}
