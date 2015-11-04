package com.services;

import com.tasks.DeployTask;
import com.tasks.GetPackagesTask;
import com.tasks.ReleaseTask;
import com.tasks.RetrieveClientTask;
import com.tasks.RetrieveTask;
import com.tasks.SubmitForApprovalTask;
import com.tasks.UpdatePackagesTask;
import com.util.Constants;

public class ForceDepService {

	public ForceDepService() {
		super();

		// c_t =
		// "00DS0000003Km6L!AQsAQFe_T3SXsKTpVRuZxE44jBIKQz3AsTRouOS1pTx2JeyqIEa0Q0flNY3DpKGEl6Av5wW1t2.5j4oUcOr0vhcxpTBD8IH1";
		/*
		 * System.out.println("start"); System.out.println("start"); String
		 * metadataLogId = "a0561000001G0Fc"; String bOrgId =
		 * "00D61000000YB04EAG"; String bOrgToken =
		 * "00D61000000YB04!ARMAQEzqgaI2XMAjdqRNrjYsf.udQEoS4JJNPbKT3n328ChmyvavNDEsyQAsbmUE0Kp6.o4ZHrgRIl3JAfMeaQK1OWVL6BYr"
		 * ; String bOrgURL = "https://na34.salesforce.com"; String refreshToken
		 * =
		 * "5Aep861tbt360sO1.vrCA2niEfjpVBi4p6yJyk8asYbgI1pFhgWfM8.e2ULvouzlfc9T41V84fSIRRa6yQNXItS"
		 * ; String releaseParentId = "a0B61000000xkL1EAI";
		 * 
		 * String releaseParentName = "oct18getPackageTimeTesting"; String
		 * releaseStatus = "Active"; getPackages(bOrgId, bOrgToken, bOrgURL,
		 * refreshToken, releaseParentId, releaseParentName, releaseStatus,
		 * metadataLogId); //deploy(bOrgId, bOrgToken, bOrgURL, refreshToken,
		 * metadataLogId);
		 * 
		 * /*retrieve(bOrgId, bOrgToken, bOrgURL,refreshToken, metadataLogId);
		 * 
		 * getPackages(bOrgId, bOrgToken, bOrgURL, refreshToken,
		 * releaseParentId, releaseParentName, releaseStatus, metadataLogId); //
		 * retrieve(bOrgId, bOrgToken, bOrgURL,refreshToken, metadataLogId);
		 * 
		 * // release(bOrgId, bOrgToken, bOrgURL, refreshToken, releaseParentId,
		 * // releaseParentName, releaseStatus);
		 */

		/*
		 * String bOrgId = "00D610000006tjPEAQ"; String bOrgToken =
		 * "00D610000006tjP!AQ4AQLpMKFRZYlHFja7spuak1Eq_C4DoCZVc8qrx8L1ry.5B1LSIG_40GXjIqGyY_JCihNpeFT8JVdFvkEodeROS1PcgFRGD"
		 * ; String bOrgURL = "https://na34.salesforce.com"; String refreshToken
		 * =
		 * "5Aep861tbt360sO1.uO0UjNoRyP9rNbAguo__QeBtE9I0DtmCAWn8r4UIu4tzqbg2okzwzEmBzokQe8gXPTDFXb"
		 * ; String releasename = "Oct5Release"; String releaseId =
		 * "a0B61000000mnDvEAI"; String releaseStatus = "Active"; String
		 * metadataLogId = "a0561000000zIFq"; String
		 * packageParentId="a0561000000b1HUAAY"; //getPackages(bOrgId,
		 * bOrgToken, bOrgURL, refreshToken, releaseId, releasename,
		 * releaseStatus, metadataLogId); updatePackages(bOrgId, bOrgToken,
		 * bOrgURL, refreshToken, metadataLogId, "False", packageParentId);
		 */

		String metadataLogId = "a0561000001G0Fc";
		String bOrgId = "00D280000015PQNEA2";
		String bOrgToken = "00D280000015PQN!ARcAQILsXvs5xULSLbrh23hvg4yzkNj6qi7yGQ0u3KVdREgy8HNLIJC5XN56XDiwXyB5U1l3I67BN215o6SEnaPOmQgFSy3d";
		String bOrgURL = "https://ap2.salesforce.com";
		String refreshToken = "5Aep861TSESvWeug_ytZDT0kfhfRrZrur.x0WtU9rQ1FUR1vzgSBU5.lbwDVYiI7IcbGs2vraRk.46K3JhnbM5A";
		String releaseParentId = "a0B28000000fXRJEA2";

		String releaseParentName = "test";
		String releaseStatus = "Active";
		getPackages(bOrgId, bOrgToken, bOrgURL, refreshToken, releaseParentId,
				releaseParentName, releaseStatus, metadataLogId);
		getPackages(bOrgId, bOrgToken, bOrgURL, refreshToken, releaseParentId,
				releaseParentName, releaseStatus, metadataLogId);

	}

