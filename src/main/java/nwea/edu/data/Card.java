package nwea.edu.data;

public class Card {
	
	private String suite;
	private String rank;
	private int cardValue;
	
	public Card(String suite, String rank, int cardValue) {
		super();
		this.suite = suite;
		this.rank = rank;
		this.cardValue = cardValue;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardValue;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suite == null) ? 0 : suite.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardValue != other.cardValue)
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suite == null) {
			if (other.suite != null)
				return false;
		} else if (!suite.equals(other.suite))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [suite=").append(suite).append(", rank=").append(rank).append(", cardValue=")
				.append(cardValue).append("]");
		return builder.toString();
	}

	// -1 = less than
	// 0 = equals
	// 1 = greater than
	public int compareTo(Card card1) {
		
		int returnValue = 999;
		if (this.getCardValue() < card1.getCardValue() ) {
			returnValue = -1;
		} else if (this.getCardValue() == card1.getCardValue() ) {
			returnValue = 0;
		} else {
			returnValue = 1;
		}
		
		return returnValue;
		
	}
}
