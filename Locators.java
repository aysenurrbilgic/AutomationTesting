package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

            WebDriver cdriver = new ChromeDriver();//Chrome driver çalıştırmak için
            int milis = 2000;//2 saniye bekleme süresi

            JavascriptExecutor jsx = (JavascriptExecutor) cdriver;//Sayfada scroll yapabilmek için yazdık

            // Browser açıldığında tam ekran olması için.
            cdriver.manage().window().maximize();

            cdriver.get("https://e-ticaretv1.sayedrabilisim.com/giris-yap");
            Thread.sleep(milis);//Bekleme adımı için gerekli. İşlemleri gözlemleyebilmek için.

            jsx.executeScript("window.scrollBy(0,250)","");//Sayfa aşağı kaydırılır

            //name
            cdriver.findElement(By.name("email"));//name ile locator tanımlama -> "name of ID's attribute value"

            //CLASS NAME
            cdriver.findElement(By.className("form-control"));//CLASS NAME ile locator tanımlama -> "name of CLASSNAME's attribute value"

            //****CSS Selectors
            cdriver.findElement(By.cssSelector("footer.bg2.pt-15.mt-15.border-t"));
            cdriver.findElement(By.cssSelector(".row.mt-20.mb-20"));//CSS ile locator tanımlama -> ".className" //Arada boşluk varsa boşluk yerine nokta koyulur
            cdriver.findElement(By.cssSelector("[type='email']"));

            //XPATH
            cdriver.findElement(By.xpath("//h2[text()='Giriş Yapın']"));//XPATH ile locator tanımlama ->  //tagName[text()='any text']"));
            cdriver.findElement(By.xpath("//input[@placeholder='E-Posta Adresi' and @type='email']"));
            cdriver.findElement(By.xpath("//div[contains(text(),'E-Posta Adresi')]"));//XPATH ile locator tanımlama ->  //tagName[contains(text(),'any text part')]"));

    }

    }
