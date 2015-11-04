
package com.sforce.soap.local.deploy.sobject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for ASA__MetadataLog__c complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ASA__MetadataLog__c">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:sobject.enterprise.soap.sforce.com}sObject">
 *       &lt;sequence>
 *         &lt;element name="ASA__Action__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__BaseOrgId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__BaseOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__BaseOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__BaseOrgUrl__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__OrganizationId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__RecordId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__SourceOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__SourceOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__TargetOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__TargetOrgTokenNonEncrypted__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASA__TargetOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASA__MetadataLog__c", propOrder = {
    "asaActionC",
    "asaBaseOrgIdC",
    "asaBaseOrgRefreshTokenC",
    "asaBaseOrgTokenC",
    "asaBaseOrgUrlC",
    "asaidc",
    "asaOrganizationIdC",
    "asaRecordIdC",
    "asaSourceOrgRefreshTokenC",
    "asaSourceOrgTokenC",
    "asasourceOrganizationURLC",
    "asaTargetOrgRefreshTokenC",
    "asaTargetOrgTokenNonEncryptedC",
    "asaTargetOrgTokenC",
    "asaNameC",
    "asaStatusC"
})
public class ASAMetadataLogC
    extends SObject
{

    @XmlElementRef(name = "ASA__Action__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaActionC;
    @XmlElementRef(name = "ASA__BaseOrgId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaBaseOrgIdC;
    @XmlElementRef(name = "ASA__BaseOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaBaseOrgRefreshTokenC;
    @XmlElementRef(name = "ASA__BaseOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaBaseOrgTokenC;
    @XmlElementRef(name = "ASA__BaseOrgUrl__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaBaseOrgUrlC;
    @XmlElementRef(name = "ASA__ID__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaidc;
    @XmlElementRef(name = "ASA__OrganizationId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaOrganizationIdC;
    @XmlElementRef(name = "ASA__RecordId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaRecordIdC;
    @XmlElementRef(name = "ASA__SourceOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaSourceOrgRefreshTokenC;
    @XmlElementRef(name = "ASA__SourceOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaSourceOrgTokenC;
    @XmlElementRef(name = "ASA__TargetOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaTargetOrgRefreshTokenC;
    @XmlElementRef(name = "ASA__TargetOrgTokenNonEncrypted__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaTargetOrgTokenNonEncryptedC;
    @XmlElementRef(name = "ASA__TargetOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaTargetOrgTokenC;
    @XmlElementRef(name = "ASA__Name__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
	protected JAXBElement<String> asaNameC;

	@XmlElementRef(name = "ASA__Status__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
	protected JAXBElement<String> asaStatusC;
	
	@XmlElementRef(name = "ASA__SourceOrganizationURL__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asasourceOrganizationURLC;
	
	
    /**
     * Gets the value of the asaActionC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAActionC() {
        return asaActionC;
    }

    /**
     * Sets the value of the asaActionC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAActionC(JAXBElement<String> value) {
        this.asaActionC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaBaseOrgIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASABaseOrgIdC() {
        return asaBaseOrgIdC;
    }

    /**
     * Sets the value of the asaBaseOrgIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASABaseOrgIdC(JAXBElement<String> value) {
        this.asaBaseOrgIdC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaBaseOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASABaseOrgRefreshTokenC() {
        return asaBaseOrgRefreshTokenC;
    }

    /**
     * Sets the value of the asaBaseOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASABaseOrgRefreshTokenC(JAXBElement<String> value) {
        this.asaBaseOrgRefreshTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaBaseOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASABaseOrgTokenC() {
        return asaBaseOrgTokenC;
    }

    /**
     * Sets the value of the asaBaseOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASABaseOrgTokenC(JAXBElement<String> value) {
        this.asaBaseOrgTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaBaseOrgUrlC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASABaseOrgUrlC() {
        return asaBaseOrgUrlC;
    }

    /**
     * Sets the value of the asaBaseOrgUrlC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASABaseOrgUrlC(JAXBElement<String> value) {
        this.asaBaseOrgUrlC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaidc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAIDC() {
        return asaidc;
    }

    /**
     * Sets the value of the asaidc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAIDC(JAXBElement<String> value) {
        this.asaidc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaOrganizationIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAOrganizationIdC() {
        return asaOrganizationIdC;
    }

    /**
     * Sets the value of the asaOrganizationIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAOrganizationIdC(JAXBElement<String> value) {
        this.asaOrganizationIdC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaRecordIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASARecordIdC() {
        return asaRecordIdC;
    }

    /**
     * Sets the value of the asaRecordIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASARecordIdC(JAXBElement<String> value) {
        this.asaRecordIdC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaSourceOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASASourceOrgRefreshTokenC() {
        return asaSourceOrgRefreshTokenC;
    }

    /**
     * Sets the value of the asaSourceOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASASourceOrgRefreshTokenC(JAXBElement<String> value) {
        this.asaSourceOrgRefreshTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaSourceOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASASourceOrgTokenC() {
        return asaSourceOrgTokenC;
    }

    /**
     * Sets the value of the asaSourceOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASASourceOrgTokenC(JAXBElement<String> value) {
        this.asaSourceOrgTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaTargetOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASATargetOrgRefreshTokenC() {
        return asaTargetOrgRefreshTokenC;
    }

    /**
     * Sets the value of the asaTargetOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASATargetOrgRefreshTokenC(JAXBElement<String> value) {
        this.asaTargetOrgRefreshTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaTargetOrgTokenNonEncryptedC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASATargetOrgTokenNonEncryptedC() {
        return asaTargetOrgTokenNonEncryptedC;
    }

    /**
     * Sets the value of the asaTargetOrgTokenNonEncryptedC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASATargetOrgTokenNonEncryptedC(JAXBElement<String> value) {
        this.asaTargetOrgTokenNonEncryptedC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaTargetOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASATargetOrgTokenC() {
        return asaTargetOrgTokenC;
    }

    /**
     * Sets the value of the asaTargetOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASATargetOrgTokenC(JAXBElement<String> value) {
        this.asaTargetOrgTokenC = ((JAXBElement<String> ) value);
    }

    /**
	 * Gets the value of the asaNameC property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getASANameC() {
		return asaNameC;
	}

	/**
	 * Sets the value of the asaNameC property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setASANameC(JAXBElement<String> value) {
		this.asaNameC = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the asaStatusC property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getASAStatusC() {
		return asaStatusC;
	}

	/**
	 * Sets the value of the asaStatusC property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setASAStatusC(JAXBElement<String> value) {
		this.asaStatusC = ((JAXBElement<String>) value);
	}

	  /**
     * Gets the value of the sourceOrganizationURLC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASASourceOrganizationURLC() {
        return asasourceOrganizationURLC;
    }

    /**
     * Sets the value of the sourceOrganizationURLC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASASourceOrganizationURLC(JAXBElement<String> value) {
        this.asasourceOrganizationURLC = ((JAXBElement<String> ) value);
    }


}

