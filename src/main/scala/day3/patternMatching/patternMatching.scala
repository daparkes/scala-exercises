package day3.patternMatching

object patternMatching {
  def addInts (a: Int, b: Int, add: Boolean): Int = add match {
    case true => a+b
    case false => a*b
  }

  def main(args: Array[String]): Unit = {
    println(addInts(4, 6, add=false))
  }
}
