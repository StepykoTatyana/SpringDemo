package com.example.demo3;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DataController2 {
    Map<Integer, String> map = new LinkedHashMap<>();

    @GetMapping("/api/data1/{id}")
    public Map<String, String> getData(@PathVariable int id) {
        return Map.of("data", map.get(id));
    }

    @PostMapping("/api/data1/new")
    public Map<String, Integer> postRequestData(@RequestBody Map<String, String> dataUser) {
        String data = dataUser.get("data");
        if (map.size() == 0) {
            map.put(1, data);
        } else {
            map.put(map.size() + 1, data);
        }
        return Map.of("id", map.size());
    }


}