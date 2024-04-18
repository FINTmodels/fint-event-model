package no.fintlabs.event.model

import spock.lang.Specification

class StatusSpec extends Specification {

    def "Each status should contain a numeric index"() {
        when:
        def statuses = Status.values()

        then:
        statuses.each {
            assert it.index > 0
        }
    }
}
