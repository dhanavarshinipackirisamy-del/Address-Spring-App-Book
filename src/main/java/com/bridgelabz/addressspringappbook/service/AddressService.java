package com.bridgelabz.addressspringappbook.service;

import com.bridgelabz.addressspringappbook.dto.AddressDTO;
import com.bridgelabz.addressspringappbook.model.Address;
import com.bridgelabz.addressspringappbook.exception.AddressBookException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final List<Address> list = new ArrayList<>();

    public List<Address> getAll() {
        return list;
    }

    public Address getById(int id) {
        return list.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Address not found with ID: " + id));
    }

    public Address create(AddressDTO dto) {
        Address address = new Address(dto);
        list.add(address);
        return address;
    }

    public Address update(int id, AddressDTO dto) {
        Address address = getById(id);
        address.setName(dto.getName());
        address.setCity(dto.getCity());
        address.setPhone(dto.getPhone());
        return address;
    }

    public void delete(int id) {
        Address address = getById(id);
        list.remove(address);
    }
}