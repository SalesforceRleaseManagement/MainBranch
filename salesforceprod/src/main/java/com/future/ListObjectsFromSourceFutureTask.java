package com.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.domain.MetaBean;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.metadata.FileProperties;
import com.sforce.soap.metadata.ListMetadataQuery;
import com.sforce.ws.ConnectionException;
import com.util.Constants;
import com.util.SFoAuthHandle;

/**
 * 
 * @author ListObjectsFromSourceFutureTask Used For Providing List of Objects
 *         From Source
 *
 */
public class ListObjectsFromSourceFutureTask implements
		Callable<List<MetaBean>> {
	private long waitTime;
	String metadataLogId;
	SFoAuthHandle sfHandle;
	String contentType;

	public ListObjectsFromSourceFutureTask(String metadataLogId,
			String contentType, SFoAuthHandle sfHandle) {
		this.metadataLogId = metadataLogId;
		this.contentType = contentType;
		this.sfHandle = sfHandle;
	}

	@Override
	public List<MetaBean> call() throws Exception {
		// MetaBean[] objlist = null;
		List<MetaBean> list = new ArrayList<MetaBean>();
		com.sforce.soap.enterprise.sobject.Folder retObj = null;
		MetaBean bean = null;
		try {
			ListMetadataQuery query = null;
			query = new ListMetadataQuery();
			query.setType(this.contentType);
			String Emailtype = "Email";
			String ReportType = "Report";
			String DashboardType = "Dashboard";
			String DocumentType = "Document";
			if (this.contentType == "EmailTemplate") {
				String emailSQL = "Select Id, Name,Type"
						+ " FROM Folder where Type = '" + Emailtype + "'";

				EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
				QueryResult queryResults = conn.query(emailSQL);
				if (queryResults.getSize() > 0) {
					for (int i = 0; i < queryResults.getRecords().length; i++) {
						// cast the SObject to a strongly-typed Contact
						retObj = (com.sforce.soap.enterprise.sobject.Folder) queryResults
								.getRecords()[i];
						query.setFolder(retObj.getName());
					}
				}

			}
			if (this.contentType == "Report") {
				String emailSQL = "Select Id, Name,Type"
						+ " FROM Folder where Type = '" + ReportType + "'";
				EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
				QueryResult queryResults = conn.query(emailSQL);
				if (queryResults.getSize() > 0) {
					for (int i = 0; i < queryResults.getRecords().length; i++) {
						// cast the SObject to a strongly-typed Contact
						retObj = (com.sforce.soap.enterprise.sobject.Folder) queryResults
								.getRecords()[i];
						query.setFolder(retObj.getName());
					}
				}

			}
			if (this.contentType == "Dashboard") {
				String emailSQL = "Select Id, Name,Type"
						+ " FROM Folder where Type = '" + DashboardType + "'";
				EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
				QueryResult queryResults = conn.query(emailSQL);
				if (queryResults.getSize() > 0) {
					for (int i = 0; i < queryResults.getRecords().length; i++) {
						// cast the SObject to a strongly-typed Contact
						retObj = (com.sforce.soap.enterprise.sobject.Folder) queryResults
								.getRecords()[i];
						query.setFolder(retObj.getName());
					}
				}

			}
			if (this.contentType == "Document") {
				String emailSQL = "Select Id, Name,Type"
						+ " FROM Folder where Type = '" + DocumentType + "'";
				EnterpriseConnection conn = sfHandle.getEnterpriseConnection();
				QueryResult queryResults = conn.query(emailSQL);
				if (queryResults.getSize() > 0) {
					for (int i = 0; i < queryResults.getRecords().length; i++) {
						// cast the SObject to a strongly-typed Contact
						retObj = (com.sforce.soap.enterprise.sobject.Folder) queryResults
								.getRecords()[i];
						query.setFolder(retObj.getName());
					}
				}

			}

			// select ID,Name from Folder

			// query.setFolder(null);
			double asOfVersion = (new Double(Constants.API_VERSION))
					.doubleValue();
			// Assuming that the SOAP binding has already been established.
			FileProperties[] lmr = sfHandle.getMetadataConnection()
					.listMetadata(new ListMetadataQuery[] { query },
							asOfVersion);

			// Write the name of each sObject to the console
			for (int j = 0; j < lmr.length; j++) {
				String objectName = lmr[j].getFullName().trim();
				
				String objName = lmr[j].getFullName().trim();
				if (!objName.startsWith("agf") && !objName.startsWith("copado")) {

					bean = new MetaBean(metadataLogId, lmr[j].getFullName(),
							lmr[j].getType(), sfHandle.getOrgId());
					list.add(bean);
				}
			}
			if (sfHandle != null) {
				sfHandle.nullify();
			}
			sfHandle = null;
		} catch (ConnectionException ce) {
			System.out.println(ce.toString());
			if (sfHandle != null) {
				sfHandle.nullify();
			}
			sfHandle = null;
			throw new SFException(ce.toString(),
					SFErrorCodes.SFObjects_List_Error);
		} catch (Exception ce) {
			if (sfHandle != null) {
				sfHandle.nullify();
			}
			sfHandle = null;
			throw new SFException(ce.toString(),
					SFErrorCodes.SFObjects_List_Error);
		}
		return list;
	}

	public List<MetaBean> callBackup() throws Exception {
		// MetaBean[] objlist = null;
		List<MetaBean> list = new ArrayList<MetaBean>();
		MetaBean bean = null;
		try {
			ListMetadataQuery query = null;
			for (int i = 0; i < Constants.SFTypes.length; i++) {
				query = new ListMetadataQuery();
				query.setType(Constants.SFTypes[i]);
				// query.setFolder(null);
				double asOfVersion = (new Double(Constants.API_VERSION))
						.doubleValue();
				// Assuming that the SOAP binding has already been established.
				FileProperties[] lmr = sfHandle.getMetadataConnection()
						.listMetadata(new ListMetadataQuery[] { query },
								asOfVersion);

				// Write the name of each sObject to the console
				for (int j = 0; j < lmr.length; j++) {
					String objectName = lmr[j].getFullName().trim();
					String objName = lmr[j].getFullName().trim();
					if (!objName.startsWith("agf")
							&& !objName.startsWith("copado")) {

						bean = new MetaBean(metadataLogId,
								lmr[j].getFullName(), lmr[j].getType(),
								sfHandle.getOrgId());
						list.add(bean);
						/*
						 * System.out.println("listing retrieved objects----" +
						 * bean.getName());
						 */
					}
				}
			}
			if (sfHandle != null) {
				sfHandle.nullify();
			}
			sfHandle = null;
		} catch (ConnectionException ce) {
			System.out.println(ce.toString());
			if (sfHandle != null) {
				sfHandle.nullify();
			}
			sfHandle = null;
			throw new SFException(ce.toString(),
					SFErrorCodes.SFObjects_List_Error);
		} catch (Exception ce) {
			if (sfHandle != null) {
				sfHandle.nullify();
			}
			sfHandle = null;
			throw new SFException(ce.toString(),
					SFErrorCodes.SFObjects_List_Error);
		}
		return list;
	}
}
