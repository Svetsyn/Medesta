package medesata;

public abstract class Employee {
    protected String firstName;
    protected String secondName;
    protected String lastName;
    protected String gender;
    protected String country;
    protected int age;

    public Employee(String firstName, String secondName, String lastName, String gender, String country, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.age = age;
    }

}
