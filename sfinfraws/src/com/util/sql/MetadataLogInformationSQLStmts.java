package com.util.sql;

public class MetadataLogInformationSQLStmts {

	public static String getMetdataLogRecordQuery(String metadataLogId){
		
		String sql = "SELECT Id, Name, ASAClient__Action__c,ASAClient__OrganizationId__c, ASAClient__Status__c "
				+ " FROM ASAClient__MetadataLogInformation__c" + " where Id= '" + metadataLogId + "'";
		System.out.println(sql);
		return sql;
	}
}
