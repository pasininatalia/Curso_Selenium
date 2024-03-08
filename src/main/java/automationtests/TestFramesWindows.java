package automationtests;

import static enums.ElementType.ID;
import static enums.ElementType.TAG_NAME;
import static utils.Alert.getTextAlertAndAccept;
import static utils.Element.clickOption;
import static utils.Element.writeText;
import static utils.Frame.changeWindow;
import static utils.Frame.closeFrame;
import static utils.Frame.openFrame;
import static utils.Utilities.driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import utils.Utilities;

public class TestFramesWindows {

	@Before
	public void before() { Utilities.createDriver();	}

	@After
	public void after() { driver.quit(); }

	@Test
	public void checkFrames() {
		openFrame("frame1");
		clickOption(ID, "frameButton");
		Assert.assertEquals("Frame OK!", getTextAlertAndAccept());
		closeFrame();
	}

	@Test
	public void checkWindow() {
		clickOption(ID, "buttonPopUpEasy");
		changeWindow("Popup");
		writeText(TAG_NAME, "textarea", "Deu certo?");
		driver.close();
		changeWindow("");
		writeText(TAG_NAME, "textarea", "E agora?");
	}

	@Test
	public void checkWindowHandle() {
		clickOption(ID,"buttonPopUpHard");
		System.out.println(driver.getWindowHandle()); //Traz o id da janela corrente
		System.out.println(driver.getWindowHandles()); //Traz a coleção de ids das janelas abertas
		changeWindow((String) driver.getWindowHandles().toArray()[1]);
		writeText(TAG_NAME, "textarea", "Deu certo?");
		changeWindow((String) driver.getWindowHandles().toArray()[0]);
		writeText(TAG_NAME, "textarea", "E agora?");
	}
}