package day4.blackjack

object Main extends App {

  def twentyOne(nums: Array[Int]): Int = {
    try {
      nums.filter(el => el <= 21).max
    }
    catch {
      case e: UnsupportedOperationException => 0
    }
  }
  println(twentyOne(Array(2, 18)))
}
