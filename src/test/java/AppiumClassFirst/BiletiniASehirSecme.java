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

public class BiletiniASehirSecme {

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

        //Step2 - Kullanici sag ust taraftan konum ikonuna tiklar.
        AndroidElement sehirİkonu=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView");
        sehirİkonu.click();
        Thread.sleep(3000);



        //Step3 -- Kullanici İstanbul Avrupa secenegine tiklar
        AndroidElement istanbulAvrupa=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
        istanbulAvrupa.click();
        Thread.sleep(3000);

        //Step4 konum ikonundan secilen sehir gozükmelidir.
        AndroidElement seciliSehir=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
        Thread.sleep(3000);
        String expecteSehirText="İstanbul Avrupa";
        String actualSehirText=seciliSehir.getText();

        Assert.assertEquals(expecteSehirText,actualSehirText);
        Thread.sleep(3000);




    }

}

