package no.fint.event.model

import spock.lang.Specification

class DefaultActionsSpec extends Specification {

    def "Get default actions"() {
        when:
        def actions = DefaultActions.getDefaultActions()

        then:
        actions.size() > 0
    }
}
