package day2.operators

object Operators {
  def operators(num1: Int, num2: Int, add: Boolean): Int = {
    var result = 0
    if (num1 == 0)
      num2
    else if (num2 == 0)
      num1
    else {
      if (add) {
        result = num1 + num2
      }
      else {
        result = num1 * num2
      }
      result
    }
  }

  def main(args: Array[String]): Unit = {
    println(operators(5, 0, add=false))
  }
}
