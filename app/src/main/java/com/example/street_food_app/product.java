package com.example.street_food_app;

public class product {

    String address,name,number;

    public product() {
    }

    public product(String address, String name, String number) {
        this.address = address;
        this.name = name;
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
