package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private final By SIDE_MENU = By.xpath(".//button[@class = 'menu-trigger js-toggle-menu']");
    private final By SIDE_MENU_ITEMS = By.xpath(".//nav[@class = 'primary-menu-container']/ul/li");
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        assertEquals("It's not a Home page", "https://sportland.lv/", baseFunc.getCurrentUrl());
    }

    public void openSideMenu() {
        baseFunc.getElement(SIDE_MENU).click();
    }

    public HomePage sideMenuItem(String name) {
        List<WebElement> menuItems = baseFunc.getElements(SIDE_MENU_ITEMS);
        menuItems
                .stream()
                .filter(we -> we.getText().contains(name))
                .findAny()
                .get()
                .click();

//        List<WebElement> menuItems = baseFunc.getElements(SIDE_MENU_ITEMS);
//        for (WebElement we : menuItems) {
//            if (we.getText().equals(name)) {
//                we.click();
//                break;
//            }
//        }
        return this;
    }

    public ProductPage getProductPage() {
        return new ProductPage(baseFunc);
    }
}
