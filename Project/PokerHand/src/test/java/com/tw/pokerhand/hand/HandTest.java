package com.tw.pokerhand.hand;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;
import com.tw.pokerhand.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTest {
    @Test
    void shouldThrowCardsRequiredExceptionWhenThereIsLessThanFiveCardsInAHand() {

        assertThrows(CardsRequiredException.class,() -> new Hand("2S 10Q 5S"));
    }

    @Test
    void shouldThrowCardsExceedExceptionWhenThereIsMoreThanFiveCardsInAHand() {

        assertThrows(CardsExceedException.class,() -> new Hand("2S 10Q 5S JH 6D QC"));
    }

    @Test
    void shouldThrowInvalidInputExceptionWhenTheInputCardValueIsNotValid() {

        assertThrows(InvalidInputException.class,() -> new Hand("11S 10Q 5S JH 6D"));
    }

    @Test
    void shouldThrowInvalidInputExceptionWhenTheInputCardSymbolIsNotValid() {

        assertThrows(InvalidInputException.class,() -> new Hand("10A 10Q 5S JH 6D"));
    }

    @Test
    void shouldThrowDuplicationCardExceptionWhenTheInputCardIsAlreadyPresentInTheHand() {

        assertThrows(DuplicateCardException.class,() -> new Hand("10S 10H 5S 10S 6D"));
    }

}
