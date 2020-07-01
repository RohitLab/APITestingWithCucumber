package com.Aress.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Workspace\\ApiWithCumcumber\\src\\test\\java\\com\\Aress\\Features",
		glue = "com.Aress.stepDefination",
		strict = true,
		monochrome = true,
		dryRun = false
		//tags={"@login,@login2","@login3","@login1"}
		)
public class TestRunner {

}
