package cscie56.hrbiz

class PayHistoryTagLib {
    static defaultEncodeAs = [taglib: 'text']

    def springSecurityService

    static namespace = "pay"

    /**
     * Shows all pay history for the currently logged in employee
     */
    def history = { attrs, body ->
        Employee employee = Employee.findById(springSecurityService.currentUserId)
        List<EmployeePaycheck> payChecks = EmployeePaycheck.findAllByEmployee(employee, [sort: 'payDate', order: 'desc'])

        if (payChecks != null) {
            out << render(template: '/employeePaycheck/payHistory', model: [pay: payChecks])
        }
    }

    /**
     * Shows yearly tax paid by employee
     */
    def w2 = { attrs, body ->
        Employee employee = Employee.findById(springSecurityService.currentUserId)

        Map w2 = [:]
        EmployeePaycheck.findAllByEmployee(employee).each { pay ->
            Date payDate = pay.payDate
            int year = payDate[Calendar.YEAR]
            if (w2.containsKey(year)) {
                int tax = w2.get(year)
                w2.put(year, pay.taxAmount + tax)
            } else {
                w2.put(year, pay.taxAmount)
            }
        }

        out << render(template: '/employeePaycheck/w2', model: [w2: w2])
    }
}
