package intercom.customers.utils;

import org.junit.Test;

import intercom.customers.Constants;
import intercom.customers.model.Customer;
import intercom.customers.model.GPSCoordinate;
import intercom.customers.utils.CustomerUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerUtilsTest {

    @Test
    public void getCustomersWithinDistance() {

        List<Customer> customersToFilter = new ArrayList<>();
        customersToFilter.add(new Customer(2, "Adam", new GPSCoordinate(53.2451022d,-6.238335d)));
        customersToFilter.add(new Customer(8, "Dave", new GPSCoordinate(55.033d,-8.112d)));
        customersToFilter.add(new Customer(4, "Beth", new GPSCoordinate(53d,-7d)));
        customersToFilter.add(new Customer(6, "Chad", new GPSCoordinate(51.92893d,-10.27699d)));

        GPSCoordinate filterLocation = new GPSCoordinate(53.339428,-6.257664);

        Double kilometerRange = 100d;

        List<Customer> customersInRange = CustomerUtils.getCustomersWithinDistance(customersToFilter, filterLocation, kilometerRange);

        assertEquals(2, customersInRange.size());
        assertEquals(2, customersInRange.get(0).getUserId());
        assertEquals(4, customersInRange.get(1).getUserId());

    }

    @Test
    public void processCustomerData() {

        List<Customer> customers = CustomerUtils.processCustomerData(Constants.DEFAULT_JSON_TXT_FILE_INPUT_URL,
                Constants.DEFAULT_VALID_RANGE_IN_KM);

        assertEquals("Ian Kehoe", customers.get(0).getName());
        assertEquals(11, customers.get(4).getUserId());

    }

    @Test
    public void processCustomerDataError(){

        List<Customer> customers = CustomerUtils.processCustomerData("Some URL that won't work",
                Constants.DEFAULT_VALID_RANGE_IN_KM);

        assertTrue(customers.isEmpty());

    }
}