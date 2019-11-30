package zy.accesurl;

//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.har.Har;
//import net.lightbody.bmp.mitm.RootCertificateGenerator;
//import net.lightbody.bmp.mitm.manager.ImpersonatingMitmManager;
//import net.lightbody.bmp.proxy.CaptureType;
//import org.littleshoot.proxy.HttpProxyServerBootstrap;
//import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
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
public class TestWebdriverOnlyOraProxy {

    public static final void main(String... strings){

        FirefoxProfile firefoxProfile  = new FirefoxProfile();
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        // set binary
        File pathToFirefoxBinary = new File("/Applications/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
        capabilities.setCapability(FirefoxDriver.BINARY, binary);
        firefoxProfile.setPreference(FirefoxProfile.ALLOWED_HOSTS_PREFERENCE, "localhost.localdomain");


        firefoxProfile.setPreference("network.proxy.type", 1);
        firefoxProfile.setPreference("network.proxy.http", "www-proxy.uk.oracle.com");
        firefoxProfile.setPreference("network.proxy.http_port", 80);
        firefoxProfile.setPreference("network.proxy.no_proxies_on", "localhost");
        firefoxProfile.setPreference("security.use_mozillapkix_verification", true);
//         firefoxProfile.setPreference("network.proxy.ssl", "www-proxy.uk.oracle.com");
//        firefoxProfile.setPreference("network.proxy.ssl_port", 80);
        firefoxProfile.setPreference("network.proxy.autoconfig_url", "http://wpad.uk.oracle.com/wpad.dat");
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // access url
        WebDriver driver = null;
        try {
            driver = new FirefoxDriver(capabilities);
            //driver.get("http://www.baidu.com");
            driver.get("https://tenant1.idcs.internal.oracle.com:8943/ui/v1/adminconsole");
            Thread.sleep(30000);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
