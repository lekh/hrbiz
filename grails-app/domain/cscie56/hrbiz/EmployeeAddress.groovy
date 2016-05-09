package cscie56.hrbiz

class EmployeeAddress {

    Employee employee

    String address1
    String address2
    String city
    String state
    String zipCode

    static belongsTo = [employee: Employee]

    static constraints = {
        employee nullable: false
        address1(blank: false, nullable: false)
        address2 (blank: true, nullable: true)
        city(blank: false, nullable: false)
        state (blank: false, nullable: false)
        zipCode (blank: false, nullable: false)
    }

    @Override
    public String toString() {
        "$address1 $address2, $city, $state $zipCode"
    }
}
