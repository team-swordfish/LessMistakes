import spock.lang.Specification

class PublicGoodiesSpec extends Specification {

    def "good stuff happens"() {
        expect:
            !PublicGoodies.isGood()
    }
}
