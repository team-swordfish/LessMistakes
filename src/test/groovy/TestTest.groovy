import org.scalatest.FunSpec
import spock.lang.Specification

class TestTest extends Specification {

    def "serious is fun"() {
        expect:
            SeriousSpec.superclass == FunSpec
    }
}
