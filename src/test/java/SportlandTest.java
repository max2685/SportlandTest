import Pages.BaseFunc;
import Pages.HomePage;
import Pages.ItemsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static enums.SideMenuItems.PRODUKTI;
import static enums.GenderTab.ZENI;
import static enums.ItemsInGenderTab.FUTBOLS;
import static enums.SortMenuFilterItems.IZPARDOSANA;
import static enums.SortMenuFilterItems.FUTBOLA_APAVI_CIETAM_SEGUMAM;
import static enums.SortMenuFilterItems.NIKE;

public class SportlandTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(SportlandTest.class);
    private final String HOME_PAGE = "sportland.lv";
    private final String PROCENT_SIGN = "%";
    private final String FILE_TXT = "File.txt";

    @Test

    public void sportlandTest() {

        LOGGER.info("Open sportland home page");
        baseFunc.goToURL(HOME_PAGE);

        LOGGER.info("Open side menu");
        HomePage homePage = new HomePage(baseFunc);
        homePage.openSideMenu();

        LOGGER.info("Click on " + PRODUKTI + "tab, select " + ZENI + "in the gender tab, select "
                + FUTBOLS + "item");

        ItemsPage itemsPage = homePage.selectItemFromSideMenu(PRODUKTI)
                .getProductPage()
                .clickOnGenderTab(String.valueOf(ZENI))
                .selectProductInSubMenu(2, String.valueOf(FUTBOLS))
                .getItemsPage();

        LOGGER.info("Open sort menu, click on " + IZPARDOSANA + " filter, click on " + FUTBOLA_APAVI_CIETAM_SEGUMAM +
                "filter and click on " + NIKE + "filter");

        itemsPage.openSortMenu()
                .clickOnFilterByName(String.valueOf(IZPARDOSANA))
                .selectItemCategoryFilter(String.valueOf(FUTBOLA_APAVI_CIETAM_SEGUMAM))
                .selectItemBrandFilter(String.valueOf(NIKE));

        LOGGER.info("Check if every item's brand is " + NIKE + ", if every item is on discount and has "
                + PROCENT_SIGN + "and write " + FILE_TXT);

        itemsPage.checkItemType(String.valueOf(NIKE))
                .checkItemsOnSale(PROCENT_SIGN)
                .writeTextFile(FILE_TXT);

        LOGGER.info("Close browser");
        baseFunc.driverQuit();
    }
}