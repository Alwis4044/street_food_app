package com.example.street_food_app;

public class Items {

    String shopname,number,address,pro1,pro2,pro3,pro4,lati,longo,imageurl;

    public Items() {
    }

    public Items(String shopname, String number, String address, String pro1, String pro2, String pro3, String pro4, String lati, String longo, String imageurl) {
        this.shopname = shopname;
        this.number = number;
        this.address = address;
        this.pro1 = pro1;
        this.pro2 = pro2;
        this.pro3 = pro3;
        this.pro4 = pro4;
        this.lati = lati;
        this.longo = longo;
        this.imageurl = imageurl;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPro1() {
        return pro1;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    public String getPro2() {
        return pro2;
    }

    public void setPro2(String pro2) {
        this.pro2 = pro2;
    }

    public String getPro3() {
        return pro3;
    }

    public void setPro3(String pro3) {
        this.pro3 = pro3;
    }

    public String getPro4() {
        return pro4;
    }

    public void setPro4(String pro4) {
        this.pro4 = pro4;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongo() {
        return longo;
    }

    public void setLongo(String longo) {
        this.longo = longo;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
