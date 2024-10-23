package Tests;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test(groups = {"raporluSmoke"})
    public void pozitifLoginTesti(){
        extentTest = extentReports.createTest("Pozitif login testi",
                "Gecerli bilgilerle sisteme giris yapilabilmeli");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURLTestOtomasyon"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");

        TestOtomasyonuPage testotomasyonuPage = new TestOtomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLink
                .click();
        extentTest.info("account linkine basar");

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");

        //5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();
        extentTest.info("Login butonuna basarak login olur");

        //6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testotomasyonuPage.logoutLink.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",testotomasyonuPage.logoutLink);
        testotomasyonuPage.logoutLink.click();
        extentTest.info("Logout butonuna basarak sayfadan cikar");

        extentTest.info("Window'u kapatir");


    }


}