package com.services.component.release;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.EnvironmentDO;
import com.domain.PackageInformationDO;
import com.domain.ReleaseInformationDO;
import com.domain.ReleasePackageDO;
import com.domain.ReleasesDO;
import com.ds.salesforce.dao.comp.PackageDAO;
import com.ds.salesforce.dao.comp.PackageInformationDAO;
import com.ds.salesforce.dao.comp.ReleaseInformationDAO;
import com.ds.salesforce.dao.comp.ReleasePackageDAO;
import com.ds.salesforce.dao.comp.ReleasesDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.services.application.RDAppService;
import com.services.component.FDGetSFoAuthHandleService;
import com.services.component.env.EnvService;
import com.util.Constants;
import com.util.Org;
import com.util.SFoAuthHandle;

public class ReleaseEnvService {

	Org borg;
	String metadataLogId;
	String releaseId;
	String releaseName;
	long startTime;

	private static final Logger LOG = LoggerFactory
			.getLogger(ReleaseEnvService.class);

	public ReleaseEnvService() {
		super();
	}

	public ReleaseEnvService(Org borg, String metadataLogId, String releaseId,
			String releaseName) {
		super();
		this.borg = borg;
		this.metadataLogId = metadataLogId;
		this.releaseId = releaseId;
		this.releaseName = releaseName;
	}

