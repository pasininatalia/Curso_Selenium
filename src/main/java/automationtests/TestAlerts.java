package automationtests;

import static enums.ElementType.ID;
import static utils.Element.clickOption;
import static utils.Alert.*;
import static utils.Utilities.driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import utils.Utilities;

public class TestAlerts {

	@Before
	public void before() {
		Utilities.createDriver();
	}

	@After
	public void after() {
		driver.quit();
	}

	@Test
	public void checkSimpleAlert() {
		clickOption(ID, "alert");
		Assert.assertEquals("Alert Simples", getTextAlertAndAccept());
	}

	@Test
	public void checkConfirmAlert() {
		clickOption(ID, "confirm");
		Assert.assertEquals("Confirm Simples", getTextAlertAndAccept());
		Assert.assertEquals("Confirmado", getTextAlertAndAccept());
	}

	@Test
	public void checkToDenyAlert() {
		clickOption(ID, "confirm");
		Assert.assertEquals("Confirm Simples", getTextAlertAndDimiss());
		Assert.assertEquals("Negado", getTextAlertAndDimiss());
	}

	@Test
	public void checkPromptConfirmAlert() {
		clickOption(ID, "prompt");
		Assert.assertEquals("Digite um numero", getTextAlert());
		utils.Alert.writeTextAlert("13");
		Assert.assertEquals("Era 13?", getTextAlertAndAccept());
		Assert.assertEquals(":D", getTextAlertAndAccept());

	}

	@Test
	public void checkPromptToDenyAlert() {
		clickOption(ID, "prompt");
		Assert.assertEquals("Digite um numero", getTextAlert());
		utils.Alert.writeTextAlert("13");
		Assert.assertEquals("Era 13?", getTextAlertAndDimiss());
		Assert.assertEquals(":(", getTextAlertAndDimiss());
	}
}
