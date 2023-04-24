package com.tw.pokerhand.hand;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;
import com.tw.pokerhand.Hand;
import com.tw.pokerhand.Value;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class HighCardHandTest {
    @Test
    void shouldReturnTrueWhenTheHandIsHighCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2H 3S 10H 5H AH");

        assertTrue(hand.isHighCard());
    }

    @Test
    void shouldReturnFalseWhenTheHandHasSequentialCards() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2H 3S 4H 5H 6H");

        assertFalse(hand.isHighCard());
    }

    @Test
    void shouldReturnFalseWhenTheHandHasAnyPairOfSameRankCards() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2H 3S 4H 5H 6H");

        assertFalse(hand.isHighCard());
    }

    @Test
    void shouldReturnFalseWhenTheHandHasAllCardsOfSameSymbol() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand = new Hand("2H 8H 4H 5H KH");

        assertFalse(hand.isHighCard());
    }
}
