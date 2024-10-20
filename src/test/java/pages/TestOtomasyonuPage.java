package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    /*
     Bir page class'i ilk defa oluşturulurken ilk yapılması gereken şey
     kullanılan WebDriver'i bu class'a tanıtmaktır.

     WebDriver'i class'a tanıtmak için constructor'ı görünür hale getirip
     içerisinde initElements() kullanılır
    */
    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucuYaziElementi;

    @FindBy(xpath = "(//*[@class='prod-img'])[1]")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = " //*[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//a[@class='e-cart'])[1]")
    public WebElement accountLink;

    @FindBy(xpath = "//a[@class='sign-up ']")
    public WebElement signUpLink;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement signUpFormuFirstNameKutusu;

    @FindBy(id = "btn-submit-form")
    public WebElement signUpFormuSignUpButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginSayfasiPasswordKutusu;

    @FindBy(xpath = "//button[@id='submitlogin']")
    public WebElement loginSayfasiSignInButonu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutLink;


}
