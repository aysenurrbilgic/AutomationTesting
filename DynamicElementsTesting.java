package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DynamicElementsTesting {
    static WebDriver cdriver;
    static WebDriver cdriver1;
    static SoftAssert softAssert;
    static JavascriptExecutor jsx;
    static int milis = 1000;

    //ELEMENTS
    static WebElement elementsButton;
    static WebElement dynamicPropertiesButton;
    static WebElement closeButton;
    static WebElement enableButton;
    static WebElement colorButton;
    static WebElement visibleButton;

    //OTHER
    static String firstRandomIdAttribute;
    static String secondRandomIdAttribute;
    static Boolean enableButtonIsEnable;
    static String firstColorButtonClassAttribute;
    static String secondColorButtonClassAttribute;
    static Boolean visibleButtonIsVisible;

    @BeforeClass
    public static void setUp(){
    cdriver1 = new ChromeDriver();
    cdriver = new ChromeDriver();
    softAssert = new SoftAssert();
    jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");

        jsx = (JavascriptExecutor) cdriver1;
        cdriver1.manage().window().maximize();
        cdriver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cdriver1.navigate().to("https://api.whatsapp.com/send/?phone=905464507043&text&type=phone_number&app_absent=0");
    }

   @BeforeMethod
    public void beforeAllTests()  throws InterruptedException{
        jsx.executeScript("window.scrollBy(0,140)");
        dynamicPropertiesButton = cdriver.findElement(By.xpath("//a[@aria-label='Go to whatsapp']//*[name()='svg']"));
        dynamicPropertiesButton.click();

    }

@AfterClass
public static void tearDown(){ cdriver.quit();
}

    @Test
    public void test01() throws InterruptedException {
    cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");
    jsx.executeScript("window.scrollBy(0,1400)");  // sayfayı aşağıya kaydırma!!!
    Thread.sleep(milis);

}

    /*@Test
    public void test02() throws InterruptedException {
        firstRandomIdAttribute = cdriver.findElement(By.xpath("//a[@aria-label='Go to whatsapp']//*[name()='svg']")).getAttribute("body");
        System.out.println("firstRandomIdAttribute: " + firstRandomIdAttribute);
        closeButton = cdriver1.findElement(By.tagName("a"));
        closeButton.click();
        System.out.println("sayfa kapatılıyor");
        cdriver1.close();
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüş
        cdriver.navigate().refresh();
        secondRandomIdAttribute = cdriver1.findElement(By.className("theme-default")).getAttribute("body");
        System.out.println("secondRandomIdAttribute: " + secondRandomIdAttribute);
        softAssert.assertNotEquals(firstRandomIdAttribute, secondRandomIdAttribute);
        System.out.println("IDs are dynamic");
        softAssert.assertAll();
    }
    /*@Test
    public void test02() throws InterruptedException {
        enableButton = cdriver.findElement(By.id("enableAfter"));
        enableButtonIsEnable = enableButton.isEnabled();
        softAssert.assertFalse(enableButtonIsEnable);
        System.out.println("STATE enableButtonIsEnable: " + enableButtonIsEnable);
        while (enableButtonIsEnable != true){
            System.out.println("Enable Button Is Not Enable, Wait For 5 Seconds");
            Thread.sleep(milis);
            enableButtonIsEnable = enableButton.isEnabled();
        }
        softAssert.assertTrue(enableButtonIsEnable);
        System.out.println("Enable Button Is Active, NOW | " + enableButtonIsEnable);
        softAssert.assertAll();
    }*/
    /*@Test
    public void test03() throws InterruptedException {
        colorButton = cdriver.findElement(By.id("colorChange"));
        firstColorButtonClassAttribute = colorButton.getAttribute("class");
        System.out.println("firstColorButtonClassAttribute: " + firstColorButtonClassAttribute);
        Thread.sleep(milis);
        secondColorButtonClassAttribute = colorButton.getAttribute("class");
        System.out.println("secondColorButtonClassAttribute: " + secondColorButtonClassAttribute);
        softAssert.assertNotEquals(firstColorButtonClassAttribute, secondColorButtonClassAttribute);
        System.out.println("Button Color Changed");
        softAssert.assertAll();
    }*/
    /*@Test
    public void test04()  throws InterruptedException {
        visibleButton = cdriver.findElement(By.id("visibleAfter"));
        visibleButtonIsVisible = visibleButton.isDisplayed();
        softAssert.assertTrue(visibleButtonIsVisible);
        System.out.println("Visible Button Is Visible, NOW | " + visibleButtonIsVisible);
        softAssert.assertAll();
    }*/






}
