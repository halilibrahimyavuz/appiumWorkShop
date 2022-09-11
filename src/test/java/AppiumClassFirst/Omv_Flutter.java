package AppiumClassFirst;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Omv_Flutter {


    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Dijital Sahne\\Desktop\\appiumWorkShop-master\\src\\test\\java\\AppiumClassFirst\\APP\\ovm-flutter.apk");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);



        // //Step1  --
     //  WebElement location=driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
     //  String lacationText=location.getText();
     //  location.click();
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
}

