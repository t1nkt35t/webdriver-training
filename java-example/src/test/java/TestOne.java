import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestOne {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void TestOne() {
        driver.get("http://www.google.com");
        wait.until(titleIs("Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver= null;
    }
}

