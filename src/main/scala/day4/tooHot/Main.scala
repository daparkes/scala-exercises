package day4.tooHot

object Main {
  def tooHot(temp: Int, isSummer: Boolean): Boolean = if (!isSummer) {
    temp match {
      case temp if temp >= 60 && temp <= 90 => true
      case _ => false
    }
  } else {
    temp match {
      case temp if temp >= 60 && temp <= 100 => true
      case _ => false
    }
  }

  def tooHotIfs(temp: Int, isSummer: Boolean): Boolean = {
    // this is better bc clearer
    if (isSummer) {
      temp >= 60 && temp <= 100
    } else {
      temp >= 60 && temp <= 90
    }
  }

  def main(args: Array[String]): Unit = {
    println(tooHotIfs(91, isSummer=true))
  }
}
