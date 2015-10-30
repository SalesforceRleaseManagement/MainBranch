package com.webservices;

import java.util.List;

import javax.jws.WebService;

import com.services.ForceDepService;
import com.sforce.soap._2005._09.outbound.ASAMetadataLogCNotification;
import com.sforce.soap._2005._09.outbound.NotificationPort;
import com.sforce.soap.local.deploy.sobject.ASAMetadataLogC;
import com.util.Constants;

 
@WebService(endpointInterface = "com.sforce.soap._2005._09.outbound.NotificationPort")
public class SFSoapRetrieveImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<ASAMetadataLogCNotification> notification) {
		
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
		ASAMetadataLogC sobject = null;
		List<ASAMetadataLogCNotification> notifications = notification;
		System.out.println("arrSize: "+notification.size());
		String bOrgToken = null;
		String bOrgId = null;
		String bOrgURL = null;
		String sOrgId = null;
		String sOrgToken = null;
		String bOrgRefreshToken = null;

		int arrSize = notification.size();
		for (int i = 0; i < arrSize; i++) {
			sobject = (ASAMetadataLogC)notification.get(i).getSObject();
			metadataLogId = sobject.getId();
			System.out.println("Id: "+ sobject.getId());
			sOrgId = organizationId;
			bOrgId = sobject.getASABaseOrgIdC().getValue();
			bOrgURL = sobject.getASABaseOrgUrlC().getValue();
			bOrgToken = sobject.getASABaseOrgTokenC().getValue();
			bOrgRefreshToken=sobject.getASABaseOrgRefreshTokenC().getValue();
			
			//System.out.println("id__c: "+sobject.getIDC().getValue());
			System.out.println("OrganizationId__c: "+sobject.getASAOrganizationIdC().getValue());
			System.out.println("RecordId__c: "+sobject.getASARecordIdC().getValue());
			//System.out.println("SourceOrgToken__c: "+sobject.getSourceOrgTokenC().getValue());
			//System.out.println("TargetOrgTokenNonEncrypted__c: "+sobject.getTargetOrgTokenNonEncryptedC().getValue());
			//System.out.println("TargetOrgToken__c: "+sobject.getTargetOrgTokenC().getValue());
			System.out.println("bOrgId : "+bOrgId+"~"+"bOrgURL : "+bOrgURL+"~"+"bOrgToken : "+bOrgToken+"~"+"bOrgRefreshToken :"+bOrgRefreshToken);
			//sOrgToken = sobject.getSourceOrgTokenC().getValue();
			//System.out.println("metadata Log Id: "+ sobject.getId());
			//System.out.println("Source OrgId: "+sOrgId+" -- SourceOrgToken : "+sobject.getSourceOrgTokenC().getValue());
		}
		try {
			ForceDepService deploymentService = new ForceDepService();	
			if ((sOrgId != null && !sOrgId.isEmpty())
					&& (metadataLogId != null && !metadataLogId.isEmpty())) {
				System.out.println("wqeqweqwewq");
				deploymentService.retrieve(bOrgId, bOrgToken, bOrgURL, bOrgRefreshToken, metadataLogId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
