package csv

import org.scalatest._

class LowLevelParserSpec extends FreeSpec with Matchers {
  import LowLevelParser._

  val testData = List(
    List("A", "B", "C"),
    List("D", "E", "F"),
    List("G", "H", "I")
  )

  "parseCsvResource" - {
    "should read a simple resource" in {
      parseCsvResource("test.csv") should equal(testData)
    }

    "should read the cities example" in {
      val cities = parseCsvResource("cities.csv")
      cities.length should equal(4080)
      cities.foreach(_.length should equal(5))
    }

    "should read the countries example" in {
      val countries = parseCsvResource("countries.csv")
      countries.length should equal(240)
      countries.foreach(_.length should equal(15))
    }
  }

  "parseCsvString" - {
    "should read from a string" in {
      parseCsvString("A,B,C\nD,E,F\nG,H,I") should equal(testData)
    }
  }

}