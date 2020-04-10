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

    //please make it not hardcoded .stream
    public ProductPage clickOnZeniTab(String name) {
        List<WebElement> menuItems = baseFunc.getElements(DROP_DOWN_MENU_PRODUCTS);
        menuItems
                .stream()
                .filter(we -> we.getText().toLowerCase().contains(name))
                .findFirst()
                .get()
                .click();
        return this;
    }


    public ProductPage clickOnFootballShoesItem(String name) {
        baseFunc.waitForElement(SELECT_ITEM_FOOTBALL);
        List<WebElement> menuItems = baseFunc.getElements(SELECT_ITEM_FOOTBALL);
        menuItems
                .stream()
                .filter(we -> we.getText().toLowerCase().contains(name))
                .findAny()
                .get()
                .click();
        return this;
    }

    public ItemsPage getItemsPage() {
        return new ItemsPage(baseFunc);
    }
}

