package intercom.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import intercom.customers.utils.CustomerUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args){
        SpringApplication.run(Application.class, args);

        CustomerUtils.processCustomerData("https://s3.amazonaws.com/intercom-take-home-test/customers.txt", 100d);

	}

}
