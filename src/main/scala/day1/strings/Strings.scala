package day1.strings

object Strings {
  def strings(inputString: String, number: Int): String = {
    var outputString = ""
    for (i: Int <- inputString.length - number until inputString.length) {
      outputString += inputString(i)
    }
    outputString
  }

  def main(args: Array[String]): Unit = {
    println(strings("hello", 3))
  }
}
