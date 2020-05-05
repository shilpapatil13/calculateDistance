package intercom.customers.utils;

import org.json.JSONObject;

import intercom.customers.Constants;
import intercom.customers.model.Customer;
import intercom.customers.model.GPSCoordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private FileReader() {
    }

    public static List<Customer> getCustomers(InputStream inputStream) throws IOException {
        List<JSONObject> customers = new ArrayList<>();

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Constants.JSON_TXT_FILE_ENCODING))) {
            String line;
            while ((line = rd.readLine()) != null) {
                customers.add(new JSONObject(line));
            }
        }
        return getCustomersListFromJsonList(customers);
    }

    static List<Customer> getCustomersListFromJsonList(List<JSONObject> customerJsonObjects){
        List<Customer> customers = new ArrayList<>();
        for(JSONObject jsonObject: customerJsonObjects){
            GPSCoordinate location = new GPSCoordinate(
                    Double.parseDouble(jsonObject.get(Constants.JSON_CUSTOMER_LATITUDE_STRING).toString()),
                    Double.parseDouble(jsonObject.get(Constants.JSON_CUSTOMER_LONGITUDE_STRING).toString()));
            Customer customer = new Customer(
                    Integer.parseInt( jsonObject.get(Constants.JSON_CUSTOMER_USER_ID_STRING).toString()),
                    jsonObject.get(Constants.JSON_CUSTOMER_NAME_STRING).toString(),
                    location
            );
            customers.add(customer);
        }

        return customers;
    }

}
