package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.util.Constants;

public class OAuthTest {

	public static void main(String[] args) {
		try {
			parseState();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testM1() {
		String authURL = "https://login.salesforce.com/services/oauth2/authorize";
		String clientId = "3MVG9fMtCkV6eLhckipcGtsdEsXpvuj0tgLP6bJJYaFcdwyUC5dmSJ.Oi2e6vkHAZMrNBY6k8y9Qf.QWFahCK";
		String clientSecret = "7048969593420516911";
		String redirect_uri = "https://sfinfraws.herokuapp.com/OAuthServlet/callback";
		String pdomain = "https://emc--oppvis.cs1.my.salesforce.com";
		
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(authURL);
		post.addParameter("response_type", "code");
		post.addParameter("client_id", clientId);
		post.addParameter("client_secret", clientSecret);
		post.addParameter("redirect_uri", redirect_uri);
		try {
			System.out.println(post.getURI());
			NameValuePair[] pair = post.getParameters();
			for (int i = 0; i < pair.length; i++) {
				NameValuePair npair = (NameValuePair)pair[i];
				System.out.println(npair.getName() + "---"+npair.getValue());
			}
		} catch (URIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int returnCode = httpclient.executeMethod(post);

			if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err
						.println("The Post method is not implemented by this URI");
				// still consume the response body
				System.out.println("++++"+post.getResponseBodyAsString());
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						post.getResponseBodyAsStream()));
				String readLine;
				System.out.println("---"+post.getResponseBodyAsString());
				while (((readLine = br.readLine()) != null)) {
					System.err.println(readLine);
				}
			}

			JSONObject authResponse = new JSONObject(new JSONTokener(
					new InputStreamReader(post.getResponseBodyAsStream())));

			System.out.println("Auth Response: {} " + authResponse.toString(2));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
	}

	private static void parseState(){
		String str = "L|a0361000001loKBAAY|00D610000006tjPEAQ|https://na34.salesforce.com|00D610000006tjP!AQ4AQLpMKFRZYlHFja7spuak1Eq_C4DoCZVc8qrx8L1ry.5B1LSIG_40GXjIqGyY_JCihNpeFT8JVdFvkEodeROS1PcgFRGD|5Aep861tbt360sO1.uO0UjNoRyP9rNbAguo__QeBtE9I0DtmCAWn8r4UIu4tzqbg2okzwzEmBzokQe8gXPTDFXb";
		StringTokenizer st = new StringTokenizer(str, "|");
		if (st.hasMoreTokens()) {
			String env = st.nextToken();
			String envId = st.nextToken();
			String orgId = st.nextToken();
			String instanceURL = st.nextToken();
			String token = st.nextToken();
			String refreshToken = st.nextToken();
			System.out.println("env: "+env + "\n" + "envId: "+envId + "\n" + "orgId: "+orgId + "\n"
					+"instanceURL: "+ instanceURL + "\n" + "token: "+ token + "\n"+ "refreshToken: "+ refreshToken);
		}
	}
	public static String getAccessToken() throws IOException {
		try {
			URL url = new URL(
					"https://login.salesforce.com/services/oauth2/authorize?prompt=login&response_type=code");
			OutputStreamWriter out = null;
			try {
				String clientId = "3MVG9fMtCkV6eLhckipcGtsdEsXpvuj0tgLP6bJJYaFcdwyUC5dmSJ.Oi2e6vkHAZMrNBY6k8y9Qf.QWFahCK";
				String clientSecret = "7048969593420516911";
				String redirect_uri = "https://sfinfraws.herokuapp.com/OAuthServlet/callback";
				String pdomain = "https://emc--oppvis.cs1.my.salesforce.com";

				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();

				connection.setUseCaches(false);
				connection.setDoOutput(true);
				connection.setDoInput(true);

				connection.setRequestProperty("charset", "utf-8");
				connection.addRequestProperty("grant_type",
						"authorization_code");
				connection.addRequestProperty("response_type", "code");

				connection.addRequestProperty("Accept", "*/*");
				connection.addRequestProperty("Accept-Encoding",
						"gzip, deflate, compress");

				connection.addRequestProperty("client_id", clientId);
				connection.addRequestProperty("client_secret", clientSecret);
				connection.addRequestProperty("redirect_uri", redirect_uri);

				/*
				 * connection.addRequestProperty("username", username);
				 * connection.addRequestProperty("password", password);
				 */
				connection.setRequestMethod("POST");

				System.out.println("URL: " + connection.getURL());
				connection.setConnectTimeout(1000 * 5);
				connection.connect();

				// out = new OutputStreamWriter( connection.getOutputStream( )
				// );
				System.out.print(connection.getResponseCode() + " - ");
				System.out.println(connection.getResponseMessage());
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));

				StringBuilder builder = new StringBuilder();
				String line = "";

				while ((line = in.readLine()) != null) {
					builder.append(line + '\n');
				}
				System.out.println(builder.toString());
			} catch (IOException ioExc) {
				System.out.println("IOException while opening connection");
			} finally {
				// out.close( );
			}
		} catch (MalformedURLException exc) {
			System.out.println("URL is malformed.");
		}
		return "";
	}
}
