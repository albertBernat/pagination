# Pagination

It's example small project to demonstrate how you can build scalable pagination using Spring framework and JPA Specification API. 


### Prequisities
1. Java 17 
2. Docker

### How to start application
1. Run docker image with postgresql container
2. Create postgresql database with user `pagination`
  ```
  create database pagination;
create user pagination with encrypted password 'pagination';
grant all privileges on database pagination to pagination;
```
3. Start server to perform flyway migrations
4. Load initial data by `executing resources/db/initialData.sql`


You can chceck how it's working by invoking exisiing endpoint. Example requests are located at `example-requests.http` in main folder
