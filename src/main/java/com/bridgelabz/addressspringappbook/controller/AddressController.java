package com.bridgelabz.addressspringappbook.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private List<Address> list = new ArrayList<>();
    private int counter = 1;

    // Model class (inner class for now)
    static class Address {
        private int id;
        private String name;
        private String city;

        public Address() {}

        public Address(int id, String name, String city) {
            this.id = id;
            this.name = name;
            this.city = city;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
    }

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

    // CREATE
    @PostMapping("/")
    public Address create(@RequestBody Address addr) {
        addr.setId(counter++);
        list.add(addr);
        return addr;
    }

    // UPDATE
    @PutMapping("/{id}")
    public Address update(@PathVariable int id, @RequestBody Address newAddr) {
        Address addr = getById(id);
        if (addr != null) {
            addr.setName(newAddr.getName());
            addr.setCity(newAddr.getCity());
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