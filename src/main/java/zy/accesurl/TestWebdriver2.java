package zy.accesurl;

//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.har.Har;
//import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriver2 {

    public static final void main(String... strings){
//
//        FirefoxProfile firefoxProfile  = new FirefoxProfile();
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//
//        // set binary
//        File pathToFirefoxBinary = new File("/Applications/Firefox.app/Contents/MacOS/firefox");
//        FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
//        capabilities.setCapability(FirefoxDriver.BINARY, binary);
//        firefoxProfile.setPreference(FirefoxProfile.ALLOWED_HOSTS_PREFERENCE, "localhost.localdomain");
//
//
//        // start mob proxy
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
////        try {
//            proxy.start(0);
////        } catch (UnknownHostException e) {
////            e.printStackTrace();
////        } finally {
////        }
//        System.out.println(proxy.getPort());
//        System.out.println(proxy.getClientBindAddress().getHostName());
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//        int port = proxy.getPort();
//        firefoxProfile.setPreference("network.proxy.type", 1);
//        firefoxProfile.setPreference("network.proxy.http", proxy.getClientBindAddress().getHostName());
//        firefoxProfile.setPreference("network.proxy.http_port", port);
////        firefoxProfile.setPreference("network.proxy.ssl", "localhost");
////        firefoxProfile.setPreference("network.proxy.ssl_port", port);
////        firefoxProfile.setPreference("network.proxy.ftp", "localhost");
////        firefoxProfile.setPreference("network.proxy.ftp_port", port);
////        firefoxProfile.setPreference("network.proxy.share_proxy_settings", true);
//
//        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//        // access url
//        WebDriver driver = null;
//        try {
//            proxy.newHar("yahoo.com");
//            driver = new FirefoxDriver(capabilities);
//            driver.get("http://www.baidu.com");
//            Thread.sleep(3000);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            // get the HAR data
//            Har har = proxy.getHar();
//
//            try {
//                har.writeTo(new File("my.har"));
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            driver.quit();
//            proxy.stop();
//        }
    }
}
