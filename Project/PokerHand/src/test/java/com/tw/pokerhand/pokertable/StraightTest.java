package com.tw.pokerhand.pokertable;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;
import com.tw.pokerhand.Hand;
import com.tw.pokerhand.PokerTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StraightTest {
    @Test
    void shouldReturnNullWhenHand2AndHand1HasSameRankingCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 6C 3H 5D 4S");
        Hand hand2 = new Hand("6S 4S 5D 3C 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertNull(winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasHighRankingCardAndBothHand1AndHand2IsStraight() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S AC 3H 5D 4S");
        Hand hand2 = new Hand("6S 4S 5D 3C 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1HasHighRankingCardAndBothHand1AndHand2IsStraight() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S AC 3H 5D 4S");
        Hand hand2 = new Hand("AS 10S QD JC KH");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand1IsThreeOfAKindAndHand2IsStraight() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D QS");
        Hand hand2 = new Hand("AS 10S QD JC KH");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightAndHand2IsTwoPairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S AC 3H 5D 4S");
        Hand hand2 = new Hand("KS KC QH QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightAndHand2IsOnePairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S AC 3H 5D 4S");
        Hand hand2 = new Hand("2S KC QH 9D AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightAndHand2IsHighHandCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S AC 3H 5D 4S");
        Hand hand2 = new Hand("2S 10C QH 9D AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }


}
