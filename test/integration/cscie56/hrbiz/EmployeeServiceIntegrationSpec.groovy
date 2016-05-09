package cscie56.hrbiz

import grails.test.spock.IntegrationSpec

class EmployeeServiceIntegrationSpec extends IntegrationSpec {

    def employeeService

    def setup() {
    }

    def cleanup() {
    }

    void "test all employees"() {
        when:
            Map employees = employeeService.listEmployee(null)
        then:
            assert employees.size() == 2
            assert employees.listType == 'All'
    }

    void "test department employees"() {
        when:
            Department dept = Department.first()
            Map employees = employeeService.listEmployee(dept)
        then:
            assert employees.size() == 2
            assert employees.listType == dept.name
    }

}
