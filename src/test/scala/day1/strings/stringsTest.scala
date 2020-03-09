package day1.strings

import day1.strings
import org.scalatest.FlatSpec

class stringsTest extends FlatSpec {
  "hello 3" should "return 'llo'" in {
    assert(Strings.strings("hello", 3) == "llo")
  }
}
