package com.tw.pokerhand;

import com.tw.exception.CardsExceedException;
import com.tw.exception.CardsRequiredException;
import com.tw.exception.DuplicateCardException;
import com.tw.exception.InvalidInputException;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    public static final int LAST_CARD_POSITION = 4;
    public static final int FIRST_CARD_POSITION = 0;
    public static final int MAX_CARDS = 5;
    public static final int ONE_PAIR_RANK = 1;
    public static final int HIGH_CARD_RANK = 0;
    private static final int TWO_PAIR_RANK = 2;
    private static final int THREE_OF_A_KIND_RANK = 3;
    public static final int STRAIGHT_RANK = 4;
    private static final int FULL_HOUSE_RANK = 6;
    private static final int FOUR_OF_A_KIND_RANK = 7;
    private static final int FLUSH_RANK = 5;
    private static final int STRAIGHT_FLUSH_RANK = 8;
    private static final int FIVE_OF_A_KIND_RANK = 9;
    public static final int CARD_RANK = 10;

    private final List<Card> cards = new ArrayList<>();
    private long points;

    public Hand(String input) throws CardsRequiredException, CardsExceedException, InvalidInputException, DuplicateCardException {
        String[] inputs = input.split(" ");

        if (isInputValid(inputs.length)) {
            for (String str : inputs) {
                addCard(str);
            }
            sort(this.cards);
        }
        this.points = 0;
    }

    public List<Card> getCards() {
        return cards;
    }

    private boolean isInputValid(int length) throws CardsRequiredException, CardsExceedException {
        if (length == MAX_CARDS) return true;
        else if (length < MAX_CARDS) throw new CardsRequiredException();
        else throw new CardsExceedException();
    }

    private void addCard(String input) throws InvalidInputException, DuplicateCardException {
        String symbol = input.substring(input.length() - 1);
        String value = input.substring(0, input.length() - 1);
        Card card = new Card(Value.getValue(value), Symbol.getSymbol(symbol));

        if (isCardUnique(card)) this.cards.add(card);
        else throw new DuplicateCardException();
    }

    private void sort(List<Card> cards) {
        cards.sort(Card::compare);
    }

    private boolean isCardUnique(Card card) {
        return !this.cards.contains(card);
    }

    public void rank() {
        if (isFiveOfAKind()) ;
        else if (isStraightFlush()) ;
        else if (isFourOfAKind()) ;
        else if (isFullHouse()) ;
        else if (isFlush()) ;
        else if (isStraight()) ;
        else if (isThreeOfAKind()) ;
        else if (isTwoPair()) ;
        else if (isOnePair()) ;
        else if (isHighCard()) ;
    }

    public boolean isHighCard() {
        if (!isFlush() && !isPair() && !isStraight()) {
            Map<Value, Integer> cardsFrequency = getCardsFrequency();
            orderByCardValueBasedOnCategory(cardsFrequency);
            setPoints(cardsFrequency, HIGH_CARD_RANK);
            return true;
        } else {
            this.points = 0;
            sort(this.cards);
            return false;
        }
    }

    public boolean isStraight() {
        if (!isSameSuit(this.cards)) {
            if (isSequential(this.cards)) {
                calculatePoints(this.cards);
                calculatePointsByCategoryRank(STRAIGHT_RANK);
                return true;
            }
        } else {
            this.points = 0;
            return false;
        }
        return false;
    }

    private boolean isPair() {
        for (Card card : this.cards) {
            if (this.cards.stream().filter(eachCard -> eachCard != card)
                    .anyMatch(eachCard -> eachCard.getValue().equals(card.getValue())))
                return true;
        }
        return false;
    }

    public boolean isFlush() {
        if (isSameSuit(this.cards)) {
            calculatePoints(cards);
            calculatePointsByCategoryRank(FLUSH_RANK);
            return true;
        }
        return false;
    }

    private boolean isSameSuit(List<Card> cards) {
        Card card = cards.get(0);
        return cards.stream().allMatch(eachCard ->
                eachCard.getSymbol().equals(card.getSymbol()));
    }

    public boolean isOnePair() {
        return containSameCardValues(2, 1, ONE_PAIR_RANK);
    }

    public boolean isTwoPair() {
        return containSameCardValues(2, 2, TWO_PAIR_RANK);
    }

    public boolean isThreeOfAKind() {
        return containSameCardValues(3, 1, THREE_OF_A_KIND_RANK);
    }

    private int getPairCount(Map<Value, Integer> frequency, int noOfCards) {
        int count = 0;
        for (Map.Entry<Value, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == noOfCards)
                count++;
        }
        return count;
    }

    private void setPoints(Map<Value, Integer> valueList, int rank) {
        int cardRank = 0;
        Value prevValue = null;
        for (Map.Entry<Value, Integer> entry : valueList.entrySet()) {
            Value cardValue = entry.getKey();
            int cardFrequency = entry.getValue();
            if (!Objects.equals(prevValue, cardValue)) {
                cardRank++;
                prevValue = entry.getKey();
            }
            long value = calculatePoints(cardRank, cardValue, cardFrequency);
            this.points += (value * cardFrequency);
        }
        calculatePointsByCategoryRank(rank);
    }

    private void calculatePointsByCategoryRank(int rank) {
        long categoryRank = (long) Math.pow(CARD_RANK, rank);
        this.points = this.points * categoryRank;
    }

    private long calculatePoints(int cardRank, Value cardValue, int frequency) {
        long cardPoint = cardValue.getPoint() * frequency * (long) Math.pow(CARD_RANK, (cardRank));
        return (cardPoint * frequency);
    }

    private void calculatePoints(List<Card> cards) {
        long point;
        for (int index = cards.size() - 1; index >= 0; index--) {
            if (isFiveHighStraight(index)) this.points += (long) Math.pow(CARD_RANK, 0);
            else {
                point = cards.get(index).getPoint();
                this.points += point * (long) Math.pow(CARD_RANK, (index));
            }
        }
    }

    private Map<Value, Integer> orderByCardValueBasedOnCategory(Map<Value, Integer> frequency) {
        return frequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    private Map<Value, Integer> getCardsFrequency() {
        Map<Value, Integer> frequency = new LinkedHashMap<>();
        for (Card card : cards) {
            int value = 1;
            if (frequency.containsKey(card.getValue())) {
                value = frequency.get(card.getValue()) + 1;
            }
            frequency.put(card.getValue(), value);
        }
        return frequency;
    }

    public static int comparePoints(Hand hand, Hand hand1) {
        return hand1.points > hand.points ? 1 : -1;
    }

    public Hand getHighRankHand(Hand hand) {
        if (this.points > hand.points)
            return this;
        else if (this.points < hand.points)
            return hand;
        else
            return null;
    }

    public boolean isFullHouse() {
        Map<Value, Integer> frequency = getCardsFrequency();
        if (isOnePair() && isThreeOfAKind()) {
            this.points = 0;
            Map<Value, Integer> valueList = orderByCardValueBasedOnCategory(frequency);
            setPoints(valueList, FULL_HOUSE_RANK);
            return true;
        }
        this.points = 0;
        return false;
    }

    public boolean isFourOfAKind() {
        return containSameCardValues(4, 1, FOUR_OF_A_KIND_RANK);
    }

    public boolean isFiveOfAKind() {
        Map<Value, Integer> frequency = getCardsFrequency();
        if (containSameCardValues(4, 1, FIVE_OF_A_KIND_RANK) && frequency.containsKey(Value.JOKER)) {
            this.points = 0;
            Map<Value, Integer> valueList = orderByCardValueBasedOnCategory(frequency);
            setPoints(valueList, FIVE_OF_A_KIND_RANK);
            return true;
        }
        this.points = 0;
        return false;
    }

    public boolean isStraightFlush() {
        if (isSequential(this.cards) && isFlush()) {
            calculatePoints(this.cards);
            calculatePointsByCategoryRank(STRAIGHT_FLUSH_RANK);
            return true;
        }
        return false;
    }

    private boolean isFiveHighStraight(Integer position) {
        return this.cards.get(position).getValue().equals(Value.ACE) &&
                this.cards.get(FIRST_CARD_POSITION).getValue().equals(Value.TWO) &&
                this.cards.get(LAST_CARD_POSITION - 1).getValue().equals(Value.FIVE);
    }

    private boolean isSequential(List<Card> cards) {
        boolean status;
        for (int index = 1; index < cards.size(); index++) {
            status = cards.get(index - 1).isSequential(cards.get(index));
            if (!status) {
                return index == LAST_CARD_POSITION && isFiveHighStraight(index);
            }
        }
        return true;
    }

    private boolean containSameCardValues(int noOfCards, int pairCount, int PAIR_RANK) {
        Map<Value, Integer> frequency = getCardsFrequency();
        int count = getPairCount(frequency, noOfCards);
        if (count == pairCount) {
            Map<Value, Integer> valueList = orderByCardValueBasedOnCategory(frequency);
            setPoints(valueList, PAIR_RANK);
            return true;
        }
        this.points = 0;
        return false;
    }
}


