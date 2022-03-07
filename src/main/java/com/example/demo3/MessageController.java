package com.example.demo3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    NewClass newClass = new NewClass();

    @PostMapping("/message")
    public ResponseEntity<?> Message(@RequestBody NewClass newClassUser) {
        newClass.setImportantMessage(newClassUser.getImportantMessage());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/message")
    public ResponseEntity<?> Message() {
        return new ResponseEntity<>(newClass, HttpStatus.OK);
    }
}
class NewClass {
    private String importantMessage;

    public String getImportantMessage() {
        return importantMessage;
    }

    public void setImportantMessage(String importantMessage) {
        this.importantMessage = importantMessage;
    }

    public NewClass(String importantMessage) {
        this.importantMessage = importantMessage;
    }

    public NewClass() {
    }
}