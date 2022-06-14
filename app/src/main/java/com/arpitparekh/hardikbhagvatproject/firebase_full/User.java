package com.arpitparekh.hardikbhagvatproject.firebase_full;

public class User {

    String name;
    String uid;
    String url;
    String address;
    String phone;
    String email;

    User(){

    }

    public User(String name, String uid, String url, String address, String phone, String email) {
        this.name = name;
        this.uid = uid;
        this.url = url;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
