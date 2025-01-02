# Servlet and JSP Integration Project

## Project Overview
This project demonstrates a basic integration of Servlets, JSP, and a simple MVC architecture. It includes user registration and profile display functionality, implemented using Servlets for business logic and JSP for rendering views.

---

## File Structure
│   ├── java
│   │   └── com
│   │       ├── exa
│   │       │   └── service
│   │       │       ├── UserProfileServlet.java
│   │       │       └── UserServiceTest.java
│   │       └── example
│   │           └── dao
│   │               └── UserDaoTest.java
├── target
│   ├── classes
│   ├── test-classes
pom.xml
profile.jsp
userForm.jsp
userList.jsp



---

## How the Project Works

1. **User Registration**:  
   - The `userForm.jsp` collects user details and sends the data to `UserServlet.java` via an HTTP POST request.  

2. **Profile Display**:  
   - `UserServlet.java` processes the form data and forwards it to `profile.jsp` for display using `RequestDispatcher`.

3. **User List**:  
   - `userList.jsp` demonstrates how to use JSTL and EL for dynamically rendering a list of users.

4. **Testing**:  
   - Unit tests for service and DAO layers are included in `UserServiceTest.java` and `UserDaoTest.java` respectively.

---

## Dependencies

- **Jakarta Servlet API**: Used to implement servlets.  
- **JSP**: Used for rendering dynamic content.  
- **JUnit 5**: For unit testing.  
- **Mockito**: For mocking dependencies in unit tests.  
- **H2 Database**: An in-memory database used for DAO testing.

---

## Key Files

### 1. `UserServlet.java`
Handles user registration and forwards data to the profile page.

### 2. `ProfileServlet.java`
Displays user profile information.

### 3. `userForm.jsp`
A form for user input.

### 4. `profile.jsp`
Displays the submitted user data.

### 5. `userList.jsp`
Demonstrates dynamic content rendering using JSTL and EL.

### 6. `UserServiceTest.java`
Tests the `UserService` layer using mocked DAO dependencies.

### 7. `UserDaoTest.java`
Tests the `UserDao` layer with an H2 in-memory database.

---

## Notes
- The `Servlet` files and `DAO` layer are fully functional and tested.
- Ensure a servlet container (e.g., Apache Tomcat) is set up for running the project.
- Update the `pom.xml` with all necessary dependencies for a smooth build and execution process.
