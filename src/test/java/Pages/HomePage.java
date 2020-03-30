package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By SIDE_MENU = By.xpath(".//button[@class = 'menu-trigger js-toggle-menu']");
    private final By SIDE_MENU_ITEMS = By.xpath(".//nav[@class = 'primary-menu-container']/ul/li");
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck("sportland.lv");
    }

    public void openSideMenu() {
        baseFunc.getElement(SIDE_MENU).click();
    }

    public ProductPage sideMenuItem(String name) {
        List<WebElement> menuItems = baseFunc.getElements(SIDE_MENU_ITEMS);
        for (WebElement we : menuItems) {
            if (we.getText().equals(name)) {
                we.click();
                break; //po drugomu ne rabotaet
            }
        }
        return new ProductPage(baseFunc);
    }
}
