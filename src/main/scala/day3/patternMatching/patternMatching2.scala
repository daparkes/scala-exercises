package day3.patternMatching

object patternMatching2 {
  def addOrMultiplyOr0(num1: Int, num2: Int, add: Boolean): Int = add match {
    case _ if num1 == 0 => num2
    case _ if num2 == 0 => num1
    case true => num1+num2
    case false => num1*num2
  }

  def patternMatching3(input: Any):Unit = input match {
    case input @ List(_,_) => println(input.reverse)
    case input @ (_,_) => println(input.swap)
    case input @ Array(_,_) => println(input(1) + "," + input(0))
    case _ => println("failed")
  }

  def main(args: Array[String]): Unit = {
    println(addOrMultiplyOr0(0, 5, add=false))
    println(patternMatching3(Array(2, 3)))
  }
}
