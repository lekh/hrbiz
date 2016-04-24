package cscie56.project

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Employee)
class EmployeeSpec extends Specification {

    Company company
    Department department

    def setup() {
        company = new Company(name: 'A1 Company')
        department = new Department(name: 'Accounting', company: company)
    }

    def cleanup() {
    }

    void "test valid employee"() {
        when:
            Employee e = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')
        then:
            e.validate()
    }

    void "test invalid employee type"() {
        when:
            Employee e = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'someUnknownTypes',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')
        then:
            !e.validate()
    }

    void "test invalid hired date"() {
        when:
            Employee e = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/2016"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')
        then:
            !e.validate()
    }

    void "test invalid email"() {
        when:
            Employee e = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'someInvalidAddr', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')
        then:
            !e.validate()
    }
}
