

##  API Documentation

# User Registration

## Registration API Documentation

### Endpoint

- **Method:** `POST`
- **Content Type:** `application/x-www-form-urlencoded`

### Parameters

1. `name` (String): User's full name.
2. `username` (String): User's chosen username.
3. `organisation` (String): User's organization.
4. `email` (String): User's email address.
5. `mobile` (String): User's mobile number.
6. `password` (String): User's chosen password.
7. `cnfpass` (String): Confirmation of the user's password.

### Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "You have successfully registered"

- **Error Response:**
  - **Status Code:** `500 Internal Server Error`
    - **Reason:** An error occurred during registration.

### Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `500 Internal Server Error`: An error occurred during registration.

### Database Connection

The servlet establishes a connection to a MySQL database using the following credentials:

- **Database URL:** `jdbc:mysql://localhost:3306/Loginpage`
- **Username:** `root`
- **Password:** `B210445@cs`

### Example HTML Form

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

# User Login

## Login API Documentation

### Endpoint

- **Method:** `POST`
- **Content Type:** `text/html`

### Parameters

- `username` (String): User's username.
- `password` (String): User's password.

### Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "Login successful"

- **Error Response:**
  - **Status Code:** `401 Unauthorized`
    - **Reason:** Invalid username or password.

### Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `401 Unauthorized`: Invalid username or password.

### Example HTML Form

```html
<form action="/Login" method="post">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  <input type="submit" value="Login">
</form>

# Forgot Password

## Forgot Password API Documentation

### Endpoint

- **Method:** `POST`
- **Content Type:** `application/x-www-form-urlencoded`

### Parameters

1. `email_or_phone` (String): User's email or phone number.
2. `otp` (String): Entered OTP for verification.
3. `password` (String): New password for resetting.

### Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "Password reset successful"

- **Error Responses:**
  - **Status Code:** `200 OK`
    - **Body:** "Password reset failed. Please try again."
  - **Status Code:** `200 OK`
    - **Body:** "Invalid OTP. Please enter the correct OTP."

### Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `Password reset failed. Please try again.`
- `Invalid OTP. Please enter the correct OTP.`


### Simulated OTP Verification

```java
private boolean verifyOTP(String emailOrPhone, String enteredOTP) {
    // Implement your OTP verification logic here
    // Compare enteredOTP with the stored OTP in your system
    // Return true if OTP is correct, false otherwise
    return true; // For simplicity, always return true
}

# Dashboard

## Dashboard API Documentation

### Endpoint

### Functionality

- Handles requests for the User Dashboard.
- Retrieves any necessary data from the database or performs other backend logic.
- Forwards the request to the dashboard page for rendering HTML content.

### Usage

1. Make a GET request to `/dashboard` to access the User Dashboard.
2. The servlet processes the request, retrieves data, and forwards it to the dashboard page.

### Dependencies

- This servlet is designed to work in a Java web application environment.


# Research Paper Submission

## Research Paper Submission API Documentation

### Endpoint

- **Method:** `POST`
- **Content Type:** `multipart/form-data`

### Parameters

1. `title` (String): Title of the research paper.
2. `field` (String): Field of the research paper.
3. `country` (String): Country code.
4. `file` (File): Research paper file (PDF, DOC, DOCX).
5. `abstract` (String): Abstract of the research paper.
6. `keywords` (String): Keywords associated with the research paper.
7. `author1_name` (String): Name of the first author.
8. `author1_designation` (String): Designation of the first author.
9. `author1_contact` (String): Contact number of the first author.
10. `author1_email` (String): Email of the first author.
11. `address_line1` (String): Address line 1 for communication.
12. `address_line2` (String): Address line 2 for communication.
13. `city_district` (String): City/District for communication.
14. `state` (String): State for communication.
15. `country_communication` (String): Country for communication.
16. `postal_code` (String): Postal code for communication.

### Responses

- **Successful Response:**
  - **Status Code:** `200 OK`
  - **Body:** "Research paper submitted successfully"

- **Error Response:**
  - **Status Code:** `500 Internal Server Error`
    - **Reason:** An error occurred during submission.

### Error Handling

In case of errors, the API returns an HTTP status code along with a message indicating the nature of the error.

- `500 Internal Server Error`: An error occurred during submission.

### Example HTML Form

```html
<form action="/submit" method="post" enctype="multipart/form-data">
  Title: <input type="text" name="title"><br>
  Field: <input type="text" name="field"><br>
  Country Code: <input type="text" name="country"><br>
  Upload Paper (PDF, DOC, DOCX only): <input type="file" name="file[]" accept=".pdf, .doc, .docx" multiple><br>
  Abstract: <textarea name="abstract" rows="4"></textarea><br>
  Keywords: <input type="text" name="keywords"><br>
  Author 1 Name: <input type="text" name="author1_name"><br>
  Author 1 Designation: <input type="text" name="author1_designation"><br>
  Author 1 Contact Number: <input type="tel" name="author1_contact"><br>
  Author 1 Email: <input type="email" name="author1_email"><br>
  Address Line 1: <input type="text" name="address_line1"><br>
  Address Line 2: <input type="text" name="address_line2"><br>
  City/District: <input type="text" name="city_district"><br>
  State: <input type="text" name="state"><br>
  Country: <input type="text" name="country_communication"><br>
  Postal Code: <input type="text" name="postal_code"><br>
  <input type="submit" value="Submit">
</form>

# View Submitted Papers

## View Submitted Papers API Documentation

### Endpoint

### Functionality

- Retrieves and displays the list of submitted research papers.
- Allows assigning reviewers to specific papers.

### Usage

1. Make a GET request to `/view-papers` to access the list of submitted papers.
2. Reviewers can use the "Assign Reviewer" button to assign themselves to specific papers.

### Dependencies

- This functionality assumes a backend implementation that provides the list of submitted papers.

### Example HTML Table

```html
<table>
  <thead>
    <tr>
      <th>Paper Name</th>
      <th>Status</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
    <!-- Sample data or dynamically populated data goes here -->
    <tr>
      <td>Paper 1</td>
      <td>Submitted</td>
      <td><button class="assign-button" onclick="assignReviewer('Paper 1')">Assign Reviewer</button></td>
    </tr>
    <!-- Repeat as needed -->
  </tbody>
</table>

