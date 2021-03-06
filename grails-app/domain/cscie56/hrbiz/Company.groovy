package cscie56.hrbiz

class Company {

    String name
    String description
    String domainName

    static hasMany = [departments: Department]

    static constraints = {
        name(blank: false, nullable: false, unique: true)
        description nullable: true
        domainName nullable: true
    }

    @Override
    public String toString() {
        name
    }
}
