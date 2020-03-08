package day1.BottlesOfBeer

object BottlesOfBeer {
  def bottlesOfBeer(bottles: Int): Unit = {
    for (i <- bottles to 0 by -1) {
      if (i > 1) {
        println(s"$i bottles of beer on the wall, $i bottles of beer," +
          s" you take one down and pass it around, " + (i-1) + " bottles of beer on the wall")
      }
      else if (i == 1) {
        println("1 bottle of beer on the wall, 1 bottle of beer," +
          " you take one down and pass it around, no bottles of beer on the wall")
      }
      else {
        println("You need to buy more beer!")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    bottlesOfBeer(99)
  }
}
