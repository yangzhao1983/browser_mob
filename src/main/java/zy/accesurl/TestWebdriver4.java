package zy.accesurl;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
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
public class TestWebdriver4 {

    public static By signinBasicSigninFormUsernameLocator = By.id("idcs-signin-basic-signin-form-username");
    public static By signinBasicSigninFormPasswordLocator = By.id("idcs-signin-basic-signin-form-password");
    public static By signinBasicSigninFormSubmitLocator = By.id("idcs-signin-basic-signin-form-submit");

    public static final void main(String... strings){

//        // create a CA Root Certificate using default settings
//        RootCertificateGenerator rootCertificateGenerator = RootCertificateGenerator.builder().build();
//
//        // save the newly-generated Root Certificate and Private Key -- the .cer file can be imported
//        // directly into a browser
//        rootCertificateGenerator.saveRootCertificateAsPemFile(new File("/Users/kaiser_zhao/my.cer"));
//        rootCertificateGenerator.savePrivateKeyAsPemFile(new File("/tmp/private-key.pem"), "password");
//
//        rootCertificateGenerator.saveRootCertificateAndKey("PKCS12", new File("/tmp/keystore.p12"),
//                "privateKeyAlias", "password");
//
//        // tell the ImpersonatingMitmManager  use the RootCertificateGenerator we just configured
//        ImpersonatingMitmManager mitmManager = ImpersonatingMitmManager.builder()
//                .rootCertificateSource(rootCertificateGenerator)
//                .build();
//
//        // tell LittleProxy to use the ImpersonatingMitmManager when MITMing
//        HttpProxyServerBootstrap bootstrap = DefaultHttpProxyServer.bootstrap()
//                .withManInTheMiddle(mitmManager);
//
//
//
        FirefoxProfile firefoxProfile  = new FirefoxProfile();
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        // set binary
        File pathToFirefoxBinary = new File("/Applications/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
        capabilities.setCapability(FirefoxDriver.BINARY, binary);
        firefoxProfile.setPreference(FirefoxProfile.ALLOWED_HOSTS_PREFERENCE, "localhost.localdomain");


        // start mob proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.setMitmManager(mitmManager);

//        // set chained
        InetSocketAddress inetsockaddr = new InetSocketAddress("www-proxy.uk.oracle.com", 80);
        proxy.setChainedProxy(inetsockaddr);
//
////        try {
//        proxy.setConnectTimeout(120, TimeUnit.SECONDS);
//        proxy.setRequestTimeout(120, TimeUnit.SECONDS);
//        proxy.setTrustAllServers(true);
//            proxy.start(0);
////        } catch (UnknownHostException e) {
////            e.printStackTrace();
////        } finally {
////        }

        proxy.setTrustAllServers(true);
        proxy.start(0);

        System.out.println(proxy.getPort());
        System.out.println(proxy.getClientBindAddress().getHostName());

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        int port = proxy.getPort();

        firefoxProfile.setPreference("network.proxy.type", 1);
        firefoxProfile.setPreference("network.proxy.http", proxy.getClientBindAddress().getHostName());
        firefoxProfile.setPreference("network.proxy.http_port", port);
        firefoxProfile.setPreference("network.proxy.ssl", proxy.getClientBindAddress().getHostName());
        firefoxProfile.setPreference("network.proxy.ssl_port", port);
        firefoxProfile.setPreference("network.proxy.autoconfig_url", "http://wpad.uk.oracle.com/wpad.dat");
        firefoxProfile.setPreference("network.proxy.ssl", "localhost");
        firefoxProfile.setPreference("network.proxy.ssl_port", port);
        firefoxProfile.setPreference("network.proxy.ftp", "localhost");
        firefoxProfile.setPreference("network.proxy.ftp_port", port);
        firefoxProfile.setPreference("network.proxy.share_proxy_settings", true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////
//        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // access url
        WebDriver driver = null;
        try {
            proxy.newHar("yahoo.com");

            driver = new FirefoxDriver(capabilities);
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//            driver.get("http://www.baidu.com");
            driver.get("http://www.baidu.com");
            Thread.sleep(30000);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // get the HAR data
            Har har = proxy.getHar();
            try {
                har.writeTo(new File("my1.har"));

            } catch (IOException e) {
                e.printStackTrace();
            }
            driver.quit();
            proxy.stop();
        }
    }
}
