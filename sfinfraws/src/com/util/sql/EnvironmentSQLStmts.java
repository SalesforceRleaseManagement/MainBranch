package com.util.sql;

public class EnvironmentSQLStmts {

	public static String getOrgEnvQuery(String orgId){
		String sql = "Select Id, ASA__Org_ID__c,ASA__OrganizationId__c, ASA__User_Name__c, ASA__Password__c, ASA__Server_URL__c, "
				+ " ASA__TokenCode__c, ASA__RefreshTokenCode__c, ASA__TokenCodeNonEncrypted__c, ASA__Type__c"
				+ " FROM ASA__Enviroment__c where ASA__OrganizationId__c = '"+orgId+"'";
		return sql;
	}
	public static String getAllEnvQuery(){
		String sql = "Select Id, ASA__Org_ID__c, ASA__OrganizationId__c, ASA__User_Name__c, ASA__Password__c, ASA__Server_URL__c, "
				+ " ASA__TokenCode__c, ASA__RefreshTokenCode__c, ASA__TokenCodeNonEncrypted__c, ASA__Type__c"
				+ " FROM ASA__Enviroment__c";
		return sql;
	}
}
