package com.webservices;

import java.util.List;

import javax.jws.WebService;

import com.services.ForceDepService;
import com.sforce.soap._2005._09.outbound.ASAMetadataLogCNotification;
import com.sforce.soap._2005._09.outbound.NotificationPort;
import com.sforce.soap.local.deploy.sobject.ASAMetadataLogC;
import com.util.Constants;

@WebService(endpointInterface = "com.sforce.soap._2005._09.outbound.NotificationPort")
public class SFSoapUpdatePackagesImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<ASAMetadataLogCNotification> notification) {

		// TODO Auto-generated method stub
		System.out.println("Hello UpdatePackages");
		System.out.println("organizationId : " + organizationId);
		System.out.println("actionId : " + actionId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("enterpriseUrl : " + enterpriseUrl);
		ASAMetadataLogC sobject = null;
		List<ASAMetadataLogCNotification> notifications = notification;
		System.out.println("arrSize: " + notification.size());
		String metadataLogId = "";
		String bOrgToken = null;
		String bOrgId = null;
		String bOrgURL = null;
		String sOrgId = null;
		String bOrgRefreshToken = null;

		String action = "";
		String status = "";
		String packageParentId = "";

		int arrSize = notification.size();
		for (int i = 0; i < arrSize; i++) {
			sobject = (ASAMetadataLogC) notification.get(i).getSObject();
			metadataLogId = sobject.getId();
			System.out.println("Id: " + sobject.getId());
			sOrgId = organizationId;
			bOrgId = sobject.getASABaseOrgIdC().getValue();
			bOrgURL = sobject.getASABaseOrgUrlC().getValue();
			bOrgToken = sobject.getASABaseOrgTokenC().getValue();
			bOrgRefreshToken = sobject.getASABaseOrgRefreshTokenC().getValue();
			action = sobject.getASAActionC().getValue();
			status = sobject.getASAStatusC().getValue();
			packageParentId = sobject.getASAIDC().getValue();

			System.out.println("bOrgId : " + bOrgId + "~" + "bOrgURL : "
					+ bOrgURL + "~" + "bOrgToken : " + bOrgToken + "~"
					+ "bOrgRefreshToken :" + bOrgRefreshToken + " ~"
					+ "action: " + action + "~" + "status: " + status + " ~"
					+ "packageParentId: " + packageParentId);
		}
		try {
			ForceDepService deploymentService = new ForceDepService();
			if ((action != null && action.equals(Constants.ACTION_UPDATEPACKAGES))
					&& (metadataLogId != null && !metadataLogId.isEmpty())) {
				deploymentService.updatePackages(bOrgId, bOrgToken, bOrgURL,
						bOrgRefreshToken, metadataLogId, status,
						packageParentId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
