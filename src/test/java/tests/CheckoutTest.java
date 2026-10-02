package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeOrderSuccessfully() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver, wait);

        inventoryPage.addBackpackToCart();

        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver, wait);

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver, wait);

        checkoutPage.fillCustomerData(
                "Maria",
                "Novruzova",
                "12345"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        assertEquals(
                "Thank you for your order!",
                checkoutPage.getCompleteMessage(),
                "После завершения заказа должно появиться сообщение об успешном оформлении"
        );
    }
}