package com.example.Shoes.DB.dto;

import java.util.Objects;

public class user {
    private String name;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    public user() {
    }

    public user(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
