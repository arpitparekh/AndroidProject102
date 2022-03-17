package com.arpitparekh.hardikbhagvatproject.passString_passObject_revision;

import java.io.Serializable;

public class Emp implements Serializable {

    String name;
    String address;

    public Emp(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
