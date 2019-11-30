package zy.accesurl;

import com.sun.deploy.net.proxy.*;
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
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kaiser_zhao on 2/2/18.
 */
public class TestWebdriverDynamicProxy {

    public static final void main(String... strings){

        System.setProperty("java.security.policy" , "policy.all");

        // dynamic proxy which can use auto config script
        BrowserProxyInfo b = new BrowserProxyInfo();
        b.setType(ProxyType.AUTO);
        b.setAutoConfigURL("http://wpad.uk.oracle.com/wpad.dat");
        SunAutoProxyHandler handler = new SunAutoProxyHandler();
        try {
            handler.init(b);
        } catch (ProxyConfigException e) {
            e.printStackTrace();
        } finally {
        }

        URL url = null;
        try {
            url = new URL("https://tenant1.idcs.internal.oracle.com:8943/ui/v1/adminconsole");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            ProxyInfo[] ps = handler.getProxyInfo(url);
            for(ProxyInfo p : ps){
                System.out.println(p.toString());
            }
        } catch (ProxyUnavailableException e) {
            e.printStackTrace();
        }
    }
}
