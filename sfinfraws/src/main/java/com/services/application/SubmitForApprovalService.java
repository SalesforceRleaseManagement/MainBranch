package com.services.application;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.EnvironmentDO;
import com.domain.PackageInformationDO;
import com.domain.ReleasePackageDO;
import com.ds.salesforce.dao.comp.PackageDAO;
import com.ds.salesforce.dao.comp.PackageInformationDAO;
import com.ds.salesforce.dao.comp.ReleaseInformationDAO;
import com.ds.salesforce.dao.comp.ReleasePackageDAO;
import com.services.component.FDGetSFoAuthHandleService;
import com.services.component.release.CreatePackage;
import com.services.component.release.CreatePackageComp;
import com.services.component.release.GetPkgCompList;
import com.services.component.release.GetPkgInfoList;
import com.util.Constants;
import com.util.Org;
import com.util.SFoAuthHandle;

public class SubmitForApprovalService {
    Org bOrg;
	Org sOrg;
	Org tOrg;
	String status;
	String pkgId;
	String metadataLogId;
	
	

	public SubmitForApprovalService(Org bOrg,Org sOrg, Org tOrg, String status,String pkgId,String metadataLogId) {
		super();
		this.bOrg=bOrg;
		this.sOrg = sOrg;
		this.tOrg = tOrg;
		this.status=status;
		this.pkgId=pkgId;
		this.metadataLogId = metadataLogId;
	}
	
/*
	public void delPkgInfoListFromBase() {
		if (getsOrg() != null) {
			ReleaseInformationDAO riDAO = new ReleaseInformationDAO();
			// Get the ReleaseInformation in the client environments.
			List<Object> relInfoList = riDAO.findByParentId(getReleaseId(),
					FDGetSFoAuthHandleService.getSFoAuthHandle(getsOrg()));

			for (Iterator iterator = relInfoList.iterator(); iterator.hasNext();) {
				EnvironmentDO envDO = new EnvironmentDO(getsOrg().getOrgId(),
						getsOrg().getOrgToken(), getsOrg().getOrgURL(), "",
						getsOrg().getRefreshToken());
				List<Object> pkgInfoList = (new GetPkgInfoList(relInfoList,
						envDO)).getList();
				for (Iterator iterator2 = pkgInfoList.iterator(); iterator2
						.hasNext();) {
					PackageInformationDO pkgInfoDO = (PackageInformationDO) iterator2
							.next();
					SFoAuthHandle sfhandle = FDGetSFoAuthHandleService
							.getSFoAuthHandle(gettOrg());
					delPkgInBase(pkgInfoDO, sfhandle);
				}
			}
		}
	}

	public void delPkgInBase(PackageInformationDO pkgInfoDO,
			SFoAuthHandle sfhandle) {
		// Deleting Packages From BaseOrg
		String[] ids = new String[1];
		ids[0] = pkgInfoDO.getId();
		PackageDAO pkgDAO = new PackageDAO();
		List<Object> pkgList = pkgDAO.findById(ids[0], sfhandle);
		if (pkgList.size() > 0) {
			// delete Packages
			pkgDAO.deleteRecords(ids, sfhandle);
		}
	}*/

	public void initiate() {
		// delete packages from Base
		//delPkgInfoListFromBase();
		EnvironmentDO bEnvDO = new EnvironmentDO(getbOrg().getOrgId(),
				getbOrg().getOrgToken(),getbOrg().getOrgURL(), "", getbOrg()
						.getRefreshToken());
		EnvironmentDO sEnvDO = new EnvironmentDO(getsOrg().getOrgId(),
				getsOrg().getOrgToken(), getsOrg().getOrgURL(), "", getsOrg()
						.getRefreshToken());
		EnvironmentDO tEnvDO = new EnvironmentDO(gettOrg().getOrgId(),
				gettOrg().getOrgToken(), gettOrg().getOrgURL(), "", gettOrg()
						.getRefreshToken());

		// Get the ReleaseInformation in the each of Source environments.
		PackageInformationDAO pkgInfoDAO=new PackageInformationDAO();

		List<Object> pkgInfoList=pkgInfoDAO.findById(pkgId, FDGetSFoAuthHandleService.getSFoAuthHandle(bEnvDO,
						Constants.CustomBaseOrgID));
		
		
			for (Iterator<Object> iterator2 = pkgInfoList.iterator(); iterator2
					.hasNext();) {
				PackageInformationDO pkgInfoDO = (PackageInformationDO) iterator2
						.next();
				if (pkgInfoDO.getReadyForDeployment() != null
						&& pkgInfoDO.getReadyForDeployment().booleanValue()) {
			
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date());
					pkgInfoDO.setCalendar(calendar);
					System.out.println(pkgInfoDO.getCalendar().getTime());

					pkgInfoDAO.updatePackageRetrievedTime(pkgInfoDO,
							FDGetSFoAuthHandleService.getSFoAuthHandle(bEnvDO,
									Constants.CustomBaseOrgID));
                      
					
					String pid = (new CreatePackage(
							getsOrg()))
							.create(pkgInfoDO,
									FDGetSFoAuthHandleService.getSFoAuthHandle(sEnvDO,
											Constants.CustomOrgID));

					List<Object> pkgCompList = (new GetPkgCompList(
							bEnvDO, pkgInfoDO.getId())).getListClient();
					(new CreatePackageComp(getsOrg(), pkgCompList)).create(pid,
							FDGetSFoAuthHandleService
									.getSFoAuthHandle(getsOrg()));
					
					// Associate package with release
					/*ReleasePackageDAO relPkgDAO = new ReleasePackageDAO();

					List<Object> relePkgList = relPkgDAO
							.findByPkgIDAndRID(
									pid,
									pkgInfoDO.getReleaseInformationId(),
									FDGetSFoAuthHandleService
											.getSFoAuthHandle(getsOrg()));
					if (relePkgList.size() > 0) {

					}

					else {
						ReleasePackageDO relPkgDO = new ReleasePackageDO(
								"1", pid, pkgInfoDO.getReleaseInformationId());

						String pkgId = relPkgDAO
								.insertAndGetId(
										relPkgDO,
										FDGetSFoAuthHandleService
												.getSFoAuthHandle(getsOrg()));
					}*/
			
					}
				}
			}
		
	

	public Org getsOrg() {
		return sOrg;
	}

	public void setsOrg(Org sOrg) {
		this.sOrg = sOrg;
	}

	public Org gettOrg() {
		return tOrg;
	}

	public void settOrg(Org tOrg) {
		this.tOrg = tOrg;
	}

	public Org getbOrg() {
		return bOrg;
	}


	public void setbOrg(Org bOrg) {
		this.bOrg = bOrg;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPkgId() {
		return pkgId;
	}


	public void setPkgId(String pkgId) {
		this.pkgId = pkgId;
	}


	
}
