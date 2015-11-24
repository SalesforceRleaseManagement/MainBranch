package com.tasks;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.services.component.FDDeployCompService;
import com.services.component.FDExecuteScriptCompService;
import com.services.component.FDRetrieveClientCompService;

public class ExecuteScript implements Runnable {

	String orgId;
	String token;
	String serverURL;
	String refreshToken;
	String metadataLogId;
	String orgType;
	String userId;
	String passwd;

	

	public ExecuteScript(String orgId, String token, String serverURL,
			String refreshToken, String orgType, String metadataLogId) {
		this.metadataLogId = metadataLogId;
		this.orgId = orgId;
		this.token = token;
		this.refreshToken = refreshToken;
		this.serverURL = serverURL;
		this.orgType = orgType;
	}

	public ExecuteScript(String userId, String passwd,String serverURL, String metadataLogId) {
		
		this.userId=userId;
		this.passwd=passwd;
		this.metadataLogId=metadataLogId;
		this.serverURL=serverURL;

	}

	@Override
	public void run() {
		String errors = null;
		boolean errorFlag = false;
		try {
			FDExecuteScriptCompService executeScriptCompService = new FDExecuteScriptCompService();
			executeScriptCompService.executeScript(getUserId(),getPasswd(),getServerURL(),getMetadataLogId());
		} catch (Exception e) {
			errorFlag = true;
			StringWriter lerrors = new StringWriter();
			e.printStackTrace(new PrintWriter(lerrors));
			errors = lerrors.toString();
		} finally {
			if (errorFlag) {
				System.out
						.println("Execute Operation Complete for requestId: "
								+ getMetadataLogId() + "\nWith Errors: "
								+ errors);
			} else {
				System.out
						.println("Execute Operation Complete for requestId: "
								+ getMetadataLogId());
			}
		}
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public String getMetadataLogId() {
		return metadataLogId;
	}

	public void setMetadataLogId(String metadataLogId) {
		this.metadataLogId = metadataLogId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}