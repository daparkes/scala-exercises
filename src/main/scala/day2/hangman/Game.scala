package day2.hangman

import scala.io.{Source, StdIn}
import scala.util.Random.nextInt

object Game {
  def chooseWord: String = {
    val file = "enable1.txt"
    val fileContents = Source.fromFile(file)
    val wordList = fileContents.getLines.toList
    fileContents.close
    wordList(nextInt(wordList.length))
  }

  def drawHangman(mistakes: Int): Unit = {
    val hangman = Array(
      "   _____   \n",
      "   |    |    \n",
      "   |    0    \n",
      "   |   /|\\  \n",
      "   |   / \\  \n",
      "   |         \n",
      "______       \n",
      "  |  | ")
    println("\n")
    for (i <- hangman.length-mistakes until hangman.length) {
      print(hangman(i))
    }
  }

  @scala.annotation.tailrec
  def getInput: Char = {
    try {
      StdIn.readLine("Guess a letter: ")(0)
    } catch {
      case e: StringIndexOutOfBoundsException =>
        println("You need to enter a letter!")
        getInput
    }
  }

  def buildCurrentGuess(word: String, correctlyGuessedLetters: String): String = {
    var currentGuess = ""
    println()
    word.foreach(let =>
      if (correctlyGuessedLetters.contains(let)){
        currentGuess += let
      } else {
        currentGuess += "_"
      }
    )
    currentGuess
  }

  def printWrongGuesses(wrongLetters: String): Unit = {
    println("Wrong guesses:")
    wrongLetters.foreach(e =>
      print(s"$e ")
    )
    println("\n")
  }

  def winOrFail(currentGuess: String, word: String, mistakes: Int): Unit = {
    if (currentGuess.equals(word)) {
      println("YOU WIN HOORAY")
    }
    if (mistakes == 8) {
      println("You fail")
    }
  }

  def playAgain: Boolean = {
    val playAgain = StdIn.readLine("Play again? (Y/n)")
    playAgain != "n"
  }
}
