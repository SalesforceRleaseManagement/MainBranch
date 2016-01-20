
package org.sforce.soap.local.sobject;

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

    private final static QName _ASAClientMetadataLogInformationCASAClientTargetOrgTokenNonEncryptedC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__TargetOrgTokenNonEncrypted__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientIDC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__ID__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientActionC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__Action__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientBaseOrgIdC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__BaseOrgId__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientStatusC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__Status__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientBaseOrgTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__BaseOrgToken__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientSourceOrganizationURLC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__SourceOrganizationURL__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientTargetOrgRefreshTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__TargetOrgRefreshToken__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientRecordIdC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__RecordId__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientSourceOrgTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__SourceOrgToken__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientTargetOrgTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__TargetOrgToken__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientBaseOrgUrlC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__BaseOrgUrl__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientBaseOrgRefreshTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__BaseOrgRefreshToken__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientOrganizationIdC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__OrganizationId__c");
    private final static QName _ASAClientMetadataLogInformationCASAClientSourceOrgRefreshTokenC_QNAME = new QName("urn:sobject.enterprise.soap.sforce.com", "ASAClient__SourceOrgRefreshToken__c");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sforce.soap.enterprise.sobject
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link ASAClientMetadataLogInformationC }
     * 
     */
    public ASAClientMetadataLogInformationC createASAClientMetadataLogInformationC() {
        return new ASAClientMetadataLogInformationC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__TargetOrgTokenNonEncrypted__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientTargetOrgTokenNonEncryptedC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientTargetOrgTokenNonEncryptedC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__ID__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientIDC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientIDC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__Action__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientActionC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientActionC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__BaseOrgId__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientBaseOrgIdC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientBaseOrgIdC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__Status__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientStatusC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientStatusC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__BaseOrgToken__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientBaseOrgTokenC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientBaseOrgTokenC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__SourceOrganizationURL__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientSourceOrganizationURLC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientSourceOrganizationURLC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__TargetOrgRefreshToken__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientTargetOrgRefreshTokenC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientTargetOrgRefreshTokenC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__RecordId__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientRecordIdC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientRecordIdC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__SourceOrgToken__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientSourceOrgTokenC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientSourceOrgTokenC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__TargetOrgToken__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientTargetOrgTokenC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientTargetOrgTokenC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__BaseOrgUrl__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientBaseOrgUrlC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientBaseOrgUrlC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__BaseOrgRefreshToken__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientBaseOrgRefreshTokenC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientBaseOrgRefreshTokenC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__OrganizationId__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientOrganizationIdC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientOrganizationIdC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sobject.enterprise.soap.sforce.com", name = "ASAClient__SourceOrgRefreshToken__c", scope = ASAClientMetadataLogInformationC.class)
    public JAXBElement<String> createASAClientMetadataLogInformationCASAClientSourceOrgRefreshTokenC(String value) {
        return new JAXBElement<String>(_ASAClientMetadataLogInformationCASAClientSourceOrgRefreshTokenC_QNAME, String.class, ASAClientMetadataLogInformationC.class, value);
    }

}
