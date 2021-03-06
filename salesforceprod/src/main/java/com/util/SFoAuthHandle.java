package com.util;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.sforce.async.AsyncApiException;
import com.sforce.async.BulkConnection;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.LoginResult;
import com.sforce.soap.enterprise.fault.UnexpectedErrorFault;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.tooling.ToolingConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SFoAuthHandle {

	String oAuthToken;
	String orgId;
	String userId = "";
	String passwd = "";
	String securityToken = "";
	ConnectorConfig enterpriseConfig = null;
	ConnectorConfig metadataConfig = null;
	ConnectorConfig toolingConfig = null;
	ConnectorConfig bulkConfig = null;
	MetadataConnection metadataConnection = null;
	EnterpriseConnection enterpriseConnection = null;
	ToolingConnection toolingConnection = null;
	BulkConnection bulkConnection = null;
	String serverURL = null;
	String refreshtoken = null;
	String orgType = null;
	String aa=null;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public SFoAuthHandle(String orgId, String token, String serverURL,
			String refreshtoken, String orgType) throws SFException {
		nullify();
		this.orgId = orgId;
		this.oAuthToken = token;
		this.serverURL = serverURL;
		this.refreshtoken = refreshtoken;
		this.orgType = orgType;
	}

	public SFoAuthHandle(String orgId, String token, String serverURL)
			throws SFException {
		nullify();
		this.orgId = orgId;
		this.oAuthToken = token;
		this.serverURL = serverURL;
	}
	public SFoAuthHandle(String userId, String passwd,String serverURL,String aa)
			throws SFException {
		nullify();
		this.userId = userId;
		this.passwd = passwd;
		this.serverURL=serverURL;
		this.aa=aa;
	}

	public SFoAuthHandle getValidConnection() throws SFException {
		SFoAuthHandle sFoAuthHandle = null;
		try {
			if (getEnterpriseConnection() != null) {
				com.sforce.soap.enterprise.GetUserInfoResult userResult = getEnterpriseConnection()
						.getUserInfo();
				return this;
			}
		} catch (UnexpectedErrorFault e) {
			if (Constants.BaseOrgID.equals(getOrgType())) {
				setAccessToken(getServerURL(), Constants.BaseOrgClientID,
						Constants.BaseOrgClientSecret, getRefreshtoken());
			} else if(Constants.CustomOrgID.equals(getOrgType())){
				setAccessToken(getServerURL(), Constants.CustomOrgClientID,
						Constants.CustomOrgClientSecret, getRefreshtoken());
			}
			else if(Constants.CustomBaseOrgID.equals(getOrgType())){
				setAccessToken(getServerURL(), Constants.CustomBaseOrgClientID,
						Constants.CustomBaseOrgClientSecret, getRefreshtoken());
			}
		
			sFoAuthHandle = new SFoAuthHandle(getOrgId(), getoAuthToken(),
					getServerURL());
			if (sFoAuthHandle.getEnterpriseConnection() != null) {
				try {
					com.sforce.soap.enterprise.GetUserInfoResult userResult1 = sFoAuthHandle
							.getEnterpriseConnection().getUserInfo();
					return sFoAuthHandle;
				} catch (ConnectionException e1) {
					throw new SFException("Not a valid connection paramters",
							SFErrorCodes.SF_Not_Valid_Conn_Parameters);
				}
			}
		} catch (SFException e) {
			throw new SFException("Not a valid connection paramters",
					SFErrorCodes.SF_Not_Valid_Conn_Parameters);
		} catch (ConnectionException e) {
			throw new SFException("Not a valid connection paramters",
					SFErrorCodes.SF_Not_Valid_Conn_Parameters);
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

	public void nullify() {
		this.enterpriseConfig = null;
		this.metadataConfig = null;
		this.toolingConfig = null;
		this.bulkConfig = null;
		this.metadataConnection = null;
		this.enterpriseConnection = null;
		this.toolingConnection = null;
		this.bulkConnection = null;
	}

	private LoginResult getLoginResult() throws ConnectionException {
		return (getEnterpriseConnection()).login(getUserId(), getPasswd());
	}

	public BulkConnection getBulkConnection() throws ConnectionException,
			AsyncApiException {
		if (bulkConnection == null) {
			if (getoAuthToken() != null && !getoAuthToken().isEmpty()) {
				bulkConfig = new ConnectorConfig();
				bulkConfig.setSessionId(getoAuthToken());
				bulkConfig.setManualLogin(true);
				bulkConfig.setCompression(false);
				String serviceEndpoint = null;
				serviceEndpoint = getServerURL() + "/services/Soap/c/33.0";
				bulkConfig.setServiceEndpoint(serviceEndpoint);

				bulkConfig
						.setAuthEndpoint("https://login.salesforce.com/services/Soap/c/33.0");
				// Creating the connection automatically handles login and
				// stores
				// the session in partnerConfig
				new EnterpriseConnection(bulkConfig);
				// When PartnerConnection is instantiated, a login is implicitly
				// executed and, if successful,
				// a valid session is stored in the ConnectorConfig instance.
				// Use this key to initialize a BulkConnection:
				ConnectorConfig config = new ConnectorConfig();
				config.setSessionId(bulkConfig.getSessionId());
				// The endpoint for the Bulk API service is the same as for the
				// normal
				// SOAP uri until the /Soap/ part. From here it's
				// '/async/versionNumber'
				String soapEndpoint = bulkConfig.getServiceEndpoint();
				// System.out.println("soapEndpoint: " + soapEndpoint);
				String apiVersion = "33.0";
				String restEndpoint = soapEndpoint.substring(0,
						soapEndpoint.indexOf("Soap/"))
						+ "async/" + apiVersion;
				config.setRestEndpoint(restEndpoint);
				// This should only be false when doing debugging.
				config.setCompression(true);
				// Set this to true to see HTTP requests and responses on stdout
				config.setTraceMessage(false);
				bulkConnection = new BulkConnection(config);
			}
		}
		return bulkConnection;
	}

	public MetadataConnection getMetadataConnection() throws SFException {
		if (metadataConnection == null) {
			if (getoAuthToken() != null && !getoAuthToken().isEmpty()) {
				metadataConfig = new ConnectorConfig();
				metadataConfig.setSessionId(getoAuthToken());
				metadataConfig.setManualLogin(true);
				metadataConfig.setCompression(false);
				String serviceEndpoint = null;
				serviceEndpoint = getServerURL() + "/services/Soap/m/33.0";
				metadataConfig.setServiceEndpoint(serviceEndpoint);
				try {
					metadataConnection = new MetadataConnection(metadataConfig);
				} catch (ConnectionException e) {
					// TODO Auto-generated catch block
					// System.out.println(e.toString());
					throw new SFException(e.getMessage(),
							SFErrorCodes.Metadata_Conn_Error);
				}
			} else if (getUserId() != null && getPasswd() != null) {
				metadataConfig = new ConnectorConfig();
				try {
					metadataConfig.setServiceEndpoint(getLoginResult()
							.getMetadataServerUrl());
					metadataConfig
							.setSessionId(getLoginResult().getSessionId());
					metadataConnection = new MetadataConnection(metadataConfig);
				} catch (ConnectionException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					// System.out.println(e.toString());
					throw new SFException(e.getMessage(),
							SFErrorCodes.Metadata_Conn_Error);
				}
			}
		}
		return metadataConnection;
	}

	public EnterpriseConnection getEnterpriseConnection() throws SFException {
		enterpriseConfig = new ConnectorConfig();
		if (enterpriseConnection == null) {
			if (getoAuthToken() != null && !getoAuthToken().isEmpty()) {
				enterpriseConfig.setSessionId(getoAuthToken());
				enterpriseConfig.setManualLogin(true);
				enterpriseConfig.setCompression(false);
				String serviceEndpoint = null;
				serviceEndpoint = getServerURL() + "/services/Soap/c/33.0";
				enterpriseConfig.setServiceEndpoint(serviceEndpoint);
				try {
					enterpriseConnection = Connector
							.newConnection(enterpriseConfig);
				} catch (ConnectionException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					// System.out.println(e.toString());
					e.printStackTrace();
					throw new SFException(e.getMessage(),
							SFErrorCodes.Enterprise_Conn_Error);
				}
			} else if (getUserId() != null && getPasswd() != null) {
				try {
					enterpriseConfig.setUsername(getUserId());
					enterpriseConfig.setPassword(getPasswd());
					String serviceEndpoint = null;
					serviceEndpoint = getServerURL() + "/services/Soap/c/33.0";
					enterpriseConfig.setAuthEndpoint(serviceEndpoint);
					enterpriseConfig.setTraceFile("trace.log");
					enterpriseConfig.setTraceMessage(true);
					enterpriseConfig.setPrettyPrintXml(true);
					enterpriseConnection = Connector
							.newConnection(enterpriseConfig);
				} catch (Exception e) {
					e.printStackTrace();
					// System.out.println(e.toString());
					throw new SFException(e.getMessage(),
							SFErrorCodes.Enterprise_Conn_Error);
				}
			}
		}
		return enterpriseConnection;
	}

	public ToolingConnection getToolingConnection() throws SFException {
		if (toolingConnection == null) {
			toolingConfig = new ConnectorConfig();
			if (getoAuthToken() != null && !getoAuthToken().isEmpty()) {
				toolingConfig.setSessionId(getoAuthToken());
				toolingConfig.setManualLogin(true);
				toolingConfig.setCompression(false);
				String serviceEndpoint = getServerURL()
						+ "/services/Soap/T/33.0";
				toolingConfig.setAuthEndpoint(serviceEndpoint);
				toolingConfig.setTraceMessage(true);
				try {
					toolingConnection = com.sforce.soap.tooling.Connector
							.newConnection(toolingConfig);
				} catch (Exception e) {
					// e.printStackTrace();
					throw new SFException(e.getMessage(),
							SFErrorCodes.Tooling_Conn_Error);
				}
			} else if (getUserId() != null && getPasswd() != null) {
				String serviceEndpoint = getServerURL()
						+ "/services/Soap/T/33.0";
				toolingConfig.setAuthEndpoint(serviceEndpoint);
				toolingConfig.setUsername(getUserId());
				toolingConfig.setPassword(getPasswd());
				toolingConfig.setTraceMessage(true);
				try {
					toolingConnection = com.sforce.soap.tooling.Connector
							.newConnection(toolingConfig);
				} catch (Exception e) {
					// e.printStackTrace();
					// System.out.println(e.toString());
					throw new SFException(e.getMessage(),
							SFErrorCodes.Tooling_Conn_Error);
				}
			}
		}
		return toolingConnection;
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

	public String getoAuthToken() {
		return oAuthToken;
	}

	public void setoAuthToken(String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public void setMetadataConnection(MetadataConnection metadataConnection) {
		this.metadataConnection = metadataConnection;
	}

	public void setEnterpriseConnection(
			EnterpriseConnection enterpriseConnection) {
		this.enterpriseConnection = enterpriseConnection;
	}

	public void setToolingConnection(ToolingConnection toolingConnection) {
		this.toolingConnection = toolingConnection;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String toString() {
		return new String(getOrgId() + "~" + getoAuthToken() + "~"
				+ getServerURL() + "~" + getRefreshtoken() + "~" + getOrgType());
	}

	public void setAccessToken(String serverURL, String clientId,
			String clientSecret, String refreshToken) {
		String environment = "https://emc--oppvis.cs1.my.salesforce.com";
		String tokenUrl = serverURL + Constants.Token_URL;

		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenUrl);
		// post.addParameter("code", code);
		post.addParameter("grant_type", "refresh_token");
		post.addParameter("client_id", clientId);
		post.addParameter("client_secret", clientSecret);
		post.addParameter("refresh_token", refreshToken);
		try {
			httpclient.executeMethod(post);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			JSONObject authResponse = new JSONObject(new JSONTokener(
					new InputStreamReader(post.getResponseBodyAsStream())));

			String accessToken = authResponse.getString("access_token");
			if (accessToken != null) {
				setoAuthToken(accessToken);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
