package be.abis.sandwich.model;

import be.abis.sandwich.exception.PersonNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String company;
    private  String mail;
    private int age;
    private List<Role> roles = new ArrayList<Role>();

    public Person(String firstName, String lastName, String mail, Role... roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.addRole(roles);
    }

    public Person(String firstName, String lastName, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        company = company;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean hasRole(String r) throws PersonNotFoundException {
        Role rol = roles.stream()
                .filter(role -> role.getType().equals(r)).findFirst()
                .orElseThrow(() -> new PersonNotFoundException("Rol not found"));
        return rol!=null ? true:false;
    }
    public Role findRole(String rol){
        Role r = null;
        r = roles.stream()
                .filter(role -> role.getType().equals(rol))
                .findFirst().get();

        return r;
    }
    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role... roles){
        for (Role r: roles         ) {
            this.roles.add(r);
        }
    }


}
