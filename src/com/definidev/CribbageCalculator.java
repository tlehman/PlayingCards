package com.definidev;

public class CribbageCalculator {
	private Deck deck;
	private int score;
	private String[] scores;

	public CribbageCalculator(Deck deck) {
		this.deck = deck;
		this.score = 0;
		calculate();
	}

	public int score() {
		return score;
	}
	
	public String[] scores() {
		return scores;
	}

	/**
	 * calculate() applies the rules of Cribbage to determine the score, 
	 * store that integer value, and keep descriptions of each hand in 
	 * scores
	 * 
	 * Some usage examples can be found in CribbageCalculatorTest
	 */
	private void calculate() {
		// Count Pairs
		for(int i = 0; i < deck.count(); i++) {
			
		}

		// Count Fifteens
		//    Loop over all subsets of cards, summing the ranks of each
		for(double subsetNum = 1; subsetNum < Math.pow(2, deck.count()); subsetNum++) {
			
		}

		// Count Maximal Runs
		deck.sortByRank();

		// Count Maximal Flushes
		deck.sortBySuit();
	}
}
