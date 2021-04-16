package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

/**
 * @author Neslihan Acar
 * @version 1.0.0
 */
public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }
    private static Logger logger = LogManager.getLogger(BasePage.class);
    /**
     * @comment Driver'ın title'ını alıp verdiğimiz text ile karşılaştıran method
     */
    public void assertionPage(String text) {
        logger.info("Title ile sayfa doğrulama işlemi başladı.");
        Assert.assertEquals(text, driver.getTitle());
        logger.info("Title ile sayfa doğrulama işlemi başarıyla bitti.");
    }
    /**
     * @comment Driver'ın url'ini alıp verdiğimiz url text'i ile karşılaştıran method
     */
    public void assertionUrl(String text) {
        logger.info("Title ile sayfa doğrulama işlemi başladı.");
        Assert.assertEquals(text, driver.getCurrentUrl());
        logger.info("Title ile sayfa doğrulama işlemi başarıyla bitti.");
    }

    public void assertPrices(double by, double br) {
        logger.info("Değer karşılaştırılması başladı.");
        Assert.assertEquals(by, br, 0.001);
        logger.info("Değer karşılaştırılması başarıyla bitti.");
    }
    /**
     * @comment Tüm elementler var olana kadar, dinamik olarak bekledikten sonra element bulunur.
     */
    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }
    /**
     * @comment Tüm elementler var olana kadar, dinamik olarak bekledikten sonra elementler bulunur.
     */
    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
    /**
     * @comment Element bulunduktan sonra elemente yazı yazdırma methodudur.
     */
    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
        logger.info("Yazı alanına "+ text + " yazısı yazıldı.");
    }
    /**
     * @comment Element tıklanabilir olduktan sonra elemente tıklayan methodtur.
     */
    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();

    }
    /**
     * @comment Elementin üzerine mouse ile gidip bekleme komutudur.
     */
    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    /**
     * @comment Element bulunana kadar sayfayı kaydırma methotudur.
     */
    public void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));

    }
    /**
     * @comment Bulunan element listesinden random bir elementi tıklama methotudur.
     */
    public void randomItemClick(By by) {
        Random rand = new Random();
        findElements(by).get(rand.nextInt(findElements(by).size())).click();
    }
    /**
     * @comment Elementin fiyat bilgisi value özelliği ile çekildi.
     */
    public double getPrice(By by) {
        return Double.parseDouble(findElement(by).getAttribute("value"));
    }
    /**
     * @comment Ürünü sepete ekleyen method.
     */
    public void addToBasket(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
        click(by);
    }
    /**
     * @comment Seçilen ürünün sayısı 2 yapıldı.
     */
    public void countProducts(By by) {
        Select two = new Select(findElement(by));
        two.selectByIndex(1);
        click(by);
    }


}
