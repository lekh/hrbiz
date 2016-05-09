package cscie56.hrbiz

class Department {

    Company company

    String name

    static belongsTo = [company: Company]

    static hasMany = [employees: Employee]

    static constraints = {
        company nullable: false
        name inList: ['Accounting', 'Technology', 'Finance', 'HR', 'Management']
    }

    @Override
    public String toString() {
        name
    }
}
