package no.fint.event.model

import spock.lang.Specification

class EventSpec extends Specification {

    def "Creating an empty Event object with default constructor"() {
        when:
        def event = new Event()

        then:
        event.corrId == null
        event.client == null
        event.data.size() == 0
        event.message == null
        event.query == null
        event.status == null
        event.source == null
        event.orgId == null
        event.time == 0
        event.action == null
    }

    def "Creating a Status.NEW Event object"() {
        when:
        def event = new Event('rogfk.no', 'FK1', DefaultActions.HEALTH, 'VFS')

        then:
        event.corrId != null
        event.client == 'VFS'
        event.data.size() == 0
        event.message == null
        event.query == null
        event.status == Status.NEW
        event.source == 'FK1'
        event.orgId == 'rogfk.no'
        event.time > 0
        event.action == DefaultActions.HEALTH.name()
    }

    def "Copy values from old event object into new"() {
        when:
        def originalEvent = new Event('rogfk.no', 'FK1', 'GET_ALL', 'VFS')
        Event<String> newEvent = new Event<>(originalEvent)

        then:
        newEvent == originalEvent
    }

    def "Check if event is health check when action is null"() {
        when:
        def event = new Event()

        then:
        !event.isHealthCheck()
    }

    def "Check if event is health check when action is HEALTH"() {
        when:
        def event = new Event(action: 'HEALTH')

        then:
        event.isHealthCheck()
    }

    def "Check if event is register orgId when action is REGISTER_ORG_ID"() {
        when:
        def event = new Event(action: 'REGISTER_ORG_ID')

        then:
        event.isRegisterOrgId()
    }

    def "Add data to an existing event"() {
        given:
        def event = new Event<String>()

        when:
        event.addData('test1')
        event.addObject('test2')

        then:
        event.data[0] == 'test1'
        event.data[1] == 'test2'
    }
}
