package intercom.customers.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import intercom.customers.Constants;
import intercom.customers.model.Customer;
import intercom.customers.model.GPSCoordinate;

public class CustomerUtils {

    private static final Logger LOGGER = Logger.getLogger(CustomerUtils.class.getName());

    private CustomerUtils() {
    }

    public static List<Customer> getCustomersWithinDistance(List<Customer> customersToFilter, GPSCoordinate filterLocation, Double kilometerRange) {
        List<Customer> customersInRange = new ArrayList<>();

        for (Customer customer : customersToFilter) {
            if (kilometerRange.compareTo(GPSCoordinateUtils.getDistanceInKm(customer.getLocation(), filterLocation)) > 0) {
                customersInRange.add(customer);
            }
        }

        return customersInRange;
    }

    public static List<Customer> processCustomerData(String fileUrl, double validRange) {
        LOGGER.log(Level.INFO, () -> "Getting List of customers within " +
                validRange + "km Range of (" + Constants.OFFICE_GPS_COORDINATE + ")");
        try {

            LOGGER.log(Level.INFO, () -> "Reading Customer data from " + fileUrl);
            InputStream inputStream = new URL(fileUrl).openStream();
            List<Customer> customers = FileReader.getCustomers(inputStream);
            List<Customer> customersInRange = getCustomersWithinDistance(
                    customers, Constants.OFFICE_GPS_COORDINATE, validRange);

            LOGGER.log(Level.INFO, () -> "Total customers read from file " + customers.size() + ", of which " +
                    customersInRange.size() + " are within a " + validRange + "km Range.");

            customersInRange.sort(Comparator.comparingInt(Customer::getUserId));
            StringBuilder sb = new StringBuilder();
            for (Customer customer : customersInRange) {
                sb.append(customer).append(System.lineSeparator());
            }

            LOGGER.log(Level.INFO, () -> "List of customers in range: " + System.lineSeparator() + System.lineSeparator() + sb);
            return customersInRange;

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An Error has occurred, Exiting Application: " + e.toString());
            return new ArrayList<>();
        }

    }
}
