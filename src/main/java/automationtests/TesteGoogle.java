package automationtests;

import utils.Utilities;
import org.junit.Assert;
import org.junit.Test;

import static utils.Utilities.driver;

public class TesteGoogle {
	@Test
	public void teste() {
		Utilities.createDriver();
//		driver.manage().window().setPosition(new Point(100,100));
//		driver.manage().window().setSize(new Dimension(1200,765));
		driver.manage().window().maximize();
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
