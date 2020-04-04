package Pages;

import org.openqa.selenium.By;

public class ProductPage {
    BaseFunc baseFunc;

    private final By DROP_DOWN_MENU_ITEM = By.xpath("//*[text()='Zēni ']");
    private final By SELECT_ITEM = By.xpath(".//li[@id = 'wp-megamenu-item-84833']");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck("produkti");
    }

    //please make it not hardcoded .stream
    public ProductPage clickOnZeniTab() {
        baseFunc.waitForElement(DROP_DOWN_MENU_ITEM);
        baseFunc.getElement(DROP_DOWN_MENU_ITEM).click();
        return this;
    }

    //please make it not hardcoded .stream
    public ProductPage clickOnFootballItem() {
        baseFunc.waitForElement(SELECT_ITEM);
        baseFunc.getElement(SELECT_ITEM).click();
        return this;
    }

    //please specify method name
    public ItemsPage andGetItemsPage() {
        return new ItemsPage(baseFunc);
    }
}

