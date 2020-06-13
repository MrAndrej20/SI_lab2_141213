package si_lab2_141213.si_lab2_141213;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function(User user, List<String> allUsers) {
        if (user == null) {//1
            throw new RuntimeException("The user argument is not initialized!");//2
        } else {
            if (user.getUsername() == null || allUsers.contains(user.getUsername())) {//3
                throw new RuntimeException("User already exists!");//4
            } else {
                if (user.getEmail() == null)//5
                    return false;//6
                boolean atChar = false, dotChar = false;//7
                for (int i = 0; i < user.getEmail().length(); i++) {//8
                    if (user.getEmail().charAt(i) == '@')//9
                        atChar = true;//10
                    if (atChar && user.getEmail().charAt(i) == '.') {//11
                        dotChar = true;//12
                    }
                }
                if (!atChar || !dotChar) {//13
                    return false;//14
                }
            }
        }
        return true;//15
    }
}