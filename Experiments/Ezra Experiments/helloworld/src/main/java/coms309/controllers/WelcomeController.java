package coms309.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "yeah imig";
    }

    @GetMapping("/{user}")
    public String welcome(@PathVariable String user) {
        return "you will never get away with this " + user + "!";
    }

    @PostMapping("/userRepository")
    public String returnUsers(){return "a";}
}
