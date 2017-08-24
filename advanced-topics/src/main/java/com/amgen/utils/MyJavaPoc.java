package com.amgen.utils;

public class MyJavaPoc {
	public static void main(String[] args) {
		String inputString = "Timestamp(mm/dd/yyyy)=5/31/2017";
		String outputString = inputString.replaceAll("/", "-");
		outputString = outputString.replaceFirst("\\(", "-");
		outputString = outputString.replaceFirst("\\)", "");		
		System.out.println("out-string: " + outputString);		
	}
}
