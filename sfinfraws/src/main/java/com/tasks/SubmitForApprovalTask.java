package com.tasks;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.processflow.ProcessStatus;
import com.processflow.ProcessTrack;
import com.request.deploy.GetPackageRequest;
import com.response.deploy.GetPackageResponse;
import com.response.packages.DeletePackageResponse;
import com.services.application.SubmitForApprovalService;
import com.services.application.getpackage.GetPackageAppService;
import com.services.component.release.ReleaseEnvService;
import com.util.Constants;
import com.util.Org;

public class SubmitForApprovalTask implements Runnable {

	String metadataLogId;
	String sOrgId;
	String sOrgToken;
	String sOrgURL;
	String sOrgRefreshToken;
	String tOrgId;
	String tOrgToken;
	String tOrgURL;
	String tOrgRefreshToken;
	String releaseParentId;
	String releaseParentName;
	String releaseStatus;

	public SubmitForApprovalTask(String metadataLogId, String sOrgId,
			String sOrgToken, String sOrgURL, String sOrgRefreshToken,
			String tOrgId, String tOrgToken, String tOrgURL,
			String tOrgRefreshToken, String releaseParentId,
			String releaseParentName, String releaseStatus) {
		this.metadataLogId = metadataLogId;
		this.sOrgId = sOrgId;
		this.sOrgToken = sOrgToken;
		this.sOrgURL = sOrgURL;
		this.sOrgRefreshToken = sOrgRefreshToken;
		this.tOrgId = tOrgId;
		this.tOrgToken = tOrgToken;
		this.tOrgURL = tOrgURL;
		this.tOrgRefreshToken = tOrgRefreshToken;
		this.releaseParentId = releaseParentId;
		this.releaseParentName = releaseParentName;
		this.releaseStatus = releaseStatus;
	}

	@Override
	public void run() {
		String errors = null;
		boolean errorFlag = false;
		try {
			Org sOrg = new Org(getsOrgId(), getsOrgToken(), getsOrgURL(),
					getsOrgRefreshToken(), Constants.CustomOrgTypeID);
			Org tOrg = new Org(gettOrgId(), gettOrgToken(), gettOrgURL(),
					gettOrgRefreshToken(), Constants.CustomOrgTypeID);
			SubmitForApprovalService subForAppService = new SubmitForApprovalService(
					sOrg, tOrg, getMetadataLogId(), getReleaseParentId(),
					getReleaseParentName(), getReleaseStatus());
			subForAppService.initiate();
		} catch (Exception e) {
			errorFlag = true;
			StringWriter lerrors = new StringWriter();
			e.printStackTrace(new PrintWriter(lerrors));
			errors = lerrors.toString();
		} finally {
			if (errorFlag) {
				System.out.println("Release Operation Complete for requestId: "
						+ getReleaseParentId() + "\nWith Errors: " + errors);
			} else {
				System.out.println("Release Operation Complete for requestId: "
						+ getReleaseParentId());
			}
		}
	}

	public String getMetadataLogId() {
		return metadataLogId;
	}

	public void setMetadataLogId(String metadataLogId) {
		this.metadataLogId = metadataLogId;
	}

	public String getsOrgId() {
		return sOrgId;
	}

	public void setsOrgId(String sOrgId) {
		this.sOrgId = sOrgId;
	}

	public String getsOrgToken() {
		return sOrgToken;
	}

	public void setsOrgToken(String sOrgToken) {
		this.sOrgToken = sOrgToken;
	}

	public String getsOrgURL() {
		return sOrgURL;
	}

	public void setsOrgURL(String sOrgURL) {
		this.sOrgURL = sOrgURL;
	}

	public String getsOrgRefreshToken() {
		return sOrgRefreshToken;
	}

	public void setsOrgRefreshToken(String sOrgRefreshToken) {
		this.sOrgRefreshToken = sOrgRefreshToken;
	}

	public String gettOrgId() {
		return tOrgId;
	}

	public void settOrgId(String tOrgId) {
		this.tOrgId = tOrgId;
	}

	public String gettOrgToken() {
		return tOrgToken;
	}

	public void settOrgToken(String tOrgToken) {
		this.tOrgToken = tOrgToken;
	}

	public String gettOrgURL() {
		return tOrgURL;
	}

	public void settOrgURL(String tOrgURL) {
		this.tOrgURL = tOrgURL;
	}

	public String gettOrgRefreshToken() {
		return tOrgRefreshToken;
	}

	public void settOrgRefreshToken(String tOrgRefreshToken) {
		this.tOrgRefreshToken = tOrgRefreshToken;
	}

	public String getReleaseParentId() {
		return releaseParentId;
	}

	public void setReleaseParentId(String releaseParentId) {
		this.releaseParentId = releaseParentId;
	}

	public String getReleaseParentName() {
		return releaseParentName;
	}

	public void setReleaseParentName(String releaseParentName) {
		this.releaseParentName = releaseParentName;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

}