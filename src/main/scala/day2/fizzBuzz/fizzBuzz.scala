package day2.fizzBuzz

object fizzBuzz {
  def fizzBuzz(input1: String, input2: String, num: Int): Unit = {
    for (i <- 1 to num) {
      var outputString = ""

      if (i % 3 == 0) {
        outputString += input1
      }
      if (i % 5 == 0) {
        outputString += input2
      }
      if (i % 3 == 0 || i % 5 == 0) {
        println(outputString)
      }
      else {
        println(i)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    fizzBuzz("Fizz", "Buzz", 15)
  }
}
