package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "После успешной авторизации URL должен содержать /inventory.html"
        );

        assertEquals(
                "Products",
                driver.findElement(
                        org.openqa.selenium.By.cssSelector(".title")
                ).getText(),
                "После входа должен отображаться заголовок Products"
        );
    }
}