# demo

Contains a server and a UI componenent.

cleanserver - A java Spring Boot application server that listens on localhost:8080.  To install dependencies and run execute the following commands from directory cleanserver.

1. mvn clean install
2. mvn spring-boot:run


cleanUI - An Angular client application that listens on localhost:4200.  To install dependencies and run execute the following commands from directory cleanUI.

1. npm install
2. ng serve


Then open localhost:4200 in a browser.

Click "Clean File" button with the default filename of ../data/normal.csv to clean the normal.csv file located in the data directory.
Change filename to ../data/advanced.csv and click "Clean File" button to clean the advaced.csv file.
