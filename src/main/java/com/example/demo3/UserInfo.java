package com.example.demo3;

public class UserInfo {

    private int id;
    private String name;
    private String phone;
    private boolean enabled;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
// getters and setters

    UserInfo() {
    }

    UserInfo(int id, String name, String phone, boolean enabled) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.enabled = enabled;
    }
}
