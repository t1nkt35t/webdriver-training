import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Verify.verify;

public class test6 {
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

        List<String> mainRegularColors = Tools.digitize(Arrays.asList(mainRegularColor.split(",")));

        String mainCampaignColor = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class='campaign-price']")).getCssValue("color");

        List<String> mainCampaignColors = Tools.digitize( Arrays.asList(mainCampaignColor.split(",")));

        driver.findElement( By.xpath( "//div[@id='box-campaigns']//a[@class=\"link\"]" ) ).click();
        String pageName = driver.findElement(By.xpath("//h1[@itemprop = 'name']")).getAttribute("textContent");
        String pageOldPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getAttribute("textContent");
        String pageSalePrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getAttribute("textContent");
        String pageSaleFontWeight = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("font-weight");
        String pageRegularStrike = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("text-decoration-line");
        String pageRegFontSize = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("font-size");
        String pageSaleFontSize = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("font-size");

        String pageRegularColor = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("color");

        List<String> pageRegularColors = Tools.digitize(Arrays.asList(pageRegularColor.split(",")));

        String pageCampaignColor = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("color");

        List<String> pageCampaignColors = Tools.digitize(Arrays.asList(pageCampaignColor.split(",")));

//а) на главной странице и на странице товара совпадает текст названия товара
        verify(mainName.equals( pageName ));
//б) на главной странице и на странице товара совпадают цены (обычная и акционная)
        verify(mainOldPrice.equals( pageOldPrice ));
        verify(mainSalePrice.equals( pageSalePrice ));
//в) обычная цена зачёркнутая и серая
        verify(mainRegularColors.get(0).equals( mainRegularColors.get(1)));
        verify(mainRegularColors.get(1).equals( mainRegularColors.get(2)));
//        verify(mainCampaignColors.get(0).equals(mainCampaignColors.get(1)));
//        verify(mainCampaignColors.get(1).equals(mainCampaignColors.get(2)));
        verify(pageRegularStrike.equals( "line-through" ));
        verify(mainRegularStrike.equals( "line-through" ));
//г) акционная жирная и красная
        verify(mainCampaignColors.get(1).equals( "0" ));
        verify(mainCampaignColors.get(2).equals( "0" ));
        verify(pageCampaignColors.get(1).equals( "0" ));
        verify(pageCampaignColors.get(2).equals( "0" ));
        verify(mainSaleFontWeight.equals( "700" ));
        verify(pageSaleFontWeight.equals( "700" ));
//д) акционная цена крупнее, чем обычная
        Float regFontSizeMain = Float.valueOf(mainRegFontSize.substring(0, mainRegFontSize.length() - 2));
        Float saleFontSizeMain = Float.valueOf(mainSaleFontSize.substring(0, mainSaleFontSize.length() - 2));
        Float regFontSizePage = Float.valueOf(pageRegFontSize.substring(0, pageRegFontSize.length() - 2));
        Float saleFontSizePage = Float.valueOf(pageSaleFontSize.substring(0, pageSaleFontSize.length() - 2));
        verify(saleFontSizeMain > regFontSizeMain);
        verify(saleFontSizePage > regFontSizePage);
//        System.out.println(mainRegularColors.get(0));
//        System.out.println(mainRegularColors.get(0) == ( mainRegularColors.get(1)));
//        System.out.println(mainOldPrice);
//        System.out.println(mainSalePrice);
//        System.out.println(mainSaleFontWeight);
//        System.out.println(mainRegularStrike);
//        System.out.println(mainRegularColors);
//        System.out.println(mainCampaignColors);
//        System.out.println(Float.valueOf(mainRegFontSize.substring(0, mainRegFontSize.length() - 2)));
//        System.out.println(Float.valueOf(mainSaleFontSize.substring(0, mainSaleFontSize.length() - 2)));
//
//        System.out.println(pageName);
//        System.out.println(pageOldPrice);
//        System.out.println(pageSalePrice);
//        System.out.println(pageSaleFontWeight);
//        System.out.println(pageRegularStrike);
//        System.out.println(pageRegularColors);
//        System.out.println(pageCampaignColors);
//        System.out.println(pageRegFontSize);
//        System.out.println(pageSaleFontSize);
    }

    @After
    public void stop() {
        driver.quit();
        driver= null;
    }
}