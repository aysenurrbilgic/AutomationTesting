package ManageMethods;
 import org.openqa.selenium.Dimension;
 import org.openqa.selenium.Point;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
public class ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver(); //chrome Driver Çalışacak

        cdriver.get("https://e-ticaretv1.sayedrabilisim.com"); //kurulan browser ile URL açılacak //https://demoqa.com

        System.out.println("Mevcut Büyüklük: " + cdriver.manage().window().getSize()); //açık olan sayfa boyutu
        Thread.sleep(2000); //işlemler arasında 2 saniyelik bekleme (işlemleri takip edebilmek için)

        cdriver.manage().window().setSize(new Dimension(800, 600)); //açık olan sekme boyutu ayarlama.
        Thread.sleep(2000);//işlemler arasında 2 saniyelik bekleme (işlemleri takip edebilmek için)

        System.out.println("Mevcut Konum: " + cdriver.manage().window().getPosition());//açık olan sekmenin ekranda açıldığı kornitları almak için.
        Thread.sleep(2000);//işlemler arasında 2 saniyelik bekleme (işlemleri takip edebilmek için)

        cdriver.manage().window().setPosition(new Point(200, 15));//açık olan sekmenin açılacağı konumun belirlenmesi.
        Thread.sleep(2000);//işlemler arasında 2 saniyelik bekleme (işlemleri takip edebilmek için)

        System.out.println("Yeni Büyüklük: " + cdriver.manage().window().getSize()); //açık olan sekmenin boyutunu yazdırmak için kullanırız.
        System.out.println("Yeni Konum: " + cdriver.manage().window().getPosition());//açık olan sekmenin konumunu yazdırmak için kullanırız.

        //Browserın tam ekran olması için
        cdriver.manage().window().fullscreen();
        System.out.println("FullScreen Büyüklük: " + cdriver.manage().window().getSize());
        Thread.sleep(2000);

        //Browserın açıldığında tam  ekran olması için
        cdriver.manage().window().maximize();
        System.out.println("Maximize Büyüklük: " + cdriver.manage().window().getSize());
        Thread.sleep(2000);

        //Browserın küçültülmesi taskbar a inmesi.
        cdriver.manage().window().minimize();
        System.out.println("Minimize Büyüklük: " + cdriver.manage().window().getSize());
        System.out.println("Minimize Konum: " + cdriver.manage().window().getPosition());

        cdriver.quit();

    }



}
