package com.ds.salesforce.dao.comp;

import java.util.List;

import com.domain.MetaBean;
import com.ds.salesforce.dao.ISFBaseDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.sforce.soap.enterprise.sobject.ASAClient__MetadataDescriptionInformation__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.util.SFoAuthHandle;

/**
 * 
 * @author MetadataDescriptionInformationDAO is Used For Performing CRUD Operations for
 *         {@link MetadataDescriptionInformation__c}
 *
 */
public class MetadataDescriptionInformationDAO implements ISFBaseDAO {

	@Override
	public List<Object> listAll(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object obj, SFoAuthHandle sfHandle) {
		return false;
	}

	public boolean insert(MetaBean[] deployObjArr, String metadataLogId,
			String sOrgId, SFoAuthHandle sfHandle) {
		int retVal = 1;
		
		// create the records
		ASAClient__MetadataDescriptionInformation__c[] records = new ASAClient__MetadataDescriptionInformation__c[deployObjArr.length];
		try {
			for (int i = 0; i < deployObjArr.length; i++) {
				// Get the name of the sObject
				ASAClient__MetadataDescriptionInformation__c a = new ASAClient__MetadataDescriptionInformation__c();
				a.setASAClient__MetadataLog__c(metadataLogId);
				a.setASAClient__Name__c(deployObjArr[i].getName());
				a.setASAClient__Type__c(deployObjArr[i].getType());
				a.setASAClient__OrganizationId__c(sOrgId);
				records[i] = a;
			}
			commit(records, sfHandle);
			if (retVal < 0) {
				return false;
			}
		} catch (Exception ce) {
			// fce.printStackTrace();
			throw new SFException(ce.toString(),
					SFErrorCodes.SFMetadataDescription_Insert_Error);
		}
		return false;
	}

	public int save(SObject[] sobjects, SFoAuthHandle sfHandle) {
		int retVal = 1;

		return retVal;
	}

	@Override
	public boolean update(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> findById(String metadataLogIdName,
			SFoAuthHandle sfHandle) {
		return null;
	}

	@Override
	public boolean commit(SObject[] sobjects, SFoAuthHandle sfHandle) {
		// System.out.println("SAVE--"+sfHandle.getUserId()+"--"+sfHandle.getPasswd());
		try {
			com.sforce.soap.enterprise.SaveResult[] saveResults = sfHandle
					.getEnterpriseConnection().create(sobjects);

			// check the returned results for any errors
			for (int i = 0; i < saveResults.length; i++) {
				if (saveResults[i].isSuccess()) {
					System.out.println(i
							+ ". Successfully created MetadataDescriptionInformation record - Id: "
							+ saveResults[i].getId());
				} else {
					com.sforce.soap.enterprise.Error[] errors = saveResults[i]
							.getErrors();
					StringBuffer sb = new StringBuffer();
					for (int j = 0; j < errors.length; j++) {
						sb.append(errors[j].getMessage());
						sb.append("\n");
						System.out.println("ERROR creating record: "
								+ errors[j].getMessage());
					}
					throw new SFException(sb.toString(),
							SFErrorCodes.SFMetadataDescription_Insert_Error);
				}
			}
		} catch (Exception e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFMetadataDescription_Insert_Error);
		}
		return true;
	}

}
