package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static enums.SideMenuItems.PRODUKTI;

public class ProductPage {
    BaseFunc baseFunc;

    private final By DROP_DOWN_MENU_PRODUCTS = By.xpath(".//ul[@id='menu-product-menu1']/li/a");
    private final By ITEMS_UNDER_SHOES = By.xpath(".//li[@id='wp-megamenu-item-84749']/ul/li");
    private final By RAWS_IN_TAB = By.xpath(".//li[@class = 'wpmm-row wp-megamenu-item-404705606899805682 wpmm-submenu-right']/ul/li");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck(PRODUKTI.menuItem());
    }

    public ProductPage clickOnGenderTab(String name) {
        baseFunc.waitForElement(DROP_DOWN_MENU_PRODUCTS);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(DROP_DOWN_MENU_PRODUCTS), name);
        return this;
    }

    public ProductPage clickOnFootballShoesItem(String name) {
        baseFunc.waitForElement(ITEMS_UNDER_SHOES);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(ITEMS_UNDER_SHOES), name);
        return this;
    }

    public ProductPage selectProductInSubMenu(Integer rawNumber, String name) {
        List<WebElement> listWithRaws = baseFunc.getElements(RAWS_IN_TAB);
        for (int i = 0; i < listWithRaws.size(); i++) {
            List<WebElement> elementsInRaw = listWithRaws.get(rawNumber).findElements(By.tagName("li"));
            baseFunc.findElementInListByNameAndClick(elementsInRaw, name);
            break;
        }
        return this;
    }

    public ItemsPage getItemsPage() {
        return new ItemsPage(baseFunc);
    }
}

