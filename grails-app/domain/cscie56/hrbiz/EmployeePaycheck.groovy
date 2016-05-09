package cscie56.hrbiz

class EmployeePaycheck {

    Employee employee

    Date payDate
    Integer grossPay
    Integer taxAmount
    Integer netPay

    static belongsTo = [employee: Employee]

    static constraints = {
        employee nullable: false
        payDate nullable: false
        grossPay nullable: false
        taxAmount nullable: true

        netPay(validator: { value, obj, errors ->
            if (value > obj.grossPay) {
                errors.rejectValue('netPay', 'netPayHigherThanGrossPay', 'Net pay cannot be higher than gross pay')
            }
        })
    }

    @Override
    public String toString() {
        grossPay
    }
}
