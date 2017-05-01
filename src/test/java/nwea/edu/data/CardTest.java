package nwea.edu.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CardTest {


	@Test
	public void lessThanCompareTo() {
		Card card1 = new Card("Heart", "Two", 1);
		Card card2 = new Card("Heart", "Three", 2);

		assertEquals(-1, card1.compareTo(card2));
	}

	public void equalCompareTo() {
		Card card1 = new Card("Heart", "Two", 1);
		Card card2 = new Card("Heart", "Two", 1);

		assertEquals(0, card1.compareTo(card2));
	}

	public void greaterThanCompareTo() {
		Card card1 = new Card("Heart", "Two", 2);
		Card card2 = new Card("Heart", "Three", 1);

		assertEquals(1, card1.compareTo(card2));
	}

}
