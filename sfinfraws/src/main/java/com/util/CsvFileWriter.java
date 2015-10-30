package com.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.domain.MetaBean;
import com.domain.MetadataDescriptionDO;

public class CsvFileWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "ASA__Name__c,ASA__Type__c,ASA__OrganizationId__c,ASA__MetadataLog__r.Name";
	//private static final String FILE_HEADER = "Name__c,Type__c,OrganizationId__c";

	
	public static void writeCsvFile(List<MetaBean> metaBeanDOList, String fileName) {
		//Create a new list of student objects
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (MetaBean metadataInformationDO : metaBeanDOList) {
				fileWriter.append(metadataInformationDO.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(metadataInformationDO.getType());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(metadataInformationDO.getSourceOrg());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(metadataInformationDO.getMetadataLogId());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully !!!");
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
		}
	}
}
