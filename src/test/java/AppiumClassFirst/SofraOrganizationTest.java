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

public class  SofraOrganizationTest {

    Faker faker=new Faker();


    @Test  //Kullanici Login olur ve Organizasyonları detaylayabilir.

    public void organizationTest() throws MalformedURLException, InterruptedException {
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

        //Step6 -- Kullanici acilan sayfadaki Organization butonuna tiklar.
        AndroidElement organizatinButonu=driver.findElementById("com.dijitalsahne.sofra:id/ll_navigate_organization");
        organizatinButonu.click();
        Thread.sleep(2000);

        //Step7 -- Kullanici Organization sayfasina geldigini dogrular
        AndroidElement organizatinPage=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
        String actualText="Organization";
        String expectedText=organizatinPage.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expectedText,actualText);

        //Step8 -- Kullanici ilk organizasyona tiklar.
        AndroidElement firstOrganization=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
        AndroidElement firstOrganizationNameText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        AndroidElement firstOrganizationDateText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]");

        String firstOrganizationName=firstOrganizationNameText.getText();
        System.out.println("firstOrganizationName = " + firstOrganizationName);
        Thread.sleep(2000);

        String firstOrganizationDate=firstOrganizationDateText.getText();
        System.out.println("firstOrganizationDate = " + firstOrganizationDate);
        Thread.sleep(2000);
        firstOrganization.click();

        Thread.sleep(2000);

        //Step9-- Kullanici organizasyon detayını karsılastırır.
        AndroidElement firstOrganizatinDetailNameText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.Spinner/android.widget.TextView");
        System.out.println("firstOrganizatinDetailNameText.getText() = " + firstOrganizatinDetailNameText.getText());
       
        AndroidElement firstOrganizatinDetailDateText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText");
        System.out.println("firstOrganizatinDetailDateText.getText()  = " + firstOrganizatinDetailDateText.getText() );
        Thread.sleep(2000);

        // ***  isimler dogrumu dogrula!!
        Assert.assertEquals(firstOrganizatinDetailNameText.getText(),firstOrganizationName);
        Thread.sleep(2000);

        // *** tarihler aynımı dogrula !!
      //  Assert.assertTrue(firstOrganizatinDetailDateText.getText().contains(firstOrganizationDate));
        Thread.sleep(2000);

        //Step10 -- Kullanici sayfayi kapatır.
        driver.quit();



    }



    }





