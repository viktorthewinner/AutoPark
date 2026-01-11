# AutoPark – Java Backend Project

One of my passions is represented by cars, that’s why for this project I chose a car related bussiness. The project is an application for a basic car selling bussiness. Every company needs a site to display information about its trustiness and its products. A company who wants to grow needs to have a site synced with its real time stock. For the backend of the website I used Java as the programming language.

### Database and Tools
As the main priority is to learn how to use Java as a backend language, I made a very simple database with only 3 tables (**Client**, **Car** and **User**). There is only one table relation between Client and Car (one to many).
* **Server:** SQL Server Management Studio
* **Frameworks:** Spring and Thymeleaf

### Backend Structure
My main database is on a server and I want to show it on a website, I need to get the data from the SQL server into local memory (to load it into cache). To store local variables, I need to use classes, a class per table. Spring has another 2 very important folders:
1. **Repository:** to access the database.
2. **Controller:** to access the user interface.

### Functionality (`MasinaController.java`)
In script `MasinaController.java` I use multiple adnotations (like small functions) to show and execute on different URLs functions which can add, remove or display elements from the list array. The most important one is `showCars`, displaying the car stock.

### Users and Administration
Users are very important; they are the leads basically. That’s why sometimes it is important to have them as subscribers to a blog or for offerts. Also some users are the admins and they are the one who keep the site updated with the latest version. I created a system for the administrators to:
* Add or remove cars.
* Change the status of ownership (by choosing the new owner from an existing customer or by adding).

These functions are in `MasinaController.java` (`addClientAndSell`, `addMasina` and `deleteMasina`).

### Future Improvements
As HTML and CSS were not my priority, the valuable part of code was represented by displaying the sorted cars by one or another field. If I needed to choose what to add for this project, I would choose:
* **Filtering system:** a SQL query containing the chose ticks and range by price or kilometers.
* **Role Management:** a more complex system for all administrative accounts by role.
* **Financial Record:** a new table and dedicated page for transactions.
* **Trade-in System:** a system for clients to sell or trade their cars.
* **Mail Service:** a working mail service on the Contacts page.