package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Links {

    static WebDriver cdriver;
    static int milis = 1000;
    static JavascriptExecutor jsx;

    //HTTP
    static HttpURLConnection connection;
    static int responseCode;

    //Elements
    static WebElement linksButton;
    static WebElement wpLink;
    static WebElement wplinks;
    static WebElement elementsButtonWait;
    static ExpectedCondition elementsButtonIsDisplayed;

    //Windows
    static Set<String> windows;
    static Iterator<String> window;
    static String parentId;
    static String childIdOne;
    static Set<String> allWindowHandles;
    static String mainWindowHandle;


    //Links
    static List<WebElement> links;
    static String url;
    static String urlText;

    @BeforeClass
    public static void setUp(){

        cdriver = new ChromeDriver();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");
    }
    @AfterClass
    public static void tearDown(){
        cdriver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        jsx.executeScript("window.scrollBy(0,1400)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
    }
    @Test
    public void test02() throws InterruptedException{
        wpLink = cdriver.findElement(By.cssSelector(".lab.la-whatsapp"));
        wpLink.click();
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüş
        System.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }
    @Test
    public void test03() throws InterruptedException{
        wplinks = cdriver.findElement(By.cssSelector(".lab.la-whatsapp"));
        ((JavascriptExecutor)cdriver).executeScript("window.open(arguments[0].href,'_blank');", wplinks);
        wplinks.click();
        mainWindowHandle = cdriver.getWindowHandle();
        Thread.sleep(milis);
        windows = cdriver.getWindowHandles();
        Thread.sleep(milis);
        window = windows.iterator();
        parentId = window.next();
        childIdOne = window.next();
        cdriver.switchTo().window(childIdOne);
        cdriver.close();
        cdriver.switchTo().window(parentId);
    }

    @Test
    public void test05() throws InterruptedException{
        links = cdriver.findElements(By.tagName("a"));
        for (int i = 4; i<links.size(); i++){
            url = links.get(i).getAttribute("href");
            urlText = links.get(i).getText();
            try{
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                responseCode = connection.getResponseCode();

                System.out.println("URL: " + url + " | " + "Returned Response Code: " + responseCode + " | " + "URL Text: " + urlText);
            }catch (IOException e){
                System.out.println("Error Checking Response Code For URL: " + url + " | " + "URL Text: " + urlText);

            }
        }
    }




}


