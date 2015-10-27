package com.junit.enterprise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.commons.logging.Log;
import org.hamcrest.core.IsInstanceOf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.MetaBean;
import com.ds.salesforce.dao.comp.CustomSettingDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.future.ListObjectsFromSourceFutureTask;
import com.services.component.FDGetComponentsTypesCompService;
import com.services.component.FDGetSFoAuthHandleService;
import com.sforce.soap.enterprise.DescribeGlobalResult;
import com.sforce.soap.enterprise.DescribeGlobalSObjectResult;
import com.sforce.soap.enterprise.DescribeSObjectResult;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.Field;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.ASA__DeploymentSetting__c;
import com.sforce.soap.enterprise.sobject.ASA__Enviroment__c;
import com.sforce.soap.enterprise.sobject.ASA__MetadataLog__c;
import com.sforce.soap.enterprise.sobject.Folder;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.soap.metadata.FileProperties;
import com.sforce.soap.metadata.ListMetadataQuery;
import com.sforce.ws.ConnectionException;
import com.util.Constants;
import com.util.SFoAuthHandle;

/**
 * 
 * @author CustomObjectTest is JUnit TestCase Used To create Sample Custom
 *         Objects CustomObj_
 * 
 *
 */
public class CustomObjectTest {
	SFoAuthHandle sfHandle = null;
	private static final Logger LOG = LoggerFactory
			.getLogger(CustomObjectTest.class);
	// ASA__MetadataLog__c
	// ASA__Enviroment__c
	// String[] ObjecList = {
	// "com.sforce.soap.enterprise.sobject.ASA__MetadataDescription__c"};
	String[] ObjecList = { "TestSettings__c" };

	public CustomObjectTest() {

		String orgId = "";
		orgId = "00D280000015PQNEA2";
		// orgId="00Do0000000dw2D";
		String token = "00D280000015PQN!ARcAQILsXvs5xULSLbrh23hvg4yzkNj6qi7yGQ0u3KVdREgy8HNLIJC5XN56XDiwXyB5U1l3I67BN215o6SEnaPOmQgFSy3d";
		String rtoken = "5Aep861TSESvWeug_ytZDT0kfhfRrZrur.x0WtU9rQ1FUR1vzgSBU5.lbwDVYiI7IcbGs2vraRk.46K3JhnbM5A";
		String url = "https://ap2.salesforce.com";
		sfHandle = FDGetSFoAuthHandleService.getSFoAuthHandle(orgId, token,
				url, rtoken, Constants.BaseOrgID);
		// listMetadata(sfHandle);
		// insert(sfHandle);
		long startTime = System.currentTimeMillis();
		LOG.info("start for connection");
		sfHandle = FDGetSFoAuthHandleService.getSFoAuthHandle(orgId, token,
				url, rtoken, Constants.BaseOrgID);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		LOG.info("Time difference for connection:" + totalTime / 1000
				+ " seconds");
		describeSFObjects(orgId, ObjecList, sfHandle);
	}

	public static void main(String[] args) throws Exception {
		CustomObjectTest sfi = new CustomObjectTest();
	}

	public boolean isObjectAvailable(String orgId, String objName,
			SFoAuthHandle sfHandle) {
		String[] listStr = listAllSFGlobalObjects(orgId, sfHandle);
		for (int i = 0; i < listStr.length; i++) {
			String string = listStr[i];
			if (string.equals(objName)) {
				System.out.println("Object " + objName + " is available in "
						+ orgId);
				return true;
			}
		}
		return false;
	}

