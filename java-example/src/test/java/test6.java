import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.text.Collator;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Verify.verify;

public class test6 {
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
    public void test6() {
        driver.get("http://localhost/litecart");
        String mainName = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class=\"name\"]")).getAttribute("textContent");
        String mainOldPrice = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class='regular-price']")).getAttribute("textContent");
        String mainSalePrice = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class='campaign-price']")).getAttribute("textContent");
        String mainSaleFontWeight = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class='campaign-price']")).getCssValue("font-weight");
        String mainRegularStrike = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class='regular-price']")).getCssValue("text-decoration-line");
        String mainRegFontSize = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class='regular-price']")).getCssValue("font-size");
        String mainSaleFontSize = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class='campaign-price']")).getCssValue("font-size");


        String mainRegularColor = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class='regular-price']")).getCssValue("color");

        List<String> mainRegularColors = Tools.split(Arrays.asList(mainRegularColor.split(",")));

        String mainCampaignColor = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class='campaign-price']")).getCssValue("color");

        List<String> mainCampaignColors = Tools.split( Arrays.asList(mainCampaignColor.split(",")));

        driver.findElement( By.xpath( "//div[@id='box-campaigns']//a[@class=\"link\"]" ) ).click();
        String pageName = driver.findElement(By.xpath("//h1[@itemprop = 'name']")).getAttribute("textContent");
        String pageOldPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getAttribute("textContent");
        String pageSalePrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getAttribute("textContent");
        String pageSaleFontWeight = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("font-weight");
        String pageRegularStrike = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("text-decoration-line");
        String pageRegFontSize = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("font-size");
        String pageSaleFontSize = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("font-size");


        String pageRegularColor = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("color");

        List<String> pageRegularColors = Tools.split(Arrays.asList(pageRegularColor.split(",")));

        String pageCampaignColor = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("color");

        List<String> pageCampaignColors = Tools.split(Arrays.asList(pageCampaignColor.split(",")));



        System.out.println(mainName);
        System.out.println(mainOldPrice);
        System.out.println(mainSalePrice);
        System.out.println(mainSaleFontWeight);
        System.out.println(mainRegularStrike);
        System.out.println(mainRegularColors);
        System.out.println(mainCampaignColors);
        System.out.println(mainRegFontSize);
        System.out.println(mainSaleFontSize);

        System.out.println(pageName);
        System.out.println(pageOldPrice);
        System.out.println(pageSalePrice);
        System.out.println(pageSaleFontWeight);
        System.out.println(pageRegularStrike);
        System.out.println(pageRegularColors);
        System.out.println(pageCampaignColors);
        System.out.println(pageRegFontSize);
        System.out.println(pageSaleFontSize);
    }

    @After
    public void stop() {
        driver.quit();
        driver= null;
    }
}