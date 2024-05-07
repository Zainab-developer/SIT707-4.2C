package sit707_week2;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main {
    public static void main(String[] args) {
        String url = "https://www.bunnings.com.au/login";
        String email = "zainab@example.com";
        String password = "zainab";
        
        SeleniumOperations.bunningsLogin(url, email, password);
    }
}