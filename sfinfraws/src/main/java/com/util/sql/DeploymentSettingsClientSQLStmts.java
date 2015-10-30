package com.util.sql;

public class  DeploymentSettingsClientSQLStmts {

	public static String getOrgEnvQuery(String orgId){
		String sql = "Select Id, ASAClient__BaseOrganizationId__c, ASAClient__TokenCode__c, ASAClient__Server_URL__c, ASAClient__RefreshTokenCode__c"
				+ " FROM ASAClient__DeploymentSettingClient__c where ASAClient__BaseOrganizationId__c = '"+orgId+"'";
		return sql;
	}
}
