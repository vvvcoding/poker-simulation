import java.util.*;

public class Hand {
    //Fields
    private Card[] hand;

    //Constructor
    public Hand(Card[] cards) {
        hand = cards;
        Arrays.sort(hand);
    }

    //Methods
    public Card[] getCards() {
        return hand;
    }

    public HandType getHandType() {
        if (checkStraightFlush()) {
            return HandType.StraightFlush;
        } else if (checkFourOfAKind()) {
            return HandType.FourOfAKind;
        } else if (checkFullHouse()) {
            return HandType.FullHouse;
        } else if (checkFlush()) {
            return HandType.Flush;
        } else if (checkStraight()) {
            return HandType.Straight;
        } else if (checkThreeOfAKind()) {
            return HandType.ThreeOfAKind;
        } else if (checkTwoPair()) {
            return HandType.TwoPair;
        } else if (checkOnePair()) {
            return HandType.OnePair;
        }
        return HandType.HighCard;
    }

    private int findMultiples(int multipleCount) {
        //Track how many multiples of ranks there are
        int [] multipleRanks = new int[14];
        for (int i = 0; i < 5; i ++) {
            multipleRanks[hand[i].getRank()] ++;
        }

        //Return true if there are that many multiples
        int count = multipleCount;
        int numOfMultiples = 0;
        for (int i = 0; i < 14; i ++) {
            if (multipleRanks[i] == count) {
                numOfMultiples ++;
            }
        }
        return numOfMultiples;
    }

    private boolean checkFourOfAKind() {
        if (findMultiples(4) == 1) {
            return true;
        }
        return false;
    }

    private boolean checkFullHouse() {
        if ((findMultiples(3) == 1) && (findMultiples(2) == 1)) {
            return true;
        }
        return false;
    }

    private boolean checkFlush() {
        //Check for same suit
        int suit = hand[0].getSuit();
        for (int i = 1; i < 5; i ++) {
            if (hand[i].getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    private boolean checkStraight() {
        //Check for decrementing ranks
        for (int i = 1; i < 5; i ++) {
            if (hand[i].getRank() != (hand[i - 1].getRank() + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkThreeOfAKind() {
        if (findMultiples(3) == 1) {
            return true;
        }
        return false;
    }

    private boolean checkTwoPair() {
        if (findMultiples(2) == 2) {
            return true;
        }
        return false;
    }

    private boolean checkOnePair() {
        if (findMultiples(2) == 1) {
            return true;
        }
        return false;
    }

    private boolean checkStraightFlush() {
        if (checkStraight() && checkFlush()) {
            return true;
        }
        return false;
    }
}