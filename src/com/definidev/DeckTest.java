package com.definidev;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest extends Assert {

	@Test
	public void testInitCount() {
		Card cards[] = {new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.HEARTS)};
		Deck deck = new Deck(cards);
		assertEquals(3, deck.count());
	}

}
