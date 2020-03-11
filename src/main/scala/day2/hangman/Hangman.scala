package day2.hangman

import Game._

object Hangman {

  def main(args: Array[String]): Unit = {
    val word = chooseWord
    println(word)
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
          println(correctlyGuessedLetters)
        } else {
          println("Wrong!")
          mistakes += 1
          wrongLetters += playerGuess
          drawHangman(mistakes)
        }
      }

      val currentGuess = buildCurrentGuess(word, correctlyGuessedLetters)
      println(currentGuess)

      printWrongGuesses(wrongLetters)

      if (mistakes == 8) {
        continue = false
        println("You fail")
      }
      if (currentGuess.equals(word)) {
        println("YOU WIN HOORAY")
        continue = false
      }
    }
  }
}


