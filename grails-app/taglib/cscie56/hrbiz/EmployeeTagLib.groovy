package cscie56.hrbiz

class EmployeeTagLib {

    static defaultEncodeAs = [taglib: 'text']

    static namespace = "employee"

    /**
     * List all employee. If department is not null it'll only display employees within the department.
     */
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
            employee << ['department': it.department.name]
            employee << ['manager': it.manager?.getName()]
            employee << ['type': it.type]
            employee << ['seniority': it.getSeniority()]

            out << render(template: '/employee/employeeRow', model: employee)
        }

    }

}
