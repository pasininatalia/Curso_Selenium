package utils;

import enums.ElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.Utilities.driver;

public class Element {

	private static final String VALUE = "value";

	private Element() {
	}

	public static void writeText(ElementType type, String idField, String text) {

		switch (type) {
			case ID -> driver.findElement(By.id(idField)).sendKeys(text);
			case TAG_NAME -> driver.findElement(By.tagName(idField)).sendKeys(text);
			case LINK_TEXT -> driver.findElement(By.linkText(idField)).sendKeys(text);
			case CSS -> driver.findElement(By.cssSelector(idField)).sendKeys(text);
			case XPATH -> driver.findElement(By.xpath(idField)).sendKeys(text);
			case CLASS_NAME -> driver.findElement(By.className(idField)).sendKeys(text);
		}
	}

	public static String getFieldValue(ElementType type, String idField) {
		return switch (type) {
			case ID -> driver.findElement(By.id(idField)).getAttribute(VALUE);
			case TAG_NAME -> driver.findElement(By.tagName(idField)).getAttribute(VALUE);
			case LINK_TEXT -> driver.findElement(By.linkText(idField)).getAttribute(VALUE);
			case CSS -> driver.findElement(By.cssSelector(idField)).getAttribute(VALUE);
			case XPATH -> driver.findElement(By.xpath(idField)).getAttribute(VALUE);
			case CLASS_NAME -> driver.findElement(By.className(idField)).getAttribute(VALUE);
			default -> null;
		};
	}

	public static String getTextField(ElementType type, String idField) {
		return switch (type) {
			case ID -> driver.findElement(By.id(idField)).getText();
			case TAG_NAME -> driver.findElement(By.tagName(idField)).getText();
			case LINK_TEXT -> driver.findElement(By.linkText(idField)).getText();
			case CSS -> driver.findElement(By.cssSelector(idField)).getText();
			case XPATH -> driver.findElement(By.xpath(idField)).getText();
			case CLASS_NAME -> driver.findElement(By.className(idField)).getText();
			default -> null;
		};
	}

	public static void clickOption(ElementType type, String idField) {
		switch (type) {
			case ID -> driver.findElement(By.id(idField)).click();
			case TAG_NAME -> driver.findElement(By.tagName(idField)).click();
			case LINK_TEXT -> driver.findElement(By.linkText(idField)).click();
			case CSS -> driver.findElement(By.cssSelector(idField)).click();
			case XPATH -> driver.findElement(By.xpath(idField)).click();
			case CLASS_NAME -> driver.findElement(By.className(idField)).click();
		}
	}

	public static boolean validateSelection(ElementType type, String idField) {
		return switch (type) {
			case ID -> driver.findElement(By.id(idField)).isSelected();
			case TAG_NAME -> driver.findElement(By.tagName(idField)).isSelected();
			case LINK_TEXT -> driver.findElement(By.linkText(idField)).isSelected();
			case CSS -> driver.findElement(By.cssSelector(idField)).isSelected();
			case XPATH -> driver.findElement(By.xpath(idField)).isSelected();
			case CLASS_NAME -> driver.findElement(By.className(idField)).isSelected();
			default -> false;
		};
	}

	public static void selectionComboboxVisibleText(ElementType type, String idField, String text) {
		WebElement element = null;
		switch (type) {
			case ID -> element = driver.findElement(By.id(idField));
			case TAG_NAME -> element = driver.findElement(By.tagName(idField));
			case LINK_TEXT -> element = driver.findElement(By.linkText(idField));
			case CSS -> element = driver.findElement(By.cssSelector(idField));
			case XPATH -> element = driver.findElement(By.xpath(idField));
			case CLASS_NAME -> element = driver.findElement(By.className(idField));
		}
		new Select(element).selectByVisibleText(text);
	}

	public static void selectionComboboxByIndex(ElementType type, String idField, int index) {
		WebElement element = null;
		switch (type) {
			case ID -> element = driver.findElement(By.id(idField));
			case TAG_NAME -> element = driver.findElement(By.tagName(idField));
			case LINK_TEXT -> element = driver.findElement(By.linkText(idField));
			case CSS -> element = driver.findElement(By.cssSelector(idField));
			case XPATH -> element = driver.findElement(By.xpath(idField));
			case CLASS_NAME -> element = driver.findElement(By.className(idField));
		}
		new Select(element).selectByIndex(index);
	}

	public static void selectionComboboxByValue(ElementType type, String idField, String text) {
		WebElement element = null;
		switch (type) {
			case ID -> element = driver.findElement(By.id(idField));
			case TAG_NAME -> element = driver.findElement(By.tagName(idField));
			case LINK_TEXT -> element = driver.findElement(By.linkText(idField));
			case CSS -> element = driver.findElement(By.cssSelector(idField));
			case XPATH -> element = driver.findElement(By.xpath(idField));
			case CLASS_NAME -> element = driver.findElement(By.className(idField));
		}
		new Select(element).selectByValue(text);
	}

	public static String getValueCombobox(ElementType type, String idField) {
		WebElement element = null;
		switch (type) {
			case ID -> element = driver.findElement(By.id(idField));
			case TAG_NAME -> element = driver.findElement(By.tagName(idField));
			case LINK_TEXT -> element = driver.findElement(By.linkText(idField));
			case CSS -> element = driver.findElement(By.cssSelector(idField));
			case XPATH -> element = driver.findElement(By.xpath(idField));
			case CLASS_NAME -> element = driver.findElement(By.className(idField));
		}
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
}