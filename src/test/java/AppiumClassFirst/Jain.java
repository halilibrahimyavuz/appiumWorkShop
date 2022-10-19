package AppiumClassFirst;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Jain {

    Faker faker=new Faker();


    @Test  //Kullanici Login olur.
    public void loginTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 10 API 29");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dijital Sahne\\IdeaProjects\\appiumWorkShop-master\\src\\test\\java\\AppiumClassFirst\\APP\\jain.bayi.2.apk");


        Thread.sleep(3000);



        AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


       Actions actions=new Actions(driver);

        //Step1  --Kullanici acilan sayfadaki Email alanina giris yapar. Email = feyza.kurubas.95@gmail.com
           AndroidElement emailTextBox=driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]/android.view.View[1]/android.widget.EditText[1]");
            Thread.sleep(4000);
            emailTextBox.click();
            Thread.sleep(2000);
           emailTextBox.sendKeys("feyza.kurubas.95@gmail.com");
          Thread.sleep(2000);
             actions.sendKeys(Keys.TAB).perform();

     //      //Step2 -- Kullanici Password alanina giris yapar. Password= 123
             Thread.sleep(3000);
            AndroidElement password=driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]/android.widget.ScrollView[1]/android.widget.EditText[2]");
            Thread.sleep(3000);
            password.click();
             Thread.sleep(2000);
             password.sendKeys("123");


     //          //Step3 - Kullanici Login Butonuna tiklar.
              AndroidElement loginButton=driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]/android.widget.ScrollView[1]/android.widget.Button[1]");
              Thread.sleep(4000);
              loginButton.click();














     //   AndroidElement usernameTextBox=driver.findElementById("com.dijitalsahne.sofra:id/et_username");
     //   actions.doubleClick(usernameTextBox);w
     //   Thread.sleep(3000);
     //   usernameTextBox.sendKeys("gamze.aytac@dijitalsahne.com");


     //   //Step2-- Kullanici Password textboxa password girirsi yapar.Password= 1234567890
     //   AndroidElement passwordTextBox=driver.findElementById("com.dijitalsahne.sofra:id/et_password");
     //   actions.doubleClick(passwordTextBox);
     //   Thread.sleep(3000);
     //   passwordTextBox.sendKeys("1234567890");

     //   //Step3 Kullanici Sözlesme okudum kutusuna tiklar.
     //   AndroidElement sozlesmeBox=driver.findElementById("com.dijitalsahne.sofra:id/cb");
     //   sozlesmeBox.click();
     //   Thread.sleep(2000);

     //   //Step4 -- Kullanici Aydınlanma Metni kutusuna tiklar.
     //   AndroidElement aydinlanmaMetniBox=driver.findElementById("com.dijitalsahne.sofra:id/cb_clarification");
     //   aydinlanmaMetniBox.click();
     //   Thread.sleep(2000);

     //   //Step 5 -- Kullanici Sing In butonuna tiklar.

     //   AndroidElement singInButonu=driver.findElementById("com.dijitalsahne.sofra:id/btn_login");
     //   singInButonu.click();
     //   Thread.sleep(2000);

     //   //Step6 -- Kulanici basarili giris yaptigini dogrular.
     //   AndroidElement welcomeText=driver.findElementById("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
     //   String actualText="Welcome";
     //   String expectedText=welcomeText.getText();
     //   Thread.sleep(2000);
     //   Assert.assertEquals(expectedText,actualText);

     //   //Step7 -- Kullanici sayfayi kapatir.
     //   driver.quit();
    }



    }





