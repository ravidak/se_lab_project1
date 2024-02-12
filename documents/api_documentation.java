

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



## User Login

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

