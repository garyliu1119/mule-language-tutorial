package com.amgen.pes.util;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
public class RemoveBom {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("test/temp/input_data.txt");
		BOMInputStream bomIn = new BOMInputStream(fis, 
				   ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_16BE,
				   ByteOrderMark.UTF_32LE, ByteOrderMark.UTF_32BE
				   );

		int ch = 0;
		StringBuffer strContent = new StringBuffer("");
		while ((ch = bomIn.read()) != -1) {
			if (ch > 0 && ch <  127) {
				strContent.append((char) ch);
			}
		}
		
		String fileText = strContent.toString();
		System.out.println(fileText);
		FileWriter fw = new FileWriter("test/temp/output_data.csv");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(fileText);
		
		bomIn.close();
	}
	
	public String removeBom(FileInputStream fis) throws Exception {
		BOMInputStream bomIn = new BOMInputStream(fis, 
				   ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_16BE,
				   ByteOrderMark.UTF_32LE, ByteOrderMark.UTF_32BE
				   );
		int ch = 0;
		StringBuffer strContent = new StringBuffer("");
		while ((ch = bomIn.read()) != -1) {
			if (ch > 0 && ch <  127) {
				strContent.append((char) ch);
			}
		}
		fis.close();
		bomIn.close();
		
		String fileText = strContent.toString();
		System.out.println(fileText);		
		return fileText;
	}
	public String removeBom(String bomText) throws Exception {
		StringBuffer strContent = new StringBuffer("");
		for(int ch : bomText.getBytes()) {
			if (ch > 0 && ch <  127) {
				strContent.append((char) ch);
			}
		}
		String fileText = strContent.toString();
		fileText = fileText.replaceAll("/", "-");
		fileText = fileText.replaceFirst("\\(", "-");
		fileText = fileText.replaceFirst("\\)", "");
		fileText = fileText.replaceAll("Timestamp-mm-dd-yyyy", "time_stamp");
		fileText = fileText.replaceAll("User Name", "user_name");
		fileText = fileText.replaceAll("User Name", "user_name");
		fileText = fileText.replaceAll("Full Name", "full_name");
		fileText = fileText.replaceAll("Field Name", "field_name");
		fileText = fileText.replaceAll("Old Value", "old_value");
		fileText = fileText.replaceAll("New Value", "new_value");
		fileText = fileText.replaceAll("Job Instance Id", "Job_Instance_Id");
		fileText = fileText.replaceAll("Workflow Name", "Workflow_Name");
		fileText = fileText.replaceAll("Task Name", "Task_Name");
		fileText = fileText.replaceAll("Signature Meaning", "Signature_Meaning");
		fileText = fileText.replaceAll("View License", "View_License");
		System.out.println(fileText);	
		return fileText;
	}
}
