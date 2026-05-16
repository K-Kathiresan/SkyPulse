SkyCast — Weather Application

SkyCast is a modern full-stack weather application built using Java Spring Boot for the backend and HTML, CSS, and JavaScript for the frontend.

The application allows users to search for any city and instantly view real-time weather information with a modern glassmorphism UI and dynamic weather visuals.

Features
Real-time weather data
Search weather by city name
Modern glassmorphism UI
Dynamic weather icons
Dynamic weather backgrounds
Responsive design
REST API integration
Custom exception handling
DTO-based backend response handling
Smooth frontend animations
Loading state handling
Tech Stack
Backend
Java
Spring Boot
Maven
REST API
Frontend
HTML5
CSS3
JavaScript
Project Structure
weatherapp/
│
├── src/
│   ├── main/
│   │   ├── java/com/project/weatherapp/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   └── WeatherappApplication.java
│   │   │
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── index.html
│   │   │   │   ├── style.css
│   │   │   │   └── script.js
│   │   │   └── application.properties
│
├── pom.xml
└── README.md
API Used

This project uses the WeatherAPI service for real-time weather data.

Weather API Provider: https://www.weatherapi.com/
Weather Data Included

The application currently displays:

City Name
Temperature
Weather Condition
Humidity
Weather Icon
UI Enhancements

SkyCast includes:

Glassmorphism design
Animated weather cards
Dynamic weather backgrounds
Weather condition icons
Hover animations
Responsive layout
Backend Concepts Implemented
REST API Consumption
DTO Mapping
Service Layer Architecture
Exception Handling
Spring Boot Annotations
JSON Mapping
Validation Handling
Frontend Concepts Implemented
DOM Manipulation
Fetch API
Async/Await
Dynamic Rendering
Conditional UI Updates
CSS Animations
Responsive Design
Setup Instructions
1. Clone the Repository
git clone https://github.com/YOUR_USERNAME/SkyCast.git
2. Open the Project

Open the project in:

Visual Studio Code
IntelliJ IDEA
3. Configure API Key

Open:

src/main/resources/application.properties

Add your WeatherAPI key:

weather.api.key=YOUR_API_KEY
weather.api.url=https://api.weatherapi.com/v1/current.json

Get your free API key from:

https://www.weatherapi.com/

4. Run the Application

Run:

mvn spring-boot:run
5. Open in Browser

Visit:

http://localhost:8080
Future Improvements

Planned improvements:

3-day weather forecast
Hourly forecast
Search history
Geolocation support
Dark/light theme toggle
Better mobile optimization
Animated weather effects
Deployment to cloud platforms
Learning Goals of This Project

This project was built to practice:

Full-stack development
Spring Boot fundamentals
API integration
Frontend UI development
Clean project structure
Real-world application workflow
Author

Kathiresan K

License

This project is open-source and available for learning and educational purposes.