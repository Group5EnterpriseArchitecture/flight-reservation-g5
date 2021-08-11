# Group 5 Flight Reservation System API

### RUN API LOCALLY

1. Build your Maven project

2. Make sure you specify your local database details in the application.yml.

```
  ...
  ...
  datasource:
    url: jdbc:<YOUR DB URL>
    username: <YOUR DB USERNAME>
    password: <YOUR DB PASSWORD>
    driverClassName: <YOUR DB DRIVER>
  ...
  ...
  jpa:
    properties:
      hibernate:
        dialect: <YOUR DB Dialect>
```

3. Run tests in the Test folder

4. Run The Application

### Postman Tests

[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.getpostman.com/collections/4500b7865bd6ada668c4)
