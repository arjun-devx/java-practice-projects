package DemoAPIProject.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import DemoAPIProject.user.user;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String Hello () {
        return "Hello Visitor";
    }

    @GetMapping("/hello/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/user")
    public user getUser() {
        return new user("Arjun", 1, "India");
    }
 }


