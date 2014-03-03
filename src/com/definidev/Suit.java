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
	
	public static Suit fromString(String suitStr) {
		Suit suit;
		if(suitStr.equalsIgnoreCase("C")) {
			suit = CLUBS;
		} else if(suitStr.equalsIgnoreCase("D")) {
			suit = DIAMONDS;
		} else if(suitStr.equalsIgnoreCase("H")) {
			suit = HEARTS;
		} else {
			suit = SPADES;
		}
		return suit;
	}
}
