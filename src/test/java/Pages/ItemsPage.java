package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ItemsPage {
    BaseFunc baseFunc;

    private final By SORT_MENU = By.xpath(".//div[@class = 'spodb-filter__select']");
    private final By SORT_MENU_FILTER = By.xpath(".//div[@class = 'spodb-filter__select']/select/option");
    private final By FILTERS_GENDER_CATEGORY_BRAND = By.xpath(".//div[@class = 'spodb-filter']/fieldset/ol/li");
    private final By ITEMS_ON_PAGE = By.xpath(".//p[@class = 'spodb-product-card__title']");
    private final By ITEMS_ON_PAGE_DISCOUNT = By.xpath(".//p[@class = 'spodb-product-card__percentage']");
    private final String FOOTBALL = "football";

    public ItemsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.pageSourceCheck(FOOTBALL);
    }

    public ItemsPage openSortMenu() {
        baseFunc.waitForElementToBeClickable(SORT_MENU);
        baseFunc.getElement(SORT_MENU).click();
        return this;
    }

    public ItemsPage clickOnFilterByName(String name) {
        baseFunc.waitForElement(SORT_MENU_FILTER);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(SORT_MENU_FILTER), name);
        baseFunc.waitForJs();
        return this;
    }

    public ItemsPage selectItemCategoryFilter(String categoryName) {
        baseFunc.waitForJs();
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(FILTERS_GENDER_CATEGORY_BRAND), categoryName);
        return this;
    }

    public ItemsPage selectItemBrandFilter(String brandName) {
        baseFunc.waitForJs();
        baseFunc.scrollDownBy(0, 800);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(FILTERS_GENDER_CATEGORY_BRAND), brandName);
        return this;
        //TUT ON PADAET
    }

    public ItemsPage checkItemType(String name) {
        // .stream
        baseFunc.waitForJs();
        baseFunc.getElements(ITEMS_ON_PAGE).forEach((webElement) -> {
                    Assert.assertTrue("Not only Nike items are here", webElement.getText().contains(name));
                });

        //KAK

//        for (WebElement we : shoesType) {
//            Assert.assertTrue("Not only Nike items are here", we.getText().toLowerCase().contains(name));
//        }
        return this;
    }

    public ItemsPage checkItemsOnSale(String name) {
        // .stream
        baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT).forEach((webElement) -> {
                    Assert.assertTrue("Not only Nike items are here", webElement.getText().contains(name));
                });

//        for (WebElement we : itemsOnSale) {
//            Assert.assertTrue("Not all of the items are on sale", we.getText().toLowerCase().contains(name));
//        }
        return this;
    }

    public ItemsPage writeTextFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            String nameOfString;
            List<WebElement> webElementsOnPage = baseFunc.getElements(ITEMS_ON_PAGE);

            webElementsOnPage
                    .stream()
                    .filter(we -> Boolean.parseBoolean(we.getText()))
                    .forEach(we -> writeTextFile(filename));

//
//            for (int i = 0; i < webElementsOnPage.size(); i++) {
//                nameOfString = webElementsOnPage.get(i).getText();
//                nameOfString = nameOfString + "\n";
//                writer.write(nameOfString);
//            }

        } catch (FileNotFoundException e) {
            try {
                throw e;
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
