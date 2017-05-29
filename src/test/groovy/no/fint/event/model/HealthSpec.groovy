package no.fint.event.model

import spock.lang.Specification

class HealthSpec extends Specification {

    def "Create new instance of Health using the default constructor"() {
        when:
        def health = new Health()

        then:
        health.component == null
        health.status == null
        health.timestamp > 0L
        health.time != null
    }

    def "Create a new instance of Health with status"() {
        when:
        def health = new Health('Application healthy')

        then:
        health.component == null
        health.status == 'Application healthy'
        health.timestamp > 0
        health.time != null
    }

    def "Create a new instance of Health with component and status"() {
        when:
        def health = new Health('provider', 'Application healthy')

        then:
        health.component == 'provider'
        health.status == 'Application healthy'
        health.timestamp > 0
        health.time != null
    }

    def "Create a new instance of Health with component, status and timestamp"() {
        when:
        def health = new Health('provider','Application healthy', System.currentTimeMillis())

        then:
        health.component == 'provider'
        health.status == 'Application healthy'
        health.timestamp > 0
        health.time != null
    }
}
