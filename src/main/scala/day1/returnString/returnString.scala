package day1.returnString

object returnString {
  def returnString(): String = {
    var string: String = "Hello World!"
    string
  }

  def main(args: Array[String]): Unit = {
    println(returnString())
  }
}
