package com.example.demo3;

import java.util.ArrayList;

public class Colors {
    private String color;
    private String category;
    private String type;
    private Code code;
    private ArrayList<Colors> colors;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }


    public Colors() {}

    public Colors(String color, String category, String type, Code code) {
        this.color = color;
        this.category = category;
        this.type = type;
        this.code = code;
    }

}
