package com.definidev;

import org.junit.Assert;
import org.junit.Test;

public class CribbageCalculatorTest extends Assert {

	@Test
	public void testScore() {
		// {5C, 10S, 2S, 2D, AS} -> score of 6 (two fifteens, one pair)
		Card cards[] = {
				new Card(Rank.FIVE, Suit.CLUBS), 
				new Card(Rank.TEN, Suit.SPADES),
				new Card(Rank.TWO, Suit.SPADES),
				new Card(Rank.TWO, Suit.DIAMONDS),
				new Card(Rank.ACE, Suit.SPADES)
		};
		Deck deck = new Deck(cards);
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(6, calc.score());
	}

	@Test
	public void testScoreDescriptions() {
		// {5C, 10S, 2S, 2D, AS} -> score of 6 (two fifteens, one pair)
		Card cards[] = {
				new Card(Rank.FIVE, Suit.CLUBS), 
				new Card(Rank.TEN, Suit.SPADES),
				new Card(Rank.TWO, Suit.SPADES),
				new Card(Rank.TWO, Suit.DIAMONDS),
				new Card(Rank.ACE, Suit.SPADES)
		};
		Deck deck = new Deck(cards);
		CribbageCalculator calc = new CribbageCalculator(deck);

		String scoresExpected[] = {
				"Pair for 2 : 2D 2S",
				"Fifteen for 2 : 5C 10S", 
				"Fifteen for 2 : 10S 2S 2D AS"
		};

		String scores[] = calc.scores();

		for(int i = 0; i < scoresExpected.length; i++) {
			assertEquals(scoresExpected[i], scores[i]);
		}
	}
	
	@Test
	public void testRankIntervals() {
		
	}
	
	@Test
	public void testFlush() {
		// 10C JC 4C 2C 6H -> score of 4 (flush of size 4) 
		Card cards[] = {
				new Card(Rank.TEN, Suit.CLUBS),
				new Card(Rank.JACK, Suit.CLUBS), 
				new Card(Rank.FOUR, Suit.CLUBS),
				new Card(Rank.TWO, Suit.CLUBS),
				new Card(Rank.SIX, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(4, calc.score());
	}

	@Test
	public void testRuns() {
		// 10H JD QH KC 2S -> score of 4 (run of size 4)
		Card cards[] = {
				new Card(Rank.TEN, Suit.HEARTS),
				new Card(Rank.JACK, Suit.DIAMONDS), 
				new Card(Rank.QUEEN, Suit.HEARTS),
				new Card(Rank.KING, Suit.CLUBS),
				new Card(Rank.TWO, Suit.SPADES)
		};
		Deck deck = new Deck(cards);
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(4, calc.score());
	}
}
