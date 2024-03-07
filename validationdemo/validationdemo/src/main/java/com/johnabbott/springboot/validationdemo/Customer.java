package com.johnabbott.springboot.validationdemo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {


    @NotNull (message = "is required")
    @Size(min=1, message = "is required")
    private String firstName;

    @NotNull (message = "is required")
    @Size(min=1, message = "is required")
    private String lastName = "";

    // Getter
    public String getLastName() {
        return lastName;
    }

    // Setter
    public void setLastName(String newName) {
        this.lastName = newName;
    }

    public String getFirstName() {
        return firstName;
    }

    // Setter
    public void setFirstName(String newName) {
        this.firstName = newName;
    }


}
