# Bear Picture App

A simple Spring Boot application to fetch, save, and view random **bear** pictures via REST API and a web UI.

## Features

- Save random bear images (`POST /api/pictures/save?animal=bear&count=N`)
- Get the last saved bear image (`GET /api/pictures/last?animal=bear`)
- Simple web UI at `/` for manual use
- Uses in-memory H2 database (no setup required)
- Ready for Docker

## How to Run

### In Codespace or Locally with Java 17+ and Maven

1. **Build the project:**
   ```bash
   mvn clean package
   ```

2. **Run the application:**
   ```bash
   java -jar target/animalapp-0.0.1-SNAPSHOT.jar
   ```

3. **Access the web UI:**
   - Open [http://localhost:8080/](http://localhost:8080/) (or use the Codespace Forwarded Port link).

4. **API Examples:**

   - Save 2 bear pictures: will save the second bear picture
     ```
     POST http://localhost:8080/api/pictures/save?animal=bear&count=2
     ```

   - Get last bear picture:shall fetch the last saved bear picture as saved through the first API call
     ```
     GET http://localhost:8080/api/pictures/last?animal=bear
     ```

### Run with Docker

1. **Build the image:**
   ```bash
   docker build -t bearapp .
   ```

2. **Run the container:**
   ```bash
   docker run -p 8080:8080 bearapp
   ```

---

## H2 Database Console

- Access at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:animaldb`

---

## Testing

Run all tests:
```bash
mvn test
```
Access and test the UI: https://stunning-giggle-69p96rwgrr6wcxqgx-8080.app.github.dev/
1- Select Bear first as this is the only working API.
2- Choose the picture number to save and Click save
3- Select Bear in the Fetch API and click Fetch button.
---

## License

MIT