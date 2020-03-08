package day5.rockPaperScissorsLizardSpock

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random._

object Main {
  def main(args: Array[String]): Unit = {
    val game = new Game

    if (game.getPlayers == 1) {
      game.singlePlayerGame()
    } else {
      game.twoPlayerGame()
    }
  }
}