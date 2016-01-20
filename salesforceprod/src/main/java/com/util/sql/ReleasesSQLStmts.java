package com.util.sql;

public class ReleasesSQLStmts {

	public static String getReleaseQuery(String id) {
		String sql = "SELECT Id, Name, ASA__Status__c"
				+ " FROM ASA__Releases__c"
				+ " where Id= '" + id + "'";
		return sql;
	}
}
