package com.tw.pokerhand.hand;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;
import com.tw.pokerhand.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnePairTest {

    @Test
    void shouldReturnTrueWhenThereIsAPairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 5S KD");

        assertTrue(hand.isOnePair());
    }

    @Test
    void shouldReturnFalseWhenThereIsNoPairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 8S KD");

        assertFalse(hand.isOnePair());
    }

    @Test
    void shouldReturnFalseWhenThereIsTwoPairsOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 8H 10C 8S 2C");

        assertFalse(hand.isOnePair());
    }

    @Test
    void shouldReturnFalseWhenThereIsThreeCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 8S 2C");

        assertFalse(hand.isOnePair());
    }

    @Test
    void shouldReturnFalseWhenThereIsFourCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 2D 2C");

        assertFalse(hand.isOnePair());
    }


}
