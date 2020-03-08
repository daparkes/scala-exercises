package day5.rockPaperScissorsLizardSpock

import java.io.Console

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

class Game {
  def singlePlayerGame(game: Game): Unit = {
    val ai = new AI
    val player = new Player(1)
    val players = Array(player)

    var continue = true

    while (continue) {
      val AIChoice = ai.Chooser(player.choices)
      val input = game.getInput

      updateChoices(player, input)

      val result = game.outcome(input, AIChoice)
      val continueYN = ai.winOrLose(result, AIChoice)

      if (continueYN == "n") {
        continue = false
      }
    }
  }

  def twoPlayerGame(game: Game): Unit = {
    val player = new Player(1)
    val player2 = new Player(2)
    val players = Array(player, player2)

    var continue = true

    while (continue) {
      val plays = ArrayBuffer[String]()
      for (player <- players) {
        plays +: getInput
      }
      val continueYN = whoWins(game.outcome(plays(0), plays(1)))

      if (continueYN == "n") {
        continue = false
      }
    }
  }

  def whoWins(result: String): String = {
    if (result == "w") {
      StdIn.readLine("\nPlayer 1 wins. Play again? (Y/N) ").toLowerCase
    } else if (result == "l") {
      StdIn.readLine("Player 2 wins. Play again? (Y/N) ").toLowerCase
    } else {
      StdIn.readLine("It's a draw. Play again? (Y/N) ").toLowerCase
    }
  }

  def updateChoices(player: Player, input: String): Unit = {
    player.choices.updateWith(input)(
      {
        case Some(input) => Some(input + 1)
        case _ => None
      }
    )
  }

  def getPlayers: Int = {
    StdIn.readLine("How many players would like to play? (1 or 2) (2 players is pointless at the" +
      "moment because player 2 can see what player 1 has typed").toInt
  }

  def outcome(input: String, input2: String): String = {
    input match {
      case "r" => input2 match {
        case "p" | "sp" => "l"
        case "r" => "d"
        case _ => "w"
      }
      case "p" => input2 match {
        case "s" | "l" => "l"
        case "p" => "d"
        case _ => "w"
      }
      case "sp" => input2 match {
        case "l" | "p" => "l"
        case "sp" => "d"
        case _ => "w"
      }
      case "s" => input2 match {
        case "r" | "sp" => "l"
        case "s" => "d"
        case _ => "w"
      }
      case "l" => input2 match {
        case "s" | "r" => "l"
        case "l" => "d"
        case _ => "w"
      }
      case _ => println("I didn't recognise that letter.")
        "d"
    }
  }

  def getInput: String = {
    var input = ""
    input = StdIn.readLine("Enter (R)ock, (P)aper, (S)cissors," +
        "(L)izard or (Sp)ock: ")
    val LCInput = input.toLowerCase
    if (LCInput(0) == 's' && LCInput.length > 1) {
      if (LCInput(1) == 'p') {
        LCInput(0).toString + LCInput(1).toString
      }
      else {
        LCInput(0).toString
      }
    }
    else {
      LCInput(0).toString
    }
  }
}
