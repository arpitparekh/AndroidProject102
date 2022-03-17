package com.arpitparekh.hardikbhagvatproject.passString_passObject;

import java.io.Serializable;

public class Student implements Serializable {

    String name;
    String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
