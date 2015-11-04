
package com.sforce.soap._2005._09.outbound;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sforce.soap.local.deploy.sobject.ASAMetadataLogC;


/**
 * <p>Java class for ASA__MetadataLog__cNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ASA__MetadataLog__cNotification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:enterprise.soap.sforce.com}ID"/>
 *         &lt;element name="sObject" type="{urn:sobject.enterprise.soap.sforce.com}ASA__MetadataLog__c"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASA__MetadataLog__cNotification", propOrder = {
    "id",
    "sObject"
})
public class ASAMetadataLogCNotification {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(required = true)
    protected ASAMetadataLogC sObject;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the sObject property.
     * 
     * @return
     *     possible object is
     *     {@link ASAMetadataLogC }
     *     
     */
    public ASAMetadataLogC getSObject() {
        return sObject;
    }

    /**
     * Sets the value of the sObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link ASAMetadataLogC }
     *     
     */
    public void setSObject(ASAMetadataLogC value) {
        this.sObject = value;
    }

}
