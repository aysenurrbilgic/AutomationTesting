package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchTables {
    static WebDriver cdriver;
    static int milis = 1000;
    static JavascriptExecutor jsx;
    static WebElement ShopsButton;
    static WebElement tecnoshopButton;
    static WebElement questionButton;
    static WebElement NumuneButton;
    static String expectedFirstMessage = "Mağazaya Soru Sor";
    static String actualFirstRowsMessage;
    static WebElement searchBox;
    static String searchBoxInputData = "avo";
    static WebElement searchButton;
    static WebElement searchcaseButton;
    static String expectedFirstRowsFirstColmSearch = "AVOKADO KREM";

    static WebElement firstName;
    static WebElement lastName;
    static WebElement email;
    static WebElement telephone;
    static WebElement tc;
    static WebElement sifre;
    static WebElement adress;
    static WebElement Click1Button;
    static WebElement Click2Button;
    static WebElement SiparisButton;
    static String firstNameLabel = "Test";
    static String lastNameLabel = "Deneme";
    static String emailLabel = "test@deneme.com";
    static String telephoneLabel = "12345678901";
    static String tcLabel = "12345678901";
    static String sifreLabel = "Bank23";
    static String adressLabel = "Kron ";
    static List<WebElement> kategorilist;
    static WebElement urunlerButton;
    static boolean isEmptyFifthRow;

    @BeforeClass
    public void setUp(){
        cdriver = new ChromeDriver();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");
    }
    @AfterClass
    public void tearDown(){
        cdriver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        ShopsButton = cdriver.findElement(By.xpath("//ul[@class='menu1 pull-right']//li//a[@href='magazalar'][contains(text(),'Mağazalar')]"));
        ShopsButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test02() throws InterruptedException {
        tecnoshopButton = cdriver.findElement(By.xpath("//a[@href='teknotoptan/']//img[@class='img-responsive']"));
        tecnoshopButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test03() throws InterruptedException {
        questionButton = cdriver.findElement(By.xpath("//a[@class='btn btn-warning']"));
        actualFirstRowsMessage = questionButton.getText();
        System.out.println("actualFirstRowsMessage: " + actualFirstRowsMessage);
        Assert.assertEquals(actualFirstRowsMessage, expectedFirstMessage);
    }
    @Test
    public void test04() throws InterruptedException {
        urunlerButton = cdriver.findElement(By.xpath("//span[normalize-space()='3D ÜRÜNLER']"));
        urunlerButton.click();
        Thread.sleep(milis);
    }

    @Test
    public void test05() throws InterruptedException {
        WebElement kategoriButton = cdriver.findElement(By.xpath("//span[normalize-space()='3D YAZICI PARÇALARI']")); ////h2[normalize-space()='3D ÜRÜNLER']
        kategoriButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test06() throws InterruptedException {
        WebElement kategori1Button = cdriver.findElement(By.xpath("//ul[@class='kategoriler']//a[@title='3D ÜRÜNLER'][normalize-space()='3D ÜRÜNLER']"));
        kategori1Button.click();
        Thread.sleep(milis);
    }
    @Test
    public void test07() throws InterruptedException {

        kategorilist = cdriver.findElements(By.xpath("(//ul[@class='kategoriler'])[1]")); ////div[@class='col-md-3 bg2 kategori_sol border']//div[1]
        System.out.println("Kategori Listesi : " + kategorilist.get(0).getText());
        isEmptyFifthRow = kategorilist.isEmpty();
        System.out.println("STATE: " + isEmptyFifthRow);//false
        if (isEmptyFifthRow){
            System.out.println("Sixth category is Empty");
        }else{
            System.out.println("Sixth category is full");
            Assert.assertFalse(isEmptyFifthRow);
        }

    }

    @Test
    public void test08() throws InterruptedException {
        searchBox = cdriver.findElement(By.xpath("//input[@placeholder='Ürün Adı ile Arama Yapabilirsiniz...']"));
        searchBox.sendKeys(searchBoxInputData);
        Thread.sleep(milis);
        searchcaseButton = cdriver.findElement(By.xpath("//a[normalize-space()='AVOKADO KREM']"));
        actualFirstRowsMessage = searchcaseButton.getText();
        searchBox.click();
        System.out.println("actualFirstRowsMessage: " + actualFirstRowsMessage);
        Assert.assertEquals(actualFirstRowsMessage, expectedFirstRowsFirstColmSearch);
        //searchBox.click();
        searchBox.clear();
        Thread.sleep(milis);

        searchButton = cdriver.findElement(By.xpath("//a[normalize-space()='AVOKADO KREM']"));
        searchButton.click();
        cdriver.navigate().refresh();
        Thread.sleep(milis);
    }
    @Test
    public void test09() throws InterruptedException {
        NumuneButton = cdriver.findElement(By.xpath("//button[normalize-space()='Numune Al']"));
        NumuneButton.click();
        Thread.sleep(milis);

        jsx.executeScript("window.scrollBy(0,175)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);

        firstName = cdriver.findElement(By.xpath("(//input[@placeholder='Adınız'])[1]"));
        firstName.sendKeys(firstNameLabel);
        Thread.sleep(milis);
        lastName = cdriver.findElement(By.xpath("//input[@placeholder='Soyadınız']"));
        lastName.sendKeys(lastNameLabel);
        Thread.sleep(milis);
        telephone = cdriver.findElement(By.xpath("//input[@placeholder='Telefon']"));
        telephone.sendKeys(telephoneLabel);
        Thread.sleep(milis);
        email = cdriver.findElement(By.xpath("//input[@placeholder='Email Adresiniz']"));
        email.sendKeys(emailLabel);
        Thread.sleep(milis);
        tc = cdriver.findElement(By.xpath("//input[@placeholder='Tc Kimlik No']"));
        tc.sendKeys(tcLabel);
        Thread.sleep(milis);
        sifre = cdriver.findElement(By.xpath("//input[@placeholder='********']"));
        sifre.sendKeys(sifreLabel);
        Thread.sleep(milis);
        adress = cdriver.findElement(By.xpath("//textarea[@placeholder='Sipariş Adresiniz']"));
        adress.sendKeys(adressLabel);
        Thread.sleep(milis);

        Click1Button = cdriver.findElement(By.xpath("//select[@name='odeme_yontemi']"));
        Click1Button.click();
        Thread.sleep(milis);

        Click2Button = cdriver.findElement(By.xpath(" //option[@value='1']"));
        Click2Button.click();
        Thread.sleep(milis);

        SiparisButton = cdriver.findElement(By.xpath("//button[contains(text(),'Siparişi Oluştur')]"));
        SiparisButton.click();
        Thread.sleep(milis);


    }
    }
