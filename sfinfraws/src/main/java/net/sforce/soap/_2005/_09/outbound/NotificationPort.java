
package net.sforce.soap._2005._09.outbound;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NotificationPort", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
@XmlSeeAlso({
	net.sforce.soap._2005._09.outbound.ObjectFactory.class,
    net.sforce.soap.local.sobject.ObjectFactory.class
})
public interface NotificationPort {


    /**
     * Process a number of notifications.
     * 
     * @param sessionId
     * @param enterpriseUrl
     * @param notification
     * @param partnerUrl
     * @param actionId
     * @param organizationId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "Ack", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
    @RequestWrapper(localName = "notifications", targetNamespace = "http://soap.sforce.com/2005/09/outbound", className = "net.sforce.soap._2005._09.outbound.Notifications")
    @ResponseWrapper(localName = "notificationsResponse", targetNamespace = "http://soap.sforce.com/2005/09/outbound", className = "net.sforce.soap._2005._09.outbound.NotificationsResponse")
    public boolean notifications(
        @WebParam(name = "OrganizationId", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
        String organizationId,
        @WebParam(name = "ActionId", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
        String actionId,
        @WebParam(name = "SessionId", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
        String sessionId,
        @WebParam(name = "EnterpriseUrl", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
        String enterpriseUrl,
        @WebParam(name = "PartnerUrl", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
        String partnerUrl,
        @WebParam(name = "Notification", targetNamespace = "http://soap.sforce.com/2005/09/outbound")
        List<MetadataLogCNotification> notification);

}