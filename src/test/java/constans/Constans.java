package constans;

import org.openqa.selenium.By;

public class Constans {
    /**
     * @comment Elementler
     */
    public static final By LOGIN_USERMENU = By.cssSelector("[data-cy='header-user-menu']");
    public static final By LOGIN_BUTTON = By.cssSelector("[data-cy='header-login-button']");
    public static final By USER_NAME = By.id("L-UserNameField");
    public static final By PASSWORD = By.id("L-PasswordField");
    public static final By LOGIN_ENTER_BUTTON = By.id("gg-login-enter");
    public static final By SEARCH_AREA = By.cssSelector("[data-cy='header-search-input']");
    public static final By FIND_BUTTON = By.cssSelector("[data-cy='search-find-button']");
    public static final By NEXT = By.className("next-link");
    public static final By PRODUCT_LIST = By.className("product-hslider-container");
    public static final By PRICE = By.id("sp-price");
    public static final By ADD_TO_BASKET_BUTTON = By.id("add-to-basket");
    public static final By GOTO_BASKET_BUTTON = By.className("dIB");
    public static final By BASKET_PRICE = By.className("data-salePrice");
    public static final By SELECT_COUNT = By.className("gg-input-select");
    public static final By PRODUCT_COUNT = By.xpath("//*[@class='amount']");
    public static final By DUST_BIN = By.className("gg-icon-bin-medium");
    /**
     * @comment Stringler
     */
    public static String PAGE_TITLE = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
    public static String USER = "testiniumprojeodevi@gmail.com";
    public static String PW = "testiniumproje1";
    public static String PRODUCT = "bilgisayar";
    public static String SECOND_PAGE_URL = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
}
