package AppiumClassFirst;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BiletiniASifreUnuttum {

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


        //Step 4 -- Kullanici Giris Yap butonuna tiklar
        AndroidElement girisYapButonu = driver.findElementById("com.DijitalSahne.Biletinial:id/btnLogin");
        girisYapButonu.click();
        Thread.sleep(2000);


        //Step 5 Kullanıcı Sifremi Unuttum butonuna tiklar
        AndroidElement sifremiUnuttum = driver.findElementById("com.DijitalSahne.Biletinial:id/tvForgotPasswd");
        sifremiUnuttum.click();
        Thread.sleep(2000);


        //Step 6 - kullanici sifremi unuttum sayfasina Email girer
        AndroidElement sifremiUnuttumEmailTExtBox = driver.findElementById("com.DijitalSahne.Biletinial:id/text_edit");
        sifremiUnuttumEmailTExtBox.sendKeys("halilibrahimyavuz07@gmail.com");
        Thread.sleep(2000);

        //Step7 - Kullanici Sifremi Unuttum sayfasindaki Gonder butonuna tiklar.
        AndroidElement sifremiUnuttumGonderButonu = driver.findElementById("com.DijitalSahne.Biletinial:id/tvUpdate");
        sifremiUnuttumGonderButonu.click();
        Thread.sleep(2000);


        //Step8 Kullanici Basarili olarak sifre sifirlama islemi yaptigini dogrular
        AndroidElement sifreSifirlamaBasariliText = driver.findElementById("android:id/alertTitle");
        String expectedSifirlamaText="Şifre Sıfırlama Başarılı";
        String actualSifirlamaText=sifreSifirlamaBasariliText.getText();
        System.out.println("actualSifirlamaText = " + actualSifirlamaText);
        Thread.sleep(2000);
        Assert.assertTrue(expectedSifirlamaText.contains(actualSifirlamaText));

        //Step 9- Kullanici Tamam butonuna tiklar.

        AndroidElement tamamButonu = driver.findElementById("android:id/button1");
        tamamButonu.click();
        Thread.sleep(2000);


        //Step 9 - Kullanici Sayfayi kapatir.
        Thread.sleep(5000);
        driver.quit();







    }
    }
