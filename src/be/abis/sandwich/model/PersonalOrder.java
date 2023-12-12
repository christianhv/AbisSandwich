package be.abis.sandwich.model;

import be.abis.sandwich.theenums.BreadType;

public class PersonalOrder {
    Sandwich sandwich;
    Boolean vegetables;
    BreadType bread;
    Person orderOwner;

    public PersonalOrder() {
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Boolean getVegetables() {
        return vegetables;
    }

    public void setVegetables(Boolean vegetables) {
        this.vegetables = vegetables;
    }

    public BreadType getBread() {
        return bread;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public Person getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(Person orderOwner) {
        this.orderOwner = orderOwner;
    }
}
