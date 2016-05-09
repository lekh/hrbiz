package cscie56.hrbiz

import grails.test.mixin.TestFor
import grails.test.spock.IntegrationSpec
import org.junit.Test

@TestFor(EmployeeTagLib)
class EmployeeTagLibIntegrationSpec extends IntegrationSpec {

    Employee employee

    def setup() {
        employee = Employee.findById(1)
    }

    def cleanup() {
    }

    @Test
    void "test list all employeees"() {
        when:
            Map values = [dept: employee.department]
            def template = '<employee:list department="${dept}" />'
            def result = applyTemplate(template, values)
        then:
            assert result.contains('<tr>')
    }
}
