package day1.strings

object Strings {
  def strings(inputString: String, number: Int): Unit = {
    for (i: Int <- inputString.length - number until inputString.length) {
      print(inputString(i))
    }
  }

  def main(args: Array[String]): Unit = {
    strings("hello", 3)
  }
}
