package day2.fizzBuzz

object fizzBuzz {
  def fizzBuzz(input1: String, input2: String, num: Int): String = {
    var outputString = ""
    for (i <- 1 to num) {
      if (i % 3 != 0 && i % 5 != 0) {
        outputString += i
      }
      if (i % 3 == 0) {
        outputString += input1
      }
      if (i % 5 == 0) {
        outputString += input2
      }
      if (i != num) {
        outputString += ","
      }
    }
    outputString
  }

  def main(args: Array[String]): Unit = {
    println(fizzBuzz("Fizz", "Buzz", 15))
  }
}
