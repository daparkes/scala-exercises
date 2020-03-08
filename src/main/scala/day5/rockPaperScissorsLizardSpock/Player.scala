package day5.rockPaperScissorsLizardSpock

import scala.collection.mutable

class Player(number: Int) {
  var choices: mutable.Map[String, Int] = mutable.Map(
    "r"  -> 1,
    "p"  -> 1,
    "s"  -> 1,
    "l"  -> 1,
    "sp" -> 1)
}
