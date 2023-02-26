package com.tw.pokerhand;

import com.tw.exception.InvalidInputException;

public enum Value {
    TWO("2",2),THREE("3",3),FOUR("4", 4),FIVE("5", 5),SIX("6", 6),SEVEN("7", 7),EIGHT("8", 8),NINE("9", 9),TEN("10", 10),JACK("J", 11),QUEEN("Q", 12),KING("K", 13),ACE("A", 14),JOKER("N",15);

    private final String value;
    private final Integer point;

    Value(String value, Integer point) {
        this.value = value;
        this.point = point;
    }

    public static Value getValue(String inputCard) throws InvalidInputException {
        for(Value value : Value.values()) {
            if(value.value.equalsIgnoreCase(inputCard))
                return value;
        }
       throw new InvalidInputException();
    }

    public int getPoint() {
        return this.point;
    }
}
