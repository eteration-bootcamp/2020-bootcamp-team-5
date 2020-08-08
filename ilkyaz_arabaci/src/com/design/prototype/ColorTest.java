package com.design.prototype;

import java.util.List;
import com.design.prototype.Colors;

public class ColorTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Colors rgbColors = new Colors();
		rgbColors.constructColorsList();

		Colors mainBands = (Colors) rgbColors.clone();
		List<String> mainBandsList = mainBands.getColorsList();
		mainBandsList.add("Orange");
		mainBandsList.add("Yellow");
		mainBandsList.add("Violet");
		
		System.out.println("RGB Colors: " + rgbColors.getColorsList());
		System.out.println("Main Bands: " + mainBands.getColorsList());
	}
}