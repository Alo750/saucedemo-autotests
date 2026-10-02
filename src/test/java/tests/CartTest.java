package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void addBackpackToCart() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver, wait);

        inventoryPage.addBackpackToCart();

        assertEquals(
                "1",
                inventoryPage.getCartBadgeText(),
                "После добавления товара счётчик корзины должен быть равен 1"
        );

        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver, wait);

        assertEquals(
                "Sauce Labs Backpack",
                cartPage.getItemName(),
                "В корзине должен находиться Sauce Labs Backpack"
        );

        assertEquals(
                "$29.99",
                cartPage.getItemPrice(),
                "Цена рюкзака должна соответствовать ожидаемой"
        );
    }
}