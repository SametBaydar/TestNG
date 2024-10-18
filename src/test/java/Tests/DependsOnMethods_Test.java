package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ReusableMethods;

import java.time.Duration;

public class DependsOnMethods_Test {

    /*
    DependsOnMethods, bir test metodunun başka bir test metoduna bağımlı olduğunu belirtir.
    Yani, bağımlı olan metodun çalışmadan önce belirtilen metodun çalışması gerektiğini
    ifade eder.
    */


    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit(); // Sayfayı kapat

    }


// 3 farklı test methodu oluşturun
// 1. test: testotomasyonu sayfasına gidip, url'nin testotomasyonu içerdiğini test edin
@Test
public void Test1(){
        driver.get("https://testotomasyonu.com");
        String expectedURL ="testotomasyonu";
        String actualURL =driver.getCurrentUrl();
    Assert.assertTrue(actualURL.contains(expectedURL));

}
// 2. test: phone için arama yapıp, ürün bulunabildiğini test edin
@Test(dependsOnMethods = "Test1")
public void Test2(){
        driver.findElement(By.id("global-search")).sendKeys("phone"+ Keys.ENTER);
    ReusableMethods.bekle(1);
    String unExpectedAramaSonucu ="0 Product Found";
    String actualAramaSonucu = driver.findElement(By.className("product-count-text")).getText();
Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

    }
// 3. test: bulunan ürünlerin ilkine tıklayıp, açılan ürün sayfasındaki ürün isminde case
//          sensitive olmadan "phone" kelimesi bulunduğunu test edin
@Test(dependsOnMethods = "Test2")
    public void Test3(){
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();
        String expectedPhone ="phone";
        String actualPhone = driver.findElement(By.xpath(" //*[@class=' heading-sm mb-4']")).getText().toLowerCase();
        Assert.assertTrue(actualPhone.contains(expectedPhone));

}



}



