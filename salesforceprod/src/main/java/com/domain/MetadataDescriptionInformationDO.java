package com.domain;

/**
 * 
 * @author MetadataDescriptionInformationDO Used for Setting MetadataDescriptionInformation__c Table Data
 *
 */
public class MetadataDescriptionInformationDO {

	String name;
	String type;
	String organizationId;
	String metadataLogId;

	/**
	 * 
	 * @param name
	 *            is the Component Name
	 * @param type
	 *            is the Component Type
	 * @param organizationId
	 *            is the SourceOrganisation ID
	 * @param metadataLogId
	 *            is the MetadataLogId
	 */
	public MetadataDescriptionInformationDO(String name, String type,
			String organizationId, String metadataLogId) {
		this.name = name;
		this.type = type;
		this.organizationId = organizationId;
		this.metadataLogId = metadataLogId;
	}

	/**
	 * 
	 * @param name
	 *            is the Component Name
	 * @param type
	 *            is the Component Type
	 * @param organizationId
	 *            is the SourceOrganisation ID
	 */
	public MetadataDescriptionInformationDO(String name, String type, String organizationId) {
		this.name = name;
		this.type = type;
		this.organizationId = organizationId;
	}

	/**
	 * 
	 * @return Name of the Component
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param Setting
	 *            Name of the Component
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Type of Component
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param Setting
	 *            Component Type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return Source Organisation ID
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * 
	 * @param Setting
	 *            Source organizationId
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * 
	 * @return MetadataLogId
	 */
	public String getMetadataLogId() {
		return metadataLogId;
	}

	/**
	 * 
	 * @param Setting
	 *            metadataLogId
	 */
	public void setMetadataLogId(String metadataLogId) {
		this.metadataLogId = metadataLogId;
	}

}
