package day4.uniqueSum

object Main extends App {
  def uniqueSum(nums: Array[Int]): Int = {
    nums.groupBy(x=>x).filter(_._2.lengthCompare(1) == 0).keySet.sum
  }

  println(uniqueSum(Array(1, 5, 2)))
}
