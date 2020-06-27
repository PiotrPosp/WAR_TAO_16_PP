package Zadanie1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/FeaturesZadanie1/",
        plugin = {"pretty","html:out"})

public class BDDZadanie1Test {
}









