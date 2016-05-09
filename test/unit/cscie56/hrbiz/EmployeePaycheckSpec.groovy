package cscie56.hrbiz

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EmployeePaycheck)
class EmployeePaycheckSpec extends Specification {

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

    void "test valid paycheck"() {
        when:
            EmployeePaycheck paycheck1 = new EmployeePaycheck(employee: employee, payDate: new Date(), grossPay: 5000, taxAmount: 1000, netPay: 4000)
        then:
            paycheck1.validate()
    }

    void "test valid paycheck for tax free state"() {
        when:
            EmployeePaycheck paycheck1 = new EmployeePaycheck(employee: employee, payDate: new Date(), grossPay: 5000, taxAmount: 0, netPay: 5000)
        then:
            paycheck1.validate()
    }

    void "test invalid paycheck"() {
        when:
            EmployeePaycheck paycheck1 = new EmployeePaycheck(employee: employee, grossPay: 5000, taxAmount: 0, netPay: 3000)
        then:
            !paycheck1.validate()
    }

    void "test invalid paycheck where net pay is higher than gross pay"() {
        when:
            EmployeePaycheck paycheck1 = new EmployeePaycheck(employee: employee, grossPay: 5000, taxAmount: 0, netPay: 6000)
        then:
            !paycheck1.validate()
    }
}
