package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "json:target/cucumber.json",
        "pretty",
        "html:target/cucumber-reports.html",
        "rerun:target/rerun.txt",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber"
},
       // features = "src/test/resources/features",
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = false, // true to get snippets (run feature file), false - run relevant step_definitions class
        tags = "@first",
        publish = true
)

public class CukesRunner {


}
