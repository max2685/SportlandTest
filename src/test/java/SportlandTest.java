import Pages.BaseFunc;
import Pages.HomePage;
import Pages.ItemsPage;
import enums.SideMenuItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;

import static enums.SideMenuItems.PRODUKTI;

public class SportlandTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(SportlandTest.class);
    private final String HOME_PAGE = "sportland.lv";
    private final String MAN = "zēni";
    private final String SHOES_FOR_FOOTBALL = "futbols";
    private final String FILTER_IZPARDOSANA = "izpārdošana";
    private final String FILTER_CATEGORY = "futbola apavi cietam segumam";
    private final String FILTER_BRAND = "nike";
    private final String PROCENT_SIGN = "%";
    private final String FILE_TXT = "File.txt";

    @Test

    public void sportlandTest() {

        LOGGER.info("Open sportland home page");
        baseFunc.goToURL(HOME_PAGE);

        LOGGER.info("Open side menu");
        HomePage homePage = new HomePage(baseFunc);
        homePage.openSideMenu();

        LOGGER.info("Click on " + PRODUKTI + "tab, select 'Football products', click on " + MAN + "tab, select "
                + SHOES_FOR_FOOTBALL + "items, click on Sort Filter dropdown, select "
                + FILTER_IZPARDOSANA + "filter, after select other filters, ckeck if all items manufacturer is "
                + FILTER_BRAND + ", and if all items have " + PROCENT_SIGN + " sign and write files");
        // fix this logger to be more readable

        ItemsPage itemsPage = homePage.selectItemFromSideMenu(PRODUKTI)
                .getProductPage()
                .clickOnGenderTab(MAN)
                .clickOnFootballShoesItem(SHOES_FOR_FOOTBALL)
                .getItemsPage();

        LOGGER.info("!!! complete !!!");
        itemsPage.openSortMenu()
                .clickOnFilterByName(FILTER_IZPARDOSANA)
                .selectItemCategoryFilter(FILTER_CATEGORY)
                .selectItemBrandFilter(FILTER_BRAND);

        LOGGER.info("Check bla bla");
        itemsPage.checkItemType(FILTER_BRAND)
                .checkItemsOnSale(PROCENT_SIGN)
                .writeTextFile(FILE_TXT);

        LOGGER.info("Close browser");
        baseFunc.driverQuit();
    }
}