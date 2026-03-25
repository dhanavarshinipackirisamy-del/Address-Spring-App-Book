package com.bridgelabz.addressspringappbook.model;

import com.bridgelabz.addressspringappbook.dto.AddressDTO;

public class Address {

    private static int counter = 1;

    private int id;
    private String name;
    private String city;
    private String phone;

    public Address(AddressDTO dto) {
        this.id = counter++;
        this.name = dto.getName();
        this.city = dto.getCity();
        this.phone = dto.getPhone();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getPhone() { return phone; }

    public void setName(String name) { this.name = name; }
    public void setCity(String city) { this.city = city; }
    public void setPhone(String phone) { this.phone = phone; }
}