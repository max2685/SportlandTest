package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ApaviPage {
    BaseFunc baseFunc;

    private final By SORT_MENU = By.xpath(".//div[@class = 'spodb-filter__select']");
    private final By SORT_MENU_IZPARDOSANA = By.xpath(".//option[@value = 'offer']");
    private final By FILTER_FUTBOLA_APAVI_VIETAM_SEGUMAM = By.xpath(".//label[@for = 'firm-ground-football-boots']");
    private final By FILTER_NIKE = By.xpath(".//label[@for = '85']");
    private final By NIKE_SHOES = By.xpath(".//p[@class = 'spodb-product-card__title']");
    private final By NIKE_SHOES_SALE = By.xpath(".//p[@class = 'spodb-product-card__percentage']");

    public ApaviPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void OpenSortMenu() {
        baseFunc.waitForElement(SORT_MENU);
        baseFunc.getElement(SORT_MENU).click();
    }

    public void clickOnIzpardosana() {
        baseFunc.waitForElement(SORT_MENU_IZPARDOSANA);
        baseFunc.getElement(SORT_MENU_IZPARDOSANA).click();
    }

    public void selectFilters() {
        baseFunc.getElement(FILTER_FUTBOLA_APAVI_VIETAM_SEGUMAM).click();
        baseFunc.scrollDown(0, 1000);
        baseFunc.pause(3000);
        baseFunc.waitForElementToBeClickable(FILTER_NIKE);
        baseFunc.getElement(FILTER_NIKE).click();
    }

    public void checkThatOnlyNikeShoesAppeared() {
        List<WebElement> nikeShoes = baseFunc.getElements(NIKE_SHOES);
        for (WebElement we : nikeShoes) {
            if (we.getText().contains("NIKE")) {
                continue;
            } else {
                System.out.println("Not only NIKE shoes are on the page, filters are not working");
                break;
            }
        }
        System.out.println("Only NIKE shoes are on the page");
    }

    public void checkThatNikeItemsAreOnSale() {
        List<WebElement> nikeShoesProcent = baseFunc.getElements(NIKE_SHOES_SALE);
        for (WebElement we : nikeShoesProcent) {
            if (we.getText().contains("%")) {
                continue;
            } else {
                System.out.println("Not all of the NIKE shoes are for sale");
                break;
            }
        }
        System.out.println("All of the NIKE shoes are for sale");
    }

    public void FileWriter() throws IOException {
        File file = new File("");
        FileWriter fw = new FileWriter(file);
        List<WebElement> fileText = baseFunc.getElements(NIKE_SHOES);
        for (WebElement we : fileText) {
            fw.write(String.valueOf(we));
        }
    }
}
