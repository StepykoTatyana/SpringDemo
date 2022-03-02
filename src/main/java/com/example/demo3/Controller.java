package com.example.demo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
}
