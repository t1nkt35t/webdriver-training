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
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void test7() {

        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//form[@name=\"login_form\"]//a[contains(text(), \"New customers click here\")]")).click();
        driver.findElement(By.xpath("//input[@name = \"firstname\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name = \"lastname\"]")).sendKeys("Testov");
        driver.findElement(By.xpath("//input[@name = \"address1\"]")).sendKeys("prospekt mira, 10-1");
        driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("53312");
        driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("Moscow");

        Select dropdownCountry = new Select(driver.findElement(By.name("country_code")));
        dropdownCountry.selectByVisibleText("United States");
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//select[@name='zone_code']"))).click().perform();
        String email = Tools.timeStamp("yyyy.MM.dd.HH.mm.ss") + "@test.ru";
        driver.findElement(By.xpath("//select[@name='zone_code']/option[@value='AK']")).click();
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys( Tools.timeStamp("yyyy.MM.dd.HH.mm.ss") + "@test.ru" );
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("+78754334332");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("qwe123");
        driver.findElement(By.xpath("//input[@name=\"confirmed_password\"]")).sendKeys("qwe123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        driver.findElement(By.xpath("//div[@id='box-account']//li/a[contains(text(), 'Logout')]" )).click();
        driver.findElement(By.xpath("//div[@id='box-account-login']//td//input[@name='email']" )).sendKeys( email );
        driver.findElement(By.xpath("//div[@id='box-account-login']//td//input[@name='password']" )).sendKeys( "qwe123" );
        driver.findElement(By.xpath("//div[@id='box-account-login']//span[@class='button-set']/button[@name='login']" )).click();
        driver.findElement(By.xpath("//div[@id='box-account']//li/a[contains(text(), 'Logout')]" )).click();

    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}