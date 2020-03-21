import Pages.BaseFunc;
import Pages.HomePage;
import Pages.ProductPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

public class SportlandTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(SportlandTest.class);
    private final String HOME_PAGE ="sportland.lv";

    @Test
    public void SportlandItemTest() {
        baseFunc.goToURL(HOME_PAGE);

        HomePage homePage = new HomePage(baseFunc);
        homePage.openSideMenu();
        homePage.sideMenuItem("PRODUKTI");

        ProductPage productPage = new ProductPage(baseFunc);
        productPage.ZeniDropDown();
        productPage.ClickOnFutbols();
    }
}
