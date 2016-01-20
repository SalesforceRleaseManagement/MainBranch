package com.util.sql;


public class PackageCompInfoSQLStmts {

	public static String getPackageCompInfoQuery(String id) {
		String sql = "SELECT Id, Name, ASAClient__Name__c, ASAClient__Order__c, ASAClient__Package__c, "
				+ "ASAClient__Package__r.Name, ASAClient__SourceOrganizationId__c, ASAClient__Type__c"
				+ " FROM ASAClient__PackageComponentInformation__c"
				+ " where Id= '" + id + "'";
		return sql;
	}
	public static String getParentPackageCompInfoQuery(String id) {
		String sql = "SELECT Id, Name, ASAClient__Name__c, ASAClient__Order__c, ASAClient__Package__c, "
				+ "ASAClient__Package__r.Name, ASAClient__SourceOrganizationId__c, ASAClient__Type__c"
				+ " FROM ASAClient__PackageComponentInformation__c"
				+ " where ASAClient__Package__c= '" + id + "'";
		return sql;
	}

}
