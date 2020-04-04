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

    public void openSortMenu() {
        baseFunc.waitForElementToBeClickable(SORT_MENU);
        baseFunc.getElement(SORT_MENU).click();
    }

    public void clickOnFilter() {
        baseFunc.waitForElementToBeClickable(SORT_MENU_ITEM);
        baseFunc.getElement(SORT_MENU_ITEM).click();


    }

    //specify method name
    public void selectFilters() {
        baseFunc.waitForJs();
        baseFunc.getElement(FILTER_CATEGORY).click();
        baseFunc.waitForJs();
        baseFunc.scrollDown(0, 600);
        baseFunc.waitForJs();
        baseFunc.waitForElementToBeClickable(FILTER_BRAND);
        baseFunc.getElement(FILTER_BRAND).click();
    }

    //can be reused. Please improve
    public void itemTypeCheck() {
        baseFunc.waitForJs();
        List<WebElement> shoesType = baseFunc.getElements(ITEMS_ON_PAGE);
        for (WebElement we : shoesType) {
            assertTrue("Not only Nike items are here", we.getText().contains("NIKE"));
        }

//        for (WebElement we : shoesType) {
//            if (we.getText().contains("NIKE")) {
//                continue;
//            } else {
//                break;
//            }
//        }
    }
    //            assertTrue("Not only Nike items are here", we.getText().contains("nike"));


    public void itemsOnSaleCheck() {
        List<WebElement> itemsOnSale = baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT);

        for (WebElement we : itemsOnSale) {
            if (we.getText().contains("%")) {
                continue;
            } else {
                break;
            }
        }
//        assertTrue("Items are not on SALE", we.getText().contains("%"));

    }

    public void writeFile(String filename) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(filename)) {
            String nameOfString;
            List<WebElement> webElementsOnPage = baseFunc.getElements(ITEMS_ON_PAGE);
//            baseFunc.waitForJs();
//            List<String> elementsOnPage = webElementsOnPage
//                    .stream()
//                    .map(WebElement::getText)
//                    .collect(Collectors.toList());
//            writer.write(String.valueOf(elementsOnPage));

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
    }
}
