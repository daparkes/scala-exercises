package day5.rockPaperScissorsLizardSpock

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random._

object Main {
  def getInput: String = {
    val input = StdIn.readLine("Enter (R)ock, (P)aper, (S)cissors, (L)izard or (Sp)ock: ")
    input(0).toLower.toString
  }

  def outcome(input: String, AIChoice: String): String = {
    input match {
      case "r" => AIChoice match {
        case "p" | "sp" => "l"
        case "r" => "d"
        case _ => "w"
      }
      case "p" => AIChoice match {
        case "s" | "l" => "l"
        case "p" => "d"
        case _ => "w"
      }
      case "s" => AIChoice match {
        case "r" | "sp" => "l"
        case "s" => "d"
        case _ => "w"
      }
      case "l" => AIChoice match {
        case "s" | "r" => "l"
        case "l" => "d"
        case _ => "w"
      }
      case "sp" => AIChoice match {
        case "l" | "p" => "l"
        case "sp" => "d"
        case _ => "w"
      }
      case _ => println("I didn't recognise that letter.")
                "d"
    }
  }

  def main(args: Array[String]): Unit = {
    var playerChoices = new PlayerChoices
    var continue = true
    val ai = new AI

    while (continue) {
      val AIChoice = ai.AIChooser(playerChoices)
      val input = getInput
      var continueYN = ""

      playerChoices.choices.updateWith(input)(
        {
          case Some(input) => Some(input + 1)
          case _ => None
        }
      )

      if (outcome(input, AIChoice) == "w") {
        ai.printAiChoice(AIChoice)
        continueYN = StdIn.readLine("\nYou lose. Play again? (Y/N) ").toLowerCase
      } else if (outcome(input, AIChoice) == "l") {
        ai.printAiChoice(AIChoice)
        continueYN = StdIn.readLine("\nYou win! Play again? (Y/N) ").toLowerCase
      } else {
        ai.printAiChoice(AIChoice)
        continueYN = StdIn.readLine("\nIt's a draw. Play again? (Y/N) ").toLowerCase
        }


      if (continueYN == "n") {
        continue = false
      }
    }
  }
}