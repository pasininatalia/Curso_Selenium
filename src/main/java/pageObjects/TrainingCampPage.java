package pageObjects;

import static enums.ElementType.ID;
import static utils.Element.clickOption;
import static utils.Element.getTextField;
import static utils.Element.selectionComboboxVisibleText;
import static utils.Element.writeText;

import enums.Education;
import enums.ElementType;
import enums.FavoriteFood;
import enums.Gender;
import enums.Sports;

public class TrainingCampPage {

	public static void setFirstName(ElementType type, String firstName) {
		writeText(type, "elementosForm:nome",  firstName);
	}

	public static void setLastName(ElementType type, String lastName) {
		writeText(type,"elementosForm:sobrenome",lastName);
	}

	public static void setGender(ElementType type, Gender gender){
		switch (gender) {
			case MALE -> clickOption(type,"elementosForm:sexo:0");
			case FEMALE -> clickOption(type,"elementosForm:sexo:1");
		}
	}

	public static void setFavoriteFood(ElementType type, FavoriteFood food) {
		switch (food) {
			case MEAT -> clickOption(type, "elementosForm:comidaFavorita:0");
			case CHICKEN -> clickOption(type, "elementosForm:comidaFavorita:1");
			case PIZZA -> clickOption(type, "elementosForm:comidaFavorita:2");
			case VEGETARIAN -> clickOption(type, "elementosForm:comidaFavorita:3");
		}
	}

	public static void setEducation(ElementType type, Education education) {
		switch (education) {
			case PRIMEIRO_GRAU_INCOMP -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "1o grau incompleto");
			case PRIMEIRO_GRAU_COMP -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "1o grau completo");
			case SEGUNDO_GRAU_INCOMP -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "2o grau incompleto");
			case SEGUNDO_GRAU_COMP -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "2o grau completo");
			case SUPERIOR -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "Superior");
			case ESPECIALIZACAO -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "Especializacao");
			case MESTRADO -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "Mestrado");
			case DOUTORADO -> selectionComboboxVisibleText(type, "elementosForm:escolaridade", "Doutorado");
		}
	}

	public static void setSports(ElementType type, Sports... sports) {
		for(Sports sport: sports) {
			selectionComboboxVisibleText(type, "elementosForm:esportes", sport.getNome());
		}
	}

	public static void register(ElementType type) {
		clickOption(type, "elementosForm:cadastrar");
	}

	public static String getResults() {
		return getTextField(ID,"resultado");
	}

	public static String getFirstName() {
		return getTextField(ID,"descNome");
	}

	public static String getLastName() {
		return getTextField(ID,"descSobrenome");
	}

	public static String getGender() {
		return getTextField(ID,"descSexo");
	}

	public static String getFavoriteFood() {
		return getTextField(ID, "descComida");
	}

	public static String getEducation() {
		return getTextField(ID, "descEscolaridade");
	}
	public static String getSports() {
		return getTextField(ID, "descEsportes");
	}
}
