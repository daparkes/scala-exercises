package day5.rockPaperScissorsLizardSpock

import scala.util.Random.nextInt

class AI {
  def getChances(playerChoices: PlayerChoices): Array[Int] = {
    Array(
      playerChoices.choices.get("r").sum,
      playerChoices.choices.get("p").sum,
      playerChoices.choices.get("s").sum,
      playerChoices.choices.get("l").sum,
      playerChoices.choices.get("sp").sum,
    )
  }

  def AIChooser(playerChoices: PlayerChoices): String = {
    val total = playerChoices.choices.foldLeft(0)(_+_._2)
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
}
