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

public class BiletiniAlUyeOlma {

    Faker faker=new Faker();


    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dijital Sahne\\Desktop\\appiumWorkShop-master\\src\\test\\java\\AppiumClassFirst\\APP\\biletinial.apk");

        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        //bu ikisi sistem acılınca default onaylar ıcın yapılan kodlardır
        // cmd ye abd shell ve sonra  dumpsys window | grep -E "mCurrentFocus" komutları yazarak package ve actıvıtylerı bulabilirız.
        // desiredCapabilities.setCapability("appPackage","com.google.android.permissioncontroller");
        // desiredCapabilities.setCapability("appActivity","com.android.packageinstaller.permission.ui.GrantPermissionsActivity");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.

        //no reset = app nin onaylarını verdım zaten resete atma ıznlerı aynen kabul et anlamında
       // desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);



        Thread.sleep(3000);
        AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);


        //Step1  --
        AndroidElement location=driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        location.click();
        Thread.sleep(3000);

         //Step2  --Kullanıcı sol taraftaki Menü butonuna tıklar
        AndroidElement menuButonu=driver.findElementById("com.DijitalSahne.Biletinial:id/ivMenu");
        menuButonu.click();
        Thread.sleep(3000);


        //Step3 -- Kulanıcı Giriş Sayfasına girdigini dogrular
        AndroidElement girisYapButonu=driver.findElementById("com.DijitalSahne.Biletinial:id/btnLogin");
        String girisYapText=girisYapButonu.getText();
        System.out.println("girisYapText = " + girisYapText);
        Assert.assertTrue(girisYapText.contains("Giriş Yap"));
        Thread.sleep(2000);

        //Step 4 -- Kullanici Giris Yap butonuna tiklar
        girisYapButonu.click();
        Thread.sleep(2000);

        //Step 5 --  Kullanici Giriş Yapin sayfasindaki UYE OL Butonuna tiklar
        WebElement uyeOlButonu=driver.findElementById("com.DijitalSahne.Biletinial:id/tvRegister");
        uyeOlButonu.click();
        Thread.sleep(2000);

        //Step 6  -- Kullanici Ücretsiz Kayit Olun sayfasindaki Adiniz bolumunu doldurur.
        WebElement adinizTextBox =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        adinizTextBox.sendKeys(faker.name().firstName());
        Thread.sleep(2000);

        //Step 7 -- Kullanici Ücretsiz Kayit Olun sayfasindaki Soyadi bolumunu doldurur.
        WebElement soyadinizTextBox =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        soyadinizTextBox.sendKeys(faker.name().lastName());
        Thread.sleep(2000);

        //Step 8-- Kullanici Ücretsiz Kayit Olun sayfasindaki E-posta Adresiniz bolumunu doldurur.
        WebElement ePostaTextBox =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        ePostaTextBox.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);

        //Step 9-- Kullanici Ücretsiz Kayit Olun sayfasindaki TelefonNumaraniz bolumunu doldurur.
        WebElement telefonTextBox =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        telefonTextBox.sendKeys("505"+faker.phoneNumber().cellPhone());
        Thread.sleep(2000);

        //Step 10 -- Kullanici il secer
        WebElement ilSelect=driver.findElementById("com.DijitalSahne.Biletinial:id/tv");
        ilSelect.click();
        Thread.sleep(2000);

            //*********Dropdown Handle ***********
        WebElement bursa=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]");
        bursa.click();
        Thread.sleep(2000);

        //Step 11 -- Kullanici Parola girer
        WebElement parolaTextBox=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        String parola="Ab123456.";
        parolaTextBox.sendKeys(parola);
        Thread.sleep(2000);

        //Step 12 -- Kullanici Parola Tekrar girer
        WebElement parolaTekrarTextBox=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
        parolaTekrarTextBox.sendKeys(parola);
        Thread.sleep(2000);


        //Step 13-- Kullanici Simdi Kayıt Ol butonuna tıklar
        WebElement simdiKayitOlButonu =driver.findElementById("com.DijitalSahne.Biletinial:id/btnRegister");
        simdiKayitOlButonu.click();
        Thread.sleep(2000);

        //Kullanici basarili olusturulmustur yazisini gormelidir.
        WebElement basariliKayitText=driver.findElementById("com.DijitalSahne.Biletinial:id/tvTitle");
        String actualBasariliKayittext=basariliKayitText.getText();
        System.out.println("actualBasariliKayittext = " + actualBasariliKayittext);
        Thread.sleep(2000);

        String expectedBasariliKayittext="Kullanıcınız başarıyla oluşturulmuştur.";
        Assert.assertTrue(actualBasariliKayittext.contains(expectedBasariliKayittext));
        Thread.sleep(2000);

        Assert.assertTrue(basariliKayitText.isDisplayed());

        //Step15- Kullanıcı tamam butonuna tiklar.
        WebElement tamamButonu=driver.findElementById("com.DijitalSahne.Biletinial:id/btnOk");
        tamamButonu.click();
        Thread.sleep(2000);


    }










    //   WebElement getStart=driver.findElementById("com.duolingo:id/introFlowNewUserButton");
    //   String yazi=getStart.getText();
    //   System.out.println("yazi = " + yazi);
    //   Thread.sleep(5000);
    //   getStart.click();
    //   Thread.sleep(5000);

    //   //Step 2-- English butonuna tıklar
    //   WebElement englishLearn=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.TextView\n");
    //   System.out.println("englishLearn.getText() = " + englishLearn.getText());
    //   englishLearn.click();
    //   Thread.sleep(2000);

    //   //Step 3 -- German butonuna tıklar
    //   WebElement germanSpeak=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.TextView");
    //   System.out.println("germanSpeak.getText() = " + germanSpeak.getText());
    //   JavascriptExecutor jse = (JavascriptExecutor) driver;
    //   // jse.executeScript("arguments[0].click();", germanSpeak);
    //   germanSpeak.click();
    //   Thread.sleep(2000);

    //   //Step 4 --- Ok butonun atıklar
    //   WebElement okButonu=driver.findElementById("android:id/button1");
    //   okButonu.click();

    //   //Step 5 -- Traverl butonun a tıklar
    //   WebElement travelButon=driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"travel\"]/android.widget.TextView");
    //   String travelText=travelButon.getText();
    //   System.out.println("travelText ---> " + travelText);


/*
        WebElement getStarterd = driver.findElementById("com.duolingo:id/introFlowNewUserButton");
        getStarterd.click();
        Thread.sleep(3000);
        WebElement getGerman = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView");
        getGerman.click();
        Thread.sleep(5000);
        WebElement getOther = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"other\"]/android.widget.TextView");
        getOther.click();
        Thread.sleep(4000);

        WebElement getReguler = driver.findElementById("com.duolingo:id/xpGoalOptionRegular");
        getReguler.click();
        Thread.sleep(4000);
        WebElement getCont = driver.findElementById("com.duolingo:id/xpGoalContinueButton");
        getCont.click();
        Thread.sleep(4000);
        WebElement getSome = driver.findElementById("com.duolingo:id/placementHeader");
        getSome.click();
        Thread.sleep(4000);
        WebElement getStartTest = driver.findElementById("com.duolingo:id/primaryButton");
        getStartTest.click();/////
*/
}

