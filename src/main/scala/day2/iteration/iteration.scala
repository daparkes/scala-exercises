package day2.iteration

object iteration {
  def iteration(input: String, int: Int): Unit = {
    for (i <- 1 to int) {
      println(input)
    }
  }

  def main(args: Array[String]): Unit = {
    iteration("Hi", 3)
  }
}
