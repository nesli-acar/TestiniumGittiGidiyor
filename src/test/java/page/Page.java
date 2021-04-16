package page;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static constans.Constans.*;
/**
 * @author Neslihan Acar
 * @version 1.0.0
 */
public class Page extends BasePage {
    public Page(WebDriver driver) {
        super(driver);

    }
    private static Logger logger = LogManager.getLogger(BasePage.class);
    /**
     * @comment Giriş yap butonuna hover olma methodu.
     */
    public Page hoverToUserMenu() {
        logger.info("Giriş yap butonuna hover olunuyor.");
        assertionPage(PAGE_TITLE);
        hoverElement(LOGIN_USERMENU);
        logger.info("Giriş yap butonuna başarıyla hover olundu.");
        return this;
    }
    /**
     * @comment Login olma methotudur.
     */
    public Page Login() {
        logger.info("Login olma işlemi yapılıyor.");
        click(LOGIN_BUTTON);
        sendKeys(USER_NAME,USER);
        sendKeys(PASSWORD,PW);
        click(LOGIN_ENTER_BUTTON);
        assertionPage(PAGE_TITLE);
        logger.info("Başarıyla Login olundu.");
        return this ;
    }
    /**
     * @comment Ürün arama methotudur.
     */
    public Page Search(){
        logger.info("Ürün Araması Yapılıyor");
        findElement(SEARCH_AREA);
        sendKeys(SEARCH_AREA,PRODUCT);
        click(FIND_BUTTON);
        logger.info("Arama başarıyla yapıldı ve "+ PRODUCT + " Ürünü aratıldı.");
        return this ;

    }
    /**
     * @comment Bir sonraki sayfaya gidildi.
     */
    public Page nextPage(){
        logger.info("İkinci sayfaya başarıyla gidiliyor.");
        scrollToElement(NEXT);
        click(NEXT);
        assertionUrl(SECOND_PAGE_URL);
        logger.info("İkinci sayfaya başarıyla gidildi ve kontrol edildi.");
        return this;
    }
    /**
     * @comment Rastgele ürün seçme methodu.
     */
    public Page randomClick(){
        logger.info("Rastgele ürün seçme işlemi başlıyor.");
        randomItemClick(PRODUCT_LIST);
        logger.info("Ürün başarıyla seçildi.");
        return this;
    }
    /**
     * @comment Ürünü sepete ekleme methodu.
     */
    public Page addBasket(){
        logger.info("Sepete Ekleme İşlemi Başlıyor.");
        double price = getPrice(PRICE);
        addToBasket(ADD_TO_BASKET_BUTTON);
        click(GOTO_BASKET_BUTTON);
        assertPrices(price,getPrice(BASKET_PRICE));
        logger.info("Sepete Başarıyla Eklendi ve Fiyat Kontrolü Yapıldı");
        return this;
    }
    /**
     * @comment Ürünü sepetteki sayısını artırma methodu.
     */
    public Page productCount(){
        logger.info("Ürün sayısı arttırılma işlemi başlıyor.");
        click(SELECT_COUNT);
        countProducts(PRODUCT_COUNT);
        logger.info("Ürün sayısı başarıyla arttırıldı.");
        return this;
    }
    /**
     * @comment Sepetteki ürünü silme methodu.
     */
    public Page deleteProduct(){
        logger.info("Sepetteki Ürün Siliniyor.");
        click(DUST_BIN);
        logger.info("Sepetteki Ürün Başarıyla Silindi.");
        return this;
    }


}