import Pages.BaseFunc;
import Pages.HomePage;
import Pages.ItemsPage;
import Pages.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SportlandTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(SportlandTest.class);
    private final String HOME_PAGE = "sportland.lv";
    private final String PRODUKTI = "PRODUKTI";

    @Test

    public void sportlandTest() {

        baseFunc.goToURL(HOME_PAGE);

        //logger before method

        HomePage homePage = new HomePage(baseFunc);
        LOGGER.info("We are on home page");
        homePage.openSideMenu();
        LOGGER.info("We are opening side menu");

        LOGGER.info("Click on " + PRODUKTI + "tab and select 'Football products'");
        ProductPage productPage = homePage.sideMenuItem(PRODUKTI)
                .getProductPage()
                .clickOnZeniTab()
                .clickOnFootballItem();

        ItemsPage itemsPage = new ItemsPage(baseFunc);
        LOGGER.info("We are on items page");
        itemsPage.openSortMenu();
        LOGGER.info("We are opening sort menu");
        itemsPage.clickOnFilter();
        LOGGER.info("We are clicking on Izpardosana");
        itemsPage.selectFilters();
        LOGGER.info("We are selecting filters");
        itemsPage.itemTypeCheck();
        LOGGER.info("We are checking if all item are Nike");
        itemsPage.itemsOnSaleCheck();
        LOGGER.info("We are checking if all items are on sale");

        try {
            itemsPage.writeFile("File.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.info("We are writing a file");

        baseFunc.driverQuit();

    }
}
//