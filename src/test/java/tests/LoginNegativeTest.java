package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void loginWithLockedUser() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        loginPage.login(
                "locked_out_user",
                "secret_sauce"
        );

        String error =
                loginPage.getErrorMessage();

        assertTrue(
                error.toLowerCase().contains("locked out"),
                "Для заблокированного пользователя должно появиться сообщение о блокировке"
        );
    }
}