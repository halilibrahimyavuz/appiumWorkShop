package AppiumClassFirst;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class ChromeA101 {




    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // chrome ile baglantı kursun ve chrome acsın dıye yazdıgımız bır komut
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        //chrome driver versiyonunu ındırdım ve drivers directory ıcıne attım path ını belırttımö
        desiredCapabilities.setCapability("chromedriverExecutable","C:\\Users\\Dijital Sahne\\Desktop\\appiumWorkShop-master\\drivers\\chromedriver.exe" );

        //no reset = app nin onaylarını verdım zaten resete atma ıznlerı aynen kabul et anlamında
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);

        Thread.sleep(3000);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);

        //Appiumda implıcıtlıyewait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // -----> https://appium.io/docs/en/writing-running-appium/web/mobile-web/
        // ----> appium chrome test --> hakkında bılgı verıyor
        //chrome versıyonları ---> https://chromedriver.storage.googleapis.com/index.html
        //            yada bu ---> https://chromedriver.chromium.org/downloads


        //Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.
        //
        //Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur. En az Web’de yapmak zorunlu.
        //- Senaryoya üye kaydı oluşturmadan devam edilecek.
        //- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
        //- Açılan ürünün siyah olduğu doğrulanır.
        //- Sepete ekle butonuna tıklanır.
        //- Sepeti Görüntüle butonuna tıklanır.
        //- Sepeti Onayla butonuna tıklanır.
        //- Üye olmadan devam et butonuna tıklanır.
        //- Mail ekranı gelir.
        //- Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
        //- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.

        //  Step1-- Kullanici A101 sayfasina gider.
        driver.get("https://www.a101.com.tr");

        //Step2 -Kullanici bildirim popupından Allow butonuna tiklar
        AndroidElement bildirimPopup=driver.findElementById("android:id/button1");
        bildirimPopup.click();
        Thread.sleep(3000);

        //Step  Kullanici Cerezleri onaylar
        AndroidElement cerezKabulEtButonu=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.TabWidget");
        cerezKabulEtButonu.click();
        Thread.sleep(3000);


        //Step - Kullanici Menü butonun tiklar
        AndroidElement menuButonu=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[1]/android.view.View[5]/android.view.View[1]");
        menuButonu.click();
        Thread.sleep(3000);



        //Step - Kulalnici, Giyim % Aksesuar sekmesine tiklar.
        AndroidElement giyimAksesuarSekmesi=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]");
        giyimAksesuarSekmesi.click();
        Thread.sleep(3000);


        //Step- kullanıcı Kadın İc Giyim sekmesine tiklar.



        //Step -kullanici Kadin Diz Alti Corap secenegine tiklar.


        // Step -- kullaniic İlk urune tiklar


        //Step Kullanici urunun Siyah renkli oldugunu8 dogrular.


        //Step-- Kullanici Sepete Ekle butonuna tiklar.


        //Step --Kullanici Sepeti Goruntule butonuna tiklar.


        //Step-- Kullanici Sepeti Onayl butonun atiklar.


        //Step -- Kullanici Uye Olmadan Devam et butonuna tiklar.


        //Step --Kuıllanici Mail ekranının geldıgını dogrular


        //Step --- Kullanici, mail adresini texctboxı dolduruur.


        //Step --







    }
    }
