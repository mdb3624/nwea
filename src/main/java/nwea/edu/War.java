package nwea.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nwea.edu.data.Card;
import nwea.edu.data.Deck;
import nwea.edu.data.NWEADeck;
import nwea.edu.data.Player;

public class War {

	Deck deck = new NWEADeck();
	List<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args) {
		War warGame = new War();
		warGame.play(NWEADeck.SUITE.length, NWEADeck.RANK.length, 3);
	}

	public void play(int numberOfSuites, int numberOfRanks, int numberOfPlayers) {

		buildPlayerList(numberOfPlayers);
		initDeck(numberOfSuites, numberOfRanks);
		dealCards();

		List<Card> winningCards = new ArrayList<Card>();

		int winningPlayer = 0;
		for ( int index = 1; index < players.size(); index++) {
			winningPlayer = challenge(winningPlayer,index, winningCards);
		}
		players.get(winningPlayer).addCardToHand(winningCards);

		System.out.println("Winning Player: " + players.get(winningPlayer));

	}

	private int challenge(int player1, int player2, List<Card> winningCards) {

		int returnValue = player1;

		List<Card> cards1 = players.get(player1).pullCards();
		List<Card> cards2 = players.get(player2).pullCards();

		winningCards.addAll(cards1);
		winningCards.addAll(cards2);

		int compareValue = cards1.get(2).compareTo(cards2.get(2));

		switch (compareValue) {
		case -1: 
			returnValue = players.get(player2).getPlayerNumber();
			break;
		case 0:
			System.out.println(cards1);
			System.out.println(cards1);
			returnValue = challenge(player1, player2,winningCards);
			break;
		case 1:
			returnValue = players.get(player1).getPlayerNumber();
			break;
		}
		
		return returnValue;
	}

	private void dealCards() {
		
		int currentPlayer = 0;
		
		for ( Card card = deck.deal(); card != null; card = deck.deal()) {
			if ( currentPlayer == players.size() ) {
				currentPlayer = 0;
			}
			players.get(currentPlayer).addCardToHand(card);
			currentPlayer++;
		}

	}
	
	private void initDeck(int numberOfSuites, int numberOfRanks) {

		deck.create(NWEADeck.SUITE.length, NWEADeck.RANK.length);
		deck.shuffle();

	}

	private void buildPlayerList(int numberOfPlayers) {
		for (int playerCnt = 0; playerCnt < numberOfPlayers; playerCnt++ ) {
			players.add(new Player(playerCnt));
		}
			
		
	}
}
