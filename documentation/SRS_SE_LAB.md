# se_lab_project1
# NITCONF Website Documentation

## 1. Introduction
### 1.1 Purpose 
The purpose of this document is to specify the requirements for the NITCONF Conference Website, specifically focusing on the functionality related to speaker login and submit abstracts.

### 1.2 Intended Audience and Reading Suggestions
This document is intended for speakers and the administrators responsible for managing the CFP (Call for papers) process and also to provide the developers with clear guidelines for the application.

### 1.3 Product Scope
This section outlines the features related to the CFP (Call for papers) process, where users can login and submit abstracts for review.


## Overall Description
### 2.1 Product Perspective
The NITCONF website is an integral part of the NITCONF conference management system. It serves as a platform for authors to submit papers for evaluation. The product is a self-contained system designed specifically for handling the submission and review process of conference papers. It does not replace any existing systems but rather enhances the efficiency of the conference management process.

The major components of the overall system include the Author Module (Module 1), Reviewer Module (Module 2), Program Committee Module (Module 3), and the Notification System. The interaction between these modules will be facilitated through well-defined interfaces.



### 2.2 Product Functions
* User registration and login functionality for authors.
* Submission of abstracts (papers in PDF format) by registered authors.
* Deadline enforcement to restrict abstract submission after the specified date.
### 2.3 User Classes and Characteristics
1. Authors: Users who submit papers for evaluation.
    * Characteristics:
    Authors may vary in technical expertise.
    All authors must register and log in to the system.
    The primary interaction for authors involves submitting abstracts.
### 2.4 Operating Environment
The software will operate in a web-based environment.

* Hardware Platform:
The system should be compatible with standard web browsers on various devices.
* Operating System:
Compatible with major operating systems like Windows, macOS, Android, iOS and Linux.
* Software Components:
The system should coexist peacefully with common web technologies (e.g., Apache Tomcat).
### 2.5 Design and Implementation Constraints
* Development must adhere to the Spring Boot framework using Java.
* The system must comply with corporate policies regarding data security and privacy.
* Utilization of specific technologies, such as Spring Security for authentication.
### 2.6 User Documentation
User documentation components will include:

* User manuals for authors.
* On-line help resources.
* Tutorials guiding authors through the submission process.
### 2.7 Assumptions and Dependencies
1. Assumptions:
    * Authors have access to a device with internet connectivity for submission.
    * Users will follow the registration and submission guidelines provided.
2. Dependencies:
    * Dependency on external libraries and frameworks compatible with Spring Boot.
    * Integration with a notification system for sending alerts to authors.
## External Interface Requirements
### 3.1 User Interfaces
1. Logical Characteristics:
The user interface for the NITCONF website's Author Module will be a web-based application accessible through standard web browsers. Key elements of the user interface include:
    * User Registration and Login Screens: Simple forms for user registration and login.
    * Dashboard: A personalized dashboard displaying submission status, deadlines, and other relevant information.
    * Abstract Submission Form: An intuitive form for authors to submit papers in PDF format.
    * Deadline Notification: Clear notification regarding the submission deadline.
2. GUI Standards and Constraints:
    * The user interface will follow standard web design principles.
    * GUI will be responsive, adapting to different screen sizes.
    * Submission forms will enforce PDF format for paper submissions.
### 3.2 Hardware Interfaces
The NITCONF website will interact with standard hardware components, ensuring compatibility with various devices. Key hardware interfaces include:
* Supported Devices: The system should be compatible with desktops, laptops, tablets, and smartphones.
* Internet Connectivity: Authors require internet access for registration and paper submission.

### 3.3 Software Interfaces
Connections with Other Software Components:
The NITCONF website will interface with specific software components, ensuring seamless integration and data exchange.
* Database: Interaction with a relational database system for storing user data and submitted papers.
* Spring Boot Framework: Utilization of the Spring Boot framework for Java-based application development.
* Spring Security: Integration for secure user authentication and authorization.
* User Registration Data: Transfer of user registration information to the database.
* Submitted Papers: Storage of papers in PDF format in the database.
Communication Nature:
* REST APIs: Communication between frontend and backend components through RESTful APIs.
* Data Encryption: Use of HTTPS for secure data transfer.
### 3.4 Communications Interfaces
#### Communication Functions:
The NITCONF website requires specific communication functions to facilitate its operation.

* Email Notifications: Sending notifications, including registration confirmation and deadline reminders via email.
* Web Browser Communications: Interaction with web browsers for user access and data submission.
#### Communication Standards:
* SMTP Protocol: For sending email notifications.
* HTTP/HTTPS Protocols: For web browser communications.
* Data Transfer Rates: Standard internet data transfer rates.
#### Security and Encryption:
* HTTPS: Ensuring secure communication with encryption.
* Data Synchronization: Real-time synchronization for timely notifications.
## Functional Requirements
The following features are made available to the users (authors).

### 4.1 Authentication
* The user has the ability to create an account, and login with their credentials.
* The user can request for a password reset, via the `forgot password` option, if required.

### 4.2 Dashboard
The following features are available as part of the main dashboard presented to the user.

#### 4.2.1 User Profile
* The user can view / update their details in the profile section

#### 4.2.2 Upload And View Submissions
* The user is provided with the current status of their latest submission, if any.
* The user is then able to re-submit their abstract, with the changes suggested by reviewers.

#### 4.2.3 Interaction With Reviewers
* The user is given a list of comments provided by the reviewer assigned.
* The user is also provided with contact information of the reviewer
* The comments are listed along with the version of the submission, the comment was targeted to.


![se_lab_srs_requirements drawio](https://github.com/ravidak/se_lab_project1/assets/101610787/e41bff39-d979-42b0-880a-91cca66bfb75)

## Other Nonfunctional Requirements
### 5.1 Performance Requirements
To ensure optimal system performance, the NITCONF Conference Website must meet the following requirements:
* 1.Response time
* 2.Concurrent user handling
* 3.Scalability
* 4.Database performance
* 5.Network Latency
* 6.Reliability and uptime
* 7.Security of data

### 5.2 Safety and Security Requirements
The system ensures data security through a dedicated database. Regular users can view information but lack the authorization to make any changes. 

In terms of security, the system is meticulously designed to shield users from any potential harm. It employs strict access controls and user permissions, guaranteeing the safety and integrity of data. Users can interact with the system with confidence, as it effectively safeguards their information against any threats or unauthorized access.

### 5.3 Software Quality Attributes
#### 5.3.1 Reliability
* The system will not lag and will provide instant and accurate results to all the users.

#### 5.3.2 Adaptability
* The system is open source. The system can be extended to other organizations as well.

#### 5.3.3 Maintainability
* In case of errors, it can be rectified by any developer due to the ease of maintenance.

#### 5.3.4 Portability
* The system can be accessed on any smartphone or laptop.

#### 5.3.5 Cost-effectiveness
