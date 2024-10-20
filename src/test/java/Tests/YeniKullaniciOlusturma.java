package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class YeniKullaniciOlusturma {

    @Test
    public void YeniKullaniciOlusturmaTesti(){
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURLTestOtomasyon"));
        // account linkine tıklayın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        // SignUp linkine tıklayın
        testOtomasyonuPage.signUpLink.click();
        // Tüm bilgi kutularını tek tek locate etmek yerine actions class'ı tab yapıp geçiş yapılsın.
        // form kısmında isim ve soyisim için fake değerler girin
        // email ve password olarak configuration.properties dosyasında verilen
        // toGecerliEmail ve toGecerliPassword değerlerini girin
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        ReusableMethods.bekle(1);
        actions.click(testOtomasyonuPage.signUpFormuFirstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"))
                .perform();
        actions.moveToElement(testOtomasyonuPage.signUpFormuSignUpButonu).perform(); // signUpFormuSignUpButonu butonu görmek için aşağı kaydırdık

        // SignUp butonuna basın
        testOtomasyonuPage.signUpFormuSignUpButonu.click();
        // kaydın oluşturulduğunu test edin (login olup logout linkinin görünür olduğunu test edebiliriz)

        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        testOtomasyonuPage.loginSayfasiSignInButonu.click();


        Assert.assertTrue(testOtomasyonuPage.logoutLink.isDisplayed());
        ReusableMethods.bekle(1);

        // sayfayı kapatın
        Driver.quitDriver();
    }
}
