package automationtests;

import static enums.Education.ESPECIALIZACAO;
import static enums.ElementType.ID;
import static enums.FavoriteFood.PIZZA;
import static enums.Gender.FEMALE;
import static enums.Sports.NATACAO;
import static utils.Utilities.driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageObjects.TrainingCampPage;
import utils.Utilities;

public class FormSubmission {

	@Before
	public void before() {
		Utilities.createDriver();
	}

	@After
	public void after() {
		driver.quit();
	}

	@Test
	public void submission() {
		TrainingCampPage.setFirstName(ID, "Nataline");
		TrainingCampPage.setLastName(ID, "Pasini");
		TrainingCampPage.setGender(ID, FEMALE);
		TrainingCampPage.setFavoriteFood(ID,PIZZA);
		TrainingCampPage.setEducation(ID, ESPECIALIZACAO);
		TrainingCampPage.setSports(ID, NATACAO);
		TrainingCampPage.register(ID);

		Assert.assertTrue(TrainingCampPage.getResults().startsWith("Cadastrado!"));
		Assert.assertTrue(TrainingCampPage.getFirstName().endsWith("Nataline"));
		Assert.assertTrue(TrainingCampPage.getLastName().endsWith("Pasini"));
		Assert.assertEquals("Sexo: Feminino", TrainingCampPage.getGender());
		Assert.assertEquals("Comida: Pizza", TrainingCampPage.getFavoriteFood());
		Assert.assertEquals("Escolaridade: especializacao", TrainingCampPage.getEducation());
		Assert.assertEquals("Esportes: Natacao", TrainingCampPage.getSports());
	}
}
