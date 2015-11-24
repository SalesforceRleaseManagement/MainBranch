package com.services.component;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import com.domain.MetaBean;
import com.domain.MetadataLogDO;
import com.ds.salesforce.dao.comp.DeployMetadataDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.services.application.RDAppService;
import com.tasks.PreProcessingTask;
import com.util.Constants;
import com.util.FileBasedDeploy;
import com.util.FileBasedRetrieve;
import com.util.SFoAuthHandle;
import com.util.app.DeployList;
import com.util.oauth.RefreshTokens;

public class FDDeployCompService {

	public FDDeployCompService() {
		super();
	}

	public void deploy(String bOrgId, String bOrgToken, String bOrgURL,
			String refreshToken, String metadataLogId, boolean isValidate) {
		MetadataLogDO metadataLogDO = null;
		SFoAuthHandle sfSourceHandle = null;
		SFoAuthHandle sfTargetHandle = null;

		// do pre-processing
		// does some sanity checks on input variables
		// updates the refreshed tokens in Environment
		PreProcessingTask preProcessingTask = new PreProcessingTask(bOrgId,
				bOrgToken, bOrgURL, refreshToken, Constants.BaseOrgID,
				metadataLogId);
		preProcessingTask.doPreProcess();

		// get refreshed base token
		bOrgToken = RefreshTokens.getoAuthToken();
		String packageName = "";

		try {
			// Get Meta data Log details
			metadataLogDO = RDAppService.findMetadataLog(metadataLogId,
					FDGetSFoAuthHandleService.getSFoAuthHandle(bOrgId,
							bOrgToken, bOrgURL, refreshToken,
							Constants.BaseOrgID));
			// nullify connection
			FDGetSFoAuthHandleService.setSfHandleToNUll();

			// updating metadataLog to prcessing state
			RDAppService.updateMetadataLogStatus(metadataLogDO,
					Constants.PROCESSING_STATUS, FDGetSFoAuthHandleService
							.getSFoAuthHandle(bOrgId, bOrgToken, bOrgURL,
									refreshToken, Constants.BaseOrgID));
			// nullify connection
			FDGetSFoAuthHandleService.setSfHandleToNUll();

			if ((metadataLogDO.getAction() != null)
					&& ((metadataLogDO.getAction().equals("Deploy")) || (metadataLogDO
							.getAction().equals("Validate")))) {
				if (metadataLogDO.getStatus() != null
						&& (metadataLogDO.getStatus()
								.equals(Constants.PROCESSING_STATUS))) {
					System.out.println("Action"+metadataLogDO.getAction());
					DeployMetadataDAO deployMetadataDAO = new DeployMetadataDAO();

					// find to be deployed object list
					List<Object> deployList = deployMetadataDAO.findById(
							metadataLogDO.getLogName(),
							FDGetSFoAuthHandleService.getSFoAuthHandle(bOrgId,
									bOrgToken, bOrgURL, refreshToken,
									Constants.BaseOrgID));
					FDGetSFoAuthHandleService.setSfHandleToNUll();

					// get source salesforce handle
					sfSourceHandle = FDGetSFoAuthHandleService
							.getSFoAuthHandle(((MetaBean) deployList.get(0))
									.getSourceOrg(), bOrgId, bOrgToken,
									bOrgURL, refreshToken,
									Constants.CustomOrgID);

					// get target salesforce handle
					sfTargetHandle = FDGetSFoAuthHandleService
							.getSFoAuthHandle(((MetaBean) deployList.get(0))
									.getTargetOrg(), bOrgId, bOrgToken,
									bOrgURL, refreshToken,
									Constants.CustomOrgID);

					/*
					 * for (Iterator iterator = deployList.iterator(); iterator
					 * .hasNext();) { MetaBean object = (MetaBean)
					 * iterator.next(); String templateType=object.getType();
					 * 
					 * if(templateType.equals("EmailTemplate")) {
					 * templateType="Email"; String emailSQL =
					 * "Select Id, Name,Type" +
					 * " FROM Folder where Type = '"+templateType+"'";
					 * 
					 * EnterpriseConnection conn =
					 * sfSourceHandle.getEnterpriseConnection();
					 * System.out.println(conn.toString()); QueryResult
					 * queryResults = conn.query(emailSQL);
					 * System.out.println(queryResults.getSize()); if
					 * (queryResults.getSize() > 0) { for (int i = 0; i <
					 * queryResults.getRecords().length; i++) { // cast the
					 * SObject to a strongly-typed Contact
					 * com.sforce.soap.enterprise.sobject.Folder retObj =
					 * (com.sforce.soap.enterprise.sobject.Folder) queryResults
					 * .getRecords()[i]; String name=retObj.getName(); String
					 * type=retObj.getType();
					 * System.out.println("folder name"+name);
					 * System.out.println("Type name"+type);
					 * 
					 * String accessType=retObj.getAccessType();
					 * System.out.println("Access Type"+accessType); boolean
					 * isReadonly=true; CustomObjectTest cot=new
					 * CustomObjectTest();
					 * cot.insert(name,type,accessType,sfTargetHandle); }
					 * 
					 * }
					 * 
					 * }
					 * 
					 * }
					 */

					// gets the map by order
					LinkedHashMap<String, List<MetaBean>> deployMap = (new DeployList())
							.getDeployListByOrder2(deployList);

					Iterator<Map.Entry<String, List<MetaBean>>> entries = deployMap
							.entrySet().iterator();
					while (entries.hasNext()) {
						Entry<String, List<MetaBean>> thisEntry = (Entry<String, List<MetaBean>>) entries
								.next();
						Double orderKey = 0.0;
						String currPackg = "";
						// Double orderKey = (Double) thisEntry.getKey();
						String orderKeyStr = (String) thisEntry.getKey();
						StringTokenizer st = new StringTokenizer(orderKeyStr,
								"~");
						if (st.hasMoreTokens()) {
							String s1 = st.nextToken();
							System.out.println("OrderKey : " + s1);
							orderKey = new Double(s1);
						}
						if (st.hasMoreTokens()) {
							String s1 = st.nextToken();
							System.out.println("current Package Name: " + s1);
							packageName = s1;
						}

						System.out.println("cmpStr: " + orderKey);
						List<MetaBean> metabeanList = (List<MetaBean>) thisEntry
								.getValue();
						// packageName = metabeanList.get(0).getPackageName();
						String msg = "";
						try {
							FDSFXMLPackageCompService xmlService = new FDSFXMLPackageCompService();
							xmlService.createPackageXML(metabeanList);
							deployObjToTargetOrg(sfSourceHandle,
									sfTargetHandle, packageName, isValidate);

							Thread.sleep(Constants.waitFor1Sec);
							msg = Constants.DEPLOY_SUCESS_MESSAGE;
						} catch (Exception e) {
							msg = e.getMessage();
						} finally {
							// String packgNames =
							// metadataLogDO.getNoOfPackgsByOrderMap().get(orderKey);
							System.out.println("package Names: " + packageName);
							RDAppService.updateDeploymentDetails(metadataLogId,
									msg + " for package: " + packageName,
									metadataLogDO.getSourceOrgId(),
									FDGetSFoAuthHandleService.getSFoAuthHandle(
											bOrgId, bOrgToken, bOrgURL,
											refreshToken, Constants.BaseOrgID));
						}
					}
					if (sfSourceHandle != null) {
						sfSourceHandle.nullify();
					}
					sfSourceHandle = null;
					if (sfTargetHandle != null) {
						sfTargetHandle.nullify();
					}
					sfTargetHandle = null;

					// Update MetadataLog status to Completed
					FDGetSFoAuthHandleService.setSfHandleToNUll();
					RDAppService.updateMetadataLogStatus(metadataLogDO,
							Constants.COMPLETED_STATUS,
							FDGetSFoAuthHandleService.getSFoAuthHandle(bOrgId,
									bOrgToken, bOrgURL, refreshToken,
									Constants.BaseOrgID));

					// nullify connection
					FDGetSFoAuthHandleService.setSfHandleToNUll();
				}
			} else {
				// Sleep for few sec to let status updated to "Processing"
				Thread.sleep(Constants.waitFor2Sec);
			}
		} catch (SFException e) {
			if (metadataLogDO != null) {
				// refresh connection
				FDGetSFoAuthHandleService.setSfHandleToNUll();
				// updating metadataLog
				RDAppService.updateMetadataLogStatus(metadataLogDO,
						Constants.ERROR_STATUS, FDGetSFoAuthHandleService
								.getSFoAuthHandle(bOrgId, bOrgToken, bOrgURL,
										refreshToken, Constants.BaseOrgID));
				// refresh connection
				FDGetSFoAuthHandleService.setSfHandleToNUll();
				// updating Deploy Details
				RDAppService.updateDeploymentDetails(metadataLogId, e
						.getMessage(), metadataLogDO.getSourceOrgId(),
						FDGetSFoAuthHandleService.getSFoAuthHandle(bOrgId,
								bOrgToken, bOrgURL, refreshToken,
								Constants.BaseOrgID));
				// refresh connection
				FDGetSFoAuthHandleService.setSfHandleToNUll();
			} else {
				System.out.println("Salesforce Exception " + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (metadataLogDO != null) {
				// refresh connection
				FDGetSFoAuthHandleService.setSfHandleToNUll();
				// updating metadataLog
				RDAppService.updateMetadataLogStatus(metadataLogDO,
						Constants.ERROR_STATUS, FDGetSFoAuthHandleService
								.getSFoAuthHandle(bOrgId, bOrgToken, bOrgURL,
										refreshToken, Constants.BaseOrgID));

				// refresh connection
				FDGetSFoAuthHandleService.setSfHandleToNUll();
				// updating Deploy Details
				RDAppService.updateDeploymentDetails(metadataLogId, e
						.getMessage(), metadataLogDO.getSourceOrgId(),
						FDGetSFoAuthHandleService.getSFoAuthHandle(bOrgId,
								bOrgToken, bOrgURL, refreshToken,
								Constants.BaseOrgID));
				// refresh connection
				FDGetSFoAuthHandleService.setSfHandleToNUll();
			} else {
				System.out.println("Salesforce Exception " + e.getMessage());
			}
		}
	}

	private void deployObjToTargetOrg(SFoAuthHandle sfSourceHandle,
			SFoAuthHandle sfTargetHandle, String packageName, boolean isValidate)
			throws SFException {

		FileBasedRetrieve retrieveObjectsFromSource = new FileBasedRetrieve();
		try {
			retrieveObjectsFromSource.retrieve(sfSourceHandle, packageName);
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new SFException(e.toString(), SFErrorCodes.FileRetrieve_Error);
		}

		try {
			(new FileBasedDeploy()).deploy(sfTargetHandle, packageName,
					isValidate);
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println(e.toString());
			throw new SFException(e.toString(), SFErrorCodes.FileDeploy_Error);
		}
	}
}
