package day2.iteration2

object iteration2 {
  def iteration2(input: String, int: Int): Unit = {
    for (i <- 1 to int) {
      println(input*int)
    }
  }

  def main(args: Array[String]): Unit = {
    iteration2("H", 4)
  }
}
