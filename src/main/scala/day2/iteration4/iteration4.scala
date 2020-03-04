package day2.iteration4

object iteration4 {
  var count = 1
  @scala.annotation.tailrec
  def iterRecurse(input: String, int: Int): Unit = {
    println(input)
    count += 1
    if (count <= int) {
      iterRecurse(input, int)
    }
  }
  def main(args: Array[String]): Unit = {
    iterRecurse("Hi", 3)
  }
}
