public class Card implements Comparable<Card> {

    //Fields
    private int suit;
    private int rank;

    //Constructor
    public Card(int cardNumber) {
        suit = cardNumber % 4;
        rank = (cardNumber / 4) + 1;
    }

    //Methods
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        String suitString = "";
        String rankString = "";

        //Get suit string
        if (suit == 0) {
            suitString = "S";
        } else if (suit == 1) {
            suitString = "H";
        } else if (suit == 2) {
            suitString = "D";
        } else if (suit == 3) {
            suitString = "C";
        }

        //Get rank string
        if (rank == 11) {
            rankString = "J";
        } else if (rank == 12) {
            rankString = "Q";
        } else if (rank == 13) {
            rankString = "K";
        } else if (rank == 1) {
            rankString = "A";
        } else {
            rankString = Integer.toString(rank);
        }

        //Return result string
        return rankString + suitString;
    }

    @Override
    public int compareTo(Card inputCard) {
        if (this.rank != inputCard.rank) {
            return Integer.compare(this.rank, inputCard.rank);
        } else {
            return Integer.compare(this.suit, inputCard.suit);
        }
    }
}