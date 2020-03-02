package day1.strings

object Strings {
  def strings(inputString: String, number: Int): String = {
    var newString = ""
    var ary: Array[Char] = inputString.toCharArray
    for (i: Int <- ary.length - number until ary.length) {
      newString += ary(i)
    }
    newString
  }

  def main(args: Array[String]): Unit = {
    println(strings("discombobulation", 5))
  }
}
