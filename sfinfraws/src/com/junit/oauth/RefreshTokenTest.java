package com.junit.oauth;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

/**
 * @author RefreshTokenTest.java is JUnit TestCase Used To Test RefreshTokens
 *         Are Getting or Not By Providing ClientId & ClientScret.
 */
public class RefreshTokenTest {

	@Test
	public void testInfrasai() throws HttpException, IOException {
		// fail("Not yet implemented");
		String environment = "https://ap2.salesforce.com";
		String tokenUrl = environment + "/services/oauth2/token";
		String refreshToken = "5Aep861TSESvWeug_yfuQdkHpKm8MD56S47bpgD8M_Mzp2D_vTwBTN4kpFDTAPX2nvIW7hx60iifqQ3REec6I.6";
		String clientId = "3MVG9fMtCkV6eLhckipcGtsdEsfpQCEkyYEebiLuCF4f6W3oYzlz5oBwSFWTKe7eZaIXoX2Zwg3Dbtaa0bUxF";
		String clientSecret = "6261950468938934297";
		// String
		// redirectUri="https://localhost:8443/SFSOAPWS/OAuthServlet/callback";

		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenUrl);
		// post.addParameter("code", code);
		post.addParameter("grant_type", "refresh_token");
		post.addParameter("client_id", clientId);
		post.addParameter("client_secret", clientSecret);
		post.addParameter("refresh_token", refreshToken);
		httpclient.executeMethod(post);
		JSONObject authResponse = new JSONObject(new JSONTokener(
				new InputStreamReader(post.getResponseBodyAsStream())));
		System.out.println(authResponse.toString());

	}

	// @Test
	public void test() throws HttpException, IOException {
		// fail("Not yet implemented");
		String environment = "https://emc--oppvis.cs1.my.salesforce.com";
		String tokenUrl = environment + "/services/oauth2/token";
		String refreshToken = "5Aep861KIwKdekr90IIyhfEcZZxgNJfv58m5BvQaUg0P_g1MEaW_z.3bf1yAZQvUXsMMvuwRv721Tw0OtQxZ515";
		String clientId = "3MVG9fMtCkV6eLhckipcGtsdEsbYJXSOdJrdCVqxaLEyjnLDaPGLekViuBqlQJcWVyZodXI42r34WH9F5wexo";
		String clientSecret = "1673914982220759042";
		// String
		// redirectUri="https://localhost:8443/SFSOAPWS/OAuthServlet/callback";

		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenUrl);
		// post.addParameter("code", code);
		post.addParameter("grant_type", "refresh_token");
		post.addParameter("client_id", clientId);
		post.addParameter("client_secret", clientSecret);
		post.addParameter("refresh_token", refreshToken);
		httpclient.executeMethod(post);
		JSONObject authResponse = new JSONObject(new JSONTokener(
				new InputStreamReader(post.getResponseBodyAsStream())));
		// System.out.println(authResponse.toString());

	}

	// @Test
	public void getIdDetails() throws ServletException, IOException {
		String accessToken = "00DS0000003Km6L!AQsAQOmsrJeFb856fPi9VPZix5Mmz4zXco3lSsZAfyQoUkqbORsuv6stkYbUqrPlvkVrJmhxH9hBwo_UIUHIaUPaTj68zNMu";
		String instanceURL = "https://emc--OppVis.cs1.my.salesforce.com";
		HttpClient httpclient = new HttpClient();
		GetMethod get = new GetMethod(
				"https://test.salesforce.com/id/00DS0000003Km6LMAS/00570000001eJC9AAM");
		// set the token in the header
		get.setRequestHeader("Authorization", "OAuth " + accessToken);

		// set the SOQL as a query param
		NameValuePair[] params = new NameValuePair[1];

		params[0] = new NameValuePair("oauth_token", accessToken);
		get.setQueryString(params);
		// System.out.println("Accessing ID URL---" + get.getURI().toString());

		httpclient.executeMethod(get);
		System.out.println(" status - " + get.getStatusCode());
		if (get.getStatusCode() == HttpStatus.SC_OK) {
			// Now lets use the standard java json classes to work with the
			// results

			JSONObject jsonResponse = new JSONObject(new JSONTokener(
					new InputStreamReader(get.getResponseBodyAsStream())));
			System.out.println("Auth Response: {} " + jsonResponse.toString(2));

			String userName = new String((String) jsonResponse.get("username"));
			String orgId = new String(
					(String) jsonResponse.get("organization_id"));
			String userId = new String((String) jsonResponse.get("user_id"));

		}
	}
}
