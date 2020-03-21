package Pages;

import org.openqa.selenium.By;

public class ProductPage {
    BaseFunc baseFunc;

    private final By ZENI_DROP_MENU = By.xpath("//*[text()='Zēni ']");
    private final By SELECTION_FUTBOLS = By.xpath(".//li[@id = 'wp-megamenu-item-84833']");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void ZeniDropDown() {
        baseFunc.waitForElement(ZENI_DROP_MENU);
        baseFunc.getElement(ZENI_DROP_MENU).click();
    }

    public ApaviPage ClickOnFutbols() {
        baseFunc.waitForElement(SELECTION_FUTBOLS);
        baseFunc.getElement(SELECTION_FUTBOLS).click();
        return new ApaviPage(baseFunc);
    }
}

