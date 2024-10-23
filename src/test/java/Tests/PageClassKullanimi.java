package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class PageClassKullanimi {
    /*
     POM de locate'ler page Class'larında olur
     ve page Class'ları obje oluşturularak kullanılır.
    */

    @Test(groups = {"Smoke"})
    public void aramaTest(){
        // testotomasyonu sayfasına gidin
        Driver.getDriver().get("https://testotomasyonu.com");

        // title'nin "testotomasyonu" içerdiğini test edin

        String expectedTitle ="Test Otomasyonu";
        String actualTitle = Driver.driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

       // phone için arama yapıp, ürün bulunabildiğini test edin

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone",Keys.ENTER);
            String unExpectedAramaSonucu ="0 Product Found";
            String actualAramaSonucu = testOtomasyonuPage.aramaSonucuYaziElementi.getText();
            Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

         // bulunan ürünlerin ilkine tıklayıp, açılan ürün sayfasındaki ürün isminde case
         // sensitive olmadan "phone" kelimesi bulunduğunu test edin

            testOtomasyonuPage.bulunanUrunElementleriList.get(0)
                                                          .click();
            String expectedPhone ="phone";
            String actualPhone = testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                        .getText()
                                                        .toLowerCase();
            Assert.assertTrue(actualPhone.contains(expectedPhone));

            Driver.quitDriver();
}
}

