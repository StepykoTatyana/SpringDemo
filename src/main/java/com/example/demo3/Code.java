package com.example.demo3;

public class Code {
    private int[] rgba;
    private String hex;

    public int[] getRgba() {
        return rgba;
    }

    public void setRgba(int[] rgba) {
        this.rgba = rgba;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
    public Code() {}

    public Code(int[] rgba, String hex) {
        this.rgba = rgba;
        this.hex = hex;
    }
}
