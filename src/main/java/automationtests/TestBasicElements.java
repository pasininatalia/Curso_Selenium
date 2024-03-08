package automationtests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utilities;

import java.util.List;

import static enums.ElementType.CLASS_NAME;
import static enums.ElementType.LINK_TEXT;
import static enums.ElementType.ID;
import static enums.ElementType.TAG_NAME;
import static utils.Element.clickOption;
import static utils.Element.getTextField;
import static utils.Element.getValueCombobox;
import static utils.Element.getFieldValue;
import static utils.Element.selectionComboboxVisibleText;
import static utils.Element.validateSelection;
import static utils.Element.writeText;
import static utils.Utilities.driver;

public class TestBasicElements {

	@Before
	public void before() {
		Utilities.createDriver();
	}

	@After
	public void after() {
		driver.quit();
	}

	@Test
	public void checkWriteTextField() {
		writeText(ID, "elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", getFieldValue(ID, "elementosForm:nome"));
	}

	@Test
	public void checkWriteTextArea() {
		writeText(ID, "elementosForm:sugestoes", "Teste");
		Assert.assertEquals("Teste", getFieldValue(ID, "elementosForm:sugestoes"));
	}

	@Test
	public void checkSelectionRadioButton() {
		clickOption(ID, "elementosForm:sexo:0");
		Assert.assertTrue(validateSelection(ID, "elementosForm:sexo:0"));
	}

	@Test
	public void checkSelectionCheckBox() {
		clickOption(ID, "elementosForm:comidaFavorita:2");
		Assert.assertTrue(validateSelection(ID, "elementosForm:comidaFavorita:2"));
	}

	@Test
	public void checkSelectionComboBox() {
		selectionComboboxVisibleText(ID, "elementosForm:escolaridade", "Especializacao");
		Assert.assertEquals("Especializacao", getValueCombobox(ID, "elementosForm:escolaridade"));
	}

	@Test //Por enquanto não será mexido
	public void checkOptionsComboBox() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean find = options.stream().anyMatch(option -> option.getText().equals("Mestrado"));
		System.out.println(find);

//		boolean find = false;
//		for (WebElement option: options){
//			if (option.getText().equals("Mestrado")){
//				find = true;
//				break;
//			}
//		}

		Assert.assertTrue(find);
	}

	@Test //Por enquanto não será totalmente finalizado
	public void checkSelectionComboBoxMultiple() {
		selectionComboboxVisibleText(ID, "elementosForm:esportes", "Natacao");
		selectionComboboxVisibleText(ID, "elementosForm:esportes", "Karate");
		selectionComboboxVisibleText(ID, "elementosForm:esportes", "Futebol");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

		combo.deselectByVisibleText("Futebol");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}

	@Test
	public void clickOnChangeButtonName() {
		clickOption(ID, "buttonSimple");
		Assert.assertEquals("Obrigado!", getFieldValue(ID, "buttonSimple"));
	}

	@Test
	public void clickLink() {
		clickOption(LINK_TEXT, "Voltar");
		Assert.assertEquals("Voltou!", getTextField(ID, "resultado"));
	}

	@Test
	public void checkTitle() {
		//Busca por inspeção de elemento título do html
		Assert.assertEquals("Campo de Treinamento", getTextField(TAG_NAME, "H3"));

		//Busca por inspeção de classe, pois a frase encontra-se em uma estrutura que não é única na página
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", getTextField(CLASS_NAME, "facilAchar"));

	}
}
