package coms309;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Hello and welcome to COMS 309";
    }

    @GetMapping("/{user}")
    public String welcome(@PathVariable String user) {
        return "Hello and welcome to COMS 309: " + user;
    }

    @PostMapping("/users")
    public String returnUsers(){return }
}
