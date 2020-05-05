package intercom.customers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private int userId;
    private String name;
    private GPSCoordinate location;

    public Customer(int parseInt, String string, GPSCoordinate location2) {
    	this.userId = parseInt;
    	this.name = string;
    	this.location = location2;
    }

	@Override
    public String toString(){
        return "user_id: " + userId +
                ", name: " + name;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(GPSCoordinate location) {
		this.location = location;
	}

	public GPSCoordinate getLocation() {
		return location;
	}

}
