// Using object instead of class makes this a singleton. Can now be
// accessed globally as GameModel.<function> (like static access)
object GameModel {
  val deck = Deck()
  val wastePile: MutableList<Card> = mutableListOf()
  val foundationPiles: Array<FoundationPile> =
      arrayOf(FoundationPile(clubs),
              FoundationPile(diamonds),
              FoundationPile(hearts),
              FoundationPile(spades))
  val tableauPiles: Array<TableauPile> = Array(7, { TableauPile() })

  fun resetGame() {
    wastePile.clear()
//    for (pile in foundationPiles) {
//      pile.reset()
//    }
    foundationPiles.forEach { it.reset() }

    deck.reset()

    tableauPiles.forEachIndexed { i, tableauPile ->
      val cardsInPile: MutableList<Card> =
          Array(i + 1, { deck.drawCard() }).toMutableList()

      tableauPiles[i] = TableauPile(cardsInPile)
    }
  }

  fun onDeckTap() {
    if (deck.cardsInDeck.size > 0) {
      val card = deck.drawCard()

      card.faceUp = true

      wastePile.add(card)
    }
    else {
      deck.cardsInDeck = wastePile.toMutableList()
      deck.cardsInDeck.forEach { it.faceUp = false }

      wastePile.clear()
    }
  }

  fun onWasteTap() {
    if (wastePile.size > 0) {
      val card = wastePile.last()

      if (playCard(card))
        wastePile.remove(card)
    }
  }

  fun onFoundationTap(index: Int) {
    val foundationPile = foundationPiles[index]

    if (foundationPile.cards.size > 0) {
      val card = foundationPile.cards.last()

      if (playCard(card))
        foundationPile.removeCard(card)
    }
  }

  fun onTableauTap(index: Int, cardIndex: Int) {
    val tableauPile = tableauPiles[index]

    if (tableauPile.cards.size > 0) {
      val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)

      if (playCards(cards)) {
        tableauPile.removeCards(cardIndex)
      }
    }
  }

  private fun playCard(card: Card): Boolean {
    foundationPiles.forEach {
      if (it.addCard(card))
        return true
    }

    tableauPiles.forEach {
      if (it.addCards(mutableListOf(card)))
        return true
    }

    return false
  }

  private fun playCards(cards: MutableList<Card>): Boolean {
    if (cards.size == 1)
      return playCard(cards.first())
    else {
      tableauPiles.forEach {
        if (it.addCards(cards))
          return true
      }
    }

    return false
  }

  fun debugPrint() {
    println(deck.cardsInDeck.last())
  }
}

