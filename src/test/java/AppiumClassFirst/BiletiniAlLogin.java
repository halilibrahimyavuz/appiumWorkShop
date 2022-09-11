package AppiumClassFirst;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BiletiniAlLogin {

    Faker faker=new Faker();

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dijital Sahne\\Desktop\\appiumWorkShop-master\\src\\test\\java\\AppiumClassFirst\\APP\\biletinial.apk");

        //bu ikisi sistem acılınca default onaylar ıcın yapılan kodlardır
        // cmd ye abd shell ve sonra  dumpsys window | grep -E "mCurrentFocus" komutları yazarak package ve actıvıtylerı bulabilirız.
        // desiredCapabilities.setCapability("appPackage","com.DijitalSahne.Biletinial");
         // desiredCapabilities.setCapability("appActivity","com.biletinialflavors.biletinial.ui.activity.MainActivity");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.

        //no reset = app nin onaylarını verdım zaten resete atma ıznlerı aynen kabul et anlamında
         // desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);

        Thread.sleep(3000);
        AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);



        //Step1  --
        AndroidElement location = driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        location.click();
        Thread.sleep(3000);

        //Step2  --Kullanıcı sol taraftaki Menü butonuna tıklar
        AndroidElement menuButonu = driver.findElementById("com.DijitalSahne.Biletinial:id/ivMenu");
        menuButonu.click();
        Thread.sleep(3000);


        //Step3 -- Kulanıcı Giriş Sayfasına girdigini dogrular
        AndroidElement girisYapButonu = driver.findElementById("com.DijitalSahne.Biletinial:id/btnLogin");
        String girisYapText = girisYapButonu.getText();
        System.out.println("girisYapText = " + girisYapText);
        Assert.assertTrue(girisYapText.contains("Giriş Yap"));
        Thread.sleep(2000);

        //Step 4 -- Kullanici Giris Yap butonuna tiklar
        girisYapButonu.click();
        Thread.sleep(2000);

        //Step 5  Kullanici Giris Yapın sayfasindaki Email textboxi doldurur.
        AndroidElement emailTextBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        emailTextBox.sendKeys("Hay123456@gmail.com");
       // emailTextBox.sendKeys("halilibrahimyavuz07@gmail.com");
        Thread.sleep(2000);

        //Step6 -- Kulanici Sifre textboxi doldurur.
        AndroidElement sifreTextBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        sifreTextBox.sendKeys("Hay123456");
        Thread.sleep(2000);

        //Step7 - Kullanici Giris Yapin sayfasindaki Giris Yap butonuna tiklar.
        AndroidElement girisYapinSayfasiGirisYapButonu = driver.findElementById("com.DijitalSahne.Biletinial:id/tvLogin");
        girisYapinSayfasiGirisYapButonu.click();
        Thread.sleep(2000);

        //Step 8 - Kulanicinin basarili olarak giriş yaptigi dogrulanir.
        AndroidElement kullaniciAdiText=driver.findElementById("com.DijitalSahne.Biletinial:id/profileName");
        String expectedKullaniciAdi="Awdwad Waww1232";
        String actualKullaniciAdi=kullaniciAdiText.getText();
        Thread.sleep(2000);
        Assert.assertTrue(expectedKullaniciAdi.equals(actualKullaniciAdi));

        //Step 9 - Kullanici Sayfayi kapatir.
        Thread.sleep(5000);
        driver.quit();







    }
    }
