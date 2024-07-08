package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CategoriesButton {
    static String expectedProductNameMessage = "GAYRET UCUZ OSMANLI OCAĞI";
    static String expectedFavButtonMessage = "Ürün Başarı ile Favorilere Eklendi";
    static String expectedMixButtonMessage = "Ürün Başarı ile Karşılaştırmalara Eklendi";

    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();

        int milis = 2000;

        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.get("https://e-ticaretv1.sayedrabilisim.com/");

        WebElement urunlerButton  = cdriver.findElement(By.xpath("//span[normalize-space()='3D ÜRÜNLER']"));
        urunlerButton .click();
        Thread.sleep(milis);

        WebElement ocakButton = cdriver.findElement(By.xpath("//body/div[@class='dis']/div[@class='col-md-9 urunler_dis']/div[1]/div[1]/div[1]"));
        ocakButton.click();
        Thread.sleep(milis);

        jsx.executeScript("window.scrollBy(0,165)"); // sayfayı aşaği kaydirma
        Thread.sleep(milis);

        String actualProductNameMessage = cdriver.findElement(By.cssSelector("div[class='col-md-12'] h1")).getText();
        Assert.assertEquals(actualProductNameMessage, expectedProductNameMessage);
        System.out.println("GAYRET UCUZ OSMANLI OCAĞI");

        WebElement favButton = cdriver.findElement(By.xpath("//span[normalize-space()='Favorilere Ekle']"));
        favButton.click();
        Thread.sleep(milis);

        String actualFavButtonMessage = cdriver.findElement(By.cssSelector("div[class='modal-body'] center h3")).getText();
        Assert.assertEquals(actualFavButtonMessage, expectedFavButtonMessage);
        System.out.println("Ürün Başarı ile Favorilere Eklendi");

        WebElement closeButton = cdriver.findElement(By.cssSelector("button[type='button']"));
        closeButton.click();
        Thread.sleep(milis);

        WebElement MixButton = cdriver.findElement(By.xpath("//span[contains(text(),'Karşılaştır')]"));
        MixButton.click();
        Thread.sleep(milis);

        String actualMixButtonMessage = cdriver.findElement(By.cssSelector("div[class='modal-body'] center h3")).getText();
        Assert.assertEquals(actualMixButtonMessage, expectedMixButtonMessage);
        System.out.println("Ürün Başarı ile Karşılaştırmalara Eklendi");

        WebElement close1Button = cdriver.findElement(By.cssSelector("button[type='button']"));
        close1Button.click();
        Thread.sleep(milis);

        WebElement AdetButton = cdriver.findElement(By.id("adet")); // id her zaman locatorlarda öneceliğe sahiptir!!
        boolean isClickableNoButton = AdetButton.isEnabled();

       // int isClickableNoButton = isClickableNoButton.sendKeys(AdetButton);
        Thread.sleep(milis);
        System.out.println("STATE: " + isClickableNoButton);

          if (isClickableNoButton ){
           System.out.println("Number of pieces is not selected");
           }else{
            System.out.println("Number of pieces selected");
            cdriver.quit();
         }

        Thread.sleep(milis);

        cdriver.quit();
    }


}
