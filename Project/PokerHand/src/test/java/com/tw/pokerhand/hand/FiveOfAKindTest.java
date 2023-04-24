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

public class FiveOfAKindTest {
    @Test
    void shouldReturnFalseWhenThereIsAPairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 5S KD");
        Map<Value, Integer> frequency = hand.getCardsFrequency();

        assertFalse(hand.isFiveOfAKind(frequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoPairOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 5H 10C 8S KD");
        Map<Value, Integer> frequency = hand.getCardsFrequency();

        assertFalse(hand.isFiveOfAKind(frequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsTwoPairsOfCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 8H 10C 8S 2C");
        Map<Value, Integer> frequency = hand.getCardsFrequency();

        assertFalse(hand.isFiveOfAKind(frequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsThreeCardsOfSameRankInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 8S 2C");
        Map<Value, Integer> frequency = hand.getCardsFrequency();

        assertFalse(hand.isFiveOfAKind(frequency));
    }

    @Test
    void shouldReturnFalseWhenThereIsFourCardsOfSameRankAndOneDifferentCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H 10C 2D 2C");
        Map<Value, Integer> frequency = hand.getCardsFrequency();

        assertFalse(hand.isFiveOfAKind(frequency));
    }

    @Test
    void shouldReturnTrueWhenThereIsFourCardsOfSameRankAndOneWildCardInAHand() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2S 2H NN 2D 2C");
        Map<Value, Integer> frequency = hand.getCardsFrequency();

        assertTrue(hand.isFiveOfAKind(frequency));
    }

}
