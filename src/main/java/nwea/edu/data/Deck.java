package nwea.edu.data;

public interface Deck {

	public void create(int numberOfSuites, int numberOfRanks);
	
	public void shuffle();
	
	public Card deal();
	
}
