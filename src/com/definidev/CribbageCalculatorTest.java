package com.definidev;

import org.junit.Assert;
import org.junit.Test;

public class CribbageCalculatorTest extends Assert {

	@Test
	public void testScorePairAndFifteens() {
		Deck deck = new Deck("5C 10S 2S 2D AS"); // score of 6 (two fifteens, one pair)
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(6, calc.score());
	}

	@Test
	public void testScoreDescriptions() {
		Deck deck = new Deck("5C 10S 2S 2D AS");  // (one pair, two fifteens)
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
	public void testFlush() {
		Deck deck = new Deck("10C JC 4C 2C 6H"); // score of 4 (flush of size 4)
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(4, calc.score());
	}

	@Test
	public void testRuns() {
		Deck deck = new Deck("10H JD QH KC 2S"); //  score of 4 (run of size 4)
		CribbageCalculator calc = new CribbageCalculator(deck);

		assertEquals(4, calc.score());
	}
	
	@Test
	public void testMultipleRuns() {
		Deck deck = new Deck("AH AS AD 2S 3H"); // trible run of 3 and a triple (15 points)
		CribbageCalculator calc = new CribbageCalculator(deck);
		assertEquals(15, calc.score());
	}
}
