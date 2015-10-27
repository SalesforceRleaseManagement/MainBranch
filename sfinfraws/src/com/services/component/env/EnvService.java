package com.services.component.env;

import java.util.List;

import com.ds.salesforce.dao.comp.EnvironmentDAO;
import com.services.component.FDGetSFoAuthHandleService;
import com.util.Org;
import com.util.SFoAuthHandle;

public class EnvService {

	public EnvService(){
		super();
	}
	
	public List<Object> ListAllEnv(Org org){
		EnvironmentDAO dao = new EnvironmentDAO();
		List<Object> envList = dao.listAll(FDGetSFoAuthHandleService
				.getSFoAuthHandle(org));
		return envList;
	}
}
