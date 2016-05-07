package cscie56.hrbiz

class Department {

    String name

    Company company

    static belongsTo = [company: Company]

    static constraints = {
        name inList: ['Accounting', 'Technology', 'Finance', 'HR', 'Management']
    }

    @Override
    public String toString() {
        name
    }
}
