package main;

//import java.util.UUID;
import model.accounts.User;
import model.app.App;
import service.LogInService;

public class Main {
    public static void main(String[] args) {
//        User user = new User("elgreco","Grecu Cristian","email@emai.com","password","0777777777","adresa","00045050430403");
//        System.out.println(user);
        App app = new App();
        LogInService loginservice = new LogInService();
        loginservice.Main(app);
    }
}
