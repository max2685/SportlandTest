import Pages.BaseFunc;
import Pages.HomePage;
import Pages.ItemsPage;
import Pages.ProductPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SportlandTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(SportlandTest.class);
    private final String HOME_PAGE ="sportland.lv";

    @Test

    public void sportlandTest() {

        baseFunc.goToURL(HOME_PAGE);

        HomePage homePage = new HomePage(baseFunc);
        homePage.openSideMenu();
        homePage.sideMenuItem("PRODUKTI");

        ProductPage productPage = new ProductPage(baseFunc);
        productPage.dropDownMenu();
        productPage.clickOnItem();

        ItemsPage itemsPage = new ItemsPage(baseFunc);
        itemsPage.openSortMenu();
        itemsPage.clickOnFilter();
        itemsPage.selectFilters();
        itemsPage.itemTypeCheck();
        itemsPage.itemsOnSaleCheck();
        try {
            itemsPage.writeFile("File.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        baseFunc.driverQuit();

    }
}
