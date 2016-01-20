package com.util.sql;

public class ReleaseInformationSQLStmts {

	public static String getRIQuery(String id) {
		String sql = "SELECT Id, Name, ASAClient__ParentReleaseID__c, ASAClient__Status__c"
				+ " FROM ASAClient__ReleaseInformation__c"
				+ " where Id= '" + id + "'";
		return sql;
	}
	public static String getParentRIQuery(String id) {
		String sql = "SELECT Id, Name, ASAClient__ParentReleaseID__c, ASAClient__Status__c"
				+ " FROM ASAClient__ReleaseInformation__c"
				+ " where ASAClient__ParentReleaseID__c= '" + id + "'";
		return sql;
	}
}
