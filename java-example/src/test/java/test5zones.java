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

public class test5zones {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void test6() {
        Collator collator = Collator.getInstance(Locale.US);
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tr//td[3]/a"));
        List <String> urls = new ArrayList<>();
        for(WebElement c:countries) {
            String country = c.getAttribute( "href" );
            urls.add( country );
        }
        for (String url:urls) {
            driver.get(url);
            Set<String> Set = new LinkedHashSet<>();
            SortedSet<String> sortedSet = new TreeSet<String>(collator);
            List<WebElement> zones = driver.findElements( By.xpath( "//table//td[3]/select//option[@selected=\"selected\"]" ) );
            for (WebElement zone:zones) {
                Set.add( zone.getAttribute("textContent"));
                sortedSet.add( zone.getAttribute("textContent"));
            }
            System.out.println(Set);
            System.out.println(sortedSet);
            verify(Set.toString().equals(sortedSet.toString()),"not in alphabetical order");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver= null;
    }
}
