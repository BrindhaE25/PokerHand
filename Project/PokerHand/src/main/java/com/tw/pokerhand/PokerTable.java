package com.tw.pokerhand;

import java.util.ArrayList;
import java.util.List;

public class PokerTable {
    private final List<Hand> hands = new ArrayList<>();

    public void addHand(Hand hand) {
        this.hands.add(hand);
    }

    public Hand winningHand() {
        for (Hand hand : hands)
            hand.rank();
        return getWinningHand(this.hands);
    }

    private Hand getWinningHand(List<Hand> hands) {
        orderHandsBasedOnPoints();
        return hands.get(0).getHighRankHand(hands.get(1));
    }

    private void orderHandsBasedOnPoints() {
        this.hands.sort(Hand::comparePoints);
    }
}
