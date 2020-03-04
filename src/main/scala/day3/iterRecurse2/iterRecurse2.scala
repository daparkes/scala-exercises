package day3.iterRecurse2

import scala.annotation.tailrec

object iterRecurse2 {
  var count = 0
  @tailrec
  def iterRecurse(input: String, int: Int): Unit = {
    if (count < int) {
      println(input * int)
      count += 1
      iterRecurse(input, int)
    }
  }

  def main(args: Array[String]): Unit = {
    iterRecurse("H", 4)
  }

}
