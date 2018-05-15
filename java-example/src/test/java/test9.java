import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void test8() {

        driver.get("http://localhost/litecart/");
        for (int i = 0; i<=2; i++) {
            driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@class=\"link\"]")).click();
            int count = Integer.valueOf(driver.findElement(By.xpath("//div[@id='cart']//span[@class='quantity']")).getText());
            if (!(ExpectedConditions.invisibilityOf(By.xpath("//select[@name='options[Size]']")) {

            }
            System.out.println(count);
            driver.findElement(By.xpath("//td[@class='quantity']//button[@name='add_cart_product']")).click();
            wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@id='cart']//span[@class='quantity']"), "textContent" ,String.valueOf(count + 1)));
            driver.findElement(By.xpath("//nav[@id='breadcrumbs']//a")).click();
        }
//        driver.findElement(By.xpath("//div[@id='tab-general']//input[@name='code']")).sendKeys("777");
//
//        driver.findElement(By.xpath("//tr/td[contains(text(),'Male')]/preceding-sibling::td/input")).click();
//        driver.findElement(By.xpath("//div[@id='tab-general']//table//input[@name='quantity']")).clear();
//        Actions act = new Actions(driver);
//        act.sendKeys("20").perform();
//        driver.findElement(By.xpath("//div[@id='tab-general']//table//input[@type='file']")).sendKeys(System.getProperty("user.dir") + "\\Beer-500x592.png");
//        driver.findElement(By.xpath("//div[@id='tab-general']//input[@name='date_valid_from']")).sendKeys("11052018");
//        driver.findElement(By.xpath("//div[@id='tab-general']//input[@name='date_valid_to']")).sendKeys("11052019");
//
//        driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), 'Information')]")).click();
//
//        Select manufact = new Select (driver.findElement(By.xpath("//div[@id='tab-information']//select[@name='manufacturer_id']")));
//        manufact.selectByVisibleText( "ACME Corp." );
//        driver.findElement(By.xpath("//div[@id='tab-information']//input[@name='keywords']")).sendKeys( "Pivo, pivko, pivasik, birra, beer" );
//        driver.findElement(By.xpath("//div[@id='tab-information']//input[@name='short_description[en]']")).sendKeys( "Pivandriy" );
//        driver.findElement(By.xpath("//div[@id='tab-information']//div[@class='trumbowyg-editor']")).sendKeys( "Pyvo vono i e Pyvo" );
//        driver.findElement(By.xpath("//div[@id='tab-information']//input[@name='head_title[en]']")).sendKeys( "P.I.V.A.S" );
//        driver.findElement(By.xpath("//div[@id='tab-information']//input[@name='meta_description[en]']")).sendKeys( "when you have a beer, you are a real fat guy" );
//        driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), 'Prices')]")).click();
//
//        driver.findElement(By.xpath("//div[@id='tab-prices']//input[@name='purchase_price']")).clear();
//        act.sendKeys( "1" );
//        Select price = new Select (driver.findElement(By.xpath("//div[@id='tab-prices']//select[@name='purchase_price_currency_code']")));
//        price.selectByVisibleText( "Euros" );
//        driver.findElement(By.xpath("//div[@id='tab-prices']//input[@name='prices[USD]']")).sendKeys( "7" );
//        driver.findElement(By.xpath("//div[@id='tab-prices']//input[@name='prices[EUR]']")).sendKeys( "5" );
//
//        driver.findElement(By.xpath("//span[@class='button-set']/button[@name='save']")).click();
//
//        driver.findElement(By.xpath("//td[@id='sidebar']//a//span[contains(text(), 'Catalog')]")).click();
//        String check = driver.findElement(By.xpath("//table[@class='dataTable']")).getText();
//        assert(check.contains( name ));

    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}