package com.webservices;

import java.util.List;

import javax.jws.WebService;

import org.sforce.soap._2005._09.outbound.ASAClientMetadataLogInformationCNotification;
import org.sforce.soap._2005._09.outbound.NotificationPort;
import org.sforce.soap.local.sobject.ASAClientMetadataLogInformationC;

import com.services.ForceDepService;
import com.util.Constants;

/**
 * @author root6
 *
 */
@WebService(endpointInterface = "org.sforce.soap._2005._09.outbound.NotificationPort")
public class SFClientMetalogInformationRequestsImpl implements NotificationPort {

	public boolean notifications(String organizationId, String actionId,
			String sessionId, String enterpriseUrl, String partnerUrl,
			List<ASAClientMetadataLogInformationCNotification> notification) {

		String orgId = organizationId;
		String actId = actionId;
		String sId = sessionId;
		String eUrl = enterpriseUrl;
		String pUrl = partnerUrl;
		String metadataLogId = "";

		// TODO Auto-generated method stub
		System.out.println("Hello Retrieve");
		System.out.println("organizationId : " + organizationId);
		System.out.println("actionId : " + actionId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("enterpriseUrl : " + enterpriseUrl);
		ASAClientMetadataLogInformationC sobject = null;
		List<ASAClientMetadataLogInformationCNotification> notifications = notification;
		System.out.println("arrSize: " + notification.size());
		String bOrgToken = null;
		String bOrgId = null;
		String bOrgURL = null;
		String bOrgRefreshToken = null;
		String sOrgId = null;
		String sOrgURL = null;
		String sOrgToken = null;
		String sOrgRefreshToken = null;
		String tOrgId = null;
		String tOrgURL = null;
		String tOrgToken = null;
		String tOrgRefreshToken = null;
		String status = "";
		String pkgId = "";
		String metadataLogAction = "";

		int arrSize = notification.size();
		for (int i = 0; i < arrSize; i++) {
			sobject = (ASAClientMetadataLogInformationC) notification.get(i)
					.getSObject();
			metadataLogId = sobject.getId();
			System.out.println("Id: " + sobject.getId());
			bOrgId = sobject.getASAClientBaseOrgIdC().getValue();
			bOrgURL = sobject.getASAClientBaseOrgUrlC().getValue();
			bOrgToken = sobject.getASAClientBaseOrgTokenC().getValue();
			bOrgRefreshToken = sobject.getASAClientBaseOrgRefreshTokenC()
					.getValue();
			metadataLogAction = sobject.getASAClientActionC().getValue();
			System.out.println("bOrgId: " + bOrgId + "~bOrgURL: " + bOrgURL
					+ "~bOrgToken: " + bOrgToken + "~bOrgRefreshToken: "
					+ bOrgRefreshToken + "~Action: " + metadataLogAction);

		}
		try {
			ForceDepService deploymentService = new ForceDepService();

			if ((metadataLogId != null && !metadataLogId.isEmpty())
					&& metadataLogAction.equals(Constants.ACTION_RETRIEVE)) {
				deploymentService.retrieveClient(bOrgId, bOrgToken, bOrgURL,
						bOrgRefreshToken, metadataLogId);
				return true;
			} else if ((metadataLogId != null && !metadataLogId.isEmpty())
					&& metadataLogAction.equals(Constants.SUBMIT_FOR_APPROVAL)) {

				System.out.println("Commit");
				sOrgId = sobject.getASAClientOrganizationIdC().getValue();
				System.out.println("Commit1");
				sOrgURL = sobject.getASAClientSourceOrganizationURLC()
						.getValue();
				System.out.println("Commit2");
				sOrgToken = sobject.getASAClientSourceOrgTokenC().getValue();
				System.out.println("Commit3");
				sOrgRefreshToken = sobject.getASAClientSourceOrgRefreshTokenC()
						.getValue();
				System.out.println("Commit4");
				System.out.println("sOrgId: " + sOrgId + " ~" + "sOrgURL: "
						+ sOrgURL + " ~" + "sOrgToken: " + sOrgToken + " ~"
						+ "sOrgRefreshToken: " + sOrgRefreshToken);

				tOrgId = "";
				tOrgURL = "";
				tOrgToken = sobject.getASAClientTargetOrgTokenC().getValue();
				tOrgRefreshToken = sobject.getASAClientTargetOrgRefreshTokenC()
						.getValue();

				status = sobject.getASAClientStatusC().getValue();
				pkgId = sobject.getASAClientIDC().getValue();
				System.out.println("status: " + status + " ~" + "packageId: "
						+ pkgId);

				
				
				
				deploymentService.submitForApproval(bOrgId, bOrgToken, bOrgURL,
						bOrgRefreshToken, sOrgId, sOrgToken, sOrgURL,
						sOrgRefreshToken, status, pkgId, metadataLogId);
				
				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
