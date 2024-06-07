package com.example.bank.domain.entities;

/**
 * @author Rami Ammous
 */

public class Customer {

    private Long id;
    private String name;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
