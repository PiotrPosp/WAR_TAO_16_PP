package Zadanie2;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/FeaturesZadanie2/",
        plugin = {"pretty","html:out"})


public class BDDZadanie2Test {
}
