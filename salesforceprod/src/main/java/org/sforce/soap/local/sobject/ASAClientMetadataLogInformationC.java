
package org.sforce.soap.local.sobject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ASAClient__MetadataLogInformation__c complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ASAClient__MetadataLogInformation__c">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:sobject.enterprise.soap.sforce.com}sObject">
 *       &lt;sequence>
 *         &lt;element name="ASAClient__Action__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__BaseOrgId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__BaseOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__BaseOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__BaseOrgUrl__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__OrganizationId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__RecordId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__SourceOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__SourceOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__SourceOrganizationURL__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__Status__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__TargetOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__TargetOrgTokenNonEncrypted__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASAClient__TargetOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASAClient__MetadataLogInformation__c", propOrder = {
    "asaClientActionC",
    "asaClientBaseOrgIdC",
    "asaClientBaseOrgRefreshTokenC",
    "asaClientBaseOrgTokenC",
    "asaClientBaseOrgUrlC",
    "asaClientIDC",
    "asaClientOrganizationIdC",
    "asaClientRecordIdC",
    "asaClientSourceOrgRefreshTokenC",
    "asaClientSourceOrgTokenC",
    "asaClientSourceOrganizationURLC",
    "asaClientStatusC",
    "asaClientTargetOrgRefreshTokenC",
    "asaClientTargetOrgTokenNonEncryptedC",
    "asaClientTargetOrgTokenC"
})
public class ASAClientMetadataLogInformationC
    extends SObject
{

    @XmlElementRef(name = "ASAClient__Action__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientActionC;
    @XmlElementRef(name = "ASAClient__BaseOrgId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientBaseOrgIdC;
    @XmlElementRef(name = "ASAClient__BaseOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientBaseOrgRefreshTokenC;
    @XmlElementRef(name = "ASAClient__BaseOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientBaseOrgTokenC;
    @XmlElementRef(name = "ASAClient__BaseOrgUrl__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientBaseOrgUrlC;
    @XmlElementRef(name = "ASAClient__ID__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientIDC;
    @XmlElementRef(name = "ASAClient__OrganizationId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientOrganizationIdC;
    @XmlElementRef(name = "ASAClient__RecordId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientRecordIdC;
    @XmlElementRef(name = "ASAClient__SourceOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientSourceOrgRefreshTokenC;
    @XmlElementRef(name = "ASAClient__SourceOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientSourceOrgTokenC;
    @XmlElementRef(name = "ASAClient__SourceOrganizationURL__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientSourceOrganizationURLC;
    @XmlElementRef(name = "ASAClient__Status__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientStatusC;
    @XmlElementRef(name = "ASAClient__TargetOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientTargetOrgRefreshTokenC;
    @XmlElementRef(name = "ASAClient__TargetOrgTokenNonEncrypted__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientTargetOrgTokenNonEncryptedC;
    @XmlElementRef(name = "ASAClient__TargetOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class)
    protected JAXBElement<String> asaClientTargetOrgTokenC;

    /**
     * Gets the value of the asaClientActionC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientActionC() {
        return asaClientActionC;
    }

    /**
     * Sets the value of the asaClientActionC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientActionC(JAXBElement<String> value) {
        this.asaClientActionC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientBaseOrgIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientBaseOrgIdC() {
        return asaClientBaseOrgIdC;
    }

    /**
     * Sets the value of the asaClientBaseOrgIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientBaseOrgIdC(JAXBElement<String> value) {
        this.asaClientBaseOrgIdC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientBaseOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientBaseOrgRefreshTokenC() {
        return asaClientBaseOrgRefreshTokenC;
    }

    /**
     * Sets the value of the asaClientBaseOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientBaseOrgRefreshTokenC(JAXBElement<String> value) {
        this.asaClientBaseOrgRefreshTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientBaseOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientBaseOrgTokenC() {
        return asaClientBaseOrgTokenC;
    }

    /**
     * Sets the value of the asaClientBaseOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientBaseOrgTokenC(JAXBElement<String> value) {
        this.asaClientBaseOrgTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientBaseOrgUrlC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientBaseOrgUrlC() {
        return asaClientBaseOrgUrlC;
    }

    /**
     * Sets the value of the asaClientBaseOrgUrlC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientBaseOrgUrlC(JAXBElement<String> value) {
        this.asaClientBaseOrgUrlC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientIDC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientIDC() {
        return asaClientIDC;
    }

    /**
     * Sets the value of the asaClientIDC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientIDC(JAXBElement<String> value) {
        this.asaClientIDC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientOrganizationIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientOrganizationIdC() {
        return asaClientOrganizationIdC;
    }

    /**
     * Sets the value of the asaClientOrganizationIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientOrganizationIdC(JAXBElement<String> value) {
        this.asaClientOrganizationIdC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientRecordIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientRecordIdC() {
        return asaClientRecordIdC;
    }

    /**
     * Sets the value of the asaClientRecordIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientRecordIdC(JAXBElement<String> value) {
        this.asaClientRecordIdC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientSourceOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientSourceOrgRefreshTokenC() {
        return asaClientSourceOrgRefreshTokenC;
    }

    /**
     * Sets the value of the asaClientSourceOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientSourceOrgRefreshTokenC(JAXBElement<String> value) {
        this.asaClientSourceOrgRefreshTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientSourceOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientSourceOrgTokenC() {
        return asaClientSourceOrgTokenC;
    }

    /**
     * Sets the value of the asaClientSourceOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientSourceOrgTokenC(JAXBElement<String> value) {
        this.asaClientSourceOrgTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientSourceOrganizationURLC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientSourceOrganizationURLC() {
        return asaClientSourceOrganizationURLC;
    }

    /**
     * Sets the value of the asaClientSourceOrganizationURLC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientSourceOrganizationURLC(JAXBElement<String> value) {
        this.asaClientSourceOrganizationURLC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientStatusC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientStatusC() {
        return asaClientStatusC;
    }

    /**
     * Sets the value of the asaClientStatusC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientStatusC(JAXBElement<String> value) {
        this.asaClientStatusC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientTargetOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientTargetOrgRefreshTokenC() {
        return asaClientTargetOrgRefreshTokenC;
    }

    /**
     * Sets the value of the asaClientTargetOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientTargetOrgRefreshTokenC(JAXBElement<String> value) {
        this.asaClientTargetOrgRefreshTokenC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientTargetOrgTokenNonEncryptedC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientTargetOrgTokenNonEncryptedC() {
        return asaClientTargetOrgTokenNonEncryptedC;
    }

    /**
     * Sets the value of the asaClientTargetOrgTokenNonEncryptedC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientTargetOrgTokenNonEncryptedC(JAXBElement<String> value) {
        this.asaClientTargetOrgTokenNonEncryptedC = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the asaClientTargetOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getASAClientTargetOrgTokenC() {
        return asaClientTargetOrgTokenC;
    }

    /**
     * Sets the value of the asaClientTargetOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setASAClientTargetOrgTokenC(JAXBElement<String> value) {
        this.asaClientTargetOrgTokenC = ((JAXBElement<String> ) value);
    }

}
