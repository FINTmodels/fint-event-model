package no.fintlabs.event.model.health

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
        def health = new Health(HealthStatus.APPLICATION_UNHEALTHY)

        then:
        health.component == null
        health.status == HealthStatus.APPLICATION_UNHEALTHY.name()
        health.timestamp > 0
        health.time != null
    }

    def "Create a new instance of Health with component and status"() {
        when:
        def health = new Health('provider', HealthStatus.APPLICATION_HEALTHY)

        then:
        health.component == 'provider'
        health.status == HealthStatus.APPLICATION_HEALTHY.name()
        health.timestamp > 0
        health.time != null
    }

    def "Create a new instance of Health with component, status and timestamp"() {
        when:
        def health = new Health('provider', HealthStatus.APPLICATION_HEALTHY, System.currentTimeMillis())

        then:
        health.component == 'provider'
        health.status == HealthStatus.APPLICATION_HEALTHY.name()
        health.timestamp > 0
        health.time != null
    }
}