	public static void main(String[] args) {
		ForceDepService sr = new ForceDepService();
	}

	public void deploy(String bOrgId, String bOrgToken, String bOrgURL,
			String refreshtoken, String metadataLogId) {
		Runnable task;
		try {
			System.out.println("Deploy Prococess Initiated with: ");
			System.out.println("bOrgId : " + bOrgId + "~" + "bOrgURL : "
					+ bOrgURL + "~" + "bOrgToken : " + bOrgToken + "~");
			System.out.println("metadata Log Id: " + metadataLogId);
			task = new DeployTask(bOrgId, bOrgToken, bOrgURL, refreshtoken,
					metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Deploy operation Initiated for requestId: "
					+ metadataLogId);
		}
	}

	public boolean retrieve(String bOrgId, String bOrgToken, String bOrgURL,
			String bOrgRefreshToken, String metadataLogId) {
		Runnable task;
		try {
			task = new RetrieveTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Retrieve operation Initiated for requestId: "
					+ metadataLogId);
		}
		return true;
	}

	public boolean updatePackages(String bOrgId, String bOrgToken,
			String bOrgURL, String bOrgRefreshToken, String metadataLogId,
			String status, String packageParentId) {
		Runnable task;
		try {
			task = new UpdatePackagesTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, status, packageParentId, metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Retrieve operation Initiated for requestId: "
					+ metadataLogId);
		}
		return true;
	}

	public boolean submitForApproval(String metadataLogId, String sOrgId,
			String sOrgToken, String sOrgURL, String sOrgRefreshToken,
			String tOrgId, String tOrgToken, String tOrgURL,
			String tOrgRefreshToken, String releaseParentId,
			String releaseParentName, String releaseStatus) {
		Runnable task;
		try {
			task = new SubmitForApprovalTask(metadataLogId, sOrgId, sOrgToken,
					sOrgURL, sOrgRefreshToken, tOrgId, tOrgToken, tOrgURL,
					tOrgRefreshToken, releaseParentId, releaseParentName,
					releaseStatus);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Retrieve operation Initiated for requestId: "
					+ metadataLogId);
		}
		return true;
	}

	public boolean retrieveClient(String bOrgId, String bOrgToken,
			String bOrgURL, String bOrgRefreshToken, String metadataLogId) {
		Runnable task;
		try {
			task = new RetrieveClientTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, Constants.CustomBaseOrgID, metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Retrieve operation Initiated for requestId: "
					+ metadataLogId);
		}
		return true;
	}

	public boolean release(String bOrgId, String bOrgToken, String bOrgURL,
			String bOrgRefreshToken, String releaseParentId,
			String releaseParentName, String releaseStatus, String metadataLogId) {
		Runnable task;
		try {
			task = new ReleaseTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, releaseParentId, releaseParentName,
					releaseStatus, metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Release operation Initiated for requestId: "
					+ releaseParentId);
		}
		return true;
	}

	public boolean getPackages(String bOrgId, String bOrgToken, String bOrgURL,
			String bOrgRefreshToken, String releaseParentId,
			String releaseParentName, String releaseStatus, String metadataLogId) {
		Runnable task;
		try {
			task = new GetPackagesTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, releaseParentId, releaseParentName,
					releaseStatus, metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Package operation Initiated for requestId: "
					+ releaseParentId);
		}
		return true;
	}

	public boolean getPackageInformation(String bOrgId, String bOrgToken,
			String bOrgURL, String bOrgRefreshToken, String releaseParentId,
			String releaseParentName, String releaseStatus, String metadataLogId) {
		Runnable task;
		try {
			task = new ReleaseTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, releaseParentId, releaseParentName,
					releaseStatus, metadataLogId);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Release operation Initiated for requestId: "
					+ releaseParentId);
		}
		return true;
	}
}
