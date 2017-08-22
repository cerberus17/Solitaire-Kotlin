class GameModel {
  val deck = Deck()
  val wastePile: MutableList<Card> = mutableListOf()
  val foundationPiles: Array<FoundationPile> =
      arrayOf(FoundationPile(clubs),
              FoundationPile(diamonds),
              FoundationPile(hearts),
              FoundationPile(spades))
  val tableauPiles: Array<TableauPile> = Array(7, { TableauPile() })
}