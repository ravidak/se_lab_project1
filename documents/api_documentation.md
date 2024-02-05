# Registration Servlet API Documentation

The Registration Servlet handles user registration by receiving data through an HTML form and storing it in a MySQL database.

## Endpoint


## Request

- **Method:** `POST`
- **Content Type:** `application/x-www-form-urlencoded`

### Parameters

- `name` (String): User's full name.
- `username` (String): User's chosen username.
- `organisation` (String): User's organization.
- `email` (String): User's email address.
- `mobile` (String): User's mobile number.
- `password` (String): User's chosen password.
- `cnfpass` (String): Confirmation of the user's password.

## Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "You have successfully registered"

- **Error Response:**
  - **Status Code:** `500 Internal Server Error`
    - **Reason:** An error occurred during registration.

## Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `500 Internal Server Error`: An error occurred during registration.

## Database Connection

The servlet establishes a connection to a MySQL database using the following credentials:

- **Database URL:** `jdbc:mysql://localhost:3306/Loginpage`
- **Username:** `root`
- **Password:** `B210445@cs`

## Example HTML Form

```html
<form action="/Register" method="post">
  Name: <input type="text" name="name"><br>
  Username: <input type="text" name="username"><br>
  Organisation: <input type="text" name="organisation"><br>
  Email: <input type="text" name="email"><br>
  Mobile: <input type="text" name="mobile"><br>
  Password: <input type="password" name="password"><br>
  Confirm Password: <input type="password" name="cnfpass"><br>
  <input type="submit" value="Register">
</form>


## Login Servlet API Documentation

The Login Servlet handles user authentication by receiving login credentials through an HTML form.

## Endpoint


## Request

- **Method:** `POST`
- **Content Type:** `application/x-www-form-urlencoded`

### Parameters

- `username` (String): User's username.
- `password` (String): User's password.

## Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "Login successful"

- **Error Response:**
  - **Status Code:** `401 Unauthorized`
    - **Reason:** Invalid username or password.

## Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `401 Unauthorized`: Invalid username or password.

## Example HTML Form

```html
<form action="/Login" method="post">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  <input type="submit" value="Login">
</form>

# Forgot Password Servlet API Documentation

The `ForgotPasswordServlet` handles the forgot password functionality by receiving user input, simulating OTP verification, and updating the password in a simulated database. Below is the API documentation for this servlet.

## Endpoint

## Request

- **Method:** `POST`
- **Content Type:** `application/x-www-form-urlencoded`

### Parameters

1. `email_or_phone` (String): User's email or phone number.
2. `otp` (String): Entered OTP for verification.
3. `password` (String): New password for resetting.

## Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "Password reset successful"

- **Error Responses:**
  - **Status Code:** `200 OK`
    - **Body:** "Password reset failed. Please try again."
  - **Status Code:** `200 OK`
    - **Body:** "Invalid OTP. Please enter the correct OTP."

## Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `Password reset failed. Please try again.`
- `Invalid OTP. Please enter the correct OTP.`

## Simulated Logic

The provided code includes simulated methods for OTP verification and updating the password in the database. Replace these methods with your actual logic for OTP verification and database interaction.

### Simulated OTP Verification

```java
private boolean verifyOTP(String emailOrPhone, String enteredOTP) {
    // Implement your OTP verification logic here
    // Compare enteredOTP with the stored OTP in your system
    // Return true if OTP is correct, false otherwise
    return true; // For simplicity, always return true
}





# Dashboard Servlet

The `DashboardServlet` is a Java servlet that handles requests for the Speaker Dashboard. It processes GET requests, retrieves necessary data from the database, and forwards the request to the `dashboard.jsp` page for rendering the HTML content.

## Endpoint


## Functionality

- Handles requests for the Speaker Dashboard.
- Retrieves any necessary data from the database or performs other backend logic.
- Forwards the request to the `dashboard.jsp` page for rendering HTML content.

## Usage

1. Make a GET request to `/dashboard` to access the Speaker Dashboard.
2. The servlet processes the request, retrieves data, and forwards it to the `dashboard.jsp` page.

## Dependencies

- This servlet is designed to work in a Java web application environment.
- Ensure that the necessary dependencies, such as a servlet container like Apache Tomcat, are properly configured.



