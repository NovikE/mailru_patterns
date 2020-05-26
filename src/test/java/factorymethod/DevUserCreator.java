package factorymethod;

import java.util.ResourceBundle;

public class DevUserCreator implements UserCreator{

    public static final String USER_NAME = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";

    @Override
    public User createUser() {
        ResourceBundle rb = ResourceBundle.getBundle("dev");
        return new User(rb.getString(USER_NAME), rb.getString(USER_PASSWORD));
    }
}
