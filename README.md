
Coverage: 92.1% TDL project

The TDL (To-Do-List) allows management of tasks and people to create, update, read, read single and delete. Ensuring that tasks can be tracked and assigned to someone

## Getting Started

Upon opening the TDL-WA-0.0.1-SNAPSHOT, the server will start up and which will then require you to open the following link - "http://localhost:8080/tasks" and you will then need to open the webpage via the "website" folder and open the "index.html" which will load up the webpage. THis will have linked to the tasks and people pages where it will allow to create, update, read, read single(currently disabled as it doesn't work) and delete for tasks and people.

To create a task, firstly create a person which can be done by locating to the people page and entering a name and job title, then click enter.
Then create a task by locating to the tasks page entering data with the data fields and input a valid people ID and then click create.

To read tasks or people click the read all button on the bottom of the page and it will display the results in a table if there are records present otherwise it will display an alert message saying "No records available". This method is the same for both pages

### Prerequisites
You will need MYSQL server 5.7 or greater, Java 11 or greater to run the program and Maven 3.6(this is recomended but not required - this is because you can use mvnw)

### Installing
Download the TDL-App from github and store within a seperate folder.

Open the cmd within the TDL-App folder (enter cmd in the address bar within the below path) C:\Users\Admin\Documents\IMS\IMS-Starter\target and enter "TDL-WA-0.0.1-SNAPSHOT" or type " java -jar " and press tab to find the jar file with dependencies and press enter.

Run the jar file with the method within getting started and that will open up the server linking to the API.
Open http://localhost:8080/tasks which link the server allowing you to access the API via the webpage.
Open the "Index.html" in the "Website" folder.

### Running the tests
Open a cmd within the TDL-App folder and run mvn test which will run (if you have maven installed on your machine).


### Unit Tests 
Unit Tests are conducted for the each entity model, service, controllers, DTO, mapper java files.

### Integration Tests 
Integration tests are conducted for the entity service and controller java files.

These test the functionality of the TDL-App as they handle the background work of the programme to ensure that it works as intended.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

Versioning
We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Alex Nung** - [alexnung](https://github.com/alexnung)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments
Team 1 - for the moral support/help
Morgan Walsh - for teaching and help
Edward Reynolds - for teaching and help
Ifan Clarke & Hassan Abbas - for the moral support/help
