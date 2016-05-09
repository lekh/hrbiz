package cscie56.hrbiz

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(PayHistoryTagLib)
@Mock([Employee, EmployeePaycheck])
class PayHistoryTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test pay history"() {
        given:
            def springSecurityService = mockFor(SpringSecurityService, true)
            tagLib.springSecurityService = springSecurityService.createMock()
        when:
            def template = '<pay:history/>'
            def result = applyTemplate(template)
        then:
            result.startsWith('<table')
    }

    void "test w2"() {
        given:
            def springSecurityService = mockFor(SpringSecurityService, true)
            tagLib.springSecurityService = springSecurityService.createMock()
        when:
            def template = '<pay:w2/>'
            def result = applyTemplate(template)
        then:
            result.startsWith('<div id="w2">')
    }

}
