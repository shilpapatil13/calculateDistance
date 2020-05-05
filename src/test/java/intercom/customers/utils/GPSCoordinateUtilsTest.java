package intercom.customers.utils;

import org.junit.Test;

import intercom.customers.model.GPSCoordinate;
import intercom.customers.utils.GPSCoordinateUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GPSCoordinateUtilsTest {

    @Test
    public void getDistanceInKm() {
        GPSCoordinate location1 = new GPSCoordinate(200d, -300d);
        GPSCoordinate location2 = new GPSCoordinate(-500d, 100d);
        Double expectedDistance = 4395.644069312897d;

        assertEquals(0, expectedDistance.compareTo(GPSCoordinateUtils.getDistanceInKm(location1,location2)));

    }

}