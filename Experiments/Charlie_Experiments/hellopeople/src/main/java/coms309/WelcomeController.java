package coms309;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Hello World Controller to display the string returned
 *
 * @author Vivek Bengre
 */

@RestController
class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello and welcome to cw_2's project page.";
    }

    @GetMapping("/info")
    public String info() { return "We are currently working on a project application which will help people find friends that share similar interests."; }

    @GetMapping("/about")
    public String about() { return "Our group members are Ezra, Charlie, Kai, and Chanho"; }

}
