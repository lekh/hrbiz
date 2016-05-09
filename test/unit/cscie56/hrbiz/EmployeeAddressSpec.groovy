package cscie56.hrbiz

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeAddress)
class EmployeeAddressSpec extends Specification {

    Company company
    Department department
    Employee employee

    def setup() {
        company = new Company(name: 'A1 Company')
        department = new Department(name: 'Accounting', company: company)
        employee = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')
    }

    def cleanup() {
    }

    void "test valid address"() {
        when:
            EmployeeAddress address1 = new EmployeeAddress(employee: employee, address1: '123 Main St', address2: 'Apt B4',
                    city: 'Boston', state: 'MA', zipCode: '98887')
        then:
            address1.validate()

        when:
            EmployeeAddress address2 = new EmployeeAddress(employee: employee, address1: '123 Main St',
                    city: 'Boston', state: 'MA', zipCode: '98887')
        then:
            address2.validate()
    }

    void "test invalid address"() {
        when:
            EmployeeAddress address1 = new EmployeeAddress(employee: employee, address1: '', address2: 'Apt B4',
                city: 'Boston', state: 'MA', zipCode: '98887')
        then:
            !address1.validate()

        when:
            EmployeeAddress address2 = new EmployeeAddress(employee: employee, address1: '123 Main St',
                city: 'Boston')
        then:
            !address2.validate()
    }

}
