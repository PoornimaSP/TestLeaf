package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/java/featureFile",glue="stepdefnition")
public class RunCucumber extends AbstractTestNGCucumberTests{
	

}
