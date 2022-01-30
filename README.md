# Movie App

This app follows different principles and architecture patterns that aim to achieve a well written application to be
maintainable, scalable and resilient. 

## Commit Format

For this project we are going to follow this format

> Add flows for show time and get movies
>  - First flow is about saving show times for specific movie. This
    includes error if show time is already saved for specific movie.
>  
>  - Second flow is for getting all the movies with specific show times.
> 
>  Implements:
    - MOV-3
    - MOV-4

As you can see, this includes the tickets defined in our scrum calls in this 
[board](https://carocc2907.atlassian.net/jira/software/projects/MOV/boards/2)


## Architecture

### DDD

The base of this project is DDD as theory, so all the concepts and procedures to deconstruct a real problem into small 
problems. That means we follow the ideas of going with:
- VOs
- Models 
- Services
- Repositories
- Factories
- Aggregates, 
- Application Services 
- Domain Services
- Domain Errors

And other concepts that come up on the road that we can use, such as ubiquitous language, domains (core domain, generic 
domain and supporting domain) context mapping and bounded context.

### Functional Programming

Functional Programming is one of the best ways we can create a project since it follows principles such as:
- Immutability,
- Anonymous functions
- Monads.

And more... 

**Vavr** is an external library that can help us to follow all these concepts, since with only java might be more 
complicated.

### Sync calls

Based on the problem all the sync calls are going to be fail fast, having in mind we might have Circuit Breaker pattern 
in some places but not all of them. Since this project might grow up, is worth to mention there are a lot of patterns
we might follow such as Gateway, SAGA Pattern, CQRS, Sharded Services and others.

### Async calls

Since this project does not required this in this moment but might have microservices in the future for Async calls, 
I think it's worth to mention this.

For this there will be some situation in which we can have Retries and Circuit Breakers since they are not to be 
fail fast. Inn case errors we can have a table to save errors, not like in Sync Calls that we just respond.

## Testing

### Integration Tests

With Spring boot we can create integration tests with **spring-boot-starter-test**, *h2* as in memory DB and **WireMock**
to mock external calls if that is the case. The idea of these tests is testing entire flows, from the beginning 
(controllers or consumers) until the end (Producers or DB or others). At this point we are just going to mock external 
calls, howevere we might decide not to do it depending on our process (there might be anothe QA team for this).

### Unit Tests

At this point we are just going to test specific functional classes with logic and business logic. That means we are not 
going to test Beans, DTOs and other classes that do not have logic.

In this project Mockito can be used to generate mocks and spies and JUnit as framework to achieve 
the AAA pattern (Arrange, Act, Assert). 

## DB Structure
The DB scripts can be found under this folder 
[scripts](https://github.com/cristianhoyos66/movie-app/tree/master/src/main/resources/db)

I decided to go with an SQL DB (Maria DB) but might perfectly be a Non-Sql DB. Even better can be combined. 

## Vault for API Key

In the future for using private credentials such as API Keys, we can use vault as server, so we do not have to take care
on the encryption and decryption of them.

## Logging

**SLF4J** is the abstraction that allow us to select implementations without any problem. We use the abstraction but 
under the hood the implementation is not going to affect if at some point we decide to change it.

## Richardson Maturity Model

For this project we can follow this maturity model. We might notice that's not entirely the case in this moment, but
might be while the project grows up. 

[Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html#level3)

## Profile

We can use Profiles to deploy application in other environments such is testing, business and production. The same
would be for local environment.

## Swagger

We use Swager V3 for this project.

### Swagger UI

- http://localhost:8080/swagger-ui/index.html

### Swagger JSON

- http://localhost:8080/v3/api-docs

## Note

Have in mind this project is expected to be done in around 3 or 8 hours, so you might see some things still unfinished,
but the most important is I can describe all what I'm aiming to have in the project and that you can see how I want to 
apply all these concepts.
