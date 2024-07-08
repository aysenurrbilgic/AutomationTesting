package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsBox {

    public static void main(String[] args) throws InterruptedException {

        WebDriver cdriver = new ChromeDriver();
        int milis = 2000;
        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        cdriver.get("https://e-ticaretv1.sayedrabilisim.com/");

        WebElement urunlerButton = cdriver.findElement(By.xpath("//span[normalize-space()='3D ÜRÜNLER']"));
        urunlerButton.click();
        Thread.sleep(milis);

        WebElement ücdürünlerButton = cdriver.findElement(By.xpath("//ul[@class='adres_cubugu']//a[contains(text(),'3D ÜRÜNLER')]"));
        ücdürünlerButton.click();
        Thread.sleep(milis);

        WebElement element = cdriver.findElement(By.xpath("//a[@title='Çok Amaçlı Düzenleyiciler']"));
        element.click();
        Thread.sleep(milis);

        cdriver.navigate().back(); //bir önceki sayfaya dönüş
        System.out.println("sayfada geri gelindi");
        Thread.sleep(milis);

        element = cdriver.findElement(By.xpath("//a[@title='Çok Amaçlı Düzenleyiciler']"));

        boolean isSelectedücdürünler = element.isSelected();

          //System.out.println("Is element selected: " + element.isSelected());
         if(isSelectedücdürünler){
        System.out.println("ProductsBox is already selected");
         }else{
         System.out.println("ProductsBox is NOT selected");
         }
        Thread.sleep(milis);

        List<WebElement> resultücdürünler = cdriver.findElements(By.xpath("//ul[@class='kategoriler']"));

        for(WebElement result : resultücdürünler){
          System.out.println(result.getText());
       }

        cdriver.quit();
    }

}
