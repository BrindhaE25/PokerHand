package com.tw.pokerhand.hand;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;
import com.tw.pokerhand.Hand;
import com.tw.pokerhand.Value;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoPairTest {

    @Test
    void shouldReturnTrueWhenThereIsTwoPairsOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 5S 10D");
        Map<Value, Integer> cardsFrequency = hand.getCardsFrequency();

        assertTrue(hand.isTwoPair(cardsFrequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoPairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 8S KD");
        Map<Value, Integer> cardsFrequency = hand.getCardsFrequency();

        assertFalse(hand.isTwoPair(cardsFrequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsThreeCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 8S 2C");
        Map<Value, Integer> cardsFrequency = hand.getCardsFrequency();

        assertFalse(hand.isTwoPair(cardsFrequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsFourCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 2D 2C");
        Map<Value, Integer> cardsFrequency = hand.getCardsFrequency();

        assertFalse(hand.isTwoPair(cardsFrequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsOnePairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 6D 4C");
        Map<Value, Integer> cardsFrequency = hand.getCardsFrequency();

        assertFalse(hand.isTwoPair(cardsFrequency));
    }

}
