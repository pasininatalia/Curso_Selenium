package automationtests;

import static enums.ElementType.ID;
import static utils.Alert.getTextAlertAndAccept;
import static utils.Utilities.driver;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import pageObjects.TrainingCampPage;
import utils.Utilities;

//Não está funcionando
@RunWith(Parameterized.class)
public class ParameterizedBusinessRuleTests {

	@Parameterized.Parameter
	public static String firstName;

	@Parameterized.Parameter(value = 1)
	public static String lastName;

	@Parameterized.Parameter(value = 2)
	public static String message;

	@Before
	public void before() {
		Utilities.createDriver();
	}

	@After
	public void after() { driver.quit(); }

	public static Collection<Object[]> validateCollection() {
		return Arrays.asList(
				new Object[] {"", "", "", "Nome eh obrigatorio"},
				new Object[] { "Nataline", "", "", "Sobrenome eh obrigatorio" },
				new Object[] {"Nataline", "Pasini", "", "Sexo eh obrigatorio"}
		);
	}
	@Test
	public static void validateGenderNotSelect() {
		TrainingCampPage.setFirstName(ID, firstName);
		TrainingCampPage.setLastName(ID, lastName);
		TrainingCampPage.register(ID);
		Assert.assertEquals(message, getTextAlertAndAccept());
	}
}
