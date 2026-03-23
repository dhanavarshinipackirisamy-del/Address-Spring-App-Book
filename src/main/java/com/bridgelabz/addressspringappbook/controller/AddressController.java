package com.bridgelabz.addressspringappbook.controller;

import com.bridgelabz.addressspringappbook.dto.AddressDTO;
import com.bridgelabz.addressspringappbook.model.Address;
import com.bridgelabz.addressspringappbook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/")
    public List<Address> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Address create(@RequestBody AddressDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable int id, @RequestBody AddressDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}