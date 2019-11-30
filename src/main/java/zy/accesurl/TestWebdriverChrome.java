package zy.accesurl;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriverChrome {

    public static final void main(String... strings){

        System.setProperty("webdriver.chrome.driver", "/Users/kaiser_zhao/Work/automation/chrome/chromedriver_2_35");

        // start mob proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        WebDriver driver = null;
        Har har = null;
        try {

            proxy.setChainedProxy(new InetSocketAddress(InetAddress.getByName("www-proxy.uk.oracle.com"),80));

            proxy.setTrustAllServers(true);

            System.out.println(InetAddress.getLocalHost().toString());
            for(InetAddress ia : InetAddress.getAllByName("yangzhao-mac")){
                System.out.println(ia.toString());
            }
            proxy.start(8100, InetAddress.getLocalHost());
            //proxy.start(0);
            System.out.println(proxy.getPort());
            System.out.println(proxy.getClientBindAddress());
            System.out.println(proxy.getChainedProxy());
            System.out.println(proxy.getServerBindAddress());

            // get the Selenium proxy object
            System.out.println("============start");
            Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
            System.out.println(seleniumProxy.getFtpProxy());
            System.out.println(seleniumProxy.getHttpProxy());
            System.out.println(seleniumProxy.getSslProxy());
            System.out.println(seleniumProxy.getNoProxy());
            System.out.println(seleniumProxy.getProxyAutoconfigUrl());
            System.out.println(proxy.getClientBindAddress().getHostName());

            System.out.println(ClientUtil.getConnectableAddress());
            System.out.println("============end");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--proxy-server=" + proxy.getClientBindAddress().getHostName() + ":" + proxy.getPort());
            //options.addExtensions(new File("/Users/kaiser_zhao/Downloads/Proxy-SwitchyOmega-Chromium-2.5.15.crx"));

            DesiredCapabilities capabilities = 	DesiredCapabilities.chrome();
            capabilities.setCapability("myProxy", seleniumProxy);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new ChromeDriver(capabilities);

            // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
            proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
            // create a new HAR with the label "yahoo.com"
            proxy.newHar("yahoo.com");

            driver.get("https://tenant1.identity.env6.ociqa1.c9dev1.oc9qadev.com/ui/v1/adminconsole");

            //driver.get("https://www.baidu.com");

            // get the HAR data
            har = proxy.getHar();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            if(har!=null){
                try {
                    har.writeTo(new File("my.har"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
