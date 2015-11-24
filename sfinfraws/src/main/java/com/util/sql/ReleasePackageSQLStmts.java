package com.util.sql;

public class ReleasePackageSQLStmts {

	public static String getReleasePackageNameQuery(String id) {
		String sql = "SELECT Id, Name, ASA__Package__c, ASA__Order__c, ASA__Release__c"
				+ " FROM ASA__ReleasePackage__c"
				+ " where Id= '" + id + "'";
		return sql;
	}
	
	public static String getReleaseQuery(String id) {
		String sql = "SELECT Id, Name, ASA__Package__c, ASA__Order__c, ASA__Release__c"
				+ " FROM ASA__ReleasePackage__c"
				+ " where ASA__Release__c= '" + id + "'";
		return sql;
	}
	public static String getfindByPkgIDAndRID(String pid,String rid) {
		String sql = "SELECT Id, Name, ASA__Package__c, ASA__Order__c, ASA__Release__c"
				+ " FROM ASA__ReleasePackage__c"
				+ " where ASA__Package__c= '" + pid + "' and ASA__Release__c='" +rid+"'";
		return sql;
	}
	
	public static String getFindByReleaseId(String rid) {
		String sql = "SELECT Id, Name, ASA__Package__c, ASA__Order__c, ASA__Release__c"
				+ " FROM ASA__ReleasePackage__c"
				+ " where ASA__Release__c= '" + rid + "'";
		return sql;
	}
}
