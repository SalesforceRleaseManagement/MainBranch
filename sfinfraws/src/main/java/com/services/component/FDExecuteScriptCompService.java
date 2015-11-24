package com.services.component;

import com.domain.TestMetadataLogDO;
import com.services.application.RDAppService;
import com.util.Constants;
import com.util.SFoAuthHandle;

public class FDExecuteScriptCompService {

	public FDExecuteScriptCompService() {
		super();
	}

	public static void main(String[] args) {
		String userId = "skrishna@developertest.com";
		String passwd = "infrascape3srAF8wqAps26TIYMXayRMYTl";
		String serverURL = "https://na34.salesforce.com";

		executeScript(userId, passwd, serverURL, "a0161000002ELwT");
	}

	public static void executeScript(String userId, String passwd,
			String serverURL, String metadataLogId) {

		TestMetadataLogDO testMetadataLogDO = null;

		SFoAuthHandle sfHandle = new SFoAuthHandle(userId, passwd, serverURL,
				"");

		try {

		/*	RegistrationTest r = new RegistrationTest();

			r.testRegister();*/

			// Get Meta data Log details
			testMetadataLogDO = RDAppService.findTestMetadataLog(metadataLogId,
					sfHandle);

			// updating metadataLog to processing state
			RDAppService.updateTestMetadataLogStatus(testMetadataLogDO,
					Constants.COMPLETED_STATUS, sfHandle);
	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
