package cscie56.project

class Employee {

    String firstName
    String middleName
    String lastName
    Date dob
    long ssn
    String email
    String title
    String type
    Date dateHired
    int annualSalary
    String pictureLocation

    Employee manager
    Department department

    static belongsTo = [department: Department]

    static constraints = {
        firstName(blank: false, nullable: false)
        middleName nullable: true
        lastName(blank: false, nullable: false)
        dob(nullable: false)
        ssn size: 10
        email(nullable: false, email: true)
        title nullable: false
        type inList: ['full-time', 'part-time', 'intern', 'contractor']

        dateHired(validator: { value, obj, errors ->
            if (value?.before(obj.dob)) {
                errors.rejectValue('dateHired', 'hiredBeforeBorn', 'hired date before dob')
            }
        })

        annualSalary min: 0     // For unpaid interns
        pictureLocation nullable: true
        manager nullable: true
        department nullable: false
    }

    @Override
    public String toString() {
        "$firstName $lastName"
    }
}
