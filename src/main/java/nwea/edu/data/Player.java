package nwea.edu.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Player {

// Make sure that first card dealt will be first one pulled
	private Queue<Card> cards = new LinkedList<Card>();

	private int playerNumber;
	
	public Player(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	
	public void addCardToHand(Card card) {
		cards.add(card);
	}

	public void addCardToHand(List<Card> cards) {
		cards.addAll(cards);
	}

	public Card getCard() {
		Card card = null;
		if ( ! cards.isEmpty() ) {
			card = cards.remove();
		}
		return card;
	}

// Using First in First Out method. The game will pull 3 cards
	public List<Card> pullCards() {

		List<Card> cards = new ArrayList<Card>();
		Card card = null;
		for ( int cntr = 0; cntr < 3; cntr++ ) {
			card = getCard();
			if ( card != null ) {
				cards.add(card);
			}
		}

		return cards;
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [cards=");
		builder.append(cards);
		builder.append(", playerNumber=");
		builder.append(playerNumber);
		builder.append("]");
		return builder.toString();
	}

}
