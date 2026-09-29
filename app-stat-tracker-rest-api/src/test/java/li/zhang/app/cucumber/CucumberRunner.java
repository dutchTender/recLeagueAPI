package li.zhang.app.cucumber;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")// Points to src/test/resources/features
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "li.zhang.app_stat_tracker_rest_api.cucumber" // Scans li.zhang.cucumber AND all subpackages (like .steps)
)
public class CucumberRunner {
}
