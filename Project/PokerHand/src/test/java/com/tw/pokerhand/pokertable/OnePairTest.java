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

public class OnePairTest {
    @Test
    void shouldReturnHand1AsWinnerWhenHand1HasOnePairAndHand2IsHighHandCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH KD QS");
        Hand hand2 = new Hand("2S KC JH QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasHighRankingCardAndBothHand1AndHand2IsOnePair() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH KD QS");
        Hand hand2 = new Hand("2S 6C 3H AD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1HasSecondHighRankingCardAndBothHand1AndHand2IsOnePair() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S QC AH KD AS");
        Hand hand2 = new Hand("2C 6C 3H AD AC");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasThirdHighRankingCardAndBothHand1AndHand2IsOnePair() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S JC AH KD AS");
        Hand hand2 = new Hand("AC QC KH AD 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasFourthHighRankingCardAndBothHand1AndHand2IsOnePair() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S QC AH KD AS");
        Hand hand2 = new Hand("AC QS KH AD 8S");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnNullWhenHand2AndHand1HasSameRankingCardAndOnePair() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S QC AH KD AS");
        Hand hand2 = new Hand("AC QS KH AD 2C");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertNull(winningHand);
    }
}
