package day1.parameters

object parameters {
  def returnString(string1: String, string2: String, string3: String, string4: String): String = {
    string1 + string2 + string3 + string4
  }
  def main(args: Array[String]): Unit = {
    returnString("hello", "my", "name", "is")
  }
}
