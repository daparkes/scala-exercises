package day1.parameters

object parameters {
  def main(args: Array[String]): Unit = {
    def returnString(string1: String, string2: String, string3: String, string4: String): Unit = {
      println(string1 + string2 + string3 + string4)
    }

    returnString("hello", "my", "name", "is")

  }


}
