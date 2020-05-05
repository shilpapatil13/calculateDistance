package intercom.customers.utils;

import intercom.customers.model.GPSCoordinate;

class GPSCoordinateUtils {

    private GPSCoordinateUtils() {
    }

    static double getDistanceInKm(GPSCoordinate location1, GPSCoordinate location2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(location2.getLatitude() - location1.getLatitude());
        double lonDistance = Math.toRadians(location2.getLongitude() - location1.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(location1.getLatitude())) * Math.cos(Math.toRadians(location2.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Math.sqrt(Math.pow(R * c, 2));
    }

}
