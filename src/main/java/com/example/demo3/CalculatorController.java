package com.example.demo3;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/{operation}")
    public String calculate(@PathVariable String operation, @RequestParam int a, @RequestParam int b) {
        switch (operation) {
            case "add":
                return String.valueOf(a + b);
            case "subtract":
                return String.valueOf(a - b);
            case "mult":
                return String.valueOf(a * b);
        }
        return "Unknown operation";
    }
}
