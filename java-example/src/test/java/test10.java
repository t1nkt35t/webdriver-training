import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void test10() {

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement( By.xpath("//form[@name=\"countries_form\"]//tr[@class=\"row\"]//td/a")).click();
        String mainWindow = driver.getWindowHandle();
        String newWindow = null;

        for (WebElement i : driver.findElements( By.xpath( "//i[@class=\"fa fa-external-link\"]" ))) {
            i.click();
            while (driver.getWindowHandles().size() < 2) {
                try {
                    Thread.sleep( 100 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!(window.equals( mainWindow ))) {
                    newWindow = window;
                }
            }
            driver.switchTo().window( newWindow );
            System.out.println(driver.getTitle());
            driver.close();
            driver.switchTo().window( mainWindow );
        }
    }

    @After
    public void stop() {
//        driver.quit();
        driver= null;
    }
}