	public void initiate() {
		EnvService envService = new EnvService();

		// Deleting Packages From BaseOrg

		ReleasePackageDAO rpkgDAO = new ReleasePackageDAO();

		SFoAuthHandle sfhandle = FDGetSFoAuthHandleService
				.getSFoAuthHandle(getBorg());
		LOG.info("deleting Packages start getting connection");
		startTime = System.currentTimeMillis();
		List<Object> rpkgDOList = rpkgDAO.findByReleaseId(releaseId, sfhandle);
		for (Iterator<Object> iteratord = rpkgDOList.iterator(); iteratord
				.hasNext();) {
			ReleasePackageDO rpkgDO = (ReleasePackageDO) iteratord.next();
			System.out.println(rpkgDO.getPackageC());
			String[] ids = new String[1];
			ids[0] = rpkgDO.getPackageC();
			PackageDAO pkgDAO = new PackageDAO();
			List<Object> pkgList = pkgDAO.findById(ids[0], sfhandle);
			if (pkgList.size() > 0) {
				// delete Packages
				pkgDAO.deleteRecords(ids, sfhandle);
			}
			long endTime = System.currentTimeMillis();
			long total = endTime - startTime;
			LOG.info("Total Time Taken to Delete Packages List" + total / 1000
					+ " seconds");
		}

		// prepare baseOrg
		List<Object> envList = envService.ListAllEnv(getBorg());
		LinkedList<GetPackageProcess> linkedlist = new LinkedList<GetPackageProcess>();
		System.out.println("Get Package Process");
		// find ReleaseOjects in all the Environments
		for (Iterator<Object> iterator = envList.iterator(); iterator.hasNext();) {
			try {

				// adding elements to the end

				EnvironmentDO envDO = (EnvironmentDO) iterator.next();
				System.out.println(envDO.getOrgId());
				if (envDO.getOrgId() != null) {
					ReleaseInformationDAO riDAO = new ReleaseInformationDAO();
					// Get the ReleaseInformation in the each of target
					// environments.
					List<Object> relInfoList = riDAO.findByParentId(releaseId,
							FDGetSFoAuthHandleService.getSFoAuthHandle(envDO,
									Constants.CustomOrgID));

					// verify if release status is active / inactive
					boolean isActive = false;
					for (Iterator iterator1 = relInfoList.iterator(); iterator1
							.hasNext();) {
						ReleaseInformationDO rInfoDO = (ReleaseInformationDO) iterator1
								.next();
						System.out.println("ReleaseId  :" + rInfoDO.getId());
						if (rInfoDO.getStatus().equalsIgnoreCase(
								Constants.RELEASE_STATUS_INACTIVE)) {
							isActive = false;
						} else {
							isActive = true;
						}
						if (isActive) {
							try {
								List<Object> pkgInfoList = (new GetPkgInfoList(
										relInfoList, envDO)).getList();

								for (Iterator<Object> iterator2 = pkgInfoList
										.iterator(); iterator2.hasNext();) {
									PackageInformationDO pkgInfoDO = (PackageInformationDO) iterator2
											.next();
									if (pkgInfoDO.getReadyForDeployment() != null
											&& pkgInfoDO
													.getReadyForDeployment()
													.booleanValue()) {
										PackageInformationDAO pkgInfoDAO = new PackageInformationDAO();
										Calendar calendar = Calendar
												.getInstance();
										calendar.setTime(new Date());
										pkgInfoDO.setCalendar(calendar);
										System.out.println(pkgInfoDO
												.getCalendar().getTime());

										pkgInfoDAO
												.updatePackageRetrievedTime(
														pkgInfoDO,
														FDGetSFoAuthHandleService
																.getSFoAuthHandle(
																		envDO,
																		Constants.CustomOrgID));

										LOG.info("Package Creating in Base Org");
										startTime = System.currentTimeMillis();
										String pid = (new CreatePackage(
												getBorg()))
												.create(pkgInfoDO,
														FDGetSFoAuthHandleService
																.getSFoAuthHandle(getBorg()));
										long endTime = System
												.currentTimeMillis();
										long total = endTime - startTime;
										LOG.info("Total Time Taken to Create Package in Base Org List"
												+ total / 1000 + " seconds");

										String Pkgdescription = "Package  "
												+ pkgInfoDO.getName()
												+ " "
												+ "is created With  package ID "
												+ pkgInfoDO.getId()
												+ " "
												+ "in  Base Org  :"
												+ FDGetSFoAuthHandleService
														.getSFoAuthHandle(
																getBorg())
														.getEnterpriseConnection()
														.getUserInfo()
														.getOrganizationId()
												+ "";
										System.out.println("Time"
												+ pkgInfoDO.getCalendar()
														.getTimeInMillis());
										linkedlist.add(new GetPackageProcess(
												Pkgdescription));
										List<Object> pkgCompList = (new GetPkgCompList(
												relInfoList, envDO,
												pkgInfoDO.getId())).getList();
										(new CreatePackageComp(getBorg(),
												pkgCompList))
												.create(pid,
														FDGetSFoAuthHandleService
																.getSFoAuthHandle(getBorg()),
														linkedlist);

										PackageInformationDAO pkginofDAO = new PackageInformationDAO();

										// Associate package with release
										ReleasePackageDAO relPkgDAO = new ReleasePackageDAO();

										List<Object> relePkgList = relPkgDAO
												.findByPkgIDAndRID(
														pid,
														getReleaseId(),
														FDGetSFoAuthHandleService
																.getSFoAuthHandle(getBorg()));
										if (relePkgList.size() > 0) {

										}

										else {
											ReleasePackageDO relPkgDO = new ReleasePackageDO(
													"1", pid, getReleaseId());

											String pkgId = relPkgDAO
													.insertAndGetId(
															relPkgDO,
															FDGetSFoAuthHandleService
																	.getSFoAuthHandle(getBorg()));
											if (pkgId != "") {
												String ReleasePkgdescription = "Release Package  "
														+ relPkgDO
																.getPackageC()
														+ " "
														+ "is created for Release ID "
														+ relPkgDO
																.getReleaseC()
														+ " "
														+ "in  Base Org  :"
														+ FDGetSFoAuthHandleService
																.getSFoAuthHandle(
																		getBorg())
																.getEnterpriseConnection()
																.getUserInfo()
																.getOrganizationId()
														+ "";
												linkedlist
														.add(new GetPackageProcess(
																ReleasePkgdescription));
											}

										}
									}

									RDAppService.updateToComplete(
											getMetadataLogId(),
											Constants.COMPLETED_STATUS,
											getBorg());

									ReleasesDAO rDAO = new ReleasesDAO();
									List<Object> release = rDAO
											.findById(
													releaseId,
													FDGetSFoAuthHandleService
															.getSFoAuthHandle(getBorg()));
									if (release.size() > 0) {

										for (Iterator releaseIterator = release
												.iterator(); releaseIterator
												.hasNext();) {
											ReleasesDO releasesDO = (ReleasesDO) releaseIterator
													.next();
											releasesDO
													.setStatus("Package Retrieved");
											rDAO.update(
													releasesDO,
													FDGetSFoAuthHandleService
															.getSFoAuthHandle(getBorg()));

										}

									}
								}

							} catch (SFException e) {
								throw new SFException(
										e.toString(),
										SFErrorCodes.SFDeployDetails_Update_Error);
							}
						}
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			for (GetPackageProcess element : linkedlist)

				System.out.println(element.toString() + "\n");

		}
	}

	private Org getBorg() {
		return borg;
	}

	private void setBorg(Org borg) {
		this.borg = borg;
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
