package com.webservices;

import java.util.List;

import javax.jws.WebService;

import com.services.ForceDepService;
import com.sforce.soap._2005._09.outbound.ASAMetadataLogCNotification;
import com.sforce.soap._2005._09.outbound.NotificationPort;
import com.sforce.soap.local.deploy.sobject.ASAMetadataLogC;
import com.util.Constants;

@WebService(endpointInterface = "com.sforce.soap._2005._09.outbound.NotificationPort")
public class SFServerMetadatalogRequestsImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<ASAMetadataLogCNotification> notification) {

	
		String metadataLogId = "";

		// TODO Auto-generated method stub
		System.out.println("Hello Release");
		System.out.println("organizationId : " + organizationId);
		System.out.println("actionId : " + actionId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("enterpriseUrl : " + enterpriseUrl);
		ASAMetadataLogC sobject = null;
		List<ASAMetadataLogCNotification> notifications = notification;
		System.out.println("arrSize: " + notification.size());
		String bOrgToken = null;
		String bOrgId = null;
		String bOrgURL = null;
		String bOrgRefreshToken = null;
		
		String releaseName = "";
		String releaseId = "";
		String releaseStatus = "";
		String packageAction = "";
		String status = "";
		String packageParentId = "";

		int arrSize = notification.size();

		for (int i = 0; i < arrSize; i++) {
			sobject = (ASAMetadataLogC) notification.get(i).getSObject();
			metadataLogId = sobject.getId();
			System.out.println("sObject Id: " + sobject.getId());
			bOrgId = sobject.getASABaseOrgIdC().getValue();
			bOrgURL = sobject.getASABaseOrgUrlC().getValue();
			bOrgToken = sobject.getASABaseOrgTokenC().getValue();
			bOrgRefreshToken = sobject.getASABaseOrgRefreshTokenC().getValue();
			packageAction = sobject.getASAActionC().getValue();
			System.out.println("bOrgId: " + bOrgId + "~bOrgURL: " + bOrgURL
					+ "~bOrgToken: " + bOrgToken + "~bOrgRefreshToken: "
					+ bOrgRefreshToken + "~Action: " + packageAction);
		}

		try {
			ForceDepService deploymentService = new ForceDepService();

			// Activate Release in target environments
			if ((metadataLogId != null && !metadataLogId.isEmpty())
					&& packageAction.equals(Constants.RELEASE_STATUS_ACTIVE)) {
				System.out.println("Initiate/Create Release in target Env");
				releaseName = sobject.getASANameC().getValue();
				releaseId = sobject.getASAIDC().getValue();
				releaseStatus = sobject.getASAStatusC().getValue();

				System.out.println("releaseName: " + releaseName
						+ "~releaseId: " + releaseId + "~status: "
						+ releaseStatus);
				deploymentService.release(bOrgId, bOrgToken, bOrgURL,
						bOrgRefreshToken, releaseId, releaseName,
						releaseStatus, metadataLogId);
				return true;
			}

			// releaseSync - with getPackages
			else if ((metadataLogId != null && !metadataLogId.isEmpty())
					&& packageAction.equals(Constants.ACTION_GETPACKAGES)) {
				System.out.println("GetPackages");
				releaseName = sobject.getASANameC().getValue();
				releaseId = sobject.getASAIDC().getValue();
				releaseStatus = sobject.getASAStatusC().getValue();

				System.out.println("releaseName: " + releaseName
						+ "~releaseId: " + releaseId + "~status: "
						+ releaseStatus);
				deploymentService.getPackages(bOrgId, bOrgToken, bOrgURL,
						bOrgRefreshToken, releaseId, releaseName,
						releaseStatus, metadataLogId);
				return true;
			}
			// releseSync - with updatePackages
			else if ((metadataLogId != null && !metadataLogId.isEmpty())
					&& packageAction.equals(Constants.ACTION_UPDATEPACKAGES)) {
				System.out.println("UpdatePackages");
				status = sobject.getASAStatusC().getValue();
				packageParentId = sobject.getASAIDC().getValue();
				System.out.println("status: " + status + " ~"
						+ "packageParentId: " + packageParentId);
				deploymentService.updatePackages(bOrgId, bOrgToken, bOrgURL,
						bOrgRefreshToken, metadataLogId, status,
						packageParentId);
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
