# Playing Cards in Java

As part of a larger project of making apps that deal with playing cards (Cribbage scores, Poker probabilities, etc.), I've decided to create an open source library for dealing with playing cards and collections of playing cards.

The types I've defined are:

### Deck (class)
 - has many `Card`s
 - can iterate over the `Card`s by `Rank`
 - can iterate over the `Card`s by `Suit`
 - can render itself to a `String`

### Card (class)
 - has a `Rank`
 - has a `Suit`
 - can render itself to a `String`

### Rank (enum)
 - has an `int` index 
 - can render itself to a `String`

### Suit (enum)
 - can render itself to a `String`
 - can 'pretty' render itself to a `String` with fancy UTF-8 characters such as ♣

### CribbageCalculator
 - takes in a deck and calculates a score
 - returns the score
 - returns the collection of score descriptions
 
 
## To Do
  - Incorporate SVG Images from [vectorized-playing-cards](https://code.google.com/p/vectorized-playing-cards/)
  - Use [j2objc](https://code.google.com/p/j2objc/) to compile this to Objective-C and use in an iOS app
  
 ![all 52 cards](http://sourceforge.net/p/vector-cards/screenshot/color_deck.png)
 
