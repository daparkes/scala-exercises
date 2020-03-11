package day2.hangman

import Game._

object Main extends App {
  val word = chooseWord
  var correctlyGuessedLetters = ""
  var mistakes = 0
  var continue = true
  var wrongLetters = ""

  while (continue) {
    val playerGuess = getInput
    if (playerGuess.toString.length > 0) {
      if (word.contains(playerGuess)) {
        println("That's correct!")
        correctlyGuessedLetters += playerGuess
      } else {
        println("Wrong!")
        mistakes += 1
        wrongLetters += playerGuess
        drawHangman(mistakes)
      }
    }

    val currentGuess = buildCurrentGuess(word, correctlyGuessedLetters)
    println(currentGuess)

    if (wrongLetters.length > 0) {
      printWrongGuesses(wrongLetters)
    }

    winOrFail(currentGuess, word, mistakes)
    continue = playAgain
  }
}
