package day2.fizzBuzz

import org.scalatest.FlatSpec

class fizzBuzzTest extends FlatSpec {
  "brains" should "be big" in {
    assert(fizzBuzz.fizzBuzz("Fizz", "Buzz", 3) == "1,2,Fizz")
    assert(fizzBuzz.fizzBuzz("Fizz", "Buzz", 5) == "1,2,Fizz,4,Buzz")
    assert(fizzBuzz.fizzBuzz("Fizz", "Buzz", 15) == "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz")
  }
}
