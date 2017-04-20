import org.scalatest.{FlatSpec, Matchers, WordSpec}

class FunctionalSpec extends WordSpec with Matchers {

  "functional adder" should {
    "add" in {

      import AdderConverters._

      var b = 1
      var a = new FunctionalAdder(1)
      a.add(b)

      var result: Int = a
      result shouldBe 2
    }
  }
}

object AdderConverters {
  implicit def converter(f: FunctionalAdder):Int = {
    f.total
  }
}

class FunctionalAdder(i: Int) {
  var total = i
  def add(b: Int) = total += b
}