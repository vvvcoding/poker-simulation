import java.util.*;

public class Deck {
    
    //Fields
    private List<Card> deck = new ArrayList<>(52);
    private Random rand;


    //Constructor
    public Deck(long seedInput) {
        //Create sorted deck
        for (int i = 0; i < 52; i ++) {
            deck.add(new Card(i));
        }

        //Create random object with user input seed
        rand = new Random(seedInput);
    }

    //Methods
    public void shuffle(int n) {
        int card1 = 0;
        int card2 = 0;
        int numShuffles = n;

        //Shuffle deck
        for (int i = 0; i < numShuffles; i ++) {
            //Get 2 different and random cards before swapping
            card1 = rand.nextInt(52);
            card2 = rand.nextInt(52);
            Collections.swap(deck, card1, card2);
        }
    }

    public Hand deal() {
        //Return the first 5 cards in the deck
        Card[] handDealt = new Card[5];

        for (int i = 0; i < 5; i ++) {
            handDealt[i] = deck.get(i);
        }
        return new Hand(handDealt);
    }
}