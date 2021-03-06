import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestFour {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void TestFour() {
        driver.get("http://localhost/litecart/");
        List<WebElement> stickers = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        List<WebElement> products = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']//div[starts-with(@class,\"sticker\")]"));
        assert(stickers.size() == products.size());
    }

    @After
    public void stop() {
        driver.quit();
        driver= null;
    }
}

