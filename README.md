 BMI Calculator & Health Assessment System

A Java-based desktop application that calculates Body Mass Index (BMI) and provides a personalized health assessment based on user information and lifestyle-related questions. The application features an interactive GUI built with Java Swing and helps users better understand their health status.

 Features
 Calculate BMI using height and weight
 Collect user information (Age, Gender, Height, Weight)
 Supports multiple measurement units
Height: meters, centimeters, feet
Weight: kilograms, pounds
 Interactive health questionnaire
 Lifestyle assessment including:
Smoking habits
Alcohol consumption
Exercise routine
Drug usage
Existing medical conditions
 Displays BMI category and health report
 User-friendly Java Swing graphical interface
 Database connectivity for storing and retrieving health-related data
 Technologies Used
Java
Java Swing (GUI)
JDBC
MySQL Database
Object-Oriented Programming (OOP)
 Project Structure
BmiCalculator/
│
├── UserInformation/      # User input form
├── Question/             # Health questionnaire
├── SubQuestions/         # Additional health-related questions
├── BmiReportDisplay/     # BMI result and report
├── Stored/               # Stores user data
├── Projectdb/            # Database connection
└── images/               # Project screenshots

 How It Works
Enter your personal information.
Select height and weight units.
The application converts values when needed.
Complete the health questionnaire.
BMI is calculated automatically.
A health report is generated based on BMI and lifestyle responses.

 BMI Categories
BMI Range	      Category
Below 18.5	    Underweight
18.5 – 24.9	    Normal Weight
25.0 – 29.9     Overweight
30.0 and above	Obese

 Future Improvements
User login and authentication
BMI history tracking
Data visualization using charts
PDF report generation
Nutrition and fitness recommendations
Improved UI/UX design
Export reports to Excel or PDF
