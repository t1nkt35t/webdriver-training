import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void test8() {

        driver.get("http://localhost/litecart/");
        for (int i = 0; i<=2; i++) {
            driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@class=\"link\"]")).click();
            int count = Integer.valueOf(driver.findElement(By.xpath("//div[@id='cart']//span[@class='quantity']")).getText());
            try {
                Select size = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
                size.selectByVisibleText( "Small" );
            }
            catch(Exception e) {

            }
            System.out.println(count);
            driver.findElement(By.xpath("//td[@class='quantity']//button[@name='add_cart_product']")).click();
            wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@id='cart']//span[@class='quantity']"), "textContent" ,String.valueOf(count + 1)));
            driver.findElement(By.xpath("//nav[@id='breadcrumbs']//a")).click();
        }
    driver.findElement(By.xpath("//div[@id='cart']//a[contains (text(), 'Checkout')]")).click();
    while (driver.findElements(By.xpath("//div[@id='order_confirmation-wrapper']//td[@class='item']")).size() != 0) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form[@name='cart_form']//button[@name='remove_cart_item']"))));
        driver.findElement(By.xpath("//form[@name='cart_form']//button[@name='remove_cart_item']")).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//form[@name='cart_form']//button[@name='remove_cart_item']"))));
    }
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='checkout-cart-wrapper']//em"))));
    assert((driver.findElement(By.xpath("//div[@id='checkout-cart-wrapper']//em")).getText()).equals("There are no items in your cart."));
    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}