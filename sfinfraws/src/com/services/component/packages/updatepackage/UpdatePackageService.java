package com.services.component.packages.updatepackage;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.domain.EnvironmentDO;
import com.domain.PackageDO;
import com.domain.PackageInformationDO;
import com.domain.ReleaseInformationDO;
import com.domain.ReleasePackageDO;
import com.ds.salesforce.dao.comp.PackageDAO;
import com.ds.salesforce.dao.comp.PackageInformationDAO;
import com.ds.salesforce.dao.comp.ReleaseInformationDAO;
import com.ds.salesforce.dao.comp.ReleasePackageDAO;
import com.exception.SFException;
import com.services.application.RDAppService;
import com.services.component.FDGetSFoAuthHandleService;
import com.services.component.env.EnvService;
import com.services.component.release.CreatePackage;
import com.services.component.release.CreatePackageComp;
import com.services.component.release.GetPkgCompList;
import com.services.component.release.GetPkgInfoList;
import com.util.Constants;
import com.util.Org;

public class UpdatePackageService {

	Org borg;
	String metadataLogId;
	String action;
	String status;
	String packageParentId;

	public UpdatePackageService() {
		super();
	}

	public UpdatePackageService(Org borg, String metadataLogId, String action,
			String status, String packageParentId) {
		super();

		this.borg = borg;
		this.metadataLogId = metadataLogId;
		this.action = action;
		this.status = status;
		this.packageParentId = packageParentId;
	}

	public UpdatePackageService(Org borg, String metadataLogId, String status,
			String packageParentId) {
		super();

		this.borg = borg;
		this.metadataLogId = metadataLogId;
		this.status = status;
		this.packageParentId = packageParentId;
	}

	public void initiate() {
		// prepare baseOrg
		EnvService envService = new EnvService();
		List<Object> envList = envService.ListAllEnv(getBorg());
		// find ReleaseOjects in all the Environments
		for (Iterator<Object> iterator = envList.iterator(); iterator.hasNext();) {
			try {
				
			
			EnvironmentDO envDO = (EnvironmentDO) iterator.next();
			System.out.println(envDO.getOrgId());
			if (envDO.getOrgId() != null) {
				PackageInformationDAO pkgInfoDAO = new PackageInformationDAO();
				// Get the ReleaseInformation in the each of target
				// environments.
				List<Object> pkgInfoList = pkgInfoDAO
						.findByReadyForDepId(getPackageParentId(),
								FDGetSFoAuthHandleService.getSFoAuthHandle(
										envDO, Constants.CustomOrgID));

				for (Iterator iterator1 = pkgInfoList.iterator(); iterator1
						.hasNext();) {
					PackageInformationDO pkgInfoDO = (PackageInformationDO) iterator1
							.next();
					System.out.println("PkgInfo Id  :" + pkgInfoDO.getId());
					pkgInfoDO.setReadyForDeployment(new Boolean(false));
					Calendar calendar = Calendar.getInstance();
					calendar.clear();
					// This is just dummy as we are setting this field as null in DAO class
					pkgInfoDO.setCalendar(calendar); 
					try {
						pkgInfoDAO.updatePackageRetrievedTime(pkgInfoDO,
								FDGetSFoAuthHandleService.getSFoAuthHandle(
										envDO, Constants.CustomOrgID));

						RDAppService.updateToComplete(getMetadataLogId(),
								Constants.COMPLETED_STATUS, getBorg());
					} catch (SFException e) {
						e.printStackTrace();
					}
				}
			}
			} catch (Exception e) {
				// TODO: handle exception
			}}
	}

	private Org getBorg() {
		return borg;
	}

	private void setBorg(Org borg) {
		this.borg = borg;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackageParentId() {
		return packageParentId;
	}

	public void setPackageParentId(String packageParentId) {
		this.packageParentId = packageParentId;
	}

	public String getMetadataLogId() {
		return metadataLogId;
	}

	public void setMetadataLogId(String metadataLogId) {
		this.metadataLogId = metadataLogId;
	}

}
