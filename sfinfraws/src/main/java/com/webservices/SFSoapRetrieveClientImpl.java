package com.webservices;

import java.util.List;

import javax.jws.WebService;

import org.sforce.soap._2005._09.outbound.ASAClientMetadataLogInformationCNotification;
import org.sforce.soap._2005._09.outbound.NotificationPort;
import org.sforce.soap.local.sobject.ASAClientMetadataLogInformationC;

import com.services.ForceDepService;

 
/**
 * @author root6
 *
 */
@WebService(endpointInterface = "org.sforce.soap._2005._09.outbound.NotificationPort")
public class SFSoapRetrieveClientImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<ASAClientMetadataLogInformationCNotification> notification) {
		
		String orgId = organizationId;
		String actId = actionId;
		String sId = sessionId;
		String eUrl = enterpriseUrl;
		String pUrl = partnerUrl;
		String metadataLogId = "";
		String tOrgId = "";
		
		// TODO Auto-generated method stub
		System.out.println("Hello Retrieve");
		System.out.println("organizationId : "+organizationId);
		System.out.println("actionId : "+actionId);
		System.out.println("sessionId : "+sessionId);
		System.out.println("enterpriseUrl : "+enterpriseUrl);
		ASAClientMetadataLogInformationC sobject = null;
		List<ASAClientMetadataLogInformationCNotification> notifications = notification;
		System.out.println("arrSize: "+notification.size());
		String bOrgToken = null;
		String bOrgId = null;
		String bOrgURL = null;
		String sOrgId = null;
		String sOrgToken = null;
		String bOrgRefreshToken = null;

		int arrSize = notification.size();
		for (int i = 0; i < arrSize; i++) {
			sobject = (ASAClientMetadataLogInformationC)notification.get(i).getSObject();
			metadataLogId = sobject.getId();
			System.out.println("Id: "+ sobject.getId());
			sOrgId = organizationId;
			bOrgId = sobject.getASAClientBaseOrgIdC().getValue();
			bOrgURL = sobject.getASAClientBaseOrgUrlC().getValue();
			bOrgToken = sobject.getASAClientBaseOrgTokenC().getValue();
			bOrgRefreshToken=sobject.getASAClientBaseOrgRefreshTokenC().getValue();
			
			System.out.println("OrganizationId__c: "+sobject.getASAClientOrganizationIdC().getValue());
			System.out.println("RecordId__c: "+sobject.getASAClientRecordIdC().getValue());
			
			System.out.println("bOrgId : "+bOrgId+"~"+"bOrgURL : "+bOrgURL+"~"+"bOrgToken : "+bOrgToken+"~"+"bOrgRefreshToken :"+bOrgRefreshToken);
			
		}
		try {
			ForceDepService deploymentService = new ForceDepService();	
			if ((sOrgId != null && !sOrgId.isEmpty())
					&& (metadataLogId != null && !metadataLogId.isEmpty())) {
				deploymentService.retrieveClient(bOrgId, bOrgToken, bOrgURL, bOrgRefreshToken, metadataLogId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
		