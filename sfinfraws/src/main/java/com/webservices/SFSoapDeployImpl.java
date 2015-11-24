package com.webservices;

import java.util.List;

import javax.jws.WebService;

import com.services.ForceDepService;
import com.sforce.soap._2005._09.outbound.ASAMetadataLogCNotification;
import com.sforce.soap._2005._09.outbound.NotificationPort;
import com.sforce.soap.local.deploy.sobject.ASAMetadataLogC;

@WebService(endpointInterface = "com.sforce.soap._2005._09.outbound.NotificationPort")
public class SFSoapDeployImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<ASAMetadataLogCNotification> notification) {

		String orgId = organizationId;
		String actId = actionId;
		String sId = sessionId;
		String eUrl = enterpriseUrl;
		String pUrl = partnerUrl;
		String metadataLogId = "";

		// TODO Auto-generated method stub
		System.out.println("Hello deploy");
		System.out.println("organizationId : " + organizationId);
		System.out.println("actionId : " + actionId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("enterpriseUrl : " + enterpriseUrl);
		System.out.println("partnerUrl : " + partnerUrl);
		ASAMetadataLogC sobject = null;
		List<ASAMetadataLogCNotification> notifications = notification;

		String bOrgToken = null;
		String bOrgId = null;
		String bOrgURL = null;
		String tOrgId = null;
		String sOrgToken = null;
		String tOrgToken = null;
		String bOrgRefreshToken = null;
		int arrSize = notification.size();
		String action = null;

		System.out.println("Arrasize : " + arrSize);
		for (int i = 0; i < arrSize; i++) {
			sobject = (ASAMetadataLogC) notification.get(i).getSObject();
			metadataLogId = sobject.getId();
			System.out.println("metadataLogId: " + metadataLogId);
			bOrgId = sobject.getASABaseOrgIdC().getValue();
			bOrgURL = sobject.getASABaseOrgUrlC().getValue();
			bOrgToken = sobject.getASABaseOrgTokenC().getValue();
			tOrgId = sobject.getASAOrganizationIdC().getValue();
			bOrgRefreshToken = sobject.getASABaseOrgRefreshTokenC().getValue();
			action = sobject.getASAActionC().getValue();

			System.out.println("bOrgId : " + bOrgId + "~" + "bOrgURL : "
					+ bOrgURL + "~" + "bOrgToken : " + bOrgToken + "~");
			
			System.out.println("metadata Log Id: " + metadataLogId
					+ "  -Org Id: " + tOrgId + "~" + action);
			try {
				ForceDepService deploymentService = new ForceDepService();
				if ((metadataLogId != null && !metadataLogId.isEmpty())
						&& (action != null && !action.isEmpty() && action
								.equals("Validate"))
						&& (tOrgId != null && !tOrgId.isEmpty())) {
					System.out.println("Validate");
					deploymentService.deploy(bOrgId, bOrgToken, bOrgURL,
							bOrgRefreshToken, metadataLogId, true);
					return true;

				} else if ((metadataLogId != null && !metadataLogId.isEmpty())
						&& (action != null && !action.isEmpty() && action
								.equals("Deploy"))
						&& (tOrgId != null && !tOrgId.isEmpty())) {
					System.out.println("deploy");
					deploymentService.deploy(bOrgId, bOrgToken, bOrgURL,
							bOrgRefreshToken, metadataLogId, false);
					return true;

					
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
