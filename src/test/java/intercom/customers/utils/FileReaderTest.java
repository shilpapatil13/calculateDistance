package intercom.customers.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import intercom.customers.model.Customer;
import intercom.customers.utils.FileReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    public void getCustomers() throws IOException {

        String exampleString = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}\n" +
                "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}\n" +
                "{\"latitude\": \"51.8856167\", \"user_id\": 2, \"name\": \"Ian McArdle\", \"longitude\": \"-10.4240951\"}\n" +
                "{\"latitude\": \"52.3191841\", \"user_id\": 3, \"name\": \"Jack Enright\", \"longitude\": \"-8.5072391\"}";

        InputStream inputStream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));

        List<Customer> customers = FileReader.getCustomers(inputStream);

        assert (customers.size() == 4);

    }

    @Test
    public void getCustomersListFromJsonList() throws JSONException {

        List<JSONObject> customerJsonObjects = new ArrayList<>();

        customerJsonObjects.add(new JSONObject("{\"latitude\": \"53.4692815\", \"user_id\": 7, \"name\": \"Frank Kehoe\", \"longitude\": \"-9.436036\"}"));
        customerJsonObjects.add(new JSONObject("{\"latitude\": \"54.080556\", \"user_id\": 23, \"name\": \"Eoin Gallagher\", \"longitude\": \"-6.361944\"}"));
        customerJsonObjects.add(new JSONObject("{\"latitude\": \"53.521111\", \"user_id\": 20, \"name\": \"Enid Enright\", \"longitude\": \"-9.831111\"}"));
        
        List<Customer> customers = FileReader.getCustomersListFromJsonList(customerJsonObjects);

        assertEquals(3, customers.size());
        assertEquals(7, customers.get(0).getUserId());
        assertEquals("Eoin Gallagher", customers.get(1).getName());
        assertEquals(0d, Double.compare(53.521111d, customers.get(2).getLocation().getLatitude()) );
        assertEquals(0d, Double.compare(-9.831111d, customers.get(2).getLocation().getLongitude()) );

    }
}