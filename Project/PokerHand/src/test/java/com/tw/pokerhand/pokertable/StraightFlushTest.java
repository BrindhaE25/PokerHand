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

public class StraightFlushTest {
    @Test
    void shouldReturnNullWhenHand2AndHand1HasSameRankingCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 6S 3S 5S 4S");
        Hand hand2 = new Hand("6H 4H 5H 3H 2H");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertNull(winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand2HasHighRankingCardAndBothHand1AndHand2IsStraightFlush() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2H AH 3H 5H 4H");
        Hand hand2 = new Hand("6C 4C 5C 3C 2C");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1HasHighRankingCardAndBothHand1AndHand2IsStraightFlush() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S AS 3S 5S 4S");
        Hand hand2 = new Hand("AH 10H QH JH KH");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand1IsThreeOfAKindAndHand2IsStraightFlush() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 2C AH 2D QS");
        Hand hand2 = new Hand("AS 10S QS JS KS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightFlushAndHand2IsTwoPairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2D AD 3D 5D 4D");
        Hand hand2 = new Hand("KS KC QH QD AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightFlushAndHand2IsOnePairCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2C AC 3C 5C 4C");
        Hand hand2 = new Hand("2S KC QH 9D AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightFlushAndHand2IsHighHandCard() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2D AD 3D 5D 4D");
        Hand hand2 = new Hand("2S 10C QH 9D AS");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand1IsFullHouseAndHand2StraightFlush() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("10S QS 10D QC 10H");
        Hand hand2 = new Hand("2D AD 3D 5D 4D");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }

    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightFlushAndHand2IsFourOfAKind() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2D AD 3D 5D 4D");
        Hand hand2 = new Hand("2S 2H 2C 2D 4C");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

    @Test
    void shouldReturnHand2AsWinnerWhenHand1IsFlushAndHand2IsStraightFlush() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2S 5S 10S 8S KS");
        Hand hand2 = new Hand("2D AD 3D 5D 4D");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand2, winningHand);
    }
    @Test
    void shouldReturnHand1AsWinnerWhenHand1IsStraightFlushAndHand2IsStraight() throws InvalidInputException, CardsRequiredException, CardsExceedException, DuplicateCardException {
        Hand hand1 = new Hand("2D AD 3D 5D 4D");
        Hand hand2 = new Hand("2S 3H AC 5D 4C");
        PokerTable pokerTable = new PokerTable();
        pokerTable.addHand(hand1);
        pokerTable.addHand(hand2);

        Hand winningHand = pokerTable.winningHand();

        assertEquals(hand1, winningHand);
    }

}
