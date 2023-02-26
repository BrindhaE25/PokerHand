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

public class ThreeOfAKindTest {
    @Test
    void shouldReturnNullWhenHand2AndHand1HasSameRankingCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D KS");
        Hand hand2 = new Hand("2S KS 2D AC 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertNull(winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasThirdHighRankingCardAndBothHand1AndHand2IsThreeOfAKind() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D 9S");
        Hand hand2 = new Hand("2S KS 2D AC 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1HasSecondHighRankingCardAndBothHand1AndHand2IsThreeOfAKind() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D 9S");
        Hand hand2 = new Hand("2S KS 2D JC 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasHighRankingCardAndBothHand1AndHand2IsThreeOfAKind() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D 9S");
        Hand hand2 = new Hand("AS QS AD JC AH");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsThreeOfAKindAndHand2IsHighHandCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D QS");
        Hand hand2 = new Hand("2S KC 9H QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsThreeOfAKindAndHand2IsTwoPairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D QS");
        Hand hand2 = new Hand("2S KC QH QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsThreeOfAKindAndHand2IsOnePairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D QS");
        Hand hand2 = new Hand("2S KC QH 9D AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

}
