package com.bridgelabz.addressspringappbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/")
    public String home() {
        return "Address Book App is Running!";
    }
}
