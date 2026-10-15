# Engineering Standards Search and Versioning API

A runnable portfolio starter for searching and maintaining engineering standards. Includes a Spring Boot REST API, PostgreSQL persistence, indexed fields, OpenAPI docs, Docker Compose, and unit tests.

## Run

- Install Docker and Docker Compose.
- Copy `.env.example` to `.env`, set a unique local `POSTGRES_PASSWORD`, then run `docker compose up --build`.
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Health: `GET http://localhost:8080/api/standards/health`
- Create: `POST /api/standards` with `{"code":"ENG-001","title":"Electrical Safety","body":"Example standard text","version":"1.0"}`
- Search: `GET /api/standards/search?q=safety`

## Local tests

Install Java 17 and Maven, then run `mvn test`.

## Notes

This is a compact starter implementation, not a verified 14,000-line legacy migration. Search uses indexed code/title fields and a simple case-insensitive body match; benchmark claims, 240-test coverage, AWS deployment, SonarQube gates, and production security need to be implemented and measured before claiming them.

The `.env` file is local configuration and is ignored by Git; never commit it.
