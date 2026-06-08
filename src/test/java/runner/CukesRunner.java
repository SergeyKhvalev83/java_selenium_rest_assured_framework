package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // that tag need to run Cucumber class with JUNIT
@CucumberOptions(plugin = { // that tag used to to customize the running of the cucumber tests

        "json:target/cucumber.json", // for cucumber report???? Something from Mehmet
        "pretty",// to coloring console information,
        "html:target/cucumber-reports.html",// we define path and type of file for delivery reports, before : you see name of file
        "rerun:target/rerun.txt", // create file to keep there failed scenarios in order to rerun those failed scenarios (TC) after we fix ussuies, before : you see name of file
        "me.jvt.cucumber.report.PrettyReports:target/cucumber"//to use better maven cucumber reporting // do not forget add to POM XML relevant dependency, before : you see name of file  (report in overview-features.html)

}, // {} we put curly braces if we have more than one plugin
        features = "src/test/resources/features", // come from features folder - > provide path to feature folder, where features  will be located (content root)
        glue = "com/cydeo/step_definitions",// comes from package where all step_definitions classes -> provide path to step_definitions folder will be located (source root)// glue run tghrough step_definitions package
        dryRun = false, // true to get snippets (run feature file), false - run relevant step_definitions class
        tags = "@table",// help us to determine which scenario (s) need to run// will look for all features files where @smoke tag appear and run all of them. If no tags - it will run all features
        publish = true // will give link with report, if you need to share that report (that report will be destroyed automaticaly in next 24 hours; true you will get report, false (by default) - you will not get report
)

public class CukesRunner {


}
