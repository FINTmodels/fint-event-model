package no.fint.event.model

import spock.lang.Specification


class EventSpec extends Specification {

    def "Creating a empty Event object with default constructor"() {
        when:
        Event event = new Event()

        then:
        event.corrId == null
        event.client == null
        event.data.size() == 0
        event.message == null
        event.status == null
        event.source == null
        event.orgId == null
        event.time == 0
        event.verb == null
    }

    def "Creatning av Status.NEW Event object"() {
        when:
        Event event = new Event("rogfk.no", "FK1", "GET_ALL", "VFS")

        then:
        event.corrId != null
        event.client == "VFS"
        event.data.size() == 0
        event.message == null
        event.status == Status.NEW
        event.source == "FK1"
        event.orgId == "rogfk.no"
        event.time > 0
        event.verb == "GET_ALL"
    }
}
