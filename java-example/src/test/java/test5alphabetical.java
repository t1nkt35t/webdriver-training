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
import static junit.framework.TestCase.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class test5alphabetical {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:/_A_R_C_H_i_v_e/Java/_wdlearn/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void test5alphabetical() {
        Collator collator = Collator.getInstance(Locale.US);
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> contries = driver.findElements(By.xpath("//tr[@class=\"row\"]"));
        Set<String> Set = new LinkedHashSet<>();
        SortedSet<String> sortedSet = new TreeSet<String>(collator);
        for (int i = 1; i <= contries.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//form[@name=\"countries_form\"]//tr[@class=\"row\"][" + i + "]"));
            WebElement name = row.findElement(By.xpath(".//td[5]"));
            String country = name.getAttribute("textContent");
            System.out.println(country);
            WebElement zones = row.findElement(By.xpath(".//td[6]"));
            String zonesCount = zones.getAttribute("textContent");
            System.out.println(zonesCount);
            if (zonesCount.equals("0")) {
            } else {
                Set<String> subSet = new LinkedHashSet<>();
                SortedSet<String> sortedSubSet = new TreeSet<String>(collator);
                System.out.println(name.findElement(By.xpath("./a")).getAttribute("href"));
                driver.get(name.findElement(By.xpath("./a")).getAttribute("href"));
//                System.out.println(driver.getCurrentUrl());
                List<WebElement> zonesEdit = driver.findElements(By.xpath("//table[@id=\"table-zones\"]//td[3]"));
                for (WebElement z : zonesEdit) {
                    String zoneName = z.getAttribute("textContent");
                    if (zoneName.isEmpty()) {
                    } else {
                        subSet.add(zoneName);
                        sortedSubSet.add(zoneName);
                    }
                }
                System.out.println(subSet.toString());
                System.out.println(sortedSubSet.toString());
                try {
                    verify(subSet.toString().equals(sortedSubSet.toString()));
                } catch (Exception e) {
                    System.out.println(country + "'s geozones are not in alphabetical order");
                }
                ;
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
            Set.add(country);
            sortedSet.add(country);
        }
        System.out.println(Set.toString());
        System.out.println(sortedSet.toString());
        try {
            verify(Set.toString().equals(sortedSet.toString()));
        } catch (Exception e) {
            System.out.println("Countries are not in alphabetical order");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver= null;
    }
}
