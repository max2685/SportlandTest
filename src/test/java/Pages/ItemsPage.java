package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

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

    public ItemsPage openSortMenu() {
        baseFunc.waitForElementToBeClickable(SORT_MENU);
        baseFunc.getElement(SORT_MENU).click();
        return this;
    }

    public ItemsPage clickOnFilterIzpardosana() {
        baseFunc.waitForElementToBeClickable(SORT_MENU_ITEM);
        baseFunc.getElement(SORT_MENU_ITEM).click();
        return this;
    }

    //specify method name
    public ItemsPage selectFilters() {
        baseFunc.waitForJs();
        baseFunc.getElement(FILTER_CATEGORY).click();
        baseFunc.waitForJs();
        baseFunc.scrollDown(0, 600);
        baseFunc.waitForJs();
        baseFunc.waitForElementToBeClickable(FILTER_BRAND);
        baseFunc.getElement(FILTER_BRAND).click();
        return this;
    }

    //can be reused. Please improve
    public ItemsPage itemsTypeCheck() {
        baseFunc.waitForJs();
        List<WebElement> shoesType = baseFunc.getElements(ITEMS_ON_PAGE);
        for (WebElement we : shoesType) {
            assertTrue("Not only Nike items are here", we.getText().contains("NIKE"));
        }
        return this;
    }

    public ItemsPage itemsOnSaleCheck() {
        List<WebElement> itemsOnSale = baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT);
        for (WebElement we : itemsOnSale) {
            assertTrue("Not all of the items are on sale", we.getText().contains("%"));
        }
        return this;
    }

    public ItemsPage writeFile(String filename) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(filename)) {
            String nameOfString;
            List<WebElement> webElementsOnPage = baseFunc.getElements(ITEMS_ON_PAGE);
//            baseFunc.waitForJs();
//            List<String> elementsOnPage = webElementsOnPage
//                    .stream()
//                    .map(WebElement::getText)
//                    .collect(Collectors.toList());
//            writer.write(String.valueOf(elementsOnPage)); ?????

            for (int i = 0; i < webElementsOnPage.size(); i++) {
                nameOfString = webElementsOnPage.get(i).getText();
                nameOfString = nameOfString + "\n";
                writer.write(nameOfString);
            }

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
