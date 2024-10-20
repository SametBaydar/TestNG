package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DriverClassKullanimi {

    @Test
    public void test01(){
        // testotomasyonu sayfasına gidin

        Driver.getDriver().get("https://testotomasyonu.com");

        // url'nin "testotomasyonu" içerdiğini test edin

        String expectedURL ="testotomasyonu";
        String actualURL = Driver.driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));

        // sayfayı kapatın
        Driver.quitDriver();
    }

}
