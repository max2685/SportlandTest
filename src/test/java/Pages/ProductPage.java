package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    BaseFunc baseFunc;

    private final By DROP_DOWN_MENU_PRODUCTS = By.xpath(".//ul[@id='menu-product-menu1']/li/a");
    private final By SELECT_ITEM_FOOTBALL = By.xpath(".//li[@id='wp-megamenu-item-84749']/ul/li");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck("produkti");
    }

    public ProductPage clickOnZeniTab(String name) {
        List<WebElement> menuItems = baseFunc.getElements(DROP_DOWN_MENU_PRODUCTS);
        baseFunc.findElementInListAndClick(menuItems, name);
        return this;
    }

    public ProductPage clickOnFootballShoesItem(String name) {
        baseFunc.waitForElement(SELECT_ITEM_FOOTBALL);
        List<WebElement> menuItems = baseFunc.getElements(SELECT_ITEM_FOOTBALL);
        baseFunc.findElementInListAndClick(menuItems, name);
        return this;
    }

    public ItemsPage getItemsPage() {
        return new ItemsPage(baseFunc);
    }
}

