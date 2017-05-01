package nwea.edu.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NWEADeckTest {

	Deck underTest = new NWEADeck();
	
	@Before
	public void setUp() throws Exception {
		underTest.create(NWEADeck.SUITE.length, NWEADeck.RANK.length);
	}

	@Test
	public void testCreate() {
		Deck myDeck = new NWEADeck();
		myDeck.create(NWEADeck.SUITE.length, NWEADeck.RANK.length);
		assertNotNull(myDeck.deal());
	}

	@Test
	public void testShuffle() {
		
		underTest.shuffle();
		String sameSuite = underTest.deal().getSuite();
		boolean changeSuite = false;
		for (int cntr = 0; cntr < 5; cntr++ ) {
			String suite = underTest.deal().getSuite();
			if ( ! sameSuite.equals(suite) ) {
				changeSuite = true;
			}
		}
		Assert.assertTrue(changeSuite);
	}

	@Test
	public void testDeal() {
		assertNotNull(underTest.deal());
	}

}
