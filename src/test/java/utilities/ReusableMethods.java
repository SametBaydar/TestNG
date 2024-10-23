package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDondur(List<WebElement> elementList){

        List<String> metinListesi = new ArrayList<>();
        for (WebElement each : elementList){
            metinListesi.add(each.getText());
        }
        return metinListesi;
    }

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        }catch (InterruptedException e){

        }

    }

    public static void handleSayfaDegister(WebDriver driver, String icerik){
        Set<String> handleList = (driver.getWindowHandles());
        for (String each:handleList){
            driver.switchTo().window(each);
            if (driver.getTitle().contains(icerik)){
                break;
            }
        }

    }

    public static void tumSayfaScreenShots (WebDriver driver){
        String dosyaYolu = "target/screenshots/tumSayfa.png";
        File sayfaResmi = new File(dosyaYolu);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResim,sayfaResmi);
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadı");
        }

    }
    public static void tumSayfaScreenShots2 (WebDriver driver, String raporIsmi){
        String dosyaYolu = "target/screenshots/" + raporIsmi + ".png";
        File sayfaResmi = new File(dosyaYolu);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResim,sayfaResmi);
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadı");
        }

    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}





