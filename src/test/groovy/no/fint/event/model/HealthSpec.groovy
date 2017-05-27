package no.fint.event.model

import spock.lang.Specification

class HealthSpec extends Specification {

    def "Create new instance of the Health object"() {
        when:
        def health = new Health()

        then:
        health.status == null
        health.timestamp > 0L
        health.time != null
    }

    def "Create a new instance of Health setting the values in the constructor"() {
        when:
        def health = new Health('Application healthy', System.currentTimeMillis())

        then:
        health.status == 'Application healthy'
        health.timestamp > 0
        health.time != null
    }
}
