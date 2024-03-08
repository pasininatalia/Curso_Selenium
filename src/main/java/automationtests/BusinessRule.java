package automationtests;

import static enums.ElementType.ID;
import static enums.FavoriteFood.MEAT;
import static enums.FavoriteFood.PIZZA;
import static enums.FavoriteFood.VEGETARIAN;
import static enums.Gender.FEMALE;
import static enums.Sports.NATACAO;
import static enums.Sports.O_QUE_E_ESPORTE;
import static utils.Alert.getTextAlertAndAccept;
import static utils.Utilities.driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageObjects.TrainingCampPage;
import utils.Utilities;

public class BusinessRule {

	@Before
	public void before() {
		Utilities.createDriver();
	}

	@After
	public void after() { driver.quit(); }

	@Test
	public void validateFirstNameEmpty() {
		TrainingCampPage.register(ID);
		Assert.assertEquals("Nome eh obrigatorio", getTextAlertAndAccept());
	}

	@Test
	public void validateLastNameEmpty() {
		TrainingCampPage.setFirstName(ID, "Nataline");
		TrainingCampPage.register(ID);
		Assert.assertEquals("Sobrenome eh obrigatorio", getTextAlertAndAccept());
	}

	@Test
	public void validateGenderNotSelect() {
		TrainingCampPage.setFirstName(ID, "Nataline");
		TrainingCampPage.setLastName(ID, "Pasini");
		TrainingCampPage.register(ID);
		Assert.assertEquals("Sexo eh obrigatorio", getTextAlertAndAccept());
	}

	@Test
	public void validateFavoriteFood() {
		TrainingCampPage.setFirstName(ID, "Nataline");
		TrainingCampPage.setLastName(ID, "Pasini");
		TrainingCampPage.setGender(ID, FEMALE);
		TrainingCampPage.setFavoriteFood(ID, MEAT);
		TrainingCampPage.setFavoriteFood(ID, VEGETARIAN);
		TrainingCampPage.register(ID);
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", getTextAlertAndAccept());
	}

	@Test
	public void validateSports() {
		TrainingCampPage.setFirstName(ID, "Nataline");
		TrainingCampPage.setLastName(ID, "Pasini");
		TrainingCampPage.setGender(ID, FEMALE);
		String value = """
            dadada
			dawdawda""";
		TrainingCampPage.setFavoriteFood(ID, MEAT);
		TrainingCampPage.setFavoriteFood(ID, PIZZA);
		TrainingCampPage.setSports(ID, NATACAO, O_QUE_E_ESPORTE);
		TrainingCampPage.register(ID);
		Assert.assertEquals("Voce faz esporte ou nao?", getTextAlertAndAccept());
	}
}