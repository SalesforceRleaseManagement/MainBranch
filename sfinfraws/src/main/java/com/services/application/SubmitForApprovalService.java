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

	Org sOrg;
	Org tOrg;
	String metadataLogId;
	String releaseId;
	String releaseName;
	String releaseStatus;
	long startTime;
	private static final Logger LOG = LoggerFactory
			.getLogger(SubmitForApprovalService.class);

	public SubmitForApprovalService(Org sOrg, Org tOrg, String metadataLogId,
			String releaseId, String releaseName, String releaseStatus) {
		super();
		this.sOrg = sOrg;
		this.tOrg = tOrg;
		this.metadataLogId = metadataLogId;
		this.releaseId = releaseId;
		this.releaseName = releaseName;
		this.releaseStatus = releaseStatus;
	}

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
	}

	public void initiate() {
		// delete packages from Base
		delPkgInfoListFromBase();
		EnvironmentDO sEnvDO = new EnvironmentDO(getsOrg().getOrgId(),
				getsOrg().getOrgToken(), getsOrg().getOrgURL(), "", getsOrg()
						.getRefreshToken());
		EnvironmentDO tEnvDO = new EnvironmentDO(gettOrg().getOrgId(),
				gettOrg().getOrgToken(), gettOrg().getOrgURL(), "", gettOrg()
						.getRefreshToken());

		// Get the ReleaseInformation in the each of Source environments.
		ReleaseInformationDAO riDAO = new ReleaseInformationDAO();
		List<Object> relInfoList = riDAO.findByParentId(releaseId,
				FDGetSFoAuthHandleService.getSFoAuthHandle(sEnvDO,
						Constants.CustomOrgID));
		for (Iterator iterator = relInfoList.iterator(); iterator.hasNext();) {
			List<Object> pkgInfoList = (new GetPkgInfoList(relInfoList, sEnvDO))
					.getList();
			for (Iterator<Object> iterator2 = pkgInfoList.iterator(); iterator2
					.hasNext();) {
				PackageInformationDO pkgInfoDO = (PackageInformationDO) iterator2
						.next();
				if (pkgInfoDO.getReadyForDeployment() != null
						&& pkgInfoDO.getReadyForDeployment().booleanValue()) {
					PackageInformationDAO pkgInfoDAO = new PackageInformationDAO();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date());
					pkgInfoDO.setCalendar(calendar);
					System.out.println(pkgInfoDO.getCalendar().getTime());

					pkgInfoDAO.updatePackageRetrievedTime(pkgInfoDO,
							FDGetSFoAuthHandleService.getSFoAuthHandle(sEnvDO,
									Constants.CustomOrgID));

					LOG.info("Package Creating in Base Org");
					startTime = System.currentTimeMillis();
					String pid = (new CreatePackage(gettOrg())).create(
							pkgInfoDO, FDGetSFoAuthHandleService
									.getSFoAuthHandle(gettOrg()));
					long endTime = System.currentTimeMillis();
					long total = endTime - startTime;
					LOG.info("Total Time Taken to Create Package in Base Org List"
							+ total / 1000 + " seconds");

					List<Object> pkgCompList = (new GetPkgCompList(relInfoList,
							sEnvDO, pkgInfoDO.getId())).getList();
					(new CreatePackageComp(gettOrg(), pkgCompList)).create(pid,
							FDGetSFoAuthHandleService
									.getSFoAuthHandle(gettOrg()));

					PackageInformationDAO pkginofDAO = new PackageInformationDAO();

					// Associate package with release
					ReleasePackageDAO relPkgDAO = new ReleasePackageDAO();

					List<Object> relePkgList = relPkgDAO.findByPkgIDAndRID(pid,
							getReleaseId(), FDGetSFoAuthHandleService
									.getSFoAuthHandle(gettOrg()));
					if (!relePkgList.isEmpty()) {
						ReleasePackageDO relPkgDO = new ReleasePackageDO("1",
								pid, getReleaseId());
						String pkgId = relPkgDAO.insertAndGetId(relPkgDO,
								FDGetSFoAuthHandleService
										.getSFoAuthHandle(gettOrg()));
					}
				}
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

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}

	private String getMetadataLogId() {
		return metadataLogId;
	}

	private void setMetadataLogId(String metadataLogId) {
		this.metadataLogId = metadataLogId;
	}

}
