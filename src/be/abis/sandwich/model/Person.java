package be.abis.sandwich.model;

public class Person {
    String firstName;
    String LastName;
    String Company;

    int age;



    public Person(String firstName, String lastName, String company) {
        this.firstName = firstName;
        LastName = lastName;
        Company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCompany() {
        return Company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setCompany(String company) {
        Company = company;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
