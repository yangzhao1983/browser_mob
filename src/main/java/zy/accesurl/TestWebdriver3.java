package zy.accesurl;


import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriver3 {

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
//
//        // set chained
//        InetSocketAddress inetsockaddr = new InetSocketAddress("www-proxy.uk.oracle.com", 80);
////        proxy.setChainedProxy(inetsockaddr);
//        proxy.setTrustAllServers(true);
////        try {
//            proxy.start(0);
////        } catch (UnknownHostException e) {
////            e.printStackTrace();
////        } finally {
////        }
//        System.out.println(proxy.getPort());
//        System.out.println(proxy.getClientBindAddress().getHostName());
//
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//        int port = proxy.getPort();
//
////        firefoxProfile.setPreference("network.proxy.ssl_port", port);
////        firefoxProfile.setPreference("network.proxy.ssl", "localhost");
////        firefoxProfile.setPreference("network.proxy.ssl_port", port);
////        firefoxProfile.setPreference("network.proxy.ftp", "localhost");
////        firefoxProfile.setPreference("network.proxy.ftp_port", port);
////        firefoxProfile.setPreference("network.proxy.share_proxy_settings", true);
//        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//
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
//
//        // access url
//        WebDriver driver = null;
//        try {
//            proxy.newHar("yahoo.com");
//            driver = new FirefoxDriver(capabilities);
//    //        driver.get("https://www.baidu.com");
//            //Thread.sleep(90000);
//            driver.get("https://tenant1.idcs.internal.oracle.com:8943/ui/v1/adminconsole");
//            Thread.sleep(800000);
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
