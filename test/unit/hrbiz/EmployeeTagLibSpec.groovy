package hrbiz

import cscie56.project.Employee
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeTagLib)
class EmployeeTagLibSpec extends Specification {

    Employee employee

    def setup() {
        employee = Employee.first()

    }

    def cleanup() {
    }

    void "test list"() {
        when:
            Map values = ['id': 2, 'name': 'SomeName', 'email': 'some@email.com']
            def template = '<employee:list department="" />'
            def result = applyTemplate(template, values)
        then:
            assert result.startsWith('<tr>')
    }
}
