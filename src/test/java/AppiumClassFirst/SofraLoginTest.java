package AppiumClassFirst;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SofraLoginTest {

    Faker faker=new Faker();


    @Test  //Kullanici Login olur.
    public void loginTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dijital Sahne\\Desktop\\appiumWorkShop-master\\src\\test\\java\\AppiumClassFirst\\APP\\sofra.apk");


        Thread.sleep(3000);
        AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);
        Actions actions=new Actions(driver);

        //Step1  --Kullanici acilan sayfadaki Username alanina giris yapar. Username= gamze.aytac@dijitalsahne.com
        AndroidElement usernameTextBox=driver.findElementById("com.dijitalsahne.sofra:id/et_username");
        actions.doubleClick(usernameTextBox);
        Thread.sleep(3000);
        usernameTextBox.sendKeys("gamze.aytac@dijitalsahne.com");


        //Step2-- Kullanici Password textboxa password girirsi yapar.Password= 1234567890
        AndroidElement passwordTextBox=driver.findElementById("com.dijitalsahne.sofra:id/et_password");
        actions.doubleClick(passwordTextBox);
        Thread.sleep(3000);
        passwordTextBox.sendKeys("1234567890");

        //Step3 Kullanici Sözlesme okudum kutusuna tiklar.
        AndroidElement sozlesmeBox=driver.findElementById("com.dijitalsahne.sofra:id/cb");
        sozlesmeBox.click();
        Thread.sleep(2000);

        //Step4 -- Kullanici Aydınlanma Metni kutusuna tiklar.
        AndroidElement aydinlanmaMetniBox=driver.findElementById("com.dijitalsahne.sofra:id/cb_clarification");
        aydinlanmaMetniBox.click();
        Thread.sleep(2000);

        //Step 5 -- Kullanici Sing In butonuna tiklar.

        AndroidElement singInButonu=driver.findElementById("com.dijitalsahne.sofra:id/btn_login");
        singInButonu.click();
        Thread.sleep(2000);

        //Step6 -- Kulanici basarili giris yaptigini dogrular.
        AndroidElement welcomeText=driver.findElementById("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
        String actualText="Welcome";
        String expectedText=welcomeText.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expectedText,actualText);

        //Step7 -- Kullanici sayfayi kapatir.
        driver.quit();
    }



    }





