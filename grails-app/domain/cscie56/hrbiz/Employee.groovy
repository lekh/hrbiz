package cscie56.hrbiz

class Employee extends User {

    Employee manager
    Department department
    EmployeeAddress address

    String firstName
    String middleName
    String lastName
    Date dob
    String email
    String phoneNumber
    String title
    String type
    Date dateHired
    Integer annualSalary
    String pictureLocation
    String aboutMe

    Integer ssn
    String bankName
    String accountNo
    String routingNo

    static belongsTo = [department: Department]

    static hasOne = [address: EmployeeAddress]

    static hasMany = [paychecks: EmployeePaycheck]

    static constraints = {
        manager nullable: true
        department nullable: false
        address nullable: true

        firstName(blank: false, nullable: false)
        middleName nullable: true
        lastName(blank: false, nullable: false)
        dob(nullable: false)
        email(nullable: false, email: true)
        phoneNumber nullable: true
        title nullable: false
        type inList: ['full-time', 'part-time', 'intern', 'contractor']

        dateHired(validator: { value, obj, errors ->
            if (value?.before(obj.dob)) {
                errors.rejectValue('dateHired', 'hiredBeforeBorn', 'hired date before dob')
            }
        })

        annualSalary min: 0     // For unpaid interns
        pictureLocation nullable: true
        aboutMe nullable: true

        ssn size: 10
        bankName nullable: true
        accountNo nullable: true
        routingNo nullable: true
    }

    @Override
    public String toString() {
        "$firstName $lastName"
    }

    public String getName() {
        if (middleName) {
            return "$firstName $middleName $lastName"
        } else {
            return "$firstName $lastName"
        }
    }

    public String getSeniority() {
        int years = new Date().year - dateHired.year
        int months =  new Date().year - dateHired.month
        int monthMod = months % 12
        return "$years years $monthMod months"
    }
}
