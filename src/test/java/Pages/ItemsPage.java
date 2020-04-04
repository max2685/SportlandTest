package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ItemsPage {
    BaseFunc baseFunc;

    private final By SORT_MENU = By.xpath(".//div[@class = 'spodb-filter__select']");
    private final By SORT_MENU_ITEM = By.xpath(".//option[@value = 'offer']");
    private final By FILTER_CATEGORY = By.xpath(".//label[@for = 'firm-ground-football-boots']");
    private final By FILTER_BRAND = By.xpath(".//label[@for = '85']");
    private final By ITEMS_ON_PAGE = By.xpath(".//p[@class = 'spodb-product-card__title']");
    private final By ITEMS_ON_PAGE_DISCOUNT = By.xpath(".//p[@class = 'spodb-product-card__percentage']");

    public ItemsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck("football");

    }

    public void openSortMenu() {
        baseFunc.waitForElementToBeClickable(SORT_MENU);
        baseFunc.getElement(SORT_MENU).click();
    }

    public void clickOnFilter() {
        baseFunc.waitForElementToBeClickable(SORT_MENU_ITEM);
        baseFunc.getElement(SORT_MENU_ITEM).click();


    }

    public void selectFilters() {
        baseFunc.waitForPageLoad();
        baseFunc.getElement(FILTER_CATEGORY).click();
        baseFunc.waitForPageLoad();
        baseFunc.scrollDown(0, 600);
        baseFunc.waitForPageLoad();
        baseFunc.waitForElementToBeClickable(FILTER_BRAND);
        baseFunc.getElement(FILTER_BRAND).click();
    }

    public void itemTypeCheck() {
        List<WebElement> shoesType = baseFunc.getElements(ITEMS_ON_PAGE);
        for (WebElement we : shoesType) {
            if (we.getText().contains("NIKE")) {
                continue;
            } else {
                break;
            }
        }
    }
    //            assertTrue("Only Nike items are here", we.getText().contains("nike"));


    public void itemsOnSaleCheck() {
        List<WebElement> itemsOnSale = baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT);
        for (WebElement we : itemsOnSale) {
            if (we.getText().contains("%")) {
                continue;
            } else {
                break;
            }
        }
//        assertTrue("Items are on SALE", we.getText().contains("%"));
    }

    public void writeFile(String filename) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(filename)) {
            List<WebElement> fileText = baseFunc.getElements(ITEMS_ON_PAGE);
            baseFunc.waitForPageLoad();
            for (WebElement we : fileText) {
                we.getText();
                writer.write(we + "\n");
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            System.err.print("Something went wrong");
        }
    }
}
