fun main(args: Array<String>) {
  GameModel.resetGame()
  GamePresenter.onDeckTap()
  GameModel.debugPrint()
}

// Extension function - Allows you to add a function to an existing object
// without subclassing and changing all references to previously used object.
// This example adds functionality to String class to check if instance is
// longer than 5 characters. Notice this is package level and has access to
// "this". Can now use myString.isLongerThan5()
//fun String.isLongerThan5(): Boolean {
//  return this.length > 5
//}