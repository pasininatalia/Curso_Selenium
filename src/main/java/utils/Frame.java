package utils;

import static utils.Utilities.driver;

public class Frame {

	private Frame() {
	}

	public static void openFrame(String frame) {
		driver.switchTo().frame(frame);
	}

	public static void closeFrame() {
		driver.switchTo().defaultContent();
	}

	public static void changeWindow(String id) {
		driver.switchTo().window(id);
	}
}