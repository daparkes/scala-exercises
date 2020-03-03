package day2.brokenKeyboard

import scala.io.Source

object brokenKeyboard {
  def brokenKeyboard(input: String): String = {
    val filename = "enable1.txt"
    val wordList: List[String] = Source.fromFile(filename).getLines.toList
    var topLength = 0
    var inputArray = input.toCharArray
    var longestWord = ""
    wordList.foreach(word =>
      if (word.contains(input)) {
        if (word.length > topLength) {
          topLength = word.length
          longestWord = word
        }
      }
    )

    filename.close
  }

}
