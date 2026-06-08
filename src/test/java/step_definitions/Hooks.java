package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import unilities.BrowserUtils;
import unilities.Driver;

public class Hooks { // works for all steps_definitions file
    //@before we can define order to run - @Before(order = 1), @Before (order = 2), so on

    // @Before
    // use @before from io cucumber, not from junit (because we do not have any code or test method in running class), need here only controlling before (pre-condition) scenario
    //  public void setupScenario() {
    //   System.out.println("Before Scenario running");
    // } we do not need it more


    @After
// use @After from io cucumber, not from junit (because we do not have any code or test method in running class), need here only controlling after (post-condition) scenario
    public void tearDownScenario(Scenario scenario) {
        // we will implement taking screenshot in this method


        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES); // make downcasting of our driver to TakeScreenshot intarface to reach getScreenshotAs(OutputType.BYTES)
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
        BrowserUtils.sleep(1);
        Driver.closeDriver();
    }

    //  @After (value = "@abc") we can apply @After  @Before to certain steps or scenario
    //public void tearDown (){
    /// code we need

}

// @Before(value = "@Hook")
//  public void setUpParticularFeature() {
//   System.out.println("Only for eating_cucumber.feature");
// apply for specific faeture or scenario and run before that aeture or scenario
// }

// @BeforeStep // use to run any pre-condition before each step of scenario
// public void setupScenarioStep(){
//      System.out.println("Each scenario step");

// }


