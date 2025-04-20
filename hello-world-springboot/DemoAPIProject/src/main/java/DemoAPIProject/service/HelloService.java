package DemoAPIProject.service;

import DemoAPIProject.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    private HelloRepository HelloRepositoryObj;

    public String getGreetingMessage() {
        String username = HelloRepositoryObj.getUserName();
        return "Hello " + username + "!";
    }
}
