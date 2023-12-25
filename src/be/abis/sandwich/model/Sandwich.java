package be.abis.sandwich.model;

import be.abis.sandwich.theenums.SandwichType;

public class Sandwich {
    String name;
    SandwichType sandwichType;
    Double pricePerUnit;
    String description;


    public Sandwich(String name, SandwichType sandwichType) {
        this.name = name;
        this.sandwichType = sandwichType;
    }

    public Sandwich( SandwichType sandwichType,String name, Double pricePerUnit, String description) {
        this.name = name;
        this.sandwichType = sandwichType;
        this.pricePerUnit = pricePerUnit;
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SandwichType getSandwichType() {
        return sandwichType;
    }

    public void setSandwichType(SandwichType sandwichType) {
        this.sandwichType = sandwichType;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "name='" + name + '\'' +
                ", sandwichType=" + sandwichType +
                ", pricePerUnit=" + pricePerUnit +
                ", description='" + description + '\'' +
                '}';
    }
}
