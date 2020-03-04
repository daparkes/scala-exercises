package day1.typeInference

object TypeInference {
  def typeInference[T](input: T) {
    println(input)
  }

  def main(args: Array[String]): Unit = {
    typeInference(4.5)
  }
}
