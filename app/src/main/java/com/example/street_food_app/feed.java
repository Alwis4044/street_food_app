package com.example.street_food_app;

public class feed {

    String name,number,rating,sname;

    public feed() {
    }

    public feed(String name, String number, String rating, String sname) {
        this.name = name;
        this.number = number;
        this.rating = rating;
        this.sname = sname;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
