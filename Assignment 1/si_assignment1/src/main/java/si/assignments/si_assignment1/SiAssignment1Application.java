package si.assignments.si_assignment1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.assignments.si_assignment1.client.GeoIPServiceLocator;
import si.assignments.si_assignment1.model.Employee;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SiAssignment1Application {

    public static void main(String[] args) throws ParseException, IOException {
        Employee employee = new Employee("Mia", "mia@gmail.com", "80.62.116.107");
        Employee employee2 = new Employee("Kenneth", "kenneth@gmail.com", "77.18.55.234");
        Employee employee3 = new Employee("Malthe", "malthe@gmail.com", "85.214.132.117");

        List<Employee> employees = new ArrayList();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);

        RestFetching rf = new RestFetching();
//        String pathName = "si_assignment1\\Invitations";
        String pathName = "C:\\Users\\miade\\IdeaProjects\\System Integration GitHub Assignments\\SystemIntegrationGroup1\\Assignment 1\\si_assignment1\\Invitations";


        WriteToFile.CleanFolder(pathName);
        WriteToFile.CreateFolder(pathName);

        for (Employee e: employees) {
            String countryCode = GetCountryByIP(e.getIP(),e.getName());
            String gender = rf.GetGenderByNameAndCountry(e.getName(), countryCode);

            WriteToFile.CreateFile(e.getName(), pathName);
            WriteToFile.WriteToFile(e.getName(), gender, pathName);
        }
    }

    public static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
    }

    public static String GetCountryByIP(String IPAddress, String name) throws ParseException {
        GeoIPServiceLocator cipL = new GeoIPServiceLocator();
        try {
            String xmlResult = cipL.getGeoIPServiceSoap().getIpLocation(IPAddress);
            String country = getTagValue(xmlResult, "Country");
            System.out.println(country);
            return country;

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }




}
