package day1.addInts

object addInts {
  def main(args: Array[String]): Unit = {
    def addInts(a: Int, b: Int, c: Int): Int = {
      if (a > b && a > c) {
        var result: Int = (b+c)*a
        result
      }
      else if (b > a && b > c){
        var result: Int = (a+c)*b
        result
      }
      else {
        var result: Int = (b+a)*c
        result
      }
    }
  }
}
