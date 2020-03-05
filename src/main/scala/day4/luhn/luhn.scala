package day4.luhn

object luhn {
  def checkDigit(number: Long) : Long = {
    var runningTotal: Long = 0
    var numAsString = number.toString

    for (i <- 0 until numAsString.length) {
      runningTotal += numAsString(i).toLong-48
    }

    var check = (runningTotal*9) % 10

    (numAsString + check.toString).toLong

  }
                  
  def addAlternateSumDigits(numAsString: String): Long = {
    var runningTotal: Long = 0
    for (i <- numAsString.length-2 to 0 by -2) {
      println(numAsString(i))
      var temp = (numAsString(i).toLong-48)*2
      if (temp.toString.length == 2) {
        runningTotal += ((temp % 10) + (temp / 10))
      } else {
        runningTotal += temp
      }

    }
    println(runningTotal)
    runningTotal
  }

  def checkIfValid(num: Long): Boolean = {
    var numAsString = num.toString
    var runningTotal: Long = addAlternateSumDigits(numAsString)

    for (i <- num.toString.length-1 to 0 by -2) {
      runningTotal += numAsString(i).toLong-48
    }

    println(runningTotal)
    runningTotal % 10 == 0
  }

  def main(args: Array[String]): Unit = {
    println(checkIfValid(49927398716L))
    
  }
}
