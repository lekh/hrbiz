package cscie56.project

class Department {

    String name

    Company company

    static belongsTo = [company: Company]

    static constraints = {
        name inList: ['Accounting', 'IT', 'Finance', 'Engineer', 'HR', 'Management']
    }

    @Override
    public String toString() {
        name
    }
}
