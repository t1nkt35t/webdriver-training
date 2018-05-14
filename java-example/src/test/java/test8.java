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

import java.util.concurrent.TimeUnit;

public class test8 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void test8() {

        driver.findElement(By.xpath("//td[@id='sidebar']//a//span[contains(text(), 'Catalog')]")).click();
        driver.findElement(By.xpath("//td[@id='content']//a[contains(text(), ' Add New Product')]")).click();
        driver.findElement(By.xpath("//div[@id='tab-general']//label[contains(text(), ' Enabled')]")).click();
        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB + "Good" + Keys.TAB + "777").perform();
        driver.findElement(By.xpath("//tr/td[contains(text(),'Male')]/preceding-sibling::td/input")).click();
        driver.findElement(By.xpath("//div[@id='tab-general']//table//input[@name='quantity']")).clear();
        act.sendKeys("20").perform();
        driver.findElement(By.xpath("//div[@id='tab-general']//table//input[@type='file']")).sendKeys(System.getProperty("user.dir") + "\\Beer-500x592.png");
        act.sendKeys(Keys.TAB + "Good" + Keys.TAB + "777").perform();
        driver.findElement(By.xpath("//div[@id='tab-general']//input[@name='date_valid_from']")).sendKeys("11052018");
        driver.findElement(By.xpath("//div[@id='tab-general']//input[@name='date_valid_to']")).sendKeys("11052019");
        driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), 'Information')]")).click();
//        act.sendKeys(Keys.TAB  + "11052018" + Keys.TAB + "11062019").perform();
//        driver.findElement(By.xpath("//input[@name = \"firstname\"]")).sendKeys("Test" +
//                Keys.TAB + "Testov" + Keys.TAB + "prospekt mira, 10-1" + Keys.TAB + Keys.TAB + 53312 +
//                Keys.TAB + "Moscow");
//
//        Select dropdownCountry = new Select(driver.findElement(By.name("country_code")));
//        dropdownCountry.selectByVisibleText("United States");
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//select[@name='zone_code']"))).click().perform();
//        String email = "kel13@yaz.ru";
//        driver.findElement(By.xpath("//select[@name='zone_code']/option[@value='AK']")).click();
//        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys( email +
//                Keys.TAB + "+78754334332" + Keys.TAB + Keys.SPACE + Keys.TAB + "qwe123" + Keys.TAB +
//                "qwe123" + Keys.TAB + Keys.ENTER);
//
//        driver.findElement(By.xpath("//div[@id='box-account']//li/a[contains(text(), 'Logout')]" )).click();
//        driver.findElement(By.xpath("//div[@id='box-account-login']//td//input[@name='email']" )).sendKeys( email );
//        driver.findElement(By.xpath("//div[@id='box-account-login']//td//input[@name='password']" )).sendKeys( "qwe123" );
//        driver.findElement(By.xpath("//div[@id='box-account-login']//span[@class='button-set']/button[@name='login']" )).click();
//        driver.findElement(By.xpath("//div[@id='box-account']//li/a[contains(text(), 'Logout')]" )).click();

    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}