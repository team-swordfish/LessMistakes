import spock.lang.Specification
import spock.lang.Unroll

class ConistentFormatterSpec extends Specification {

    @Unroll
    def "format numbers consistently - #numbers"() {
        given:
            ConsistentFormatter formatter = new ConsistentFormatter()

        when:
            def result = formatter.format(numbers)

        then:
            result.replaceAll(' ', '') == numbers.join(',')

        where:
            numbers << [
                makeNumbers(3)
            ] + [
                [1,2,3],
                [4,5,6]
            ]
    }

    def makeNumbers(int n) {
        List<Integer> numbers = []
        n.times { numbers.add(new Random().nextInt(10)) }
        numbers
    }
}
