package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TextBox {

    static String expectedValidationText = "Üye Değil Misiniz ?";  //3D ÜRÜNLER
    static String Name = "abcde";               //!!Her deneme için yeniden oluşturunuz!!!!
    static String SurName = "fghj";            //!!Her deneme için yeniden oluşturunuz!!!!
    static String Telephone = "98745632103";  //!!Her deneme için yeniden oluşturunuz!!!!
    static String email = "deneme10@test.com"; //!!Her deneme için yeniden oluşturunuz!!!!
    static String Password = "abc234567";       //!!Her deneme için yeniden oluşturunuz!!!!

    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();//Chrome Driver çalıştırılacak
        int milis = 2000;
        cdriver.manage().window().maximize();
        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");//URL kurulan browser ile açılacak
        jsx.executeScript("window.scrollBy(0,350)");
        Thread.sleep(milis);

       // WebElement elementsButton = cdriver.findElement(By.xpath(" //ul[@class='menu3 pt-10 pb-10']//a[@title='3D ÜRÜNLER']")); 3D ürünler için
        WebElement GirisyapButton = cdriver.findElement(By.xpath("//a[@href='giris-yap']"));
        GirisyapButton.click();
        Thread.sleep(milis);

        //String actualValidationText = cdriver.findElement(By.xpath("//h2[normalize-space()='3D ÜRÜNLER']")).getText();  3D ürünler için
        String actualValidationText = cdriver.findElement(By.xpath("//h2[contains(text(),'Üye Değil Misiniz ?')]")).getText();
        Assert.assertEquals(actualValidationText, expectedValidationText);
        Thread.sleep(milis);

        WebElement KayitolButton = cdriver.findElement(By.xpath("//a[contains(text(),'Kayıt Ol')]"));
        KayitolButton.click();
        Thread.sleep(milis);

        WebElement NameLabel = cdriver.findElement(By.name("ad"));
        WebElement SurNameLabel = cdriver.findElement(By.name("soyad"));
        WebElement TelephoneLabel = cdriver.findElement(By.name("telefon"));
        WebElement EmailLabel = cdriver.findElement(By.name("email"));
        WebElement PasswordLabel = cdriver.findElement(By.name("sifre"));

        NameLabel.sendKeys(Name);
        Thread.sleep(milis);
        SurNameLabel.sendKeys(SurName);
        Thread.sleep(milis);
        TelephoneLabel.sendKeys(Telephone);
        Thread.sleep(milis);
        EmailLabel.sendKeys(email);
        Thread.sleep(milis);
        PasswordLabel.sendKeys(Password);
        Thread.sleep(milis);

        jsx.executeScript("window.scrollBy(0,350)");  // sayfayı aşağıya kaydırma!!!
        Thread.sleep(milis);

        WebElement Click1Button = cdriver.findElement(By.xpath("//div[@class='row mt-20']//span[1]"));
        Click1Button.click();
        Thread.sleep(milis);

        WebElement Click2Button = cdriver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/label[1]/span[1]/i[1]"));
        Click2Button.click();
        Thread.sleep(milis);

        WebElement Click3Button = cdriver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[7]/div[1]/label[1]/span[1]"));
        Click3Button.click();
        Thread.sleep(milis);

        WebElement KayitButton = cdriver.findElement(By.xpath("//button[contains(text(),'Kayıt Ol')]"));
        KayitButton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

        cdriver.quit();

    }


}
