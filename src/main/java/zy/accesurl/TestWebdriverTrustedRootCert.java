package zy.accesurl;

//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.har.Har;
//
//import net.lightbody.bmp.mitm.TrustSource;
//import net.lightbody.bmp.mitm.manager.ImpersonatingMitmManager;
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
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriverTrustedRootCert {
    public static By signinBasicSigninFormUsernameLocator = By.id("idcs-signin-basic-signin-form-username");
    public static By signinBasicSigninFormPasswordLocator = By.id("idcs-signin-basic-signin-form-password");
    public static By signinBasicSigninFormSubmitLocator = By.id("idcs-signin-basic-signin-form-submit");

    public static final void main(String... strings){

        // your root CA certificate(s) may be in a Java KeyStore, a PEM-encoded File or String, or an X509Certificate
//        File pemEncodedCAFile = new  File("/Users/kaiser_zhao/idcs_09ydn");
//        TrustSource trustSource = TrustSource.defaultTrustSource().add(pemEncodedCAFile);

        // when using MITM+LittleProxy, use the trustAllServers() method, or set the TrustSource on the ImpersonatingMitmManager:
//        ImpersonatingMitmManager mitmManager = ImpersonatingMitmManager.builder()
//                .trustSource(trustSource) // use an explicit trust source, or:
//                .trustAllServers(true) // do not validate servers' certificates
//                .build();

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
//        // when using BrowserMob Proxy, use the .setTrustSource() method:
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        //proxy.setTrustSource(trustSource);
//        // or disable server certificate validation:
//        proxy.setTrustAllServers(true);
//
//
////        try {
//        proxy.setConnectTimeout(120, TimeUnit.SECONDS);
//        proxy.setRequestTimeout(120, TimeUnit.SECONDS);
//
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
//            //driver.get("http://www.baidu.com");
//            driver.get("https://tenant1.idcs.internal.oracle.com:8943/ui/v1/adminconsole");
//            Thread.sleep(5000);
//            driver.findElement(signinBasicSigninFormUsernameLocator).sendKeys("admin@oracle.com");
//            driver.findElement(signinBasicSigninFormPasswordLocator).sendKeys("Welc0me@1");
//            Thread.sleep(1000);
//            driver.findElement(signinBasicSigninFormSubmitLocator).click();
//            Thread.sleep(30000);
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
