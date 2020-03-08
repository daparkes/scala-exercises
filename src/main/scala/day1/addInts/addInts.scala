package day1.addInts

object addInts {
  def main(args: Array[String]): Unit = {
    def addInts(a: Int, b: Int, c: Int): Int = {
      if (a > b && a > c) {
        val result: Int = (b+c)*a
        result
      }
      else if (b > a && b > c){
        val result: Int = (a+c)*b
        result
      }
      else {
        val result: Int = (b+a)*c
        result
      }
    }
  }
}
