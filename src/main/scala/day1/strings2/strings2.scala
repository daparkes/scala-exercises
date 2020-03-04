package day1.strings2

object strings2 {
  def strings2(input1: String, input2: String, char1: Char, char2: Char): String = {
    var concatString = input1+input2
    var charArray = concatString.toCharArray
    var newString = ""
    for (i <- 0 until concatString.length) {
      if (charArray(i) == char1) {
        newString += char2
      }
      else {
        newString += charArray(i)
      }
    }
    newString
  }

  def main(args: Array[String]): Unit = {
    println(strings2("ha", "llo", 'a', 'e'))
  }
}
