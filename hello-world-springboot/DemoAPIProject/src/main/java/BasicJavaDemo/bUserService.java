package BasicJavaDemo;

public class bUserService {

    private bUserService bUserService;

    public bUserService() {
        this.repository = new cUserRepository();
    }

    public String getUserGreetingMsg() {
        String username = "";
        return "Hello! Welcome to our app" + username;
    }
}
