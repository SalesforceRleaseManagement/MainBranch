package JunitTest;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

import org.junit.Test;

import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.util.SFoAuthHandle;


public class SFLoginTest {
	
	@Test
	  public void testAssertFalse() {
	    
	    boolean flag=false;
	    String bOrgId = "00DS0000003Km6LMAS"; 
		String bOrgToken="00DS0000003Km6L!AQsAQNo8fjby_oeoQRptW6F2UbIV9C6Fn94EB_Roft527IgAJPazdc2v2CSsh6ejqPzUXl89ET1sGICyqbqgWxtF5yw7UyK1";
		 String bOrgURL ="https://emc--OppVis.cs1.my.salesforce.com";
		SFoAuthHandle s=new SFoAuthHandle(bOrgId,bOrgToken,bOrgURL);
		try {
			s.getEnterpriseConnection();
			
			//System.out.println("first " + s.getEnterpriseConnection().getSessionHeader());
			//System.out.println("first " + s.getEnterpriseConnection().getUserInfo());
			
		} catch (Exception e) {
			//e.printStackTrace();
			flag=true;
		}
		org.junit.Assert.assertFalse("failure - Not proper Connection ", flag);
	  }
	@Test
	public void testsai() {
		String bOrgId = "00DS0000003Km6LMAS"; 
		String bOrgToken="00DS0000003Km6L!AQsAQNo8fjby_oeoQRptW6F2UbIV9C6Fn94EB_Roft527IgAJPazdc2v2CSsh6ejqPzUXl89ET1sGICyqbqgWxtF5yw7UyK1";
		 String bOrgURL ="https://emc--OppVis.cs1.my.salesforce.com";
		SFoAuthHandle s=new SFoAuthHandle(bOrgId,bOrgToken,bOrgURL);
		try {
			s.getEnterpriseConnection().getUserInfo();
			assertEquals("", s.getEnterpriseConnection().getUserInfo());
			//System.out.println("first " + s.getEnterpriseConnection().getSessionHeader());
			//System.out.println("first " + s.getEnterpriseConnection().getUserInfo());

		} catch (Exception e) {
			e.printStackTrace();
			
		}
			
		
		}
	
		//System.out.println(" Test result : "+flag);
	}
	
	
	
	
