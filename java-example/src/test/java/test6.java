import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.Collator;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Verify.verify;

public class test6 {
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
    public void test6() {
        driver.get("http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");
        String regularStrike = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("text-decoration-line");
        String regularColor = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("color");
        System.out.println(regularColor);
        System.out.println(regularStrike);
    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}
