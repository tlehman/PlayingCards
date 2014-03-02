package com.definidev;

public enum Suit {
	CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");
	
	private String suitValue;

	Suit(String suit) {
		suitValue = suit;
	}
	
	public String toString() {
		return suitValue;
	}
}
