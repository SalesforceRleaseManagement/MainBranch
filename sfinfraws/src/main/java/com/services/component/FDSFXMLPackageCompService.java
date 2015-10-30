package com.services.component;

import java.util.List;

import com.util.XMLUtil;  

public class FDSFXMLPackageCompService {

	public FDSFXMLPackageCompService(){  
		super();
	}
	
	public void createPackageXML(List metadataObjList) {
		XMLUtil.doPreProcessing();
		XMLUtil.createDeployXMLFile(metadataObjList);
	}
	
}
