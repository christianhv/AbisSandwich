package be.abis.sandwich.model;

import be.abis.sandwich.theenums.SandwichType;

import javax.xml.namespace.QName;

public class Sandwich {
    String name;
    SandwichType sndwchType;
    Double pricePerUnit;
    String description;

    public Sandwich(String name, SandwichType sndwchType) {
        this.name = name;
        this.sndwchType = sndwchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SandwichType getSndwchType() {
        return sndwchType;
    }

    public void setSndwchType(SandwichType sndwchType) {
        this.sndwchType = sndwchType;
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
}
