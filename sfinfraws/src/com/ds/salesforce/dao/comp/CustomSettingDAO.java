package com.ds.salesforce.dao.comp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

import com.domain.DeploymentSettingsDO;
import com.domain.EnvironmentDO;
import com.ds.salesforce.dao.ISFBaseDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.junit.enterprise.PojoGenerator;
import com.services.component.FDGetSFoAuthHandleService;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.ASA__Enviroment__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.util.Constants;
import com.util.SFoAuthHandle;
import com.util.sql.DeploymentSettingsSQLStmts;

/**
 * 
 * @author DeploySettingsDAO is Used For Performing CRUD Operations for
 *         {@link DeploymentSetting__c}
 *
 */
public class CustomSettingDAO implements ISFBaseDAO {

	public CustomSettingDAO() {
		super();
	}

	@Override
	public List<Object> listAll(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object obj, SFoAuthHandle sfHandle) {
		// create the records
		System.out.println("insereting EnvironmentDAO :");
		EnvironmentDO envDO = (EnvironmentDO) obj;
		ASA__Enviroment__c[] record = new ASA__Enviroment__c[1];
		try {
			// Get the name of the sObject

			ASA__Enviroment__c a = new ASA__Enviroment__c();
			a.setASA__Org_ID__c(envDO.getOrgId());
			a.setASA__TokenCode__c(envDO.getToken());
			a.setASA__TokenCodeNonEncrypted__c(envDO.getToken());
			a.setASA__Server_URL__c(envDO.getServerURL());

			record[0] = a;
			commit(record, sfHandle);
		} catch (Exception ce) {
			throw new SFException(ce.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return true;
	}

	@Override
	public boolean update(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub

		return true;
	}

	public boolean commit(SObject[] sobjects, SFoAuthHandle sfHandle) {
		// System.out.println("SAVE--"+sfHandle.getUserId()+"--"+sfHandle.getPasswd());
		try {
			com.sforce.soap.enterprise.UpsertResult[] saveResults = sfHandle
					.getEnterpriseConnection().upsert("Id", sobjects);

			for (UpsertResult r : saveResults) {
				if (r.isSuccess()) {
					System.out.println("Created DeployDetails record - Id: "
							+ r.getId());
				} else {
					for (com.sforce.soap.enterprise.Error e : r.getErrors()) {
						System.out.println("-status code-" + e.getStatusCode());
						throw new SFException(e.getMessage() + "-status code-"
								+ e.getStatusCode(),
								SFErrorCodes.SFDeployDetails_Update_Error);
					}
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SFException(e.toString(),
					SFErrorCodes.SFDeployDetails_Update_Error);
		}
		return true;
	}

	@Override
	public boolean delete(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> findById(String orgId, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		com.sforce.soap.enterprise.sobject.ASA__DeploymentSetting__c retObj = null;
		DeploymentSettingsDO dsDO = new DeploymentSettingsDO();
		List list = new ArrayList();
		try {
			EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
			QueryResult queryResults = conn.query(DeploymentSettingsSQLStmts
					.getOrgEnvQuery(orgId));
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					retObj = (com.sforce.soap.enterprise.sobject.ASA__DeploymentSetting__c) queryResults
							.getRecords()[i];
					dsDO = new DeploymentSettingsDO(retObj.getId(),
							retObj.getASA__BaseOrganizationId__c(),
							retObj.getASA__TokenCode__c(),
							retObj.getASA__Server_URL__c(),
							retObj.getASA__RefreshTokenCode__c());
					System.out.println(" - Id: " + retObj.getId());
					System.out.println(" - BaseOrg: "
							+ retObj.getASA__BaseOrganizationId__c());
					System.out.println(" - token: "
							+ retObj.getASA__TokenCode__c());
					System.out.println(" - server url: "
							+ retObj.getASA__Server_URL__c());
					System.out.println(" - refreshToken: "
							+ retObj.getASA__RefreshTokenCode__c());
					list.add(dsDO);
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		} catch (Exception e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		}
		return list;
	}

	public List<Object> findByName(Map<String, List<String>> map,
			SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String Columns = "";
		String query = "";
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			System.out.println("Key : " + entry.getKey());
			for (String val : entry.getValue()) {
				Columns = Columns + val + ",";
			}
			int index = Columns.lastIndexOf(",");
			Columns = new StringBuilder(Columns).replace(index, index + 1, " ")
					.toString();
			System.out.println(Columns);
			query = "SELECT" + " " + Columns + "" + "from " + " " + key + "";
			System.out.println("key-----------" + key + "  " + query);
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();

			Map<String, Class<?>> props = new HashMap<String, Class<?>>();
			props.put("TestField__c", String.class);

			Class<?> clazz = null;
			try {
				clazz = generate(
						"com.sforce.soap.enterprise.sobject.TestSettings__c",
						props);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CannotCompileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Object obj = clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				clazz = classLoader.loadClass("com.sforce.soap.enterprise.sobject.TestSettings__c");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			

			try {
				EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
				QueryResult queryResults = conn.query(query);
				SObject[] ss = new SObject[queryResults.getSize()];
				for (int k = 0; k < queryResults.getRecords().length; k++) {

					com.sforce.soap.enterprise.sobject.SObject retObj = (com.sforce.soap.enterprise.sobject.SObject) queryResults
							.getRecords()[k];
					ss[0] = retObj;

					String destiOrgID = "00DS0000003Km6LMAS";
					String destiToken = "00DS0000003Km6L!AQsAQGxQkJics1JFNRqjat_WSr9y8yn.6rFwYfBwAS.yoBSnBeDygKLAduq44CCYJYreC5hXiUZQj2yxb8vftcoVMH8t.RtB";
					String destiURL = "https://emc--OppVis.cs1.my.salesforce.com";
					String destiRefreshCode = "5Aep861KIwKdekr90IIyhfEcZZxgNJfv58m5BvQaUg0P_g1MEYKX0CPOXBPhS2N16Xvy.Rqto0xOUMYhcW3veky";

					sfHandle = FDGetSFoAuthHandleService.getSFoAuthHandle(
							destiOrgID, destiToken, destiURL, destiRefreshCode,
							Constants.CustomOrgID);

					commit(ss, sfHandle);

					// com.sforce.soap.enterprise.sobject.SObject retObj =
					// (com.sforce.soap.enterprise.sobject.SObject)queryResults.getRecords()[k];
					// String strObjType = String.valueOf(retObj);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static Class generate(String className,
			Map<String, Class<?>> properties) throws NotFoundException,
			CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);

		// add this to define a super class to extend
		cc.setSuperclass(resolveCtClass(com.sforce.soap.enterprise.sobject.SObject.class));

		// add this to define an interface to implement
		cc.addInterface(resolveCtClass(Serializable.class));

		for (Entry<String, Class<?>> entry : properties.entrySet()) {

			cc.addField(new CtField(resolveCtClass(entry.getValue()), entry
					.getKey(), cc));

			// add getter
			cc.addMethod(generateGetter(cc, entry.getKey(), entry.getValue()));

			// add setter
			cc.addMethod(generateSetter(cc, entry.getKey(), entry.getValue()));
		}

		return cc.toClass();
	}

	private static CtMethod generateGetter(CtClass declaringClass,
			String fieldName, Class fieldClass) throws CannotCompileException {

		String getterName = "get" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public ").append(fieldClass.getName()).append(" ")
				.append(getterName).append("(){").append("return this.")
				.append(fieldName).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	private static CtMethod generateSetter(CtClass declaringClass,
			String fieldName, Class fieldClass) throws CannotCompileException {

		String setterName = "set" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public void ").append(setterName).append("(")
				.append(fieldClass.getName()).append(" ").append(fieldName)
				.append(")").append("{").append("this.").append(fieldName)
				.append("=").append(fieldName).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	private static CtClass resolveCtClass(Class clazz) throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		return pool.get(clazz.getName());
	}

	public List<Object> findByName1(String sql, String objname,
			SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		com.sforce.soap.enterprise.sobject.ASA__DeploymentSetting__c retObj = null;
		DeploymentSettingsDO dsDO = new DeploymentSettingsDO();
		List list = new ArrayList();
		try {
			EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
			QueryResult queryResults = conn.query(sql);
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					retObj = (com.sforce.soap.enterprise.sobject.ASA__DeploymentSetting__c) queryResults
							.getRecords()[i];
					dsDO = new DeploymentSettingsDO(retObj.getId(),
							retObj.getASA__BaseOrganizationId__c(),
							retObj.getASA__TokenCode__c(),
							retObj.getASA__Server_URL__c(),
							retObj.getASA__RefreshTokenCode__c());
					System.out.println(" - Id: " + retObj.getId());
					System.out.println(" - BaseOrg: "
							+ retObj.getASA__BaseOrganizationId__c());
					System.out.println(" - token: "
							+ retObj.getASA__TokenCode__c());
					System.out.println(" - server url: "
							+ retObj.getASA__Server_URL__c());
					System.out.println(" - refreshToken: "
							+ retObj.getASA__RefreshTokenCode__c());
					list.add(dsDO);
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		} catch (Exception e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		}
		return list;
	}

}