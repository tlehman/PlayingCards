package com.definidev;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.junit.Assert;
import org.junit.Test;

public class CardTest extends Assert {

	// Deterministic methods
	@Test
	public void testToString() {
		Card c = new Card(Rank.ACE, Suit.CLUBS);
		assertEquals("AC", c.toString());
	}
	
	@Test
	public void testFromStrings() {
		Card ah1 = Card.fromStrings("A", "H");
		Card ah2 = new Card(Rank.ACE, Suit.HEARTS);
		
		assertEquals(ah1, ah2);
	}
	
	// Random methods
	@Test
	public void testInitWithNoArgs() {
		Card c = new Card();
		Pattern p = Pattern.compile("[A2-9JKQ][CHSD]");
		Matcher m = p.matcher(c.toString());
		assertEquals(m.find(), true);
	}
}
