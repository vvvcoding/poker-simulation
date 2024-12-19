import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Variables
        long seedValue = 0;
        int numHands = 0;
        Scanner scnr = new Scanner(System.in);

        //Get user input then return information
        System.out.print("Enter the seed value: ");
        seedValue = scnr.nextLong();
        
        //Generate and display 5 sorted hands
        Deck deckOfCards = new Deck(seedValue);
        for (int i = 0; i < 5; i ++) {
            System.out.print("  ");
            deckOfCards.shuffle(676);
            Hand dealtHand = deckOfCards.deal();
            for (int j = 0; j < 5; j ++) {
                Card [] dealtCards = dealtHand.getCards();
                System.out.print(dealtCards[j] + "  ");
            }
            System.out.println();
        }

        System.out.print("Enter the number of hands: ");
        numHands = scnr.nextInt();
        
        //Generate number of hands and analyze them
        int [] resultArr = new int[9];
        for (int i = 0; i < numHands; i ++) {
            deckOfCards.shuffle(676);
            Hand dealtHand = deckOfCards.deal();
            HandType currentHandType = dealtHand.getHandType();
            switch (currentHandType) {
                case StraightFlush:
                    resultArr[0] ++;
                    break;
                case FourOfAKind:
                    resultArr[1] ++;
                    break;
                case FullHouse:
                    resultArr[2] ++;
                    break;
                case Flush:
                    resultArr[3] ++;
                    break;
                case Straight:
                    resultArr[4] ++;
                    break;
                case ThreeOfAKind:
                    resultArr[5] ++;
                    break;
                case TwoPair:
                    resultArr[6] ++;
                    break;
                case OnePair:
                    resultArr[7] ++;
                    break;
                case HighCard:
                    resultArr[8] ++;
                    break;
                default:
                    break;
            }
        }

        //Print results of analyzing the hands
        String [] pokerResults = {"Straight Flush", "Four of a Kind",
                                    "Full House", "Flush", "Straight",
                                    "Three of a Kind", "Two Pair",
                                    "One Pair", "High Card"};
        for (int i = 0; i < 9; i ++) {
            double percentageResults = (double) resultArr[i] / numHands * 100;
            System.out.printf("%-18s%10.5f%%%5d\n", pokerResults[i], percentageResults, resultArr[i]);
        }

        //Close scanner
        scnr.close();
    }
}