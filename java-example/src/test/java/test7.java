import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Verify.verify;

public class test7 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void test7() {

        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//form[@name=\"login_form\"]//a[contains(text(), \"New customers click here\")]")).click();
        driver.findElement(By.xpath("//input[@name = \"firstname\"]")).sendKeys("Test" +
                Keys.TAB + "Testov" + Keys.TAB + "prospekt mira, 10-1" + Keys.TAB + Keys.TAB + 53312 + Keys.TAB + "Moscow");
        Select dropdownCountry = new Select(driver.findElement(By.name("country_code")));
        dropdownCountry.selectByVisibleText("United States");
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//select[@name='zone_code']"))).click().perform();
        driver.findElement(By.xpath("//select[@name='zone_code']/option[@value='AK']")).click();
        Select dropdownState = new Select(driver.findElement(By.name("country_code")));
//        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("lil@yaz.ru" +
//                Keys.TAB + "+78754334332" + Keys.TAB + Keys.SPACE + Keys.TAB + "qwe123" + Keys.TAB +
//                "qwe123" + Keys.TAB + Keys.ENTER);
    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}