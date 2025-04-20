package BasicJavaDemo;

public class bUserService {
    private final cUserRepository cUserRepositoryObj;

    //Constructor
    public bUserService(cUserRepository cUserRepositoryObj) {
        this.cUserRepositoryObj = cUserRepositoryObj;
    }

    public String getUserGreetingMsg() {
        String username = cUserRepositoryObj.getUserName();;
        return "Hello! Welcome to our app " + username;
    }
}
