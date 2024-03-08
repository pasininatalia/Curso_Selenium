package utils;

import static utils.Utilities.driver;

public class Alert {

	private Alert() {
	}

	public static String getTextAlert() {
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		return alertText;
	}
	public static String getTextAlertAndAccept() {
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public static String getTextAlertAndDimiss() {
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.dismiss();
		return alertText;
	}

	public static void writeTextAlert(String text) {
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
}