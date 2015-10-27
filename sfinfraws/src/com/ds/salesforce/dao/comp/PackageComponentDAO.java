package com.ds.salesforce.dao.comp;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domain.PackageCompInfoDO;
import com.domain.PackageComponentDO;
import com.domain.PackageDO;
import com.domain.PackageInformationDO;
import com.ds.salesforce.dao.ISFBaseDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.services.component.FDGetSFoAuthHandleService;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.util.SFoAuthHandle;
import com.util.sql.PackageCompInfoSQLStmts;
import com.util.sql.PackageComponentSQLStmts;
import com.util.sql.PackageInformationSQLStmts;

public class PackageComponentDAO implements ISFBaseDAO {

	public PackageComponentDAO() {
		super();

	}

	@Override
	public List<Object> findById(String id, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		PackageComponentDO retObj = null;
		retObj = null;
		List list = new ArrayList();
		try {
			EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
			System.out.println(" sql : "
					+ PackageComponentSQLStmts.getPackageCompQuery(id));
			QueryResult queryResults = conn.query(PackageComponentSQLStmts
					.getPackageCompQuery(id));

			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c locObj = (com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c) queryResults
							.getRecords()[i];
					System.out.println(" - Id: " + locObj.getId());
					System.out.println(" - Name: " + locObj.getName());
					System.out.println(" - Name__c: " + locObj.getASA__Name__c());
					System.out.println(" - Order__c: " + locObj.getASA__Order__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASA__Package__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASA__Package__r().getName());
					System.out.println(" - SourceOrganizationId__c: "
							+ locObj.getASA__SourceOrganizationId__c());
					System.out.println(" - Type: " + locObj.getASA__Type__c());
                     
					Double Order=1.0;
					retObj = new PackageComponentDO(locObj.getName(),
							locObj.getASA__Name__c(), Order,
							locObj.getASA__Package__c(),
							locObj.getASA__SourceOrganizationId__c(),
							locObj.getASA__Type__c(),locObj.getASA__ParentPackageCompID__c());

					list.add(retObj);
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		}
		return list;
	}
	public List<Object> findByParentPackageCompID(String id, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		PackageComponentDO retObj = null;
		retObj = null;
		List list = new ArrayList();
		try {
			EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
			System.out.println(" sql : "
					+ PackageComponentSQLStmts.getParentPackageComPID(id));
			QueryResult queryResults = conn.query(PackageComponentSQLStmts
					.getParentPackageComPID(id));

			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c locObj = (com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c) queryResults
							.getRecords()[i];
					
				
				  
					System.out.println(" - Id: " + locObj.getId());
					System.out.println(" - Name: " + locObj.getName());
					System.out.println(" - Name__c: " + locObj.getASA__Name__c());
					System.out.println(" - Order__c: " + locObj.getASA__Order__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASA__Package__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASA__Package__r().getName());
					System.out.println(" - SourceOrganizationId__c: "
							+ locObj.getASA__SourceOrganizationId__c());
					System.out.println(" - Type: " + locObj.getASA__Type__c());
					Double Order=1.0;
				
					
						retObj = new PackageComponentDO(locObj.getId(),locObj.getName(),
								locObj.getASA__Name__c(),Order,
								locObj.getASA__Package__c(),
								locObj.getASA__SourceOrganizationId__c(),
								locObj.getASA__Type__c(),locObj.getASA__ParentPackageCompID__c());

						list.add(retObj);	
					
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		}
		return list;
	}

	
	public List<Object> findByPackageId(String id, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		PackageCompInfoDO retObj = null;
		retObj = null;
		List list = new ArrayList();
		try {
			EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
			System.out
					.println(" sql : "
							+ PackageCompInfoSQLStmts
									.getParentPackageCompInfoQuery(id));
			QueryResult queryResults = conn.query(PackageCompInfoSQLStmts
					.getParentPackageCompInfoQuery(id));

			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					com.sforce.soap.enterprise.sobject.ASAClient__PackageComponentInformation__c locObj = (com.sforce.soap.enterprise.sobject.ASAClient__PackageComponentInformation__c) queryResults
							.getRecords()[i];
					String sql = "SELECT Id, Name, Name__c, Order__c, Package__c, "
							+ "Package__r.Name, SourceOrganizationId__c, Type__c"
							+ " FROM PackageComponentInformation__c"
							+ " where Id= '" + id + "'";
					System.out.println(" - Id: " + locObj.getId());
					System.out.println(" - Name: " + locObj.getName());
					System.out.println(" - Name__c: " + locObj.getASAClient__Name__c());
					System.out.println(" - Order__c: " + locObj.getASAClient__Order__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASAClient__Package__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASAClient__Package__r().getName());
					System.out.println(" - SourceOrganizationId__c: "
							+ locObj.getASAClient__SourceOrganizationId__c());
					System.out.println(" - Type: " + locObj.getASAClient__Type__c());

					String Order="1";
					retObj = new PackageCompInfoDO(locObj.getId(),locObj.getName(),
							locObj.getASAClient__Name__c(), Order,
							locObj.getASAClient__Type__c(),
							locObj.getASAClient__SourceOrganizationId__c(),
							locObj.getASAClient__Package__c());

					list.add(retObj);
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		}
		return list;
	}
	public List<Object> findByPackageId1(String id, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		PackageComponentDO retObj = null;
		retObj = null;
		List list = new ArrayList();
		try {
			EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
			System.out
					.println(" sql : "
							+ PackageCompInfoSQLStmts
									.getParentPackageCompInfoQuery(id));
			QueryResult queryResults = conn.query(PackageComponentSQLStmts
					.getParentPackageCompQuery(id));

			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c locObj = (com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c) queryResults
							.getRecords()[i];
					String sql = "SELECT Id, Name, Name__c, Order__c, Package__c, "
							+ "Package__r.Name, SourceOrganizationId__c, Type__c"
							+ " FROM PackageComponent__c"
							+ " where Id= '" + id + "'";
					System.out.println(" - Id: " + locObj.getId());
					System.out.println(" - Name: " + locObj.getName());
					System.out.println(" - Name__c: " + locObj.getASA__Name__c());
					System.out.println(" - Order__c: " + locObj.getASA__Order__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASA__Package__c());
					System.out.println(" - Package__c Id: "
							+ locObj.getASA__Package__r().getName());
					System.out.println(" - SourceOrganizationId__c: "
							+ locObj.getASA__SourceOrganizationId__c());
					System.out.println(" - Type: " + locObj.getASA__Type__c());

					Double Order=1.0;
					retObj = new PackageComponentDO(locObj.getId(),locObj.getName(),
							locObj.getASA__Name__c(), Order,
							locObj.getASA__Type__c(),
							locObj.getASA__SourceOrganizationId__c(),
							locObj.getASA__Package__c(),locObj.getASA__ParentPackageCompID__c());

					list.add(retObj);
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Query_Error);
		}
		return list;
	}
	@Override
	public List<Object> listAll(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		PackageCompInfoDO retObj = null;
		List list = new ArrayList();
		return list;
	}

	@Override
	public boolean insert(Object obj, SFoAuthHandle sfHandle) {
		// create the records
		System.out.println("insereting PkgComp DAO :");
		
		PackageComponentDO pkgCompDO = (PackageComponentDO) obj;
		com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c[] record = new com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c[1];
		try {
			// Get the name of the sObject
			com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c a = new com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c();
			//a.setName(pkgCompDO.getPkgCompName());
			a.setASA__Name__c(pkgCompDO.getObjName());
			a.setASA__Order__c(pkgCompDO.getOrder());
			a.setASA__Package__c(pkgCompDO.getPkgParentId());
			a.setASA__SourceOrganizationId__c(pkgCompDO.getSourceOrganizationId());
			a.setASA__Type__c(pkgCompDO.getType());
			a.setASA__ParentPackageCompID__c(pkgCompDO.getParentPackageCompID());
			

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
		com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c newObj = new com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c();
		PackageComponentDO lObj = (PackageComponentDO) obj;
		try {
			newObj.setId(lObj.getId());
			newObj.setASA__Name__c(lObj.getObjName());
			newObj.setASA__Order__c(lObj.getOrder());
			newObj.setASA__Package__c(lObj.getPkgParentId());
			newObj.setASA__SourceOrganizationId__c(lObj.getSourceOrganizationId());
			newObj.setASA__Type__c(lObj.getType());
			newObj.setASA__ParentPackageCompID__c(lObj.getParentPackageCompID());
			com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c[] mobj = new com.sforce.soap.enterprise.sobject.ASA__PackageComponent__c[1];
			mobj[0] = newObj;
			commit(mobj, sfHandle);
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		} catch (Exception e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return true;
	}
	

	@Override
	public boolean commit(SObject[] sobjects, SFoAuthHandle sfHandle) {
		try {
			if (sobjects != null && sobjects.length > 0) {
				UpsertResult[] results = sfHandle.getEnterpriseConnection()
						.upsert("Id", sobjects);
				for (UpsertResult r : results) {
					if (r.isSuccess()) {
						System.out.println("Updated Environment component: "
								+ r.getId());
					} else {

						System.out
								.println("Errors were encountered while updating "
										+ r.getId());
						for (com.sforce.soap.enterprise.Error e : r.getErrors()) {
							System.out.println("Error message: "
									+ e.getMessage());
							System.out.println("Status code: "
									+ e.getStatusCode());
						}
						commitC(sobjects, sfHandle);
					}
				}
			}
		} catch (Exception e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return true;
	}

	@Override
	public boolean delete(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean commitC(SObject[] sobjects, SFoAuthHandle sfHandle) {
		// System.out.println("SAVE--"+sfHandle.getUserId()+"--"+sfHandle.getPasswd());
		try {
			com.sforce.soap.enterprise.SaveResult[] saveResults = sfHandle
					.getEnterpriseConnection().create(sobjects);

			// check the returned results for any errors
			for (int i = 0; i < saveResults.length; i++) {
				if (saveResults[i].isSuccess()) {
					System.out
							.println(i
									+ ". Successfully created MetadataDescription record - Id: "
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
