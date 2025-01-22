package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= { "src/test/java/FeatureFiles" },
		glue= {"StepApi"},
		dryRun=false,
		monochrome=true,
		tags = "@Personals",
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
public class RunnerTest extends AbstractTestNGCucumberTests{

}