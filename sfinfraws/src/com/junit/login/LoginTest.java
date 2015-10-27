package com.junit.login;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.sforce.soap.enterprise.fault.UnexpectedErrorFault;
import com.sforce.ws.ConnectionException;
import com.util.SFoAuthHandle;

/**
 * 
 * @author LoginTest is JUnit TestCase Used To Test Connections.
 *
 */
public class LoginTest {

	// @Test
	public void testAssertFalse() {

		boolean flag = false;
		String metadataLogId = "a0Yj0000003RWg66662";
		String bOrgId = "00Dj0000001tsUfEAI666666";
		String bOrgToken = "00Dj0000001tsUf!AR8AQLhaIkFSAHESZWqjCerrTDNBEhfHtL0Mba.P9TdqvqWqIS5LK_x_yfotHHPc2SVjSWZ62YE_L6yteCqSACLvo26zcim2";
		// String bOrgURL ="https://emc--OppVis.cs1.my.salesforce.com";
		String bOrgURL = "https://na16.salesforce.com";
		SFoAuthHandle s = new SFoAuthHandle(bOrgId, bOrgToken, bOrgURL, "",
				"0");
		try {
			// s.getEnterpriseConnection();
			System.out.println("first "
					+ s.getEnterpriseConnection().getUserInfo());
		} catch (UnexpectedErrorFault e) {

			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			String s1 = writer.toString();
			String s2 = s1.substring(0, s1.indexOf("]"));
			System.out.println("s2-" + s2);
			CharSequence sequence = "exceptionCode='";
			String seqString = sequence.toString();
			if (s2.contains(sequence)) {
				int beginIndex = s2.indexOf(sequence.toString())
						+ seqString.length();
				int endIndex = s2.indexOf("'", beginIndex);
				String errorCode = s2.substring(beginIndex, endIndex);
				System.out.println("' index:"
						+ s2.substring(beginIndex, endIndex));

				if (SFErrorCodes.INVALID_SESSION_ID.getNumber() == 131) {
					flag = true;
				} else {
					flag = false;
				}
				// String s3 = s2.substring(, s2.indexOf("'"));
				// System.out.println("----"+s3);
			}
		} catch (SFException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		org.junit.Assert.assertFalse("failure - Not proper Connection ", flag);
	}

	// @Test
	public void testOppVis() {
		String bOrgId = "00DS0000003Km6LMAS";
		String bOrgToken = "00DS0000003Km6L!AQsAQKeucB18h18cIYE3Ot2PqVwIW07kSDYZHbFicjlNC2ztG5QT9PB0v6_hXUFBR1v317ysgpEtWix6FhzS0tigYwoGoz4Y";
		String bOrgURL = "https://emc--OppVis.cs1.my.salesforce.com";
		SFoAuthHandle s = new SFoAuthHandle(bOrgId, bOrgToken, bOrgURL);
		try {
			System.out.println("---"
					+ s.getEnterpriseConnection().getUserInfo().getProfileId());
			assertEquals("", s.getEnterpriseConnection().getUserInfo());
			// System.out.println("first " +
			// s.getEnterpriseConnection().getSessionHeader());
			// System.out.println("first " +
			// s.getEnterpriseConnection().getUserInfo());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInfrasai() {
		String bOrgId = "00D28000000fAHiEAM";
		String bOrgToken = "00D28000000fAHi!ARkAQKYnLaoWioXgCD.UxYEuAlkTumtU11K_V4HHKGZs_sDMTwJyPues1.Kgrz_elrJ9xE9ZJl4iAfGC_6QwnRJot2SYbuM8";
		String bOrgURL = "https://ap2.salesforce.com";
		SFoAuthHandle s = new SFoAuthHandle(bOrgId, bOrgToken, bOrgURL);
		try {
			System.out.println("---"
					+ s.getEnterpriseConnection().getUserInfo().getProfileId());
			assertEquals("", s.getEnterpriseConnection().getUserInfo());
			// System.out.println("first " +
			// s.getEnterpriseConnection().getSessionHeader());
			// System.out.println("first " +
			// s.getEnterpriseConnection().getUserInfo());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// System.out.println(" Test result : "+flag);
}
