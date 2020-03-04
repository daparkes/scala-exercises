package day2.hangman

import scala.io.{Source, StdIn}
import scala.util.Random._

object Hangman {
  def chooseWord: String = {
    val file = "/home/dan/Documents/scala-exercises/src/main/scala/day2/hangman/enable1.txt"
    val fileContents = Source.fromFile(file)
    val wordList = fileContents.getLines.toList
    val randWord = wordList(nextInt(wordList.length))
    fileContents.close
    randWord
  }

  def drawHangman(lives: Int): Unit = {
    if (lives == 5) {
      println(" |  | ")
    }
    else if (lives == 4) {
      println("______\n" +
        " |  | ")
    }
    else if (lives == 3) {
      println("   |    \n" +
        "   |   \n" +
        "______\n" +
        "  |  | ")
    }
    else if (lives == 2) {
      println("   |   \n" +
        "   |   \n" +
        "   |   \n" +
        "   |   \n" +
        "______\n" +
        "  |  | ")
    }
    else if (lives == 2) {
      println("   _____" +
        "   |    \n" +
        "   |    \n" +
        "   |   \n" +
        "   |   \n" +
        "   |   \n" +
        "______ \n" +
        "  |  | ")
    }
    else if (lives == 1) {
      println("   _____" +
        "   |    |  \n" +
        "   |    0  \n" +
        "   |       \n" +
        "   |       \n" +
        "   |       \n" +
        "______     \n" +
        "  |  | ")
    }
    else {
      println("   _____" +
        "   |    |  \n" +
        "   |    0  \n" +
        "   |   /|\\ \n" +
        "   |   /\\  \n" +
        "   |        \n" +
        "______      \n" +
        "  |  | ")
      println("Game over!")
    }
  }

  def getInput: Char = {
    var letter = StdIn.readLine("Guess a letter: ")
    var charLetter = letter(0)
    charLetter
  }

  def main(args: Array[String]): Unit = {
    val word = chooseWord
    var correctlyGuessedLetters = List()
    var lives = 5
    var currentGuess = ""
    var continue = true

    while (continue) {
      var playerGuess = getInput
      if (word.contains(playerGuess)) {
        println("That's correct!")
        currentGuess += playerGuess
        for (let <- word) {
          for (guessedLet <- correctlyGuessedLetters) {
            if (guessedLet == let) {
              currentGuess += guessedLet
              correctlyGuessedLetters :+ guessedLet
            }
            else {
              currentGuess += "_"
            }
          }
        }
        println(currentGuess)
      }
      else {
        println("Wrong!")
        currentGuess += "_"
        lives -= 1
        drawHangman(lives)
        if (lives == 0) {
          continue = false
          println("You fail")
        }
      }
    }

    if (currentGuess.equals(word)) {
      println("YOU WIN HOORAY")
      continue = false
    }
  }
}


