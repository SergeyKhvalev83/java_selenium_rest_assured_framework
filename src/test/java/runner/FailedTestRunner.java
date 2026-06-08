package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt", // @ sighn need because target folder and refreshed with every running,
        glue = "com/cydeo/step_definitions" // comes from package where all step_definitions classes -> provide path to step_definitions folder, where running files stored (source root)// glue run tghrough step_definitions package and run only failed lines

// this runner class will run only failed  scenarios

)
public class FailedTestRunner {

}
