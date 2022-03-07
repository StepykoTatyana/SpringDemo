package com.example.demo3;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    @PostMapping("/user")
    public String userStatus(@RequestBody UserInfo user) {
        if (user.isEnabled()) {
            return String.format("Hello! %s. Your account is enabled.", user.getName());

        } else {
            return String.format(
                    "Hello! Nice to see you, %s! Your account is disabled",
                    user.getName()
            );
        }
    }

    @PostMapping("/user1")
    public String userStatus1(@RequestBody List<UserInfo> userList) {
        return String.format("Added %d users", userList.size());
    }

    @PostMapping(value = "/user2", consumes = MediaType.APPLICATION_XML_VALUE)
    public String userStatus2(@RequestBody UserInfo user) {
        return String.format("Added User %s", user);
    }
}

