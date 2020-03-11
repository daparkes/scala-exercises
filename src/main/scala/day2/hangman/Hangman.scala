package day2.hangman

import scala.collection.mutable.ArrayBuffer
import scala.io.{Source, StdIn}
import scala.util.Random._

object Hangman {
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
    for (i <- hangman.length-mistakes until hangman.length) {
      print(hangman(i))
    }
  }
  def getInput: Option[Char] = {
    try {
      Some(StdIn.readLine("Guess a letter: ")(0))
    } catch {
      case e: StringIndexOutOfBoundsException => None
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

  def main(args: Array[String]): Unit = {
    val word = chooseWord

    var correctlyGuessedLetters = ""
    var mistakes = 0
    var currentGuess = ""
    var continue = true

    while (continue) {

      var playerGuess = getInput
      if (playerGuess.isDefined) {
        if (word.contains(playerGuess)) {
          println("That's correct!")
          correctlyGuessedLetters += playerGuess
        } else {
          println("Wrong!")
          mistakes += 1
          drawHangman(mistakes)
        }
      }

      println(buildCurrentGuess(word, correctlyGuessedLetters))

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