	public String[] listAllSFGlobalObjects(String orgId, SFoAuthHandle sfHandle) {
		String[] objlist = null;
		try {
			// Environment env = new Environment();
			// Enviroment__c envObj = env.queryObject(orgId);
			DescribeGlobalResult describeGlobalResult = sfHandle
					.getEnterpriseConnection().describeGlobal();
			// Get the sObjects from the describe global result
			DescribeGlobalSObjectResult[] sobjectResults = describeGlobalResult
					.getSobjects();

			objlist = new String[sobjectResults.length];
			// Write the name of each sObject to the console
			for (int i = 0; i < sobjectResults.length; i++) {
				objlist[i] = sobjectResults[i].getName();

				System.out.println("Hello: " + sobjectResults[i]);

			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
		return objlist;
	}

	public void listMetadata(SFoAuthHandle sfhandle) {
		try {

			ListMetadataQuery query = new ListMetadataQuery();

			// query.setFolder(null);
			double asOfVersion = 33.0;
			// Assuming that the SOAP binding has already been established.
			FileProperties[] lmr = sfHandle.getMetadataConnection()
					.listMetadata(new ListMetadataQuery[] { query },
							asOfVersion);
			if (lmr != null) {
				for (FileProperties n : lmr) {
					System.out
							.println("Component fullName: " + n.getFullName());
					System.out.println("Component type: " + n.getType());
				}
			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
	}

	public <SObject> void describeSFObjects(String orgId, String[] objList,
			SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		try {
			// Call describeSObjectResults and pass it an array with
			// the names of the objects to describe.

			DescribeSObjectResult[] describeSObjectResults = sfHandle
					.getEnterpriseConnection().describeSObjects(objList);

			for (int i = 0; i < describeSObjectResults.length; i++) {
				DescribeSObjectResult desObj = describeSObjectResults[i];

				// Get the name of the sObject
				System.out.println(desObj.isCustomSetting());
				LOG.info("Custom Setting There or not  :"
						+ desObj.getCustomSetting());
				System.out.println("Custom Setting There or not  :"
						+ desObj.getCustomSetting());
				String objectName = desObj.getName();
				LOG.info("SObject Name  :" + objectName);
				System.out.println("sObject name: " + objectName);
				// For each described sObject, get the fields
				Field[] fields = desObj.getFields();
				List<String> fieldList = new ArrayList<String>();

				Map<String, List<String>> objFieldsMap = new HashMap<String, List<String>>();
				for (int j = 0; j < fields.length; j++) {

					if (fields[j].getName().endsWith("__c")) {
						fieldList.add(fields[j].getName());
						fieldList.add("Id");
						System.out.println("Name(): " + fields[j].getName()
								+ " Type(): " + fields[j].getType());
					}
					
					
				}
				objFieldsMap.put(objectName, fieldList);

				CustomSettingDAO customSettingDAO = new CustomSettingDAO();
				List<Object> list = customSettingDAO.findByName(objFieldsMap,
						sfHandle);

			}
		} catch (Exception e) {
			// exception
		}
	}

	public boolean insert(String name, String type, String accessType,
			SFoAuthHandle sfHandle) {
		// create the records CustomObjectTest cc=new CustomObjectTest();

		Folder[] record = new Folder[1];
		try {
			// Get the name of the sObject
			Folder a = new Folder();
			a.setType(type);
			a.setName(name);
			a.setDeveloperName(name);
			a.setAccessType("public");
			a.setIsReadonly(true);
			record[0] = a;
			commit(record, sfHandle);
		} catch (Exception ce) {
			throw new SFException(ce.toString(),
					SFErrorCodes.SFDeployDetails_Update_Error);
		}
		return true;
	}

	public boolean commit(SObject[] sobjects, SFoAuthHandle sfHandle) {
		// System.out.println("SAVE--"+sfHandle.getUserId()+"--"+sfHandle.getPasswd());
		try {
			com.sforce.soap.enterprise.SaveResult[] saveResults = sfHandle
					.getEnterpriseConnection().create(sobjects);

			for (SaveResult r : saveResults) {
				if (r.isSuccess()) {
					System.out.println("Created DeployDetails record - Id: "
							+ r.getId());
				} else {
					for (com.sforce.soap.enterprise.Error e : r.getErrors()) {
						throw new SFException(e.getMessage() + "-status code-"
								+ e.getStatusCode(),
								SFErrorCodes.SFDeployDetails_Update_Error);
					}
					return false;
				}
			}
		} catch (Exception e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFDeployDetails_Update_Error);
		}
		return true;
	}

}