package hrbiz

import cscie56.project.Company
import cscie56.project.Department
import cscie56.project.Employee

class EmployeeTagLib {

    static defaultEncodeAs = [taglib:'text']

    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "employee"

    def list = { attrs, body ->
        Department department = attrs.department

        List<Employee> employees
        if (department != null) {
            employees = Employee.findAllByDepartment(department)
        } else {
            employees = Employee.list()
        }

        employees.each {
            Map employee = [:]
            employee << ['id': it.id]
            employee << ['name': it.getName()]
            employee << ['email': it.email]
            employee << ['phone': it.phoneNumber]
            employee << ['title': it.title]
            employee << ['type': it.type]
            employee << ['seniority': it.getSeniority()]

            out << render(template: '/employee/employeeRow', model: employee)
        }

    }

}
