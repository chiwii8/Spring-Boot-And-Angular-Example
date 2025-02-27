# Angular - Spring Boot Example
---
**Note**: This project focuses in create a example of spring security with a simple login and does not include a focus on the UI.

## Getting Started
---
### Prerequisites
- Java 17
- Maven
- Angular
- Docker

**1. Clone the repository:**
```
git clone https://github.com/chiwii8/Spring-Boot-And-Angular-Example.git
```

#### Spring Boot Backend
1. Navigate to the `backend` directory:
   
   ```
   cd backend
   ```
2. Build and start the backend app:
   ```
   mvn clean install
   mvn spring-boot:run
   ```

#### Angular Frontend
1. Navigate to the `frontend` directory:
   
   ```
   cd frontend
   ```
2. Install dependencies
   ```
   npm install
   ```
3. Start the angular app
   ```
   ng serve
   ```


#### Using Docker 

1. Build and start the Docker containers
   
    ```
    docker-compose up -d --build
    ```
    ##### Proyect Directory
    ```
    /project-root
    │── backend/
    │   ├── Dockerfile
    |   ...
    │   ├── pom.xml
    │── frontend/
    |   ...
    │   ├── Dockerfile
    │── docker-compose.yml
    ```

#### Ports of the App
This will started the backend and frontend on the followings ports:

- **Backend:** `http://localhost:8080`
- **FrontEnd:** `http://localhost:4200`





