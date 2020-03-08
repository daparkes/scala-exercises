package day5.rockPaperScissorsLizardSpock

import scala.collection.mutable
import scala.io.StdIn
import scala.util.Random.nextInt

class AI {
  def getChances(choices: mutable.Map[String, Int]): Array[Int] = {
    Array(
      choices.get("r").sum,
      choices.get("p").sum,
      choices.get("s").sum,
      choices.get("l").sum,
      choices.get("sp").sum,
    )
  }

  def Chooser(playerChoices: mutable.Map[String, Int]): String = {
    val total = playerChoices.foldLeft(0)(_+_._2)
    val randInt = nextInt(total)
    val chances = getChances(playerChoices)

    randInt match {
      case randInt if randInt < chances(0) => "p"
      case randInt if randInt < chances(0) + chances(1) => "s"
      case randInt if randInt < chances(0) + chances(1) + chances(2) => "r"
      case randInt if randInt < chances(0) + chances(1) + chances(2) + chances(3) => "s"
      case randInt if randInt < chances(0) + chances(1) + chances(2) + chances(3) + chances(4) => "p"
    }
  }

  def printAiChoice(AIChooser: String): Unit = AIChooser match {
    case "p" => println("Computer chooses paper.")
    case "r" => println("Computer chooses rock.")
    case "s" => println("Computer chooses scissors.")
  }

  def winOrLose(result: String, AIChoice: String): String = {
    if (result == "w") {
      printAiChoice(AIChoice)
      StdIn.readLine("\nYou win! Play again? (Y/N) ").toLowerCase
    } else if (result == "l") {
      printAiChoice(AIChoice)
      StdIn.readLine("\nYou lose. Play again? (Y/N) ").toLowerCase
    } else {
      printAiChoice(AIChoice)
      StdIn.readLine("\nIt's a draw. Play again? (Y/N) ").toLowerCase
    }
  }
}