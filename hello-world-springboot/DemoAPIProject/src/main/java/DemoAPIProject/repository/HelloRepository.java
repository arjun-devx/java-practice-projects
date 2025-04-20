package DemoAPIProject.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    public String getUserName() {
        return "Arjun";
    }
}
