package cscie56.hrbiz

class Employee extends User {

    String firstName
    String middleName
    String lastName
    Date dob
    long ssn
    String email
    String phoneNumber
    String title
    String type
    Date dateHired
    int annualSalary
    String pictureLocation
    String aboutMe

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
        manager nullable: true
        department nullable: false
        aboutMe nullable: true
    }

    /*
    @Override
    public String toString() {
        "$firstName $lastName"
    }
    */




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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", ssn=" + ssn +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", dateHired=" + dateHired +
                ", annualSalary=" + annualSalary +
                ", pictureLocation='" + pictureLocation + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", manager=" + manager +
                ", department=" + department +
                ", version=" + version +
                "} " + super.toString();
    }
}