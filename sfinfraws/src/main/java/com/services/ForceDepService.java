package com.services;

import com.tasks.DeployTask;
import com.tasks.ExecuteScript;
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

		
	 /*    String bOrgId = "00D610000006tjPEAQ"; 
		 String bOrgToken ="00D610000006tjP!AQ4AQLpMKFRZYlHFja7spuak1Eq_C4DoCZVc8qrx8L1ry.5B1LSIG_40GXjIqGyY_JCihNpeFT8JVdFvkEodeROS1PcgFRGD";
		 String bOrgURL = "https://na34.salesforce.com"; 
		 String refreshToken="5Aep861tbt360sO1.uO0UjNoRyP9rNbAguo__QeBtE9I0DtmCAWn8r4UIu4tzqbg2okzwzEmBzokQe8gXPTDFXb";
		 String releaseParentName = "releasetest"; 
		 String releaseParentId="a0B28000000fWDOEA2";
		 String releaseStatus = "Active"; 
		 String metadataLogId = "a05610000028bTU";
         deploy(bOrgId, bOrgToken, bOrgURL, refreshToken, metadataLogId, true);		 

		/*String metadataLogId = "a0361000004SosV";
		String bOrgId = "00D610000007yNVEAY";
		String bOrgToken = "00D610000007yNV!ARcAQHRg06nkk_4oU6b5Ngnc59._NLgeK3Pcxv2VC5mnK6WrUSRHUIi0MM7UEd7SSHxzCu0Wk_BX9qSfH5uZDLMKw_Cu4KQ6";
		String bOrgURL = "https://na34.salesforce.com";
		String bOrgRefreshToken = "5Aep861tbt360sO1.skXKEfcaogqPgWJf14yO4wDCxuG5pNkRrNI3BUV8RwxKYj.8eS8IrTWpJPDYmwD3K7gBFz";

		String sOrgId = "00D280000015PQNEA2";
		String sOrgToken = "00D280000015PQN!ARcAQNUvsM72PP5XrXv.nbd6Kz3PtxvZzhtUNFKxulGYmb8EuatLx3bpLzgnTHY9R4FU17LCSuTuwAR1pl3saS3CxXiYMy.t";
		String sOrgURL = "https://ap2.salesforce.com";
		String sOrgRefreshToken = "5Aep861TSESvWeug_ytZDT0kfhfRrZrur.x0WtU9rQ1FUR1vzhy2q222c7rre5NCCNBAY6cdcr66LRYbw9o8qSj";

		String tOrgId = "";
		String tOrgToken = "";
		String tOrgURL = "";
		String tOrgRefreshToken = "";

		String status = "open";
		String pkgId = "a05610000016IGxAAM";
		submitForApproval(bOrgId, bOrgToken, bOrgURL, bOrgRefreshToken, sOrgId,
				sOrgToken, sOrgURL, sOrgRefreshToken, tOrgId, tOrgToken,
				tOrgURL, tOrgRefreshToken, status, pkgId, metadataLogId);*/
		
		
		/*
		 * getPackages(bOrgId, bOrgToken, bOrgURL, refreshToken,
		 * releaseParentId, releaseParentName, releaseStatus, metadataLogId);
		 * getPackages(bOrgId, bOrgToken, bOrgURL, refreshToken,
		 * releaseParentId, releaseParentName, releaseStatus, metadataLogId);
		 */
		//executeScript(Constants.userId, Constants.passwd, Constants.serverURL,"a0161000002rbAS");
  
	}

	public static void main(String[] args) {
		ForceDepService sr = new ForceDepService();
	}

	public void deploy(String bOrgId, String bOrgToken, String bOrgURL,
			String refreshtoken, String metadataLogId, boolean isValidate) {
		Runnable task;
		try {
			System.out.println("Deploy Prococess Initiated with: ");
			System.out.println("bOrgId : " + bOrgId + "~" + "bOrgURL : "
					+ bOrgURL + "~" + "bOrgToken : " + bOrgToken + "~");
			System.out.println("metadata Log Id: " + metadataLogId);
			task = new DeployTask(bOrgId, bOrgToken, bOrgURL, refreshtoken,
					metadataLogId, isValidate);
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

	public boolean submitForApproval(String bOrgId, String bOrgToken,
			String bOrgURL, String bOrgRefreshToken, String sOrgId,
			String sOrgToken, String sOrgURL, String sOrgRefreshToken,
			String status, String pkgId,
			String metadataLogId) {

		Runnable task;
		try {
			task = new SubmitForApprovalTask(bOrgId, bOrgToken, bOrgURL,
					bOrgRefreshToken, sOrgId, sOrgToken, sOrgURL,
					sOrgRefreshToken,status, pkgId, metadataLogId);
			/*
			 String bOrgId,
			String bOrgToken, String bOrgURL, String bOrgRefreshToken,String sOrgId,
			String sOrgToken, String sOrgURL, String sOrgRefreshToken,String tOrgId,
			String tOrgToken, String tOrgURL, String tOrgRefreshToken,
			String status, String pkgId, String metadataLogId
			 */
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out
					.println("Submit for Approval operation Initiated for requestId: "
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
	public boolean executeScript(String userId, String passwd,
		String serverURL,String metadataLogId,String testcasename) {
		Runnable task;
		try {
			task = new ExecuteScript(userId, passwd,serverURL,metadataLogId,testcasename);
			Thread t = new Thread(task);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("ExecuteScript  operation Initiated for requestId: "
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
