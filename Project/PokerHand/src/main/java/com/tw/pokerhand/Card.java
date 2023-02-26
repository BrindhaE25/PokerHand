package com.tw.pokerhand;

import java.util.Objects;

public class Card {
    public static final int INCREMENT_BY_ONE = 1;
    private final Value value;
    private final Symbol symbol;

    public Card(Value value, Symbol symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && symbol == card.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, symbol);
    }

    public Value getValue() {
        return value;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean isSequential(Card card) {
        return this.getValue().ordinal() + INCREMENT_BY_ONE == card.getValue().ordinal();
    }

    public static int compare(Card card1, Card card2) {
        return card1.value.compareTo(card2.value);
    }

    public int getPoint() {
        return this.value.getPoint();
    }
}
