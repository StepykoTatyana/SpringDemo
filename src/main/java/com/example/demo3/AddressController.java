package com.example.demo3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressController {
    private final ConcurrentMap<String, String> addressBook = new ConcurrentHashMap<>();

    @PostMapping("/addresses")
    public void postAddress(@RequestParam String name, @RequestParam String address) {
        addressBook.put(name, address);
    }

    @GetMapping("/addresses/{name}")
    public String getAddress(@PathVariable String name) {
        System.out.println(addressBook.get(name));
        return addressBook.get(name);
    }

    @DeleteMapping("/addresses")
    public String removeAddress(@RequestParam String name) {
        addressBook.remove(name);
        return name + " removed from address book!";
    }


    final ConcurrentHashMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
            55L, "Chair",
            99L, "Table",
            345L, "Vase"
    ));

    final String ERROR = "Item wasn't found";

    @GetMapping("/items/{id}")
    String getItem(@PathVariable long id) {
        String item = items.get(id);
        return item != null ? item : ERROR;
    }

    @DeleteMapping("/items/{id}")
    public String removeItems(@PathVariable long id) {
        if (items.containsKey(id)) {
            String value = items.get(id);
            items.remove(id);
            return value;
        } else {
            return ERROR;
        }
    }
}