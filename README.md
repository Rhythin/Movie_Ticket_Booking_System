# 🎬 Movie Ticket Booking System

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

### 👥 User Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users/addUser` | Register new user |
| GET | `/users/getById?id={id}` | Get user details |
| GET | `/users/getAll` | List all users |
| PUT | `/users/update?id={id}` | Update user information |
| DELETE | `/users/deleteById?id={id}` | Delete user account |
| GET | `/users/getTicketsById?id={id}` | Get user's booking history |

### 🎬 Movie Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/movie/addMovie` | Add new movie |
| GET | `/movie/getById?id={id}` | Get movie details |
| GET | `/movie/getAll` | List all movies |
| GET | `/movie/movie_with_max_shows` | Get most popular movie |
| GET | `/movie/theaters_for_movie/{id}` | Get theaters showing movie |
| GET | `/movie/salesForMovieById?id={id}` | Get movie revenue |

### 🏛️ Theater Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/theater/add_theater` | Add new theater |
| GET | `/theater/getById?id={id}` | Get theater details |
| GET | `/theater/getAll` | List all theaters |
| GET | `/theater/get_unique_locations` | Get available locations |
| GET | `/theater/getTheatersInLocation?location={location}` | Get theaters by location |
| GET | `/theater/getMoviesAvailableInLocation?location={location}` | Get movies by location |

### 🎭 Show Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/shows/add_show` | Create new show |
| GET | `/shows/getById?id={id}` | Get show details |
| GET | `/shows/getAll` | List all shows |
| GET | `/shows/get_show_time?movieId={id}&theaterId={id}` | Get show timings |
| GET | `/shows/getAvailableSeats?id={id}` | Get available seats |
| GET | `/shows/getSalesForShow?id={id}` | Get show revenue |
| GET | `/shows/getShowsForMovieAndLocation?id={id}&location={location}` | Find shows by movie and location |
| GET | `/shows/getShowsForDate?date={date}` | Get shows by date |

### 🎫 Ticket Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/ticket/book` | Book movie tickets |
| PUT | `/ticket/cancel?ticketId={id}` | Cancel booking |
| GET | `/ticket/getById?id={id}` | Get ticket details |
| GET | `/ticket/getAll` | List all tickets |

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
src/
├── main/java/com/example/Movie_Ticket_Booking_System/
│   ├── Controller/          # REST API endpoints
│   ├── Service/            # Business logic layer
│   ├── Repository/         # Data access layer
│   ├── Models/             # JPA entities
│   ├── DTOs/               # Data transfer objects
│   │   ├── EntryDTOs/      # Request DTOs
│   │   └── ResponseDTOs/   # Response DTOs
│   ├── Converters/         # Entity-DTO converters
│   └── Enums/              # Application constants
└── resources/
    └── application.properties
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
- [ ] **API Documentation** (Swagger/OpenAPI)
- [ ] **Docker Containerization**

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