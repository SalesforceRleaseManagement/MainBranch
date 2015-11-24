package com.util.oauth;

import java.util.Iterator;
import java.util.List;

import com.domain.DeploymentSettingsDO;
import com.domain.EnvironmentDO;
import com.domain.EnvironmentInformationDO;
import com.ds.salesforce.dao.comp.DeployDetailsDAO;
import com.ds.salesforce.dao.comp.DeploySettingsDAO;
import com.ds.salesforce.dao.comp.EnvironmentDAO;
import com.ds.salesforce.dao.comp.EnvironmentInformationDAO;
import com.exception.SFErrorCodes;
import com.exception.SFException;
import com.services.component.FDGetSFoAuthHandleService;
import com.util.Constants;

public class RefreshTokens {
	private static String  oAuthToken;
	private static String baseAuthToken;
	private static String customAuthToken;
	private static String customBaseAuthToken;

	public RefreshTokens() {
		super();
	}

	public static void refreshBaseSFHandle(String bOrgId, String bOrgToken,
			String bOrgURL, String refreshtoken) throws SFException {
		DeploySettingsDAO dsDAO = new DeploySettingsDAO();
		DeploymentSettingsDO dsDO = null;
		try {
			boolean isBase = true;
			baseAuthToken = FDGetSFoAuthHandleService.getSFAuthToken(bOrgId,
					bOrgToken, bOrgURL, refreshtoken,Constants.BaseOrgID );
			System.out.println(baseAuthToken);

			
			List dsList = dsDAO.findById(bOrgId, FDGetSFoAuthHandleService
					.getSFoAuthHandle(bOrgId, baseAuthToken, bOrgURL,
							refreshtoken, Constants.BaseOrgID));

			for (Iterator iterator = dsList.iterator(); iterator.hasNext();) {
				dsDO = (DeploymentSettingsDO) iterator.next();
			}
			System.out.println("Old Token: " + bOrgToken);
			System.out.println("new Token: " + baseAuthToken);
			dsDO.setToken(baseAuthToken);
			dsDAO.update(dsDO, FDGetSFoAuthHandleService.getSFoAuthHandle(
					bOrgId, baseAuthToken, bOrgURL, refreshtoken, Constants.BaseOrgID));
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
	}
	
	public static String refreshSFHandle(String bOrgId, String bOrgToken,
			String bOrgURL,String orgType, String refreshtoken) throws SFException {
		DeploySettingsDAO dsDAO = new DeploySettingsDAO();
		DeploymentSettingsDO dsDO = null;
		try {
			
			oAuthToken = FDGetSFoAuthHandleService.getSFAuthToken(bOrgId,
					bOrgToken, bOrgURL, refreshtoken,orgType );
			System.out.println(oAuthToken);

			
			/*List dsList = dsDAO.findById(bOrgId, FDGetSFoAuthHandleService
					.getSFoAuthHandle(bOrgId, baseAuthToken, bOrgURL,
							refreshtoken, Constants.BaseOrgID));

			for (Iterator iterator = dsList.iterator(); iterator.hasNext();) {
				dsDO = (DeploymentSettingsDO) iterator.next();
			}
			System.out.println("Old Token: " + bOrgToken);
			System.out.println("new Token: " + baseAuthToken);
			dsDO.setToken(baseAuthToken);
			dsDAO.update(dsDO, FDGetSFoAuthHandleService.getSFoAuthHandle(
					bOrgId, baseAuthToken, bOrgURL, refreshtoken, Constants.BaseOrgID));*/
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return oAuthToken;
	}

	public static void refreshCustomSFHandle(String bOrgId, String bOrgToken,
			String bOrgURL, String refreshtoken) throws SFException {}

	public static String refreshCustomSFHandle(EnvironmentDO envDO,String bOrgId, String bOrgToken, String bOrgURL,
			String refreshToken)
			throws SFException {
		EnvironmentDAO envDAO = new EnvironmentDAO();
		try {
			
			customAuthToken = FDGetSFoAuthHandleService.getSFAuthToken(
					envDO.getOrgId(), envDO.getToken(), envDO.getServerURL(),
					envDO.getRefreshtoken(), Constants.CustomOrgID);
			System.out.println(customAuthToken);
			
		
			List envLogList = envDAO.findById(envDO.getOrgId(),
					FDGetSFoAuthHandleService.getSFoAuthHandle(
							bOrgId, bOrgToken,bOrgURL,refreshToken,Constants.BaseOrgID));

			for (Iterator iterator = envLogList.iterator(); iterator.hasNext();) {
				envDO = (EnvironmentDO) iterator.next();
			}
			envDO.setTokenCodeNonEncrypted(customAuthToken);

			System.out.println("customAuthToken new Token: " + envDO.getTokenCodeNonEncrypted());
			envDAO.update(envDO, FDGetSFoAuthHandleService.getSFoAuthHandle(
					bOrgId, bOrgToken,bOrgURL,refreshToken,Constants.BaseOrgID));
			
			FDGetSFoAuthHandleService.setSfHandleToNUll();
			
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return customAuthToken;
	}
	
	public static String refreshCustomBaseSFHandle(EnvironmentDO envDO,String bOrgId, String bOrgToken, String bOrgURL,
			String refreshToken)
			throws SFException {
		EnvironmentDAO envDAO = new EnvironmentDAO();
		try {
			
			String customBaseAuthToken = FDGetSFoAuthHandleService.getSFAuthToken(
					envDO.getOrgId(), envDO.getToken(), envDO.getServerURL(),
					envDO.getRefreshtoken(), Constants.CustomBaseOrgID);
			System.out.println(customBaseAuthToken);
			
		
			List envLogList = envDAO.findById(envDO.getOrgId(),
					FDGetSFoAuthHandleService.getSFoAuthHandle(
							bOrgId, bOrgToken,bOrgURL,refreshToken,Constants.CustomBaseOrgID));

			for (Iterator iterator = envLogList.iterator(); iterator.hasNext();) {
				envDO = (EnvironmentDO) iterator.next();
			}
			envDO.setTokenCodeNonEncrypted(customBaseAuthToken);

			System.out.println("customAuthToken new Token: " + envDO.getTokenCodeNonEncrypted());
			envDAO.update(envDO, FDGetSFoAuthHandleService.getSFoAuthHandle(
					bOrgId, bOrgToken,bOrgURL,refreshToken,Constants.CustomBaseOrgID));
			
			FDGetSFoAuthHandleService.setSfHandleToNUll();
			
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return customBaseAuthToken;
	}
	public static String refreshClientCustomSFHandle(EnvironmentInformationDO envDO,String bOrgId, String bOrgToken, String bOrgURL,
			String refreshToken)
			throws SFException {
		EnvironmentInformationDAO envDAO = new EnvironmentInformationDAO();
		try {
			
			customAuthToken = FDGetSFoAuthHandleService.getSFAuthToken(
					envDO.getOrgId(), envDO.getToken(), envDO.getServerURL(),
					envDO.getRefreshtoken(), Constants.CustomBaseOrgID);
			System.out.println(customAuthToken);
			
		
			List envLogList = envDAO.findById(envDO.getOrgId(),
					FDGetSFoAuthHandleService.getSFoAuthHandle(
							bOrgId, bOrgToken,bOrgURL,refreshToken,Constants.CustomBaseOrgID));

			for (Iterator iterator = envLogList.iterator(); iterator.hasNext();) {
				envDO = (EnvironmentInformationDO) iterator.next();
			}
			envDO.setTokenCodeNonEncrypted(customAuthToken);

			System.out.println("customAuthToken new Token: " + envDO.getTokenCodeNonEncrypted());
			envDAO.update(envDO, FDGetSFoAuthHandleService.getSFoAuthHandle(
					bOrgId, bOrgToken,bOrgURL,refreshToken,Constants.CustomBaseOrgID));
			
			FDGetSFoAuthHandleService.setSfHandleToNUll();
			
		} catch (SFException e) {
			throw new SFException(e.toString(),
					SFErrorCodes.SFEnvironment_Update_Error);
		}
		return customAuthToken;
	}

	public static String getBaseAuthToken() {
		return baseAuthToken;
	}

	private static void setBaseAuthToken(String baseAuthToken) {
		RefreshTokens.baseAuthToken = baseAuthToken;
	}

	public static String getCustomAuthToken() {
		return customAuthToken;
	}

	private static void setCustomAuthToken(String customAuthToken) {
		RefreshTokens.customAuthToken = customAuthToken;
	}

	public static String getoAuthToken() {
		return oAuthToken;
	}

	public static void setoAuthToken(String oAuthToken) {
		RefreshTokens.oAuthToken = oAuthToken;
	}

}
