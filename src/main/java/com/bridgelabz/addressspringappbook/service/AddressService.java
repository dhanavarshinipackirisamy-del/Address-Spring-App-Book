package com.bridgelabz.addressspringappbook.service;

import com.bridgelabz.addressspringappbook.dto.AddressDTO;
import com.bridgelabz.addressspringappbook.model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private List<Address> list = new ArrayList<>();
    private int counter = 1;

    // GET ALL
    public List<Address> getAll() {
        return list;
    }

    // GET BY ID
    public Address getById(int id) {
        return list.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE
    public Address create(AddressDTO dto) {
        Address addr = new Address(counter++, dto.name, dto.city);
        list.add(addr);
        return addr;
    }

    // UPDATE
    public Address update(int id, AddressDTO dto) {
        Address addr = getById(id);
        if (addr != null) {
            addr.setName(dto.name);
            addr.setCity(dto.city);
        }
        return addr;
    }

    // DELETE
    public void delete(int id) {
        list.removeIf(a -> a.getId() == id);
    }
}