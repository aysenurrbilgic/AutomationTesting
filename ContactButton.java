package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactButton {
    static WebDriver cdriver;
    static int milis = 1000;
    static JavascriptExecutor jsx;
    //Elements
    static WebElement ContactButton;
    static WebElement buttonsButtons;
    static WebElement securityClickButton;
    static WebElement cargoClickButton;
    static WebElement salesContractButton;
    static WebElement membershipButton;
    static WebElement termsButton;
    static WebElement consentTextButton;
    //String
    static String ContactClickMessage;
    static String expectedDoubleClickMessage = "Hakkımızda";

    static String securityClickMessage;
    static String expectedSecurityClickMessage = "GİZLİLİK VE GÜVENLİK POLİTİKASI";

    static String cargoClickMessage;
    static String expectedcargoClickMessage = "Teslimat & İade Koşulları";

    static String salesContactMessage;
    static String expectedsalesContactMessage = "MESAFELİ SATIŞ SÖZLEŞMESİ";

    static String membershipMessage;
    static String expectedmembershipMessage = "4. ÜYELİK ŞARTLARI VE YÜKÜMLÜLÜKLERİ";

    static String termsMessage;
    static String expectedtermsMessage = "Kullanım Koşulları";

    static String consentTextMessage;
    static String expectedconsentTextMessage = "Aydınlatma ve Rıza Metni";

    @BeforeClass
    public static void setUp() {
        cdriver = new ChromeDriver();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");
    }

    @AfterClass
    public static void tearDown() {
        cdriver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        ContactButton = cdriver.findElement(By.xpath("//ul[@class='menu1 pull-right']//li//a[@href='iletisim'][contains(text(),'İletişim')]"));
        ContactButton.click();
        Thread.sleep(milis);
    }

    @Test
    public void test02() throws InterruptedException {

        jsx.executeScript("window.scrollBy(0,175)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        buttonsButtons = cdriver.findElement(By.xpath("//a[@title='Hakkımızda']"));
        //actions.moveToElement(buttonsButtons).doubleClick().perform();
        buttonsButtons.click();
        Thread.sleep(milis);
        ContactClickMessage = cdriver.findElement(By.xpath("//h1[2]")).getText();
        System.out.println("Contact Click Message: " + ContactClickMessage);
        Assert.assertEquals(ContactClickMessage, expectedDoubleClickMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüş
        System.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }

    @Test
    public void test03() throws InterruptedException {

        securityClickButton = cdriver.findElement(By.xpath("//a[@title='Gizlilik Politikası']"));
        securityClickButton.click();
        Thread.sleep(milis);
        securityClickMessage = cdriver.findElement(By.xpath("//div[contains(text(),'GİZLİLİK VE GÜVENLİK POLİTİKASI')]")).getText();
        System.out.println("Security Click Message: " + securityClickMessage);
        Assert.assertEquals(securityClickMessage, expectedSecurityClickMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüş
        System.out.println("sayfada geri gelindi");
        Thread.sleep(milis);

    }

    @Test
    public void test04() throws InterruptedException {
        cargoClickButton = cdriver.findElement(By.xpath("//a[@title='Teslimat ve İade']"));
        cargoClickButton.click();
        Thread.sleep(milis);
        cargoClickMessage = cdriver.findElement(By.xpath("//div[contains(text(),'Teslimat & İade Koşulları')]")).getText();
        System.out.println("Right Click Message: " + cargoClickMessage);
        Assert.assertEquals(cargoClickMessage, expectedcargoClickMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüşSystem.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }

    @Test
    public void test05() throws InterruptedException {
        salesContractButton = cdriver.findElement(By.xpath("//a[@title='Mesafeli Satış Sözleşmesi']"));
        salesContractButton.click();
        Thread.sleep(milis);
        salesContactMessage = cdriver.findElement(By.xpath("//div[contains(text(),'MESAFELİ SATIŞ SÖZLEŞMESİ')]")).getText();
        System.out.println("Sales Contact Message: " + salesContactMessage);
        Assert.assertEquals(salesContactMessage, expectedsalesContactMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüşSystem.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }

    @Test
    public void test06() throws InterruptedException {
        membershipButton = cdriver.findElement(By.xpath("//a[@title='Üyelik Sözleşmesi']"));
        membershipButton.click();
        Thread.sleep(milis);
        membershipMessage = cdriver.findElement(By.xpath("//div[contains(text(),'4. ÜYELİK ŞARTLARI VE YÜKÜMLÜLÜKLERİ')]")).getText();
        System.out.println("Sales Contact Message: " + membershipMessage);
        Assert.assertEquals(membershipMessage, expectedmembershipMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüşSystem.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }

    @Test
    public void test07() throws InterruptedException {
        termsButton = cdriver.findElement(By.xpath("//a[@title='Kullanım Koşulları']"));
        termsButton.click();
        Thread.sleep(milis);
        termsMessage = cdriver.findElement(By.xpath("//h2[contains(text(),'Kullanım Koşulları')]")).getText();
        System.out.println("Sales Contact Message: " + termsMessage);
        Assert.assertEquals(termsMessage, expectedtermsMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüşSystem.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }

    @Test
    public void test08() throws InterruptedException {
        consentTextButton = cdriver.findElement(By.xpath("//a[@title='Aydınlatma ve Rıza Metni']"));
        consentTextButton.click();
        Thread.sleep(milis);
        consentTextMessage = cdriver.findElement(By.xpath("//h2[contains(text(),'Aydınlatma ve Rıza Metni')]")).getText();
        System.out.println("Sales Contact Message: " + consentTextMessage);
        Assert.assertEquals(consentTextMessage, expectedconsentTextMessage);
        jsx.executeScript("window.scrollBy(0,200)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);
        cdriver.navigate().back(); //bir önceki sayfaya dönüşSystem.out.println("sayfada geri gelindi");
        Thread.sleep(milis);
    }
}