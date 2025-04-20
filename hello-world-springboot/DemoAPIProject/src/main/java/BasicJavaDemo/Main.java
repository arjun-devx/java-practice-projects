package BasicJavaDemo;

public class Main {
    public static void main (String[] arg ) {
        cUserRepository cUserRepositoryObj = new cUserRepository();
        bUserService bUserServiceObj = new bUserService(cUserRepositoryObj);
        aUserController aUserControllerObj = new aUserController(bUserServiceObj);

        aUserControllerObj.greetUser();
    }
}
