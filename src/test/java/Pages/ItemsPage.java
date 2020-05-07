package Pages;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ItemsPage {
    BaseFunc baseFunc;

    private final By SORT_MENU = By.xpath(".//div[@class = 'spodb-filter__select']");
    private final By SORT_MENU_FILTER = By.xpath(".//div[@class = 'spodb-filter__select']/select/option");
    private final By FILTERS_GENDER_CATEGORY_BRAND = By.xpath(".//div[@class = 'spodb-filter']/fieldset/ol/li/label");
    private final By ITEMS_ON_PAGE = By.xpath(".//p[@class = 'spodb-product-card__title']");
    private final By ITEMS_ON_PAGE_DISCOUNT = By.xpath(".//p[@class = 'spodb-product-card__percentage']");
    private final String FOOTBALL = "football";
    private final By PIDR = By.xpath(".//label[@for = '85']");

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
        return this;

    }

    public ItemsPage selectItemCategoryFilter(String categoryName) {
        baseFunc.waitJsExecution();
        baseFunc.waitForElementToBeClickable(FILTERS_GENDER_CATEGORY_BRAND);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(FILTERS_GENDER_CATEGORY_BRAND), categoryName);
        return this;
    }

    public ItemsPage selectItemBrandFilter(String brandName) {
        baseFunc.scrollDownBy(0, 200);
        baseFunc.findElementInListByNameAndClick(baseFunc.getElements(FILTERS_GENDER_CATEGORY_BRAND), brandName);
        return this;
    }

    public ItemsPage checkItemType(String type) {
        baseFunc.waitForJs();
        baseFunc.waitForPageLoadComplete();
        baseFunc.getElements(ITEMS_ON_PAGE)
                .forEach(webElement -> Assert.assertTrue("Not only Nike items are here",
                        webElement.getText().toLowerCase().contains(type)));
        return this;
    }

    public ItemsPage checkItemsOnSale(String name) {
        baseFunc.getElements(ITEMS_ON_PAGE_DISCOUNT).forEach(webElement -> Assert.assertTrue("Not only Nike items are here",
                webElement.getText().toLowerCase().contains(name)));
        return this;
    }

    public ItemsPage writeTextFile(String filename) {
        List<WebElement> webElementsOnPage = baseFunc.getElements(ITEMS_ON_PAGE);
        try {
            FileWriter fileWriter = new FileWriter(new File(filename));
            for (WebElement info : webElementsOnPage) {
                fileWriter.write(info.getText() + "\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ItemsPage writeJSONFile(String filename) {
        List<WebElement> webElementsOnPage = baseFunc.getElements(ITEMS_ON_PAGE);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        webElementsOnPage.stream()
                .map(WebElement::getText)
                .forEach(jsonArray::put);
        jsonObject.put("Items", jsonArray);
        try {
            FileWriter fileWriter = new FileWriter(new File(filename));
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
