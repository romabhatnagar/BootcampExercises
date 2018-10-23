package com.ttn.spring.Thymleaf;

public enum Role {
    SUPER_ADMIN("SUPER ADMIN"),
    ADMIN("ADMIN"),
    USER("USER");

    String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
