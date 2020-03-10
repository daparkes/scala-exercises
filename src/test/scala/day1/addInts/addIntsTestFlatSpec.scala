package day1.addInts

import day1.returnString.returnString
import org.scalatest._

class addIntsTestFlatSpec extends FlatSpec {
  "5x5" should "have the result 25" in {
    assert(addInts.addInts(2, 3, 5) == 25)
    assert(addInts.addInts(6, 7, 8) == 104)
  }
}