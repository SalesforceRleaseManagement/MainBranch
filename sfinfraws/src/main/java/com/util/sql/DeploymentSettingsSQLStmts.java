package com.util.sql;

public class DeploymentSettingsSQLStmts {

	public static String getOrgEnvQuery(String orgId){
		String sql = "Select Id, ASA__BaseOrganizationId__c, ASA__TokenCode__c, ASA__Server_URL__c, ASA__RefreshTokenCode__c"
				+ " FROM ASA__DeploymentSetting__c where ASA__BaseOrganizationId__c = '"+orgId+"'";
		return sql;
	}
}
