package com.util.sql;


public class PackageComponentSQLStmts {

	public static String getPackageCompQuery(String id) {
		String sql = "SELECT Id, Name, ASA__Name__c, ASA__Order__c, ASA__Package__c, "
				+ "ASA__Package__r.Name, ASA__SourceOrganizationId__c, ASA__Type__c"
				+ " FROM ASA__PackageComponent__c"
				+ " where Id= '" + id + "'";
		return sql;
	}
	public static String getParentPackageCompQuery(String id) {
		String sql = "SELECT Id, Name, ASA__Name__c, ASA__Order__c, ASA__Package__c, "
				+ "ASA__Package__r.Name, ASA__SourceOrganizationId__c, ASA__Type__c"
				+ " FROM ASA__PackageComponent__c"
				+ " where ASA__Package__c= '" + id + "'";
		return sql;
	}
	public static String getParentPackageComPID(String id) {
		String sql = "SELECT Id, Name, ASA__Name__c, ASA__Order__c, ASA__Package__c, "
				+ "ASA__Package__r.Name, ASA__SourceOrganizationId__c, ASA__Type__c"
				+ " FROM ASA__PackageComponent__c"
				+ " where ASA__ParentPackageCompID__c= '" + id + "'";
		return sql;
	}

}
