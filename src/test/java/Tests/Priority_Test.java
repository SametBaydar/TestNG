package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Priority_Test {

    /* TestNG'de priority, test metotlarının yürütülme sırasını belirlemek için kullanılır.
    Her bir test metodu, @Test anotasyonu ile işaretlenir ve bu anotasyona bir priority
    değeri atandığında, TestNG bu değere göre testleri çalıştırır.
    Herhangi bir değer atanmaz ise default değeri 0 olarak alır.
    Yine herhangi bir değer atanmaz ise alfabetik sıraya göre çalıştırır.

       */
    WebDriver driver; // Tüm method'larda driveri kullanabilmemiz için class içerisinde driver değişkenini oluşturduk.
    @BeforeMethod // Çalıştırılacak tüm method'lardan önce çalışması için @BeforeMethod kullanıldı.
    public void setup(){
        driver = new ChromeDriver(); // Yeni bir Chrome driver objesi oluşturduk.
        driver.manage().window().maximize(); // sayfa açıldığında sayfa maximum büyüklüğe geçecek.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // sayfa çalıştığında element vs. arattığımız zaman bekletmek adına implicitlyWait oluşturduk. 10 saniyeden sonra element bulunamaz ise hata verecek.

    }

    @AfterMethod // Çalıştırılacak tüm method'lardan sonra çalışması için @AfterMethod kullanıldı.
    public void teardown(){
        driver.quit(); // Sayfayı kapat

    }

    // https://testotomasyonu.com sayfanın url'sinin testotomasyonu içerdiğini test edin
    @Test(priority = 1)
    public void testotomasyonuTesti(){
        driver.get("https://testotomasyonu.com");
        String expectedURL = "testotomasyon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));

    }

    // https://youtube.com sayfanın url'sinin youtube içerdiğini test edin
    @Test(priority = 2)
    public void youtubeTesti(){
        driver.get("https://youtube.com");
        String expectedURL = "youtube";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));



    }

    // https://arabam.com sayfanın url'sinin arabam içerdiğini test edin
    @Test(priority = 3)
    public void arabamTesti(){
        driver.get("https://arabam.com");
        String expectedURL = "arabam";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));



    }

}
