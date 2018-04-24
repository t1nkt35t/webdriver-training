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

public class TestThree {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void TestThree() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> menu = driver.findElements(By.xpath("//td[@id='sidebar']//li[@id='app-']"));
        for (int j = 1; j <= menu.size(); j++) {
            WebElement item = driver.findElement(By.xpath("//td[@id='sidebar']//li[@id='app-'][" + j + "]"));
            item.click();
            assert(driver.findElement(By.xpath("//td[@id='content']//h1"))).isDisplayed();
            List<WebElement> submenu = driver.findElements(By.xpath("//li[@id='app-']//ul/li"));
            if (submenu.size() > 0 ) {
                for (int i=1; i <= submenu.size(); i++) {
                    WebElement subitem = driver.findElement(By.xpath("//li[@id='app-']//ul/li[" + i + "]"));
                    subitem.click();
                    assert(driver.findElement(By.xpath("//td[@id='content']//h1"))).isDisplayed();
                }
            }
        }
    }

    @After
    public void stop() {
//        driver.quit();
//        driver= null;
    }
}

