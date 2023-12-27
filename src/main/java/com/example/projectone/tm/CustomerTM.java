package com.example.projectone.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private int id;
    private String name;
    private String contactNo;
    private Button option;

    public CustomerTM() {
    }

    public CustomerTM(int id, String name, String contactNo, Button option) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Button getOption() {
        return option;
    }

    public void setOption(Button option) {
        this.option = option;
    }
}
