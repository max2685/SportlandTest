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
    private final By SORT_MENU_FILTER_IZPARDOSANA = By.xpath(".//div[@class = 'spodb-filter__select']/select/option");
    private final By FILTERS_GENDER_CATEGORY_BRAND = By.xpath(".//fieldset[@class = 'accordion']/ol/li");
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

    public ItemsPage clickOnFilterIzpardosana(String name) {
        baseFunc.waitForElement(SORT_MENU_FILTER_IZPARDOSANA);
        List<WebElement> dropDownMenuItems = baseFunc.getElements(SORT_MENU_FILTER_IZPARDOSANA);
        baseFunc.findElementInListAndClick(dropDownMenuItems, name);
        return this;
    }

    public ItemsPage selectItemCategoryFilter(String categoryName) {
        baseFunc.waitForJs();
        baseFunc.waitForElement(FILTERS_GENDER_CATEGORY_BRAND);
        List<WebElement> filters = baseFunc.getElements(FILTERS_GENDER_CATEGORY_BRAND);
        baseFunc.findElementInListAndClick(filters, categoryName);
        return this;
    }

    public ItemsPage selectItemBrandFilter(String brandName) {
        baseFunc.waitForJs();
        baseFunc.scrollDown(0, 600);
        baseFunc.waitForElement(FILTERS_GENDER_CATEGORY_BRAND);
        List<WebElement> filters = baseFunc.getElements(FILTERS_GENDER_CATEGORY_BRAND);
        baseFunc.findElementInListAndClick(filters, brandName);
        return this;
    }

    public ItemsPage itemsTypeCheck(String name) {
        baseFunc.waitForJs();
        List<WebElement> shoesType = baseFunc.getElements(ITEMS_ON_PAGE);
        for (WebElement we : shoesType) {
            assertTrue("Not only Nike items are here", we.getText().toLowerCase().contains(name));
        }
        return this;
    }

    public ItemsPage itemsOnSaleCheck(String name) {
        List<WebElement> itemsOnSale = baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT);
        for (WebElement we : itemsOnSale) {
            assertTrue("Not all of the items are on sale", we.getText().toLowerCase().contains(name));
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
        return this;
    }
}
