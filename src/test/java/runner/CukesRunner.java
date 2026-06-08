package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // that tag need to run Cucumber class with JUNIT
@CucumberOptions(plugin = { // that tag used to to customize the running of the cucumber tests

        "json:target/cucumber.json",
        "pretty",//
        "html:target/cucumber-reports.html",
        "rerun:target/rerun.txt",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber"

},
        features = "src/test/resources/features",
        glue = "step_definitions",


        dryRun = false, // true to get snippets (run feature file), false - run relevant step_definitions class
        tags = "first_login",
        publish = true
)

public class CukesRunner {


}
