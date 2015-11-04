package com.services.component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.domain.EnvironmentDO;
import com.domain.EnvironmentInformationDO;
import com.domain.SFoAuthHandleDO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.future.GetSFoAuthHandleFutureTask;
import com.services.application.RDAppService;
import com.util.Org;
import com.util.SFoAuthHandle;
import com.util.oauth.RefreshTokens;

public class FDGetSFoAuthHandleService {

	private static SFoAuthHandle sfHandle = null;

	// create an object of SingleObject
	private static FDGetSFoAuthHandleService instance = null;

	// Get the only object available
	public static FDGetSFoAuthHandleService getInstance() {
		if (instance == null) {
			instance = new FDGetSFoAuthHandleService();
		}
		return instance;
	}

	// make the constructor private so that this class cannot be
	// instantiated
	private FDGetSFoAuthHandleService() {
		super();
	}

	private SFoAuthHandle getSFHandle(String orgId, String token,
			String instanceURL, String refreshtoken, String orgType) {
		if (instance == null) {
			instance = getInstance();
		}
		if (sfHandle != null) {
			sfHandle.nullify();
			sfHandle = null;
		}

		SFoAuthHandleDO authDO = new SFoAuthHandleDO(orgId, token, instanceURL,
				refreshtoken, orgType);
		sfHandle = getSFoAuthHandleFFT(authDO);

		try {
			sfHandle = getSfHandle().getValidConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.sfHandle;
	}

	public static String getSFAuthToken(String orgId, String token,
			String instanceURL, String refreshtoken, String orgType) {
		getSFoAuthHandle(orgId, token, instanceURL, refreshtoken, orgType);
		return getSfHandle().getoAuthToken();
	}

	public static SFoAuthHandle getSFoAuthHandle(String orgId, String token,
			String instanceURL, String refreshtoken, String orgType)
			throws SFException {
		if (instance == null) {
			instance = getInstance();
		}
		if (sfHandle != null) {
			sfHandle.nullify();
			sfHandle = null;
		}

		SFoAuthHandleDO authDO = new SFoAuthHandleDO(orgId, token, instanceURL,
				refreshtoken, orgType);
		sfHandle = getSFoAuthHandleFFT(authDO);
		try {
			sfHandle = sfHandle.getValidConnection();
		} catch (SFException e) {
			throw e;
		}
		return sfHandle;
	}

	public static SFoAuthHandle getSFoAuthHandle(Org org)
			throws SFException {
		if (instance == null) {
			instance = getInstance();
		}
		if (sfHandle != null) {
			sfHandle.nullify();
			sfHandle = null;
		}

		SFoAuthHandleDO authDO = new SFoAuthHandleDO(org.getOrgId(), org.getOrgToken(), org.getOrgURL(),
				org.getRefreshToken(), org.getOrgType());
		sfHandle = getSFoAuthHandleFFT(authDO);
		try {
			sfHandle = sfHandle.getValidConnection();
		} catch (SFException e) {
			throw e;
		}
		return sfHandle;
	}
	
	public static SFoAuthHandle getSFoAuthHandle(String sourceOrgId,
			String orgId, String token, String instanceURL,
			String refreshtoken, String orgType) {
		setSfHandleToNUll();
		// get source environment details
		EnvironmentDO envSoureDO = RDAppService.getEnv(sourceOrgId,
				getSFoAuthHandle(orgId, token,
						instanceURL, refreshtoken, "0"));

		// refresh access tokens if the existing tokens have expired
		String newSToken = RefreshTokens.refreshCustomSFHandle(envSoureDO,
				orgId, token, instanceURL, refreshtoken);
		envSoureDO.setToken(newSToken);

		// get source salesforce handle
		sfHandle = FDGetSFoAuthHandleService.getSFoAuthHandle(envSoureDO,
				orgType);
		
		return sfHandle;
	}

	
	public static SFoAuthHandle getSFoAuthHandle(EnvironmentDO envDO,
			String orgType) throws SFException {
		if (instance == null) {
			instance = getInstance();
		}
		if (sfHandle != null) {
			sfHandle.nullify();
			sfHandle = null;
		}

		SFoAuthHandleDO authDO = new SFoAuthHandleDO(envDO.getOrgId(),
				envDO.getToken(), envDO.getServerURL(),
				envDO.getRefreshtoken(), orgType);
		sfHandle = getSFoAuthHandleFFT(authDO);
		sfHandle = getSFoAuthHandleFFT(authDO);
		try {
			sfHandle = getSfHandle().getValidConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sfHandle;
	}
	public static SFoAuthHandle getSFoAuthHandle(EnvironmentInformationDO envDO,
			String orgType) throws SFException {
		if (instance == null) {
			instance = getInstance();
		}
		if (sfHandle != null) {
			sfHandle.nullify();
			sfHandle = null;
		}

		SFoAuthHandleDO authDO = new SFoAuthHandleDO(envDO.getOrgId(),
				envDO.getToken(), envDO.getServerURL(),
				envDO.getRefreshtoken(), orgType);
		sfHandle = getSFoAuthHandleFFT(authDO);
		sfHandle = getSFoAuthHandleFFT(authDO);
		try {
			sfHandle = getSfHandle().getValidConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sfHandle;
	}
	private static SFoAuthHandle getSFoAuthHandleFFT(SFoAuthHandleDO authDO)
			throws SFException {
		if (instance == null) {
			instance = getInstance();
		}
		SFoAuthHandle sFoAuthHandle = null;

		GetSFoAuthHandleFutureTask callable1 = new GetSFoAuthHandleFutureTask(
				authDO);
		FutureTask<SFoAuthHandle> getSFoAuthHandleFutureTask = new FutureTask<SFoAuthHandle>(
				callable1);
		try {
			getSFoAuthHandleFutureTask.run();
			// ExecutorService executor = Executors.newFixedThreadPool(1);
			// executor.execute(getSFoAuthHandleFutureTask);
			while (true) {
				try {
					if (getSFoAuthHandleFutureTask.isDone()) {
						System.out
								.println("getSFoAuthHandleFutureTask is Done");
						// shut down executor service
						// executor.shutdown();
						sFoAuthHandle = getSFoAuthHandleFutureTask.get();
						return sFoAuthHandle;
					} else if (!getSFoAuthHandleFutureTask.isDone()) {
						// wait indefinitely for future task to complete
						System.out.println("Waiting on SFoAuthHandle.....");
						sFoAuthHandle = getSFoAuthHandleFutureTask.get();
					}
					System.out
							.println("Waiting for getSFoAuthHandleFutureTask to complete");
					sFoAuthHandle = getSFoAuthHandleFutureTask.get(200L,
							TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {
					// do nothing
				}
			}
		} catch (Exception ce) {
			throw new SFException(ce.toString(),
					SFErrorCodes.SF_ListObject_Error);
		}
	}

	public static void setSfHandleToNUll() {
		if (sfHandle != null) {
			sfHandle.nullify();
		}
		sfHandle = null;
	}

	public static SFoAuthHandle getSfHandle() {
		return sfHandle;
	}

	public static void setSfHandle(SFoAuthHandle sfHandle) {
		FDGetSFoAuthHandleService.sfHandle = sfHandle;
	}

}