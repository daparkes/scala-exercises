package day2.hangman

import scala.io.{Source, StdIn}
import scala.util.Random._

object Hangman {
  def chooseWord: String = {
    val filename = "enable1.txt"
    val wordList = Source.fromFile(filename).getLines.toList
    val randWord = wordList(nextInt(wordList.length))
    randWord
  }

  def drawUnderscores(randWord: String): String = {
    var underscores = ""
    for (letter <- randWord) {
      underscores += "_"
    }
    underscores
  }

  def getInput: Char = {
    var letter = StdIn.readLine("Guess a letter: ")
    var charLetter = letter.charAt(0)
    charLetter
  }

  def main(args: Array[String]): Unit = {
    val word = chooseWord
    var storedWord = drawUnderscores(word)
    while (true) {
      var playerGuess = getInput
      if (word.contains(playerGuess)) {
        println("Correct!")
        for (i <- 1 to word.length) {
          if (word.charAt(i-1) == playerGuess) {
            storedWord.charAt(i-1) =
          }
          else {

          }
        }
      }
    }

  }
}
