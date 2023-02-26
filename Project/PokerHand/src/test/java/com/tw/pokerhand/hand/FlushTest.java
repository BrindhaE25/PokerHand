package com.tw.pokerhand.hand;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;
import com.tw.pokerhand.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushTest {
    @Test
    void shouldReturnFalseWhenThereIsAPairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 5S KD");

        assertFalse(hand.isFlush());
    }

    @Test
    void shouldReturnTrueWhenThereIsNoPairOfCardAndOfSameSuitInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5S 10S 8S KS");

        assertTrue(hand.isFlush());
    }

    @Test
    void shouldReturnFalseWhenThereIsTwoPairsOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 8H 10C 8S 2C");

        assertFalse(hand.isFlush());
    }

    @Test
    void shouldReturnFalseWhenThereIsThreeCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 8S 2C");

        assertFalse(hand.isFlush());
    }

    @Test
    void shouldReturnFalseWhenThereIsFourCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 2D 2C");

        assertFalse(hand.isFlush());
    }

    @Test
    void shouldReturnFalseWhenTheCardsAreSequentialInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 3H AC 5D 4C");

        assertFalse(hand.isFlush());
    }

//    @Test
//    void shouldReturnFalseWhenTheCardsAreSequentialAndOfSameSuitInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
//        Hand hand = new Hand("2H 3H AH 5H 4H");
//
//        assertFalse(hand.isFlush());
//    }

}
