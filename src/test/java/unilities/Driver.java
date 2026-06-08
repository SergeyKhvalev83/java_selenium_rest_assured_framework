package unilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    // singlton conception bellow
    // created private constructor, so we closing access to creating object of this class from another class

    private Driver() {
    }

    // making driver instance private, so it is not reachable outside that class
    // static because we will use it in static method, and we want it run before anything else


    // create reusable utility method which will return same driver instance when call it

   // private static WebDriver driver; // first time it will be null interchanged that to  private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>() in ordr to setup ability to use parallet testing

    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        //depending on the browserType our switch statement will determine to open specific type of browser/driver
        if (driverPool.get() == null) {
            String browserType = "";
            if(System.getProperty("BROWSER") == null){
                 browserType = ConfigurationReader.getProperty("browser").toLowerCase();

            } else {
                browserType = System.getProperty("BROWSER");// value of BROWSER come from maven runner command in case if need run execution in SELENIUmGRID
            }

            switch (browserType) {

                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "107.22.49.0";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "107.22.49.0";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions option=new ChromeOptions();
                    option.setHeadless(true);
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }

//same driver instance will be return every time we call Driver.getDriver() method
        return driverPool.get();
    }

// we use that method to close opened driver
public static void closeDriver (){
       if (driverPool.get()!= null) {
           driverPool.get().quit(); // this line kill the current session, value will NOT null, because driver object still exist
           driverPool.remove(); //- we assign driver object value NULL, now driver is null
       }
}
}
