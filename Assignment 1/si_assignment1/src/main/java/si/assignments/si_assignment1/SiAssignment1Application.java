package si.assignments.si_assignment1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.assignments.si_assignment1.client.GeoIPServiceLocator;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Scanner;

@SpringBootApplication
public class SiAssignment1Application {

    public static void main(String[] args) throws ParseException {

        GeoIPServiceLocator cipL = new GeoIPServiceLocator();
        RestFetching rf = new RestFetching();
        try {
            String xmlResult = cipL.getGeoIPServiceSoap().getIpLocation("80.62.116.107");
            String country = getTagValue(xmlResult, "Country");
            //System.out.println(country);
            try {
                System.out.println(rf.fetching("Mia", country));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
    }
    public static void GeoIpFunction(String IPAddress, String name) throws ParseException {
        GeoIPServiceLocator cipL = new GeoIPServiceLocator();
        RestFetching rf = new RestFetching();
        try {
            String xmlResult = cipL.getGeoIPServiceSoap().getIpLocation(IPAddress);
            String country = getTagValue(xmlResult, "Country");
            //System.out.println(country);
            try {
                System.out.println(rf.fetching(name, country));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }




}
