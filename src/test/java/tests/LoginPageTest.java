package tests;

import factorymethod.QAUserCreator;
import factorymethod.User;
import factorymethod.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginPageTest extends BaseTest{

        @Test
        public void loginUser() throws IOException {
            UserCreator creator = new QAUserCreator();
            User testUser = creator.createUser();
            Assert.assertTrue(new LoginPage(driver)
            .login(testUser)
            .getLoggedUserName().contains(testUser.getUsername()),"Wrong user login name!");
        }

    }

