package cscie56.hrbiz

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class EmployeeService {

    def springSecurityService

    /**
     * List all employees. If department is passed it'll list employees
     * within the department
     */
    def listEmployee(Department department) {
        String listType = 'All'
        if (department != null) {
            listType = department.name
        }
        ['department': department, 'listType': listType]
    }

    /**
     * Save employee profile
     * Gets value from GrailsParameterMap
     */
    def saveProfile(GrailsParameterMap params) {
        println("printing all params " + params)

        Employee employee = Employee.findById(springSecurityService.currentUserId)
        employee.phoneNumber = params.phone as String
        employee.bankName = params.bankName as String
        employee.routingNo = params.routingNumber as String
        employee.accountNo = params.accountNumber as String
        employee.aboutMe = params.aboutMe as String
        employee.save(flush: true)

        // Validate and save address
        EmployeeAddress address = EmployeeAddress.findByEmployee(employee)
        if (address == null) {
            address = new EmployeeAddress(employee: employee)
        }
        address.address1 = params.address1 as String
        address.address2 = params.address2 as String
        address.city = params.city as String
        address.state = params.state as String
        address.zipCode = params.zip as String

        if (address.validate()) {
            address.save(flush: true)
        } else {
            log.info("address not saved")
        }

    }
}
