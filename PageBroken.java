package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class PageBroken {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static JavascriptExecutor jsx;
    static int milis = 1000;
    static String url;
    static String urlText;
    static String imagesUrl;
    static String imagesUrlText;
    //ELEMENTS
    //static WebElement elementsButton;
    static WebElement brokenLinksButton;
    static List<WebElement> images;
    static List<WebElement> links;

    //HTTP
    static HttpURLConnection connection;
    static int responseCodeImg;
    static int responseCodeLink;

    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");
    }
    @AfterClass
    public void tearDown(){
        cdriver.quit();
    }

    @Test
    public void test01() throws InterruptedException{
        jsx.executeScript("window.scrollBy(0,300)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
    }
   @Test
    public void test02() throws InterruptedException{

        brokenLinksButton = cdriver.findElement(By.xpath("(//img[@alt='Loreal'])"));
        Thread.sleep(milis);
        brokenLinksButton.click();
        Thread.sleep(milis);
    }

   @Test
    public void test03() throws InterruptedException{
        images = cdriver.findElements(By.tagName("img"));
        for (int i = 2; i < images.size(); i++){
            imagesUrl = images.get(i).getAttribute("src");
            imagesUrlText = images.get(i).getText();
            try{
                connection = (HttpURLConnection) new URL(imagesUrl).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCodeImg = connection.getResponseCode();
                if (responseCodeImg == 200){
                    System.out.println("IMG IS VALID: " + imagesUrl + " | " + "Returned Response Code: " + responseCodeImg + " | " + "URL Text: " + imagesUrlText);
                }else {
                    softAssert.assertTrue(responseCodeImg > 200);
                    System.out.println("IMG IS BROKEN: " + imagesUrl + " | " + "Returned Response Code: " + responseCodeImg + " | " + "URL Text: " + imagesUrlText);
                }
            }catch (IOException e){
                System.out.println("Error Checking Response Code For URL: " + imagesUrl + " | " + "URL Text: " + imagesUrlText);
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void test04() throws InterruptedException{
        links = cdriver.findElements(By.tagName("a"));
        for (int i = 2; i < links.size(); i++){
            url = links.get(i).getAttribute("src");
            urlText = links.get(i).getText();
            try{
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCodeLink = connection.getResponseCode();
                if (responseCodeLink == 301){
                    System.out.println("LINK IS VALID: " + url + " | " + "Returned Response Code: " + responseCodeLink + " | " + "URL Text: " + urlText);
                }else {
                    softAssert.assertTrue(responseCodeLink > 301);
                    System.out.println("LINK IS BROKEN: " + url + " | " + "Returned Response Code: " + responseCodeLink + " | " + "URL Text: " + urlText);
                }
            }catch (IOException e){
                System.out.println("Error Checking Response Code For URL: " + url + " | " + "URL Text: " + urlText);
            }
        }
        softAssert.assertAll();
    }

}

