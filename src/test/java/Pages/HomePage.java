package Pages;

import enums.SideMenuItems;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private final String SPORTLAND_LV = "https://sportland.lv/";
    private final By SIDE_MENU = By.xpath(".//button[@class = 'menu-trigger js-toggle-menu']");
    private final By SIDE_MENU_ITEMS = By.xpath(".//nav[@class = 'primary-menu-container']/ul/li");
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        assertEquals("It's not a Home page", SPORTLAND_LV, baseFunc.getCurrentUrl());
    }

    public void openSideMenu() {
        baseFunc.getElement(SIDE_MENU).click();
    }

    public HomePage selectItemFromSideMenu(SideMenuItems name) {
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(SIDE_MENU_ITEMS), name.menuItem());
        return this;
    }

    public ProductPage getProductPage() {
        return new ProductPage(baseFunc);
    }
}
