package zy.accesurl;

//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.har.Har;
//import net.lightbody.bmp.proxy.CaptureType;
//import org.littleshoot.proxy.HttpProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriver {

    public static By signinBasicSigninFormUsernameLocator = By.id("idcs-signin-basic-signin-form-username");
    public static By signinBasicSigninFormPasswordLocator = By.id("idcs-signin-basic-signin-form-password");
    public static By signinBasicSigninFormSubmitLocator = By.id("idcs-signin-basic-signin-form-submit");


    public static final void main(String... strings){

//        FirefoxProfile firefoxProfile  = new FirefoxProfile();
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//
//        // set binary
//        File pathToFirefoxBinary = new File("/Applications/Firefox.app/Contents/MacOS/firefox");
//        FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
//        capabilities.setCapability(FirefoxDriver.BINARY, binary);
//
//        // set proxy
//        firefoxProfile.setPreference(FirefoxProfile.ALLOWED_HOSTS_PREFERENCE, "localhost.localdomain");
//
//        // can work in local machine
////        firefoxProfile.setPreference("network.proxy.type", 1);
////        firefoxProfile.setPreference("network.proxy.http", "www-proxy.uk.oracle.com");
////        firefoxProfile.setPreference("network.proxy.http_port", 80);
//
//        // can not work in local machine
////        firefoxProfile.setPreference("network.proxy.type", 2);
////        firefoxProfile.setPreference("network.proxy.autoconfig_url", "http://wpad.uk.oracle.com/wpad.dat");
////        firefoxProfile.setPreference("network.proxy.no_proxies_on", "localhost");
////        firefoxProfile.setPreference("security.use_mozillapkix_verification", true);
//        firefoxProfile.setAcceptUntrustedCertificates(true);
//        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
//
////        Proxy httpProxy = new Proxy();
////        httpProxy.setHttpProxy("www-proxy.uk.oracle.com:80");
////        httpProxy.setNoProxy("localhost");
////        capabilities.setCapability(CapabilityType.PROXY, httpProxy);
//
//        // start mob proxy
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
////        Socket socket = new Socket(httpProxy);
////        proxy.setChainedProxy(httpProxy.getSocksProxy());
////        InetSocketAddress inetsockaddr = new InetSocketAddress("www-proxy.uk.oracle.com", 80);
////        proxy.setChainedProxy(inetsockaddr);
//
//        InetAddress ip=null;
//        try {
//            ip = InetAddress.getByName("www-proxy.uk.oracle.com");
//            System.out.println("Host Name: "+ip.getHostName());
//            System.out.println("IP Address: "+ip.getHostAddress());
////            proxy.setChainedProxy(new InetSocketAddress(ip, 80));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        proxy.start(0);
//        System.out.println(proxy.getPort());
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        /** browser mob proxy can not use existing ip?*/
////        proxy.start(80,ip);
////        try {
////            proxy.start(8180,ip);
////
////        } catch (UnknownHostException e) {
////            e.printStackTrace();
////        }
//
//        int port = proxy.getPort(); // get the JVM-assigned port
//
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//        seleniumProxy.setNoProxy("localhost");
//
//        // manual proxy
//        // proxy set proxy
//
//        Proxy httpProxy = new Proxy();
//        httpProxy.setHttpProxy("www-proxy.uk.oracle.com:80");
//        httpProxy.setNoProxy("localhost");
//        httpProxy.setSocksProxy(proxy.getClientBindAddress().getHostName() + proxy.getPort());
//        capabilities.setCapability(CapabilityType.PROXY, httpProxy);
//
//     //   capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//
//        // set profile
//        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
//
//        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//
//
//        // access url
//        WebDriver driver = null;
//        try {
//
//            proxy.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS, CaptureType.RESPONSE_CONTENT);
//
//            proxy.newHar("com");
//
//            driver = new FirefoxDriver(capabilities);
//            //driver = new FirefoxDriver();
//
////            driver.get("http://www.baidu.com");
//            driver.get("https://tenant1.idcs.internal.oracle.com:8943/ui/v1/adminconsole");
////            Thread.sleep(10000);
////            driver.findElement(signinBasicSigninFormUsernameLocator).sendKeys("admin@oracle.com");
////            driver.findElement(signinBasicSigninFormPasswordLocator).sendKeys("Welc0me@1");
////
////            String js = "var sudoChangeEvent = new Event('HTMLEvents');"
////                    +"sudoChangeEvent.initEvent('change', true, true);"
////                    +"var username = document.getElementById('idcs-signin-basic-signin-form-username');"
////                    +"username.dispatchEvent(sudoChangeEvent);"
////                    +"var password = document.getElementById('idcs-signin-basic-signin-form-password');"
////                    +"password.dispatchEvent(sudoChangeEvent);";
////            ((JavascriptExecutor) driver).executeScript(js);
////
////            driver.findElement(signinBasicSigninFormSubmitLocator).click();
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
//
//            proxy.stop();
//        }
//        //       WebDriver driver = new FirefoxDriver();
//        // login
    }
}
