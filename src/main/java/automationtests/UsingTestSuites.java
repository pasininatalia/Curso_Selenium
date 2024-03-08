package automationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		BusinessRule.class,
		FormSubmission.class
})
public class UsingTestSuites {
}
