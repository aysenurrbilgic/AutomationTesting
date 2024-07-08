package navigateMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        int milis = 2000;//2 saniye bekleme süresi
        WebDriver cdriver = new ChromeDriver(); //Chorome driver çalıştırmak için

        cdriver.get("https://e-ticaretv1.sayedrabilisim.com");  //https://demoqa.com
        System.out.println("Anasayfa açıldı");
        Thread.sleep(milis); //işlemleri gözlemleyebilmek için bekleme adımı.

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/kategori/3d-urunler"); //sayfayı ileri geri yapabilmek için //https://demoqa.com
        System.out.println("3D ürünler sayfasına gidildi");
        Thread.sleep(milis);

        cdriver.navigate().back(); //bir önceki sayfaya dönüş
        System.out.println("sayfada geri gelindi");
        Thread.sleep(milis);

        cdriver.navigate().refresh(); // sayfayı yenilemek
        System.out.println("sayfa yenilendi");
        Thread.sleep(milis);

        cdriver.navigate().forward(); // bir sonraki sayfaya gider
        System.out.println("sayfada ileri gidildi");
        Thread.sleep(milis);

        System.out.println("sayfa kapatılıyor");
        cdriver.close(); // açık olan sekmeyi kapatır
        cdriver.quit(); // tüm pencereleri kapatır

    }


}
