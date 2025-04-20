package BasicJavaDemo;

public class aUserController {

    private bUserService bUserServiceObj;

    public aUserController(bUserService bUserServiceObj) {
        this.bUserServiceObj =  bUserServiceObj;
    }

    public void greetUser() {
        System.out.println(bUserServiceObj.getUserGreetingMsg());
    }
}
