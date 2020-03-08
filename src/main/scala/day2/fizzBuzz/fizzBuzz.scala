package day2.fizzBuzz

object fizzBuzz {
  def fizzBuzz(input1: String, input2: String, num: Int): Unit = {
    for (i <- 1 to num) {
      if (i % 3 != 0 && i % 5 != 0) {
        print(i + ",")
      }
      if (i % 3 == 0) {
        print(input1 + ",")
      }
      if (i % 5 == 0) {
        print(input2 + ",")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    fizzBuzz("Fizz", "Buzz", 15)
  }
}
