/**
 * GeoIPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package si.assignments.si_assignment1.client;

public interface GeoIPService extends javax.xml.rpc.Service {

/**
 * <b>A web service which performs GetIpAddress Lookups.</b>
 */
    public java.lang.String getGeoIPServiceSoapAddress();

    public si.assignments.si_assignment1.client.GeoIPServiceSoap_PortType getGeoIPServiceSoap() throws javax.xml.rpc.ServiceException;

    public si.assignments.si_assignment1.client.GeoIPServiceSoap_PortType getGeoIPServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getGeoIPServiceSoap12Address();

    public si.assignments.si_assignment1.client.GeoIPServiceSoap_PortType getGeoIPServiceSoap12() throws javax.xml.rpc.ServiceException;

    public si.assignments.si_assignment1.client.GeoIPServiceSoap_PortType getGeoIPServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
