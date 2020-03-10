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

  def drawHangman(lives: Int): Unit = lives match {
    case 6 => println(" |  | ")

    case 5 => println("______\n" +
        " |  | ")

    case 4 => println("   |    \n" +
        "   |   \n" +
        "______\n" +
        "  |  | ")

    case 3 => println("   |   \n" +
        "   |   \n" +
        "   |   \n" +
        "   |   \n" +
        "______\n" +
        "  |  | ")

    case 2 => println("   _____\n" +
        "   |    \n" +
        "   |    \n" +
        "   |   \n" +
        "   |   \n" +
        "   |   \n" +
        "______ \n" +
        "  |  | ")

    case 1 => println("   _____\n" +
        "   |    |  \n" +
        "   |    0  \n" +
        "   |       \n" +
        "   |       \n" +
        "   |       \n" +
        "______     \n" +
        "  |  | ")

    case _ => println("   _____\n" +
        "   |    |  \n" +
        "   |    0  \n" +
        "   |   /|\\ \n" +
        "   |   /\\  \n" +
        "   |        \n" +
        "______      \n" +
        "  |  | ")
  }

  def drawHangman(mistakes: ArrayBuffer[Int]): Unit = {
    val hangman = Array(
    "  |  | ",
    "______      \n",
    "   |        \n",
    "   |   / \\  \n",
    "   |   /|\\ \n",
    "   |    0  \n",
    "   |    |  \n",
    "   _____\n")

  }
  def getInput: Char = {
    StdIn.readLine("Guess a letter: ")(0)
  }

  def main(args: Array[String]): Unit = {
    val word = chooseWord

    var correctlyGuessedLetters = ""
    var mistakes = ArrayBuffer[Int](0,0,0,0,0,0,0,0)
    var currentGuess = ""
    var continue = true

    while (continue) {

      var playerGuess = getInput
      if (word.contains(playerGuess)) {
        println("That's correct!")
        correctlyGuessedLetters += playerGuess
      } else {
        println("Wrong!")
        mistakes.remove(mistakes.length-1)
        drawHangman(mistakes)
      }

      currentGuess = ""
      for (let <- word) {
        if (correctlyGuessedLetters.contains(let)){
          currentGuess += let
        } else {
          currentGuess += "_"
          }
        }

      println(currentGuess)

      if (lives == 0) {
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


