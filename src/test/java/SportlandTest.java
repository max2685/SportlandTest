import Pages.BaseFunc;
import Pages.HomePage;
import Pages.ItemsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SportlandTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(SportlandTest.class);
    private final String HOME_PAGE = "sportland.lv";
    private final String PRODUKTI = "produkti";
    private final String MAN = "zēni";
    private final String SHOES_FOR_FOOTBALL = "futbols";
    private final String FILTER_IZPARDOSANA = "izpārdošana";
    private final String FILTER_CATEGORY = "futbola apavi cietam segumam";
    private final String FILTER_BRAND = "nike";
    private final String PROCENT_SIGN = "%";

    @Test

    public void sportlandTest() throws FileNotFoundException {

        baseFunc.goToURL(HOME_PAGE);

        LOGGER.info("We are on home page");
        HomePage homePage = new HomePage(baseFunc);
        LOGGER.info("We are opening side menu");
        homePage.openSideMenu();

        LOGGER.info("Click on " + PRODUKTI + "tab, select 'Football products', click on " + MAN + "tab, select "
                + SHOES_FOR_FOOTBALL + "items, click on Sort Filter dropdown, select "
                + FILTER_IZPARDOSANA + "filter, after select other filters, ckeck if all items manufacturer is "
                + FILTER_BRAND + ", and if all items have " + PROCENT_SIGN + " sign and write files");

        ItemsPage itemsPage = homePage.sideMenuItem(PRODUKTI)
                .getProductPage()
                .clickOnZeniTab(MAN)
                .clickOnFootballShoesItem(SHOES_FOR_FOOTBALL)
                .getItemsPage()
                .openSortMenu()
                .clickOnFilterIzpardosana(FILTER_IZPARDOSANA)
                .selectItemCategoryFilter(FILTER_CATEGORY)
                .selectItemBrandFilter(FILTER_BRAND)
                .itemsTypeCheck(FILTER_BRAND)
                .itemsOnSaleCheck(PROCENT_SIGN)
                .writeFile("File.txt");

        baseFunc.driverQuit();

    }
}