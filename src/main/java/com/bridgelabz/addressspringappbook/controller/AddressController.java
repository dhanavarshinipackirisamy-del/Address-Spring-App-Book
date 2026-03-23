package com.bridgelabz.addressspringappbook.controller;

import com.bridgelabz.addressspringappbook.dto.AddressDTO;
import com.bridgelabz.addressspringappbook.model.Address;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private List<Address> list = new ArrayList<>();
    private int counter = 1;

    // GET ALL
    @GetMapping("/")
    public List<Address> getAll() {
        return list;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) {
        return list.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE (use DTO)
    @PostMapping("/")
    public Address create(@RequestBody AddressDTO dto) {
        Address addr = new Address(counter++, dto.name, dto.city);
        list.add(addr);
        return addr;
    }

    // UPDATE (use DTO)
    @PutMapping("/{id}")
    public Address update(@PathVariable int id, @RequestBody AddressDTO dto) {
        Address addr = getById(id);
        if (addr != null) {
            addr.setName(dto.name);
            addr.setCity(dto.city);
        }
        return addr;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        list.removeIf(a -> a.getId() == id);
        return "Deleted Successfully";
    }
}