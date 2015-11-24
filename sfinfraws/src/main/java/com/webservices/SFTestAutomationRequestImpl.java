package com.webservices;

import java.util.List;

import javax.jws.WebService;

import com.services.ForceDepService;
import com.util.Constants;

import net.sforce.soap._2005._09.outbound.MetadataLogCNotification;
import net.sforce.soap._2005._09.outbound.NotificationPort;
import net.sforce.soap.local.sobject.MetadataLogC;

/**
 * @author root6
 *
 */
@WebService(endpointInterface = "net.sforce.soap._2005._09.outbound.NotificationPort")
public class SFTestAutomationRequestImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<MetadataLogCNotification> notification) {

		String metadataLogId = "";
		String userId="skrishna@developertest.com";
		String passwd="infrascape3srAF8wqAps26TIYMXayRMYTl";
		String serverURL="https://na34.salesforce.com";
		String metadataLogAction = "";


		// TODO Auto-generated method stub
		System.out.println("Hello TestAutomation");
		System.out.println("organizationId : " + organizationId);
		System.out.println("actionId : " + actionId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("enterpriseUrl : " + enterpriseUrl);
		MetadataLogC sobject = null;
		List<MetadataLogCNotification> notifications = notification;
		System.out.println("arrSize: " + notification.size());

		int arrSize = notification.size();
		for (int i = 0; i < arrSize; i++) {
			sobject = (MetadataLogC) notification.get(i).getSObject();
			metadataLogId = sobject.getId();
			metadataLogAction=sobject.getActionC().getValue();
			System.out.println("Id: " + sobject.getId());
			System.out.println("Test Automation :"+ metadataLogId);
			System.out.println("metadataLogAction :"+metadataLogAction);

		}
		
		try {
			ForceDepService deploymentService = new ForceDepService();

			if ((metadataLogId != null && !metadataLogId.isEmpty())
					&& metadataLogAction.equals(Constants.TEST_AUTOMATION_ACTION)) {
			deploymentService.executeScript(userId, passwd,serverURL, metadataLogId);
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}
}
