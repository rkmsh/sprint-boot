# Jasper Reports with Spring Boot

This repository demonstrates how to integrate **Jasper Reports** with a **Spring Boot** application.

## Features

- Generate dynamic PDF reports using JasperReports.
- Integration with Spring Boot for seamless report generation.
- Example templates for quick setup.

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Spring Boot 2.5+ (or compatible version)

## Getting Started

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/jasper-reports.git
    cd jasper-reports
    ```

2. **Build the project**:
    ```bash
    mvn clean install
    ```

3. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

## Using Docker
    ```bash
    # Build Docker image
    docker build -t my-spring-boot-app .

    # Run the container
    docker run -p 8080:8080 my-spring-boot-app
    ```

## Usage

- Place your `.jrxml` or `.jasper` templates in the `src/main/resources/reports` directory.
- Use the provided REST endpoints to generate reports dynamically.

## Example Endpoints

- **Generate PDF Report**:
  ```bash
  curl --location 'localhost:8080/reports/generate' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "data": [
            {
                "name": "Alice",
                "email": "alice@example.com",
                "age": 30
            },
            {
                "name": "Bob",
                "email": "bob@example.com",
                "age": 25
            }
        ]
    }'
  ```

## Folder Structure

```
src/
├── main/
│   ├── java/           # Application source code
│   ├── resources/
│       ├── reports/    # Jasper report templates
│       ├── application.yml
├── test/               # Unit and integration tests
```

## Dependencies

- Spring Boot
- JasperReports
- Spring Web
- Spring Data JPA (if applicable)

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

- [JasperReports Documentation](https://community.jaspersoft.com/documentation)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- Inspiration from the open-source community.
