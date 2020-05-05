package intercom.customers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GPSCoordinate {

    private double latitude;
    private double longitude;

    public GPSCoordinate(double d, double e) {
    	this.latitude = d;
    	this.longitude = e;
	}

	@Override
    public String toString(){
        return "latitude: " + latitude + ", longitude: " + longitude;
    }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
