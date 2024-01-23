# se_lab_project1
# NITCONF Website Documentation

## 1. Introduction

### 1.1 Purpose

The NITCONF website serves the purpose of streamlining the paper submission and review process for the conference. Its key objectives include facilitating the submission of papers, efficient evaluation by a team of reviewers, and final decision-making by the Program Committee.

### 1.2 Scope

The website focuses on managing the submission and evaluation of papers related to the NITCONF conference. It provides an intuitive interface for speakers, reviewers, and the Program Committee to seamlessly interact with the system.

## 2. System Architecture

### 2.1 Overview

The system is designed as a robust web-based application with a front-end for user interaction, a back-end for data storage and processing, and a secure authentication system to manage user access.

### 2.2 User Roles

- **Speaker:** Individuals interested in presenting a paper at the conference.
- **Reviewer:** Members of the review team responsible for evaluating submitted papers.
- **Program Committee:** A group of individuals making the final decision on accepted papers.

## 3. Functional Requirements

### 3.1 Call for Papers (CFP)

#### 3.1.1 CFP Button

A prominent "Call for Papers" (CFP) button on the homepage redirects users to a secure login page.

### 3.2 User Authentication

#### 3.2.1 Secure Authentication

Users must securely authenticate themselves to access the submission system.

#### 3.2.2 User Registration

Any user can create an account to become a speaker.

### 3.3 Speaker Submission

#### 3.3.1 Submission Form

Authenticated speakers can submit abstracts through a well-designed form.

#### 3.3.2 Form Fields

The submission form includes fields for title, abstract, author information, and keywords.

#### 3.3.3 Supporting Documents

Speakers can upload supporting documents, such as research papers or presentations.

### 3.4 Review Process

#### 3.4.1 Assignment to Reviewers

An automated system assigns submitted papers to a team of qualified reviewers.

#### 3.4.2 Evaluation Criteria

Reviewers evaluate papers based on predefined, transparent criteria.

#### 3.4.3 Comments and Recommendations

Reviewers provide detailed comments and recommendations for each paper.

#### 3.4.4 Acceptance/Rejection

Reviewers recommend acceptance or rejection of papers based on their assessments.

### 3.5 Program Committee Decision

#### 3.5.1 Access to Reviewed Papers

The Program Committee has privileged access to reviewed papers.

#### 3.5.2 Final Decision

The Committee makes well-informed final decisions based on reviewer recommendations.

#### 3.5.3 Notifications

Automated notifications are sent to speakers regarding the acceptance or rejection of their papers.

## 4. Non-functional Requirements

### 4.1 Security

#### 4.1.1 Secure Authentication

User authentication is implemented securely to protect user data.

#### 4.1.2 Role-Based Access Control

Role-based access control ensures data privacy and integrity.

### 4.2 Performance

#### 4.2.1 Simultaneous Handling

The system efficiently handles simultaneous submissions and reviews.

#### 4.2.2 Response Times

User interactions exhibit minimal response times for enhanced usability.

## 5. Diagrams

### 5.1 Use Case Diagram

Use Case Diagram for Authors (Speakers)

Actors:
  - Guest (Doesn't login)
  - Speaker

Use Cases:
  1. Login
  2. Submit Abstract
  3. Upload Documents (pdf file)
  4. View Submission Status
  5. Receive Notification

Associations:
  - Guest -> Login
  - Speaker -> Submit Abstract
  - Speaker -> Upload Supporting Documents
  - Speaker -> View Submission Status
  - Speaker -> Receive Notification

   
![image](https://github.com/SauravB210489CS/selab23_basics/assets/155982778/1c2726fc-f33d-4bf8-b674-7852f1463f54)

## 6. Conclusion

The NITCONF website, through its comprehensive set of features and robust design, aims to provide a seamless and user-friendly experience for speakers, reviewers, and the Program Committee involved in the conference paper submission and review process.


