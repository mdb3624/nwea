package nwea.edu.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NWEADeck implements Deck {

	public static final int CARDVALUE[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	public static final String RANK[] = {"Two", "Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	public static final String SUITE[] = {"Dimand","Heart","Club","Spade"};
	
	private List<Card> cards = new ArrayList<Card>();
	private int cardDealt = 0;
	
// Build a deck of cards to be used in the game of WAR.
	public void create(int numberOfSuites, int numberOfRanks) {
		cardDealt = 0;
		// Prepare deck for game
		for ( int suiteValue = 0; suiteValue < NWEADeck.SUITE.length; suiteValue++) {
			for ( int rankValue = 0; rankValue < NWEADeck.RANK.length; rankValue++ ) {
				cards.add(new Card(NWEADeck.SUITE[suiteValue],NWEADeck.RANK[rankValue],NWEADeck.CARDVALUE[rankValue]));
			}
		}
	}

// use the standard JAVA collections method to shuffle the deck of cards.
	public void shuffle() {
		if ( ! cards.isEmpty() ) {
			Collections.shuffle(cards);
		}
	}

	public Card deal() {
		Card card = null;
		if (cardDealt < cards.size()) {
			card = cards.get(cardDealt++);
		}

		return card;
	}

	@Override
	public String toString() {
		StringBuffer debug = new StringBuffer();
		for (Card card : cards ) {
			debug.append("NWEADeck [cards=").append(card).append("]\n");
		}
		return debug.substring(0);
	}

}
