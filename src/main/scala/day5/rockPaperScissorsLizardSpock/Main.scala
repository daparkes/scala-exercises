package day5.rockPaperScissorsLizardSpock

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random._

object Main {
  def getInput: String = {
    val input = StdIn.readLine("Enter (R)ock, (P)aper, (S)cissors, (L)izard or (Sp)ock: ")
    input(0).toLower.toString
  }

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

  def playerWins(input: String, AIChoice: String): Boolean = {
    input match {
      case "r" => AIChoice match {
        case "p" | "sp" => false
        case _ => true
      }
      case "p" => AIChoice match {
        case "s" | "l" => false
        case _ => true
      }
      case "s" => AIChoice match {
        case "r" | "sp" => false
        case _ => true
      }
      case "l" => AIChoice match {
        case "s" | "r" => false
        case _ => true
      }
      case "sp" => AIChoice match {
        case "l" | "p" => false
        case _ => true
      }
      case _ => println("I didn't recognise that letter.")
                false
    }
  }

  def main(args: Array[String]): Unit = {
    var playerChoices = new PlayerChoices
    var continue = true

    while (continue) {
      val AIChoice = AIChooser(playerChoices)
      val input = getInput
      var continueYN = ""

      playerChoices.choices.updateWith(input)(
        {
          case Some(input) => Some(input + 1)
          case _ => None
        }
      )

      if (!playerWins(input, AIChoice)) {
        printAiChoice(AIChoice)
        continueYN = StdIn.readLine("\nYou lose. Play again? (Y/N) ").toLowerCase
      } else {
        printAiChoice(AIChoice)
        continueYN = StdIn.readLine("\nYou win! Play again? (Y/N) ").toLowerCase
      }

      if (continueYN == "n") {
        continue = false
      }
    }
  }
}