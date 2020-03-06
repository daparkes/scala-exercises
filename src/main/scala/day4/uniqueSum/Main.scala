package day4.uniqueSum

object Main extends App {
  def uniqueSum(nums: Array[Int]): Unit = {
    nums.groupBy(x=>x).filter(_._2.lengthCompare(1) == 0).keySet.sum
  }

  uniqueSum(Array(1, 2, 2))
}
