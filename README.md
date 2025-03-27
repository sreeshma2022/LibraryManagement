## Library Management System
### Objective
Develop an application system to enable librarians to efficiently manage books, allowing them to add, update, search, and remove books while maintaining their availability status.

## Run using deployment link
Download jar from https://github.com/sreeshma2022/LibraryManagement/releases/tag/v1.0   
java -jar LibraryManagement.1.0.jar

## Installation & Running the Project
git clone https://github.com/sreeshma2022/LibraryManagement.git   
cd LibraryManagement

## Build the Project
mvn clean package

## Run the Application
java -jar target/LibraryManagement.1.0.jar

## Sample Commands
ADD_BOOK B001 "The Alchemist" "Paulo Coelho" "Fiction" "Available"  
VIEW_BOOKS    
SEARCH_BOOK B001   
UPDATE_BOOK B001 "The Alchemist" "Paulo Coelho" "Checked_Out"    
DELETE_BOOK B001    
EXIT   







