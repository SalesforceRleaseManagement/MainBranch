
package com.sforce.soap.local.retrieve.sobject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sforce.soap.enterprise.sobject package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ASAMetadataLogCASABaseOrgUrlC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__BaseOrgUrl__c");
    private final static QName _ASAMetadataLogCASAIDC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__ID__c");
    private final static QName _ASAMetadataLogCASAOrganizationIdC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__OrganizationId__c");
    private final static QName _ASAMetadataLogCASATargetOrgTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__TargetOrgToken__c");
    private final static QName _ASAMetadataLogCASASourceOrgRefreshTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__SourceOrgRefreshToken__c");
    private final static QName _ASAMetadataLogCASARecordIdC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__RecordId__c");
    private final static QName _ASAMetadataLogCASABaseOrgTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__BaseOrgToken__c");
    private final static QName _ASAMetadataLogCASABaseOrgRefreshTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__BaseOrgRefreshToken__c");
    private final static QName _ASAMetadataLogCASASourceOrgTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__SourceOrgToken__c");
    private final static QName _ASAMetadataLogCASABaseOrgIdC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__BaseOrgId__c");
    private final static QName _ASAMetadataLogCASAActionC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__Action__c");

    private final static QName _ASAMetadataLogCASASourceOrganizationURLC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__SourceOrganizationURL__c");
    private final static QName _ASAMetadataLogCASATargetOrgTokenNonEncryptedC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASA__TargetOrgTokenNonEncrypted__c");
    
    

    
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sforce.soap.enterprise.sobject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ASAMetadataLogC }
     * 
     */
    public ASAMetadataLogC createASAMetadataLogC() {
        return new ASAMetadataLogC();
    }

    /**
     * Create an instance of {@link SObject }
     * 
     */
    public com.sforce.soap.enterprise.sobject.SObject createSObject() {
        return new com.sforce.soap.enterprise.sobject.SObject();
    }

    /**
     * Create an instance of {@link AggregateResult }
     * 
     */
    public AggregateResult createAggregateResult() {
        return new AggregateResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__TargetOrgToken__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASATargetOrgTokenC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASATargetOrgTokenC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__SourceOrganizationURL__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASASourceOrganizationURLC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASASourceOrganizationURLC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__BaseOrgUrl__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASABaseOrgUrlC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASABaseOrgUrlC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__TargetOrgTokenNonEncrypted__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASATargetOrgTokenNonEncryptedC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASATargetOrgTokenNonEncryptedC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__OrganizationId__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASAOrganizationIdC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASAOrganizationIdC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__RecordId__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASARecordIdC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASARecordIdC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__SourceOrgToken__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASASourceOrgTokenC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASASourceOrgTokenC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__BaseOrgRefreshToken__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASABaseOrgRefreshTokenC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASABaseOrgRefreshTokenC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__SourceOrgRefreshToken__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASASourceOrgRefreshTokenC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASASourceOrgRefreshTokenC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__BaseOrgId__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASABaseOrgIdC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASABaseOrgIdC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__ID__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASAIDC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASAIDC_QNAME, String.class, ASAMetadataLogC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__BaseOrgToken__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASABaseOrgTokenC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASABaseOrgTokenC_QNAME, String.class, ASAMetadataLogC.class, value);
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASA__Action__c", scope = ASAMetadataLogC.class)
    public JAXBElement<String> createASAMetadataLogCASAActionC(String value) {
        return new JAXBElement<String>(_ASAMetadataLogCASAActionC_QNAME, String.class, ASAMetadataLogC.class, value);
    }


}