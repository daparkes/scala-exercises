package day1.typeInference

object TypeInference {
  def typeInference[T](input: T) {
    input
  }

  def main(args: Array[String]): Unit = {
    println(typeInference(4.5))
  }
}
