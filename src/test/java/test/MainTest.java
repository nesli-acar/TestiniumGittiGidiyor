package test;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.Page;
/**
 * @author Neslihan Acar
 * @version 1.0.0
 */
public class MainTest extends BaseTest {
    page.Page Page;
    private static Logger logger = LogManager.getLogger(MainTest.class);

    @Before
    public void before() {
        logger.info("ChromeDriver ayağa kaldırılma işlemi başladı.");
        Page = new Page(getWebDriver());
        logger.info("ChromeDriver başarıyla ayağa kaldırıldı.");
    }

    @Test
    public void testLogin() throws InterruptedException {
        logger.info("Test Senaryosu Başlıyor.");
        Page.hoverToUserMenu().Login().Search().nextPage().randomClick().addBasket().productCount().deleteProduct();
        logger.info("Test Senaryosu Başarıyla Bitti.");
    }

    @After
    public void after() throws InterruptedException {
        logger.info("ChromeDriver Kapatılıyor");
        tearDown();
    }
}