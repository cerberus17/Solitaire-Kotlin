// These can be declared anywhere. Variables/Functions
// declared outside are package scoped
// (not associated with Card class)
val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"

val redSuits = arrayOf(diamonds, hearts)
val blackSuits = arrayOf(clubs, spades)

data class Card(val value: Int, val suit: String, var faceUp: Boolean = false) {
}