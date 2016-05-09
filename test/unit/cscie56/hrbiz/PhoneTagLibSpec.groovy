package cscie56.hrbiz

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(PhoneTagLib)
class PhoneTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test format phone number"() {
        when:
            Map values = ['phoneNo': 6175568957]
            def template = '<phone:formatNumber number="${phoneNo}" />'
            def result = applyTemplate(template, values)
        then:
            assert result == '(617) 556-8957'
    }
}
