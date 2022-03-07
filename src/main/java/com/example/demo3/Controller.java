package com.example.demo3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class Controller {

    List<Colors> taskList = List.of(
            new Colors("black", "hue", "primary", new Code(new int[]{0, 0, 0, 1}, "#000")),
            new Colors("white", "value", "primary", new Code(new int[]{255, 255, 255, 1}, "#FFF"))
    );
    Map<String, List<Colors>> stringListMap = Map.of(
            "colors", taskList);


    @GetMapping("/colors")
    public Map<String, List<Colors>> getTasks() {
        return stringListMap;
    }


    private final ArrayList<String> users = new ArrayList<>();

    @PostMapping("/users")
    public void postUsers(@RequestParam String name) {
        users.add(name);
    }

    @GetMapping("/users")
    public ArrayList<String> getUsers() {
        return users;
    }

    final ConcurrentMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
            535L, "Chair",
            99534533L, "Table",
            343455L, "Vase"
    ));

    @GetMapping("/items1/{id}")
    ResponseEntity<?> getItem(@PathVariable long id) {
        if (items.containsKey(id)) {
            return new ResponseEntity<>(items.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test/{status}")
    ResponseEntity<?> getTest(@PathVariable int status) {
        switch (status){
            case 200:
                return new ResponseEntity<>(HttpStatus.OK);
            case 300:
                return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
            case 400:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
