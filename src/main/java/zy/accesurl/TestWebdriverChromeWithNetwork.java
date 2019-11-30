package zy.accesurl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriverChromeWithNetwork {

    public static final void main(String... strings){

        System.setProperty("webdriver.chrome.driver", "/Users/kaiser_zhao/Work/automation/chrome/chromedriver_2_35");


        WebDriver driver = null;

        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver();

        driver.get("https://tenant1.identity.env6.ociqa1.c9dev1.oc9qadev.com/ui/v1/adminconsole");

        //driver.get("https://www.baidu.com");
        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
        String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();

        System.out.println(netData);
    }
}
