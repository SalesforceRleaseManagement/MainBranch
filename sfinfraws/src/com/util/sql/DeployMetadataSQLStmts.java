package com.util.sql;

public class DeployMetadataSQLStmts {

	public static String getToBeDeployedRecordQuery(String metadataLogIdName) {
		String sql = "SELECT Id, ASA__Name__c, ASA__SourceOrganizationId__c, ASA__OrganizationId__c, "
				+ " ASA__Type__c, ASA__Order__c, ASA__Package__c, ASA__MetadataLog__r.Name FROM ASA__DeployMetadata__c"
				+ " where "
				+ " ASA__MetadataLog__r.Name='"
				+ metadataLogIdName
				+ "'" + " ORDER BY ASA__Order__c ASC NULLS LAST";

		return sql;
	}
}
