This project is the answer to a test to demonstrate how to structure components in a small program.

The test:
We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

The GPS coordinates for our office are 53.339428, -6.257664.
You can find the Customer list here: https://s3.amazonaws.com/intercom-take-home-test/customers.txt

# How to run this project

Download the project
 
* Download the .zip file and extract it

Build the project 

* Once you have unzipped / cloned the project, using your terminal navigate to its root folder (the once containing the "README.md" file)
* Now run this command:  `mvn clean install` 
* This will use Maven to download the required dependencies, and build an executable jar file in the newly created "target" folder

Run the project as spring boot app
Your output should look something like this


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.3.RELEASE)

2020-02-09 17:24:59.657  INFO 8712 --- [           main] intercom.customers.Application           : Starting Application on Princess with PID 8712 (D:\Test\customers-take-home-test-master\customers-take-home-test-master\target\classes started by SHILPA in D:\Test\customers-take-home-test-master\customers-take-home-test-master)
2020-02-09 17:24:59.660  INFO 8712 --- [           main] intercom.customers.Application           : No active profile set, falling back to default profiles: default
2020-02-09 17:25:00.147  INFO 8712 --- [           main] intercom.customers.Application           : Started Application in 0.801 seconds (JVM running for 1.407)
2020-02-09 17:25:00.153  INFO 8712 --- [           main] intercom.customers.utils.CustomerUtils   : Getting List of customers within 100.0km Range of (latitude: 53.339428, longitude: -6.257664)
2020-02-09 17:25:00.154  INFO 8712 --- [           main] intercom.customers.utils.CustomerUtils   : Reading Customer data from https://s3.amazonaws.com/intercom-take-home-test/customers.txt
2020-02-09 17:25:01.551  INFO 8712 --- [           main] intercom.customers.utils.CustomerUtils   : Total customers read from file 32, of which 16 are within a 100.0km Range.
2020-02-09 17:25:01.554  INFO 8712 --- [           main] intercom.customers.utils.CustomerUtils   : List of customers in range: 

user_id: 4, name: Ian Kehoe
user_id: 5, name: Nora Dempsey
user_id: 6, name: Theresa Enright
user_id: 8, name: Eoin Ahearn
user_id: 11, name: Richard Finnegan
user_id: 12, name: Christina McArdle
user_id: 13, name: Olive Ahearn
user_id: 15, name: Michael Ahearn
user_id: 17, name: Patricia Cahill
user_id: 23, name: Eoin Gallagher
user_id: 24, name: Rose Enright
user_id: 26, name: Stephen McArdle
user_id: 29, name: Oliver Ahearn
user_id: 30, name: Nick Enright
user_id: 31, name: Alan Behan
user_id: 39, name: Lisa Ahearn