# 🎬 Movie Ticket Booking System

<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![REST API](https://img.shields.io/badge/REST%20API-02569B?style=for-the-badge&logo=rest&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)

</div>

A comprehensive **Spring Boot REST API** application for movie ticket booking, inspired by platforms like BookMyShow. This system provides a complete backend solution for managing movies, theaters, shows, and ticket bookings with enterprise-grade features.

## 🚀 Project Overview

This portfolio project demonstrates full-stack backend development skills using modern Java technologies. The system handles the complete movie ticket booking lifecycle, from theater and movie management to seat selection and booking confirmation.

### Key Achievements
- **30+ REST API endpoints** with comprehensive CRUD operations
- **Multi-entity relational database** with complex relationships
- **Real-time seat availability** management
- **Dynamic pricing** support for different seat types
- **Sales analytics** and reporting features
- **Robust error handling** and validation

## ✨ Features

### 🎭 Core Functionality
- **User Management**: Registration, profile management, and booking history
- **Movie Catalog**: Add, update, and manage movie information with genres and ratings
- **Theater Management**: Multi-location theater support with customizable seating
- **Show Scheduling**: Flexible show timing with 2D/3D support
- **Ticket Booking**: Real-time seat selection and booking confirmation
- **Cancellation System**: Automated refund processing and seat availability updates

### 📊 Advanced Features
- **Location-based Search**: Find movies and theaters by location
- **Dynamic Pricing**: Different pricing for normal and premium seats
- **Sales Analytics**: Revenue tracking for shows and movies
- **Seat Management**: Real-time seat availability tracking
- **Multi-language Support**: Movies in multiple languages
- **Show Analytics**: Popular movies and theater utilization metrics

## 🛠️ Technology Stack

### Backend Framework
- **Java 19** - Modern language features and performance
- **Spring Boot 3.0.2** - Enterprise-grade framework
- **Spring Data JPA** - Data persistence layer
- **Hibernate** - ORM for database operations

### Database
- **MySQL** - Relational database with complex relationships
- **JPA/Hibernate** - Object-relational mapping

### Development Tools
- **Maven** - Dependency management and build automation
- **Lombok** - Code generation for cleaner models
- **Spring Boot DevTools** - Development productivity

### API Design
- **RESTful Architecture** - Clean, resource-based URLs
- **JSON** - Lightweight data exchange format
- **DTO Pattern** - Separation of concerns between layers

## 🏗️ System Architecture

### Database Schema
The system uses a well-normalized database design with the following entities:

![Database Schema](https://i.imgur.com/7zTqGzS.png)

### Key Relationships
- **User** → **Ticket** (One-to-Many): Users can book multiple tickets
- **Show** → **Ticket** (One-to-Many): Shows can have multiple bookings
- **Movie** → **Show** (One-to-Many): Movies can have multiple shows
- **Theater** → **Show** (One-to-Many): Theaters can host multiple shows
- **Show** → **ShowSeat** (One-to-Many): Dynamic seat pricing per show

## 📚 API Documentation

📖 **Complete API Documentation Available**: 
- **OpenAPI 3.0 Specification**: [`docs/openapi.yaml`](docs/openapi.yaml)
- **JSON Format**: [`docs/openapi.json`](docs/openapi.json)

The API documentation includes:
- **30+ REST endpoints** organized by functionality (Users, Movies, Theaters, Shows, Tickets)
- **Detailed request/response schemas** with examples
- **Parameter specifications** and validation rules
- **Error handling** documentation
- **Authentication schemas** (for future implementation)

**Quick API Overview**:
- **Users**: Registration, profile management, booking history
- **Movies**: Catalog management, theater listings, sales analytics
- **Theaters**: Location-based search, seat management
- **Shows**: Scheduling, availability, revenue tracking
- **Tickets**: Booking, cancellation, detailed receipts

## 🚀 Getting Started

### Prerequisites
- Java 19 or higher
- Maven 3.6+
- MySQL 8.0+
- IDE (IntelliJ IDEA recommended)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/Movie_Ticket_Booking_System.git
   cd Movie_Ticket_Booking_System
   ```

2. **Configure Database**
   - Create MySQL database: `mtbs`
   - Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mtbs?createTableIfNotExists=true
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and Run**
   ```bash
   # Using Maven
   mvn clean install
   mvn spring-boot:run
   
   # Or using Maven wrapper
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. **Verify Installation**
   - Application runs on `http://localhost:9996`
   - Database tables are auto-created
   - Test with: `GET http://localhost:9996/users/getAll`

## 📁 Project Structure

```
Movie_Ticket_Booking_System/
├── docs/                   # API Documentation
│   ├── openapi.yaml       # OpenAPI 3.0 specification
│   └── openapi.json       # JSON format documentation
├── src/
│   ├── main/java/com/example/Movie_Ticket_Booking_System/
│   │   ├── Controller/          # REST API endpoints
│   │   ├── Service/            # Business logic layer
│   │   ├── Repository/         # Data access layer
│   │   ├── Models/             # JPA entities
│   │   ├── DTOs/               # Data transfer objects
│   │   │   ├── EntryDTOs/      # Request DTOs
│   │   │   └── ResponseDTOs/   # Response DTOs
│   │   ├── Converters/         # Entity-DTO converters
│   │   └── Enums/              # Application constants
│   └── resources/
│       └── application.properties
├── pom.xml                 # Maven configuration
└── README.md              # Project documentation
```

## 🎯 Key Technical Highlights

### Data Modeling
- **Normalized Database Design** with proper relationships
- **Entity-DTO Pattern** for clean API design
- **Enum-based Validation** for data consistency

### Business Logic
- **Seat Availability Management** with real-time updates
- **Dynamic Pricing Algorithm** for different seat types
- **Automated Booking Validation** with conflict resolution
- **Sales Analytics** with aggregated reporting

### API Design
- **RESTful Principles** with proper HTTP methods
- **Consistent Error Handling** across all endpoints
- **Standardized Response Format** for better client integration

## 📈 Future Enhancements

### Planned Features
- [ ] **Authentication & Authorization** (JWT implementation)
- [ ] **Payment Gateway Integration** (Stripe/PayPal)
- [ ] **Email Notifications** for booking confirmations
- [ ] **Movie Recommendations** based on user history
- [ ] **Loyalty Program** with points system
- [ ] **Admin Dashboard** for system management
- [ ] **Mobile API** optimization
- [ ] **Caching Layer** (Redis) for performance
- [ ] **Docker Containerization**
- [x] **API Documentation** (OpenAPI/Swagger) ✅

### Technical Improvements
- [ ] **Unit & Integration Tests** (JUnit 5)
- [ ] **Performance Monitoring** (Micrometer)
- [ ] **Security Enhancements** (Spring Security)
- [ ] **API Rate Limiting**
- [ ] **Database Optimization** (Query optimization)

## 🤝 Contributing

This is a portfolio project, but suggestions and feedback are welcome! Feel free to:
- Report bugs or issues
- Suggest new features
- Provide code reviews
- Share improvement ideas

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 📧 Contact

**Github** - [Rhythin](https://github.com/Rhythin)

**Portfolio**: [your-portfolio-website.com](https://your-portfolio-website.com)

**LinkedIn**: [Rhythin](https://www.linkedin.com/in/rhythin/)

---

⭐ **Star this repository** if you found it helpful or interesting!

---

*Built with ❤️ using Spring Boot and modern Java technologies*