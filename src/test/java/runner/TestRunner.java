package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;;


@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps", "com.base"},
    plugin = {"pretty", "html:target/allureReport.html"},
    tags = "@bank"
)
public class TestRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios(); // parallel execution here
    }
}
