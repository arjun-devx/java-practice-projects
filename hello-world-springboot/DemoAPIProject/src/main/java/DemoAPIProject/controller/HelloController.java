package DemoAPIProject.controller;

import DemoAPIProject.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import DemoAPIProject.user.user;

@RestController
public class HelloController {
    @Autowired
    private HelloService HelloServiceObj;

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

    @GetMapping("/greetUser")
    public String greetUser() {
        return HelloServiceObj.getGreetingMessage();
    }
 }


