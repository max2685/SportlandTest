package Pages;

import org.openqa.selenium.By;

import static enums.SideMenuItems.PRODUKTI;

public class ProductPage {
    BaseFunc baseFunc;

    private final By DROP_DOWN_MENU_PRODUCTS = By.xpath(".//ul[@id='menu-product-menu1']/li/a");
    private final By ITEMS_UNDER_SHOES = By.xpath(".//li[@id='wp-megamenu-item-84749']/ul/li");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck(PRODUKTI.menuItem());
    }

    public ProductPage clickOnGenderTab(String name) {
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(DROP_DOWN_MENU_PRODUCTS), name);
        return this;
    }

    public ProductPage clickOnFootballShoesItem(String name) {
        baseFunc.waitForElement(ITEMS_UNDER_SHOES);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(ITEMS_UNDER_SHOES), name);
        return this;
    }

    public void selectProductInSubMenu() {
        // try to create it reusable
    }

    public ItemsPage getItemsPage() {
        return new ItemsPage(baseFunc);
    }
}

