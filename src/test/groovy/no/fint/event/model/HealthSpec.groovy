package no.fint.event.model

import spock.lang.Specification

class HealthSpec extends Specification {

    def "Create new instance of the Health object"() {
        when:
        def health = new Health()

        then:
        health.status == null
        health.timestamp > 0L
        health.time.length() > 0
    }
}
