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
    private final String PRODUKTI = "PRODUKTI";
    private final String MAN = "zēni";
    private final String SHOES_FOR_FOOTBALL = "futbols";
    private final String FILTER_IZPARDOSANA = "izpārdošana";

    @Test

    public void sportlandTest() throws FileNotFoundException {

        baseFunc.goToURL(HOME_PAGE);

        //logger before method

        HomePage homePage = new HomePage(baseFunc);
        LOGGER.info("We are on home page");
        homePage.openSideMenu();
        LOGGER.info("We are opening side menu");

        LOGGER.info("Click on " + PRODUKTI + "tab, select 'Football products', click on " + MAN + "tab, select "
                + SHOES_FOR_FOOTBALL + "items, click on Sort Filter dropdown, select "
                + FILTER_IZPARDOSANA + "filter, after select other filters, assert results and write files");

        ItemsPage itemsPage = homePage.sideMenuItem(PRODUKTI)
                .getProductPage()
                .clickOnZeniTab(MAN)
                .clickOnFootballShoesItem(SHOES_FOR_FOOTBALL)
                .getItemsPage()
                .openSortMenu()
                .clickOnFilterIzpardosana(FILTER_IZPARDOSANA)
                .selectItemSortFilters()
                .itemsTypeCheck()
                .itemsOnSaleCheck()
                .writeFile("File.txt");

        baseFunc.driverQuit();

    }
}