import org.junit.Test

import org.junit.Assert.*

class TableauPileTest {
  @Test
  fun addCards() {
    val tableauPile = TableauPile(mutableListOf(Card(12, spades)))
    val cards: MutableList<Card> = mutableListOf(Card(11, diamonds))

    tableauPile.addCards(cards)

    assertEquals(2, tableauPile.cards.size)
  }

  @Test
  fun removeCards() {
    val tableauPile = TableauPile(mutableListOf(Card(4, spades),
        Card(3, hearts), Card(2, clubs)))

    assertEquals(tableauPile.cards.size, 3)

    tableauPile.removeCards(1)
    assertEquals(mutableListOf(Card(4, spades, true)), tableauPile.cards)
  }

}