import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}

object NonInvertingConverters {
  implicit def toStringConverter(boolean: Boolean): String = {
    (!boolean).toString
  }
}

class TestNameSpec extends WordSpec with Matchers {

  import NonInvertingConverters._

  val scenarios = Tables.Table[String, Int, Boolean](
    ("a","b","c"),
    ("a", 1, true),
    ("b", 2, true),
    ("c", 3, true)
  )

  "test name" should {
    TableDrivenPropertyChecks.forAll(scenarios) { (c,b,a) =>

      val test = ((s"$c" * b) + a.toString).stripSuffix(a == b)

      val scenario = test.substring(test.length - b, 1)

      s"scenario - $scenario" in {
        test shouldNot contain(c)
      }
    }
  }
}
