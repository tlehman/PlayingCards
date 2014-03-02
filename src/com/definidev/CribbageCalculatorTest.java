package com.definidev;

import org.junit.Assert;
import org.junit.Test;

public class CribbageCalculatorTest extends Assert {

	@Test
	public void testScore() {
		// {5C, 10S, 2S, 2D, AS} -> score of 6 (two fifteens, one pair)
		Card cards[] = {new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.HEARTS)};
		Deck deck = new Deck(cards);
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(0, calc.score());
	}

	@Test
	public void testScoreDescriptions() {
		// {5C, 10S, 2S, 2D, AS} -> score of 6 (two fifteens, one pair)
		Card cards[] = {
				new Card(Rank.ACE, Suit.CLUBS), 
				new Card(Rank.TWO, Suit.CLUBS), 
				new Card(Rank.THREE, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		CribbageCalculator calc = new CribbageCalculator(deck);

		String scoresExpected[] = {
				"Fifteen for 2 : 5C 10S", 
				"Fifteen for 2 : 10S 2S 2D AS",
				"Pair for 2 : 2S 2D"
		};

		String scores[] = calc.scores();	
	}
}
