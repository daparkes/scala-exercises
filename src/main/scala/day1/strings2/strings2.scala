package day1.strings2

object strings2 {
  def strings2(input1: String, input2: String, char1: Char, char2: Char): Unit = {
    val concatString = input1+input2
    val charArray = concatString.toCharArray
    for (i <- 0 until concatString.length) {
      if (charArray(i) == char1) {
        print(char2)
      }
      else {
        print(charArray(i))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    strings2("ha", "llo", 'a', 'e')
  }
}
