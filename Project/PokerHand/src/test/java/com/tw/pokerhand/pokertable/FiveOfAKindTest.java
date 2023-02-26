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

public class FiveOfAKindTest {
    @Test
    void shouldReturnNullWhenHand2AndHand1HasSameRankingCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C 2H 2D NN");
        Hand hand2 = new Hand("2S NN 2D 2C 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertNull(winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1HasHigherRankingCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("AS AC AH AD NN");
        Hand hand2 = new Hand("2S NN 2D 2C 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1,winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsFiveOfAKindAndHand2IsHighHandCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C 2H 2D NN");
        Hand hand2 = new Hand("2S KC 9H QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand1IsFourOfAKindAndHand2IsFiveOfAKind() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C 2H 2D QS");
        Hand hand2 = new Hand("2S 2C 2H 2D NN");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsFiveOfAKindAndHand2IsTwoPairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C 2H 2D NN");
        Hand hand2 = new Hand("2S KC QH QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsFiveOfAKindAndHand2IsOnePairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C 2H 2D NN");
        Hand hand2 = new Hand("2S KC QH 9D AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsFiveOfAKindAndHand2IsStraight() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("10S NN 10D 10C 10H");
        Hand hand2 = new Hand("2S 3H AC 5D 4C");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsFiveOfAKindAndHand2IsFlush() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("10S NN 10D 10C 10H");
        Hand hand2 = new Hand("2S 5S 10S 8S KS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand1IsFullHouseAndHand2IsFiveOfAKind() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("10S QS 10D QC 10H");
        Hand hand2 = new Hand("2S 2H 2C 2D NN");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

}
