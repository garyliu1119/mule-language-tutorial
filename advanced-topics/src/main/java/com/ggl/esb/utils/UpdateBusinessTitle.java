package com.ggl.esb.utils;

public class UpdateBusinessTitle {
	public static String REGEX_PART_1;
	public static void main(String[] args) {
		updateBusinessTitle("Exception Template - AFP- Specialist IS Architect");
		updateBusinessTitle("Exception Template - Specialist IS Architect");
		updateBusinessTitle("Specialist IS Architect – AFP");
		updateBusinessTitle("Specialist IS Architect -AFP");

	}
	
	public static String updateBusinessTitle(String title) {
		System.out.println("input title: " + title);
		String result = title.replaceAll("Exception\\s*Template\\s*[-–]\\s*AFP\\s*[-–]\\s*", "")
				.replaceAll("Exception\\s*Template\\s*[-–]\\s*", "")
				.replaceAll("\\s*[-–]\\s*AFP\\s*", "");
		System.out.println("output: " + result);
		return result;
	}
}
