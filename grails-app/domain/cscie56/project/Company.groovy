package cscie56.project

class Company {

    String name
    String description
    String domainName

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
