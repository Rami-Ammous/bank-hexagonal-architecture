package com.example.bank.application.dto;

/**
 * @author Rami Ammous
 */

public class CustomerDto {

    private Long id;
    private String name;

    public CustomerDto(Long id, String name) {
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
