This is the Kotlin version to search for rental cars and make reservations, example that I've used to presentation
on developing microservices.

This application demonstrates the patterns:

* [Saga](https://microservices.io/patterns/data/saga.html) - use sagas, which a sequences of local transactions, to maintain data consistency across services.
* [Database per service](https://microservices.io/patterns/data/database-per-service.html) - each service has its own private database.
* [CQRS](http://microservices.io/patterns/data/cqrs.html) - implement queries by maintaining one or more materialized views that can be efficiently queried.
* [Shared database](https://microservices.io/patterns/data/shared-database.html) - services share a database.

## Architecture

The following diagram shows the architecture of the Rental Cars application.

![](./images/architecture2.png)

The application consists in the services: `Reservation Service`, `Inventory Service`, `Inventory History Service`, `Emailer Service`, and `Insurance Partner Wrapper Service`.

All services are implemented using Spring Boot.