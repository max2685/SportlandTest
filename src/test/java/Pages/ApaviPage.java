package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ApaviPage {
    BaseFunc baseFunc;

    private final By SORT_MENU = By.xpath(".//div[@class = 'spodb-filter__select']");
    private final By SORT_MENU_ITEM = By.xpath(".//option[@value = 'offer']");
    private final By FILTER_CATEGORY = By.xpath(".//label[@for = 'firm-ground-football-boots']");
    private final By FILTER_BRAND = By.xpath(".//label[@for = '85']");
    private final By ITEMS_ON_PAGE = By.xpath(".//p[@class = 'spodb-product-card__title']");
    private final By ITEMS_ON_PAGE_DISCOUNT = By.xpath(".//p[@class = 'spodb-product-card__percentage']");

    public ApaviPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck("football");

    }

    public void openSortMenu() {
        baseFunc.waitForElement(SORT_MENU);
        baseFunc.getElement(SORT_MENU).click();
    }

    public void clickOnFilter() {
        baseFunc.waitForElement(SORT_MENU_ITEM);
        baseFunc.getElement(SORT_MENU_ITEM).click();
    }

    public void selectFilters() {
        baseFunc.getElement(FILTER_CATEGORY).click();
        baseFunc.scrollDown(0, 1000);
        baseFunc.pause(3000);
        baseFunc.waitForElementToBeClickable(FILTER_BRAND);
        baseFunc.getElement(FILTER_BRAND).click();
    }

    public void itemTypeCheck() {
        List<WebElement> shoesType = baseFunc.getElements(ITEMS_ON_PAGE);
        for (WebElement we : shoesType) {
            assertTrue("Only Nike items are here", we.getText().contains("NIKE"));

        }
    }

    public void itemsOnSaleCheck() {
        List<WebElement> itemsOnSale = baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT);
        for (WebElement we : itemsOnSale) {
            assertTrue("Items are on SALE", we.getText().contains("%"));

        }
//            if (we.getText().contains("%")) {
//                continue;
//            } else {
//                System.out.println("Not all of the NIKE shoes are for sale");
//            }
//            break;
//        }
//        System.out.println("All of the NIKE shoes are for sale");
    }

    public void FileWriter() throws IOException {
//        use try - catch
        File file = new File("");
        FileWriter fw = new FileWriter(file);
        List<WebElement> fileText = baseFunc.getElements(ITEMS_ON_PAGE);
        for (WebElement we : fileText) {
            fw.write(String.valueOf(we));
        }
    }
}
