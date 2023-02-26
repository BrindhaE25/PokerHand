package com.tw.pokerhand;

import com.tw.exception.InvalidInputException;

public enum Symbol {
    S, D, H, C,N;

    public static Symbol getSymbol(String symbol) throws InvalidInputException {
        try {
            return Symbol.valueOf(symbol);
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }
}
