package day1.parameters

import org.scalatest.FlatSpec

class ParametersTest extends FlatSpec {
  "returnString" should "return the string that is passed into it" in {
    assert(parameters.returnString("hello", "my", "name", "is") == "hellomynameis")
  }
}